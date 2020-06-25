package org.br.poorbnb.poorbnb.pattern.command;

import java.util.Objects;

@FunctionalInterface
public interface Condition {

    boolean condition(Double rate);

    default boolean conditionChecker(Double rate) {
        Objects.requireNonNull(rate);
        return condition(rate);
    }
}
