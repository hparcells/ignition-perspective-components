package com.hunterparcells.huntercomponents.common.expressionfunction;

import com.inductiveautomation.ignition.common.TypeUtilities;
import com.inductiveautomation.ignition.common.expressions.Expression;
import com.inductiveautomation.ignition.common.expressions.ExpressionException;
import com.inductiveautomation.ignition.common.expressions.functions.AbstractFunction;
import com.inductiveautomation.ignition.common.model.values.BasicQualifiedValue;
import com.inductiveautomation.ignition.common.model.values.QualifiedValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplace extends AbstractFunction {
    @Override
    public Class<?> getType() {
        return String.class;
    }

    @Override
    protected String getFunctionDisplayName() {
        return "regexReplace";
    }

    @Override
    public String getArgDocString() {
        return "string, pattern, replacement";
    }

    @Override
    protected boolean validateNumArgs(int args) {
        return args == 3;
    }

    @Override
    public QualifiedValue execute(Expression[] expressions) throws ExpressionException {
        String string = TypeUtilities.toString(expressions[0].execute().getValue());
        String patternString = TypeUtilities.toString(expressions[1].execute().getValue());
        String replacement = TypeUtilities.toString(expressions[2].execute().getValue());

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(string);

        return new BasicQualifiedValue(matcher.replaceAll(replacement));
    }
}
