package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.Axons3DBuilder;
import org.ml4j.nn.components.builders.axons.Axons3DPermitted;
import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.common.ParallelPathsPermitted;
import org.ml4j.nn.components.builders.skipconnection.SkipConnection3DPermitted;

public interface Axons3DGraphBuilder<C extends Axons3DBuilder, A extends AxonsBuilder> extends Axons3DPermitted<C, A>, Axons3DBuilder, ParallelPathsPermitted<Axons3DSubGraphBuilder<C, A>>, SkipConnection3DPermitted<Axons3DGraphSkipConnectionBuilder<C, A>>{


}
