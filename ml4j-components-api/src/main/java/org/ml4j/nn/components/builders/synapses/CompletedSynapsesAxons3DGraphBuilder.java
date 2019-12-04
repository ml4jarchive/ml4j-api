package org.ml4j.nn.components.builders.synapses;

import org.ml4j.nn.components.builders.axons.ActivationFunctionPermitted;
import org.ml4j.nn.components.builders.axonsgraph.Axons3DGraphBuilder;

public interface CompletedSynapsesAxons3DGraphBuilder<P, Q> extends Axons3DGraphBuilder<CompletedSynapsesAxons3DGraphBuilder<P, Q>, CompletedSynapsesAxonsGraphBuilder<Q>>, ActivationFunctionPermitted<SynapsesEnder<P>>{

	P endSynapses();
}
