package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.PathEnder;

public interface AxonsSubGraphBuilder<P> extends AxonsGraphBuilder<AxonsSubGraphBuilder<P>>, AxonsBuilder {

	PathEnder<P, AxonsSubGraphBuilder<P>> endPath();
}
