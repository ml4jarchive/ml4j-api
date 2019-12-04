package org.ml4j.nn.components.builders.synapses;

import org.ml4j.nn.components.builders.axons.ActivationFunctionPermitted;
import org.ml4j.nn.components.builders.axonsgraph.AxonsGraphBuilder;

public interface CompletedSynapsesAxonsGraphBuilder<P> extends AxonsGraphBuilder<CompletedSynapsesAxonsGraphBuilder<P>>, ActivationFunctionPermitted<SynapsesEnder<P>> {

	P endSynapses();
}
