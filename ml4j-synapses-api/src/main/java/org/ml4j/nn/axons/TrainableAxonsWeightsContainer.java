package org.ml4j.nn.axons;

import org.ml4j.Matrix;

/**
 * Container for weights for TrainableAxons.
 * 
 * @author Michael Lavelle
 *
 */
public interface TrainableAxonsWeightsContainer extends AxonsWeightsContainer {

  /**
   * @param adjustments The adjustment Matrix.
   * @param adjustmentDirection The adjustment direction.
   */
  public void adjustConnectionWeights(Matrix adjustments, 
      ConnectionWeightsAdjustmentDirection adjustmentDirection);
  
}
