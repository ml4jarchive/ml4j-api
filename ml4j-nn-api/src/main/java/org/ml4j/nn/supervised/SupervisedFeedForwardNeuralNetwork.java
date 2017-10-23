/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.supervised;

import org.ml4j.nn.FeedForwardNeuralNetwork;
import org.ml4j.nn.FeedForwardNeuralNetworkContext;
import org.ml4j.nn.layers.FeedForwardLayer;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * 
 * @author Michael Lavelle
 *
 * @param <C> The specific type of {@link org.ml4j.nn.NeuralNetworkTrainingContext} 
 *      used to train this AutoEncoder
 */
public interface SupervisedFeedForwardNeuralNetwork extends 
    SupervisedNeuralNetwork<FeedForwardLayer<?, ?>, FeedForwardNeuralNetworkContext, 
        SupervisedFeedForwardNeuralNetwork>,
            FeedForwardNeuralNetwork<FeedForwardNeuralNetworkContext, 
            SupervisedFeedForwardNeuralNetwork> {

  /**
   * Trains the SupervisedNeuralNetwork.
   * 
   * @param trainingDataActivations The NeuronsActivation produced by the training data
   * @param trainingLabelActivations The NeuronsActivation produced by the training labels
   * @param trainingContext The NeuralNetworkContext used for training
   */
  public void train(NeuronsActivation trainingDataActivations, 
      NeuronsActivation trainingLabelActivations, FeedForwardNeuralNetworkContext trainingContext);

  public double getClassificationAccuracy(NeuronsActivation inputActivations,
      NeuronsActivation desiredClassificationActivations, FeedForwardNeuralNetworkContext context); 
}
