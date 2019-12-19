package org.ml4j.nn.components.builders.common;

import org.ml4j.nn.components.manytoone.PathCombinationStrategy;

public interface PathEnder<P, C> {

	P endParallelPaths(PathCombinationStrategy pathCombinationStrategy);
	C withPath();
}
