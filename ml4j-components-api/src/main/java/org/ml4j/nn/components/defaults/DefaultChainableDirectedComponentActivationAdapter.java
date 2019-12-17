package org.ml4j.nn.components.defaults;

import java.util.List;
import java.util.stream.Collectors;

import org.ml4j.nn.components.ChainableDirectedComponentActivation;
import org.ml4j.nn.components.DefaultChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

public class DefaultChainableDirectedComponentActivationAdapter implements DefaultChainableDirectedComponentActivation {

	private ChainableDirectedComponentActivation<NeuronsActivation> delegatedActivation;
	
	public DefaultChainableDirectedComponentActivationAdapter(
			ChainableDirectedComponentActivation<NeuronsActivation> delegatedActivation) {
		this.delegatedActivation = delegatedActivation;
	}

	@Override
	public List<DefaultChainableDirectedComponentActivation> decompose() {
		List<? extends ChainableDirectedComponentActivation<NeuronsActivation>> decomposed = delegatedActivation.decompose();
		return decomposed.stream().map(a -> 
			new DefaultChainableDirectedComponentActivationAdapter(a)).collect(Collectors.toList());
	}

	@Override
	public DirectedComponentGradient<NeuronsActivation> backPropagate(
			DirectedComponentGradient<NeuronsActivation> outerGradient) {
		return delegatedActivation.backPropagate(outerGradient);
	}

	@Override
	public NeuronsActivation getOutput() {
		return delegatedActivation.getOutput();
	}

}
