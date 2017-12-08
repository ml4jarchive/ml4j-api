/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ml4j.nn.neurons;

import org.ml4j.Matrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encapsulates the activation activities of a set of Neurons.
 * 
 * @author Michael Lavelle
 */
public class NeuronsActivation {

  private static final Logger LOGGER = LoggerFactory.getLogger(NeuronsActivation.class);
  
  /**
   * The matrix of activations.
   */
  private Matrix activations;
  
  /**
   * Defines whether the features of the activations are represented by the columns
   * or the rows of the activations Matrix.
   */
  private NeuronsActivationFeatureOrientation featureOrientation;


  /**
   * Constructs a NeuronsActivation instance from a matrix of activations.
   * 
   * @param activations A matrix of activations
   * @param featureOrientation The orientation of the features of the activation matrix
   */
  public NeuronsActivation(Matrix activations,
      NeuronsActivationFeatureOrientation featureOrientation) {
    LOGGER.debug("Creating new NeuronsActivation");
    this.activations = activations;
    this.featureOrientation = featureOrientation;
  }

  /**
   * Obtain the feature orientation of the Matrix representing the activations - whether the
   * features are represented by the rows or the columns.
   * 
   * @return the feature orientation of the Matrix representing the activations - whether the
   *         features are represented by the rows or the columns
   */
  public NeuronsActivationFeatureOrientation getFeatureOrientation() {
    return featureOrientation;
  }

  /*
  public Matrix getActivations() {
    return activations;
  }
  */
  
  public Matrix getActivations() {
    return activations;
  }

  /**
   * Obtain the number of features ( including any bias ) represented by this NeuronsActivation.
   * 
   * @return the number of features ( including any bias ) represented by this NeuronsActivation.
   */
  public int getFeatureCount() {

    if (featureOrientation == NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET) {
      int featureCount = activations.getColumns();
      return featureCount;
    } else {
      int featureCount = activations.getRows();
      return featureCount;
    }
  }

}
