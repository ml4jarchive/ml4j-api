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

package org.ml4j.nn.layers;

import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Represents a Directed Layer of a NeuralNetwork - a Layer through which information propagates
 * from input neurons to output neurons in one direction.
 * 
 * @author Michael Lavelle
 * 
 * @param <L> The type of DirectedLayer
 */
public interface DirectedLayer<L extends DirectedLayer<L>>
    extends Layer<L> {

  /**
   * @return The number of input neurons (including any bias unit) to the left of this 
   *     Directed Layer.
   */
  int getInputNeuronCount();
  
  /**
   * @return The number of output neurons (including any bias unit) to the right of this 
   *     Directed Layer.
   */
  int getOutputNeuronCount();
  
  /**
   * Obtain the input NeuronsActivation which maximises the output
   *        of the specified output neuron.
   * 
   * @param outpuNeuronIndex The index of the output neuron we wish to obtain the
   *        output activation maximising input activation for.
   * @param directedLayerContext The directed layer context
   * @return The input NeuronsActivation which maximises the output
   *        of the specified output neuron.
   */
  NeuronsActivation getOptimalInputForOutputNeuron(int outpuNeuronIndex, 
      DirectedLayerContext directedLayerContext);
}
