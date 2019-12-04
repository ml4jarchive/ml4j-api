package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.common.PathEnder;

public interface ComponentsSubGraphBuilder<P> extends ComponentsGraphBuilder<ComponentsSubGraphBuilder<P>> {

	PathEnder<P, ComponentsSubGraphBuilder<P>> endPath();
}
