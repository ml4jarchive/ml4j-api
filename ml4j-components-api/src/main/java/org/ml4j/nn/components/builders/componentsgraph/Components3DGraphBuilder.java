package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.axons.ActivationFunctionPermitted;
import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.axons.Axons3DPermitted;
import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.ParallelPathsPermitted;
import org.ml4j.nn.components.builders.skipconnection.Components3DGraphSkipConnectionBuilder;
import org.ml4j.nn.components.builders.skipconnection.SkipConnection3DPermitted;
import org.ml4j.nn.components.builders.synapses.Synapses3DPermitted;

public interface Components3DGraphBuilder<C extends Axons3DBuilder, D extends AxonsBuilder> extends Axons3DPermitted<C, D>, Synapses3DPermitted<C, D>, ActivationFunctionPermitted<C>, ParallelPathsPermitted<Components3DSubGraphBuilder<C, D>>, SkipConnection3DPermitted<Components3DGraphSkipConnectionBuilder<C, D>>, Axons3DBuilder {

	C get3DBuilder();
	D getBuilder();
	Components3DGraphBuilder<C, D> withComponents(Components3DGraphBuilder<?, ?> builder);

}
