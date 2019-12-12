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
