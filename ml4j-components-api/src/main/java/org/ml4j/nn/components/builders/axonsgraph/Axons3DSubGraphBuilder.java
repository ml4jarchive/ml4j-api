package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.common.PathEnder;

public interface Axons3DSubGraphBuilder<P, Q> extends Axons3DGraphBuilder<Axons3DSubGraphBuilder<P, Q>, AxonsSubGraphBuilder<Q>>, Axons3DBuilder {

	PathEnder<P, Axons3DSubGraphBuilder<P, Q>> endPath();
}
