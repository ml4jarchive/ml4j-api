/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ml4j;


import java.util.Objects;

/**
 * Represents an operation that accepts a single {@code float}-valued argument and
 * returns a float valued result. 
 *
 * <p>This is a functional interface
 * whose functional method is {@link #acceptAndModify(float)}.
 *
 */
@FunctionalInterface
public interface FloatModifier {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     * @return the modified input argument
     */
    float acceptAndModify(float value);

    /**
     * Returns a composed {@code FloatModifier} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code FloatModifier} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default FloatModifier andThen(FloatModifier after) {
        Objects.requireNonNull(after);
        return (float t) -> { float modified = acceptAndModify(t); return after.acceptAndModify(modified); };
    }
}
