package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.ChainableDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DefaultChainableDirectedComponent<A extends DefaultChainableDirectedComponentActivation, C> extends ChainableDirectedComponent<NeuronsActivation, A, C> {

	@Override
	DefaultChainableDirectedComponent<A, C> dup();

	@Override
	List<DefaultChainableDirectedComponent<?, ?>> decompose();
	
}
