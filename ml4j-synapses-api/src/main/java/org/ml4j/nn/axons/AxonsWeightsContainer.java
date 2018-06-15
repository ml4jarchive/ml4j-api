package org.ml4j.nn.axons;

import org.ml4j.Matrix;

import java.io.Serializable;

/**
 * Container for weights for Axons.
 * 
 * @author Michael Lavelle
 *
 */
public interface AxonsWeightsContainer extends Serializable {

  /**
   * @return A clone of the connection weights Matrix for these Axons.
   */
  Matrix getDetachedConnectionWeights();
  
}
