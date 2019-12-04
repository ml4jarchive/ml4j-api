package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.PathEnder;

public interface SubComponents3DGraphBuilder<C extends Axons3DBuilder, D extends AxonsBuilder> extends Components3DGraphBuilder<C, D> {

	PathEnder<C, SubComponents3DGraphBuilder<C, D>> endPath();
	SubComponents3DGraphBuilder<C, D> withPath();

}
