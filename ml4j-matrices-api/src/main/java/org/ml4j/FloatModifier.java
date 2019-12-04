package org.ml4j;


import java.util.Objects;

/**
 * Represents an operation that accepts a single {@code float}-valued argument and
 * returns a float valued result.  This is the primitive type specialization of
 * {@link Consumer} for {@code int}. 
 *
 * <p>This is a functional interface
 * whose functional method is {@link #acceptAndModify(float)}.
 *
 * @since 1.8
 */
@FunctionalInterface
public interface FloatModifier {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     */
    float acceptAndModify(float value);

    /**
     * Returns a composed {@code IntConsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code IntConsumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default FloatModifier andThen(FloatModifier after) {
        Objects.requireNonNull(after);
        return (float t) -> { float modified = acceptAndModify(t); return after.acceptAndModify(modified); };
    }
}
