package com.hunterparcells.huntercomponents.common.expressionfunction;

import com.inductiveautomation.ignition.common.TypeUtilities;
import com.inductiveautomation.ignition.common.expressions.Expression;
import com.inductiveautomation.ignition.common.expressions.ExpressionException;
import com.inductiveautomation.ignition.common.expressions.functions.AbstractFunction;
import com.inductiveautomation.ignition.common.model.values.BasicQualifiedValue;
import com.inductiveautomation.ignition.common.model.values.QualifiedValue;
import org.jboss.dna.common.text.Inflector;

public class Singularize extends AbstractFunction {
    Inflector inflector = new Inflector();

    @Override
    public Class<?> getType() {
        return String.class;
    }

    @Override
    protected String getFunctionDisplayName() {
        return "singularize";
    }

    @Override
    public String getArgDocString() {
        return "string";
    }

    @Override
    protected boolean validateNumArgs(int args) {
        return args == 1;
    }

    @Override
    public QualifiedValue execute(Expression[] expressions) throws ExpressionException {
        String string = TypeUtilities.toString(expressions[0].execute().getValue());

        return new BasicQualifiedValue(inflector.singularize(string));
    }
}
