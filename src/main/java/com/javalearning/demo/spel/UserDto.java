package com.javalearning.demo.spel;

import lombok.Data;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author lhh
 * @date 2021/4/1
 */
@Data
public class UserDto {

    private String username;
    private String password;

    private String expEqualUserName = "account?.getName() == #username";

    public boolean verifyUserName(StandardEvaluationContext context) {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expEqualUserName);
        return expression.getValue(context, Boolean.class);
    }
}
