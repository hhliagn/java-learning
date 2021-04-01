package com.javalearning.demo.spel;

import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author lhh
 * @date 2021/3/31
 */
public class Main {

    /**
     * rootObject: 直接用属性名获取值
     * setVariable: （数组）通过 #name 获取值
     */
    public static void main(String[] args) {
        //ExpressionParser parser = new SpelExpressionParser();
        //Expression expression = parser.parseExpression("6+2");
        //Integer result = (Integer) expression.getValue();
        //System.out.println("result:" + result);

        //ExpressionParser parser = new SpelExpressionParser();
        //Expression expression = parser.parseExpression("'SpEL'.concat(' thinking')");
        //String result = (String) expression.getValue();
        //System.out.println("result:" + result);

        // setVariable 和 #
        //Account account = new Account("lianghh");
        //
        //ExpressionParser parser = new SpelExpressionParser();
        //StandardEvaluationContext context = new StandardEvaluationContext();
        //context.setVariable("account", account);
        //context.setVariable("newName", "brain");
        //Expression expression = parser.parseExpression("#account.getName(#newName)");
        //String result = (String) expression.getValue(context);
        //System.out.println("result:" + result);


        Student student = new Student();
        Account account = new Account("joe");
        student.setAccount(account);

        StandardEvaluationContext context = new StandardEvaluationContext(student);

        UserDto userDto = new UserDto();
        userDto.setUsername("joe");
        userDto.setPassword("123456");

        context.setVariable("username", userDto.getUsername());
        if (userDto.verifyUserName(context)) {
            System.out.println("verify pass..");
        }
    }
}
