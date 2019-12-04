package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.PathEnder;

public interface SubComponentsGraphBuilder<C extends AxonsBuilder> extends ComponentsGraphBuilder<C> {

	PathEnder<C, SubComponentsGraphBuilder<C>> endPath();

}
