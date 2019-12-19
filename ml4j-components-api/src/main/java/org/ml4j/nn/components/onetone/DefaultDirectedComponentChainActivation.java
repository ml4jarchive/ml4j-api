package org.ml4j.nn.components.onetone;

import java.util.List;

import org.ml4j.nn.components.DirectedComponentChainActivation;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the activation from a DefaultDirectedComponentChain after forward propagation.
 * 
 * @author Michael Lavelle
 *
 */
public interface DefaultDirectedComponentChainActivation extends DirectedComponentChainActivation<NeuronsActivation, DefaultChainableDirectedComponentActivation>, DefaultChainableDirectedComponentActivation {

	@Override
	List<DefaultChainableDirectedComponentActivation> decompose();
}
