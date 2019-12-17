package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.components.DefaultChainableDirectedComponentActivation;
import org.ml4j.nn.components.DirectedComponentGradient;
import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface DifferentiableActivationFunctionActivation extends
    ActivationFunctionActivation<DifferentiableActivationFunction, 
    DifferentiableActivationFunctionActivation>, DefaultChainableDirectedComponentActivation {

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
