package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.common.PathEnder;

public interface Components3DSubGraphBuilder<P, Q> extends Components3DGraphBuilder<Components3DSubGraphBuilder<P, Q>, ComponentsSubGraphBuilder<Q>>, Axons3DBuilder {

	PathEnder<P, Components3DSubGraphBuilder<P, Q>> endPath();
	
	
}
