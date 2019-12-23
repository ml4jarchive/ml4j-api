package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponentActivation;
import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * 
 * Encapsulates the activations from an activation through a DifferentiableActivationFunctionComponent,
 * and the logic required in order to back propagate gradients back through the activations.
 * 
 * 
 * @author Michael Lavelle
 */
public interface DifferentiableActivationFunctionComponentActivation extends
     DefaultChainableDirectedComponentActivation {

  /**
   * 
   * @param da The outer gradient.
   * @param context The synapses context.
   * @return The backpropagated gradient.
   */
	DirectedComponentGradient<NeuronsActivation> backPropagate(DirectedComponentGradient<NeuronsActivation> da);
  
  /**
   * 
   * @param da The outer gradient.
   * @param context The synapses context.
   * @return The backpropagated gradient.
   */
	DirectedComponentGradient<NeuronsActivation> backPropagate(CostFunctionGradient da);

}
