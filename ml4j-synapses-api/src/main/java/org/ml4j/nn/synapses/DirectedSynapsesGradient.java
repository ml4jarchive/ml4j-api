package org.ml4j.nn.synapses;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates the gradient-related artifacts as they propagate backwards through
 * a DirectedSynapses instance.  
 * 
 * @author Michael Lavelle
 */
public interface DirectedSynapsesGradient {

  /**
   * @return The gradient of the Axons weights if they are trainable, or null otherwise.
   */
  Matrix getTrainableAxonsGradient();

  /**
   * @return The backpropagated gradient passing backwards through the DirectedSynapses.
   */
  NeuronsActivation getOutput();

}
