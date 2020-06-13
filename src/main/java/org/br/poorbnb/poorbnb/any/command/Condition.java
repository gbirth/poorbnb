package org.br.poorbnb.poorbnb.any.command;

@FunctionalInterface
public interface Condition {

    boolean condition(Double rate);

    default boolean conditionChecker(Double rate) {
        return condition(rate);
    }
}
