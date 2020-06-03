package com.javalearning.demo.commonmistakes.redundantcode.reflection.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

@Slf4j
@Service
public class BetterBankService {

    public String createUser(String name, String identity, String mobile, int age) throws IOException {
        CreateUserAPI createUserAPI = new CreateUserAPI();
        createUserAPI.setName(name);
        createUserAPI.setIdentity(identity);
        createUserAPI.setMobile(mobile);
        createUserAPI.setAge(age);
        return remoteCall(createUserAPI);
    }

    public String pay(long userId, BigDecimal amount) throws IOException {
        PayAPI payAPI = new PayAPI();
        payAPI.setUserId(userId);
        payAPI.setAmount(amount);
        return remoteCall(payAPI);
    }

    public String remoteCall(AbstractAPI api) throws IOException {

        //构建API
        BankAPI bankAPI = api.getClass().getAnnotation(BankAPI.class);
        String url = bankAPI.url();
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(api.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(BankFieldAPI.class))
                .sorted(Comparator.comparingInt(field -> field.getAnnotation(BankFieldAPI.class).order()))
                .forEach(field -> {
                    Object value = "";
                    try {
                        value = field.get(api);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    BankFieldAPI bankAPIField = field.getAnnotation(BankFieldAPI.class);

                    switch (bankAPIField.type()){
                        case "S": {
                            stringBuilder.append(String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_'));
                            break;
                        }
                        case "N": {
                            stringBuilder.append(String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0'));
                            break;
                        }
                        case "M": {
                            if (!(value instanceof BigDecimal))
                                throw new RuntimeException(String.format("{} 的 {} 必须是BigDecimal", api, field));
                            stringBuilder.append(String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
                            break;
                        }
                        default:
                            break;
                    }
                });

        stringBuilder.append(DigestUtils.md2Hex(stringBuilder.toString()));
        String param = stringBuilder.toString();

        //发送请求
        long start = System.currentTimeMillis();
        String result = Request.Post("http://localhost:8080/reflection" + url)
                .bodyString(param, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent()
                .asString();

        log.info("请求: {} 访问：{}, 参数：{}, 返回：{}, 耗时：{}",
                bankAPI.desc(), bankAPI.url(), param, result, System.currentTimeMillis() - start);
        return result;
    }
}
