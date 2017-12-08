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

package org.ml4j.nn;

import org.ml4j.nn.layers.UndirectedLayerContext;

/**
 * Encapsulates the runtime context used with a UndirectedNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface UndirectedNeuralNetworkContext extends NeuralNetworkContext {

  /**
   * Create the UndirectedLayerContext for the UndirectedLayer specified
   * by the layerIndex.
   * 
   * @param layerIndex The index of the UndirectedLayer in this
   *        UndirectedNeuralNetwork to create the context for.
   * @return The UndirectedLayerContext for the UndirectedLayer specified
   *        by the layerIndex.
   */
  UndirectedLayerContext getLayerContext(int layerIndex);
  
  /**
   * @return The learning rate used during training.
   */
  double getTrainingLearningRate();
  
  /**
   * @return The number of iterations through the entire data set during training.
   */
  int getTrainingEpochs();
  
  /**
   * @return The size of the mini batch if training in batch mode... or null if non-batch mode.
   */
  Integer getTrainingMiniBatchSize();
  
  /**
   * @param trainingLearningRate The learning rate used during training.
   */
  void setTrainingLearningRate(double trainingLearningRate);
  
  /**
   * @param trainingEpochs The number of iterations through the entire data set during training.
   */
  void setTrainingEpochs(int trainingEpochs);
  
  /**
   * @param batchSize The size of the mini batch if training in batch mode... or null if non-batch
   *        mode.
   */
  void setTrainingMiniBatchSize(Integer batchSize);
 
}
