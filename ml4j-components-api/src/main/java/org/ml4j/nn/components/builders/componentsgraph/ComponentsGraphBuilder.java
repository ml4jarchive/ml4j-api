package org.ml4j.nn.components.builders.componentsgraph;

import org.ml4j.nn.components.builders.axons.ActivationFunctionPermitted;
import org.ml4j.nn.components.builders.axons.AxonsBuilder;
import org.ml4j.nn.components.builders.axons.AxonsPermitted;
import org.ml4j.nn.components.builders.common.ParallelPathsPermitted;
import org.ml4j.nn.components.builders.skipconnection.ComponentsGraphSkipConnectionBuilder;
import org.ml4j.nn.components.builders.skipconnection.SkipConnectionPermitted;
import org.ml4j.nn.components.builders.synapses.SynapsesPermitted;

public interface ComponentsGraphBuilder<C extends AxonsBuilder> extends AxonsPermitted<C>, SynapsesPermitted<C>, ActivationFunctionPermitted<C>, ParallelPathsPermitted<ComponentsSubGraphBuilder<C>>, SkipConnectionPermitted<ComponentsGraphSkipConnectionBuilder<C>>, AxonsBuilder {

}
