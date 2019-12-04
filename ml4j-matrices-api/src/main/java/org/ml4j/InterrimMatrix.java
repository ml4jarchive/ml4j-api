package org.ml4j;

public interface InterrimMatrix extends Matrix, AutoCloseable {

	void close();
}
