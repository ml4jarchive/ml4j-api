package org.ml4j.nn.components.builders.axonsgraph;

import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.axons.AxonsPermitted;
import org.ml4j.nn.components.builders.common.ParallelPathsPermitted;
import org.ml4j.nn.components.builders.skipconnection.SkipConnectionPermitted;

public interface AxonsGraphBuilder<C> extends AxonsPermitted<C>, AxonsBuilder, ParallelPathsPermitted<AxonsSubGraphBuilder<C>>, SkipConnectionPermitted<AxonsGraphSkipConnectionBuilder<C>> {

}
