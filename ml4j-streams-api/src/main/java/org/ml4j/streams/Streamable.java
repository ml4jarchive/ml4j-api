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
package org.ml4j.streams;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;


public interface Streamable<T> extends Supplier<Stream<T>> {

	default Stream <T> get() {
		return stream();
	}
	
	 /**
     * Create a streamable that transforms the streams produced by this streamable with a stream transformer.
     * @param transformer The transformer to apply to this streamable's streams.
     * @param <T2> The type of the streams produced by the transformation.
     * @return A streamable which produces the transformed streams.
     */
    default <T2> Streamable<T2> transform(Function<Stream<T>, Stream<T2>> transformer) {
        return () -> transformer.apply(stream());
    }
    
    /**
     * Transform this streamable's streams with the supplied map.
     * @param f The map to apply.
     * @param <T2> The mapped-to type.
     * @return A streamable which produces the transformed streams.
     */
    default <T2> Streamable<T2> map(Function<? super T, ? extends T2> f) {
        return transform(s -> s.map(f));
    }

	
	Stream<T> stream();
}
