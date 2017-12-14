package org.ml4j.nn.activationfunctions;

import org.ml4j.nn.costfunctions.CostFunctionGradient;
import org.ml4j.nn.synapses.DirectedSynapsesContext;
import org.ml4j.nn.synapses.DirectedSynapsesGradient;

public interface DifferentiableActivationFunctionActivation extends
    ActivationFunctionActivation<DifferentiableActivationFunction, 
    DifferentiableActivationFunctionActivation> {

  /**
   * 
   * @param da The outer gradient.
   * @param context The synapses context.
   * @return The backpropagated gradient.
   */
  ActivationFunctionGradient backPropagate(DirectedSynapsesGradient da, 
      DirectedSynapsesContext context);
  
  /**
   * 
   * @param da The outer gradient.
   * @param context The synapses context.
   * @return The backpropagated gradient.
   */
  ActivationFunctionGradient backPropagate(CostFunctionGradient da, 
      DirectedSynapsesContext context);

}
