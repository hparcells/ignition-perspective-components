package com.hunterparcells.huntercomponents.common.expressionfunction;

import com.inductiveautomation.ignition.common.TypeUtilities;
import com.inductiveautomation.ignition.common.expressions.Expression;
import com.inductiveautomation.ignition.common.expressions.ExpressionException;
import com.inductiveautomation.ignition.common.expressions.functions.AbstractFunction;
import com.inductiveautomation.ignition.common.model.values.BasicQualifiedValue;
import com.inductiveautomation.ignition.common.model.values.QualifiedValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExtract extends AbstractFunction {
    @Override
    public Class<?> getType() {
        return String.class;
    }

    @Override
    protected String getFunctionDisplayName() {
        return "regexExtract";
    }

    @Override
    public String getArgDocString() {
        return "string, pattern";
    }

    @Override
    protected boolean validateNumArgs(int args) {
        return args == 2;
    }

    @Override
    public QualifiedValue execute(Expression[] expressions) throws ExpressionException {
        String string = TypeUtilities.toString(expressions[0].execute().getValue());
        String patternString = TypeUtilities.toString(expressions[1].execute().getValue());

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(string);

        if(matcher.find() && matcher.groupCount() > 0) {
            return new BasicQualifiedValue(matcher.group(1));
        }
        return new BasicQualifiedValue(string);
    }
}
