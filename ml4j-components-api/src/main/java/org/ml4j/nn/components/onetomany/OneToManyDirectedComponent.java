package org.ml4j.nn.components.onetomany;

import org.ml4j.nn.components.DirectedComponentsContext;
import org.ml4j.nn.components.GenericOneToManyDirectedComponent;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a directed component which takes a single NeuronsActivation instance as input and maps to many NeuronsActivation instances as output.
 * 
 * Used within component graphs where the flow through the NeuralNetwork is split into paths, eg. for skip-connections in ResNets or inception modules.
 * 
 * @author Michael Lavelle
 *
 * @param <A> The type of activation produced by this component on forward-propagation.
 */
public interface OneToManyDirectedComponent<A extends OneToManyDirectedComponentActivation> extends GenericOneToManyDirectedComponent<NeuronsActivation,DirectedComponentsContext, A > {

	@Override
	OneToManyDirectedComponent<A> dup();
}
