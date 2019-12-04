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

package org.ml4j.nn.axons;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;

/**
 * Encapsulates the connections between a set of Neurons on the left (with bias) and 
 * a set of Neurons on the right, of the same size as the left Neurons but without the bias.
 * 
 * <p>Each Neuron on the right is connected to the corresponding Neuron on the left and also to the
 * left-hand bias unit, with weights applied to both connections.
 * 
 * <p>The weight for connection between the left hand bias with right hand Neuron i is called a 
 * shift, and the weight for the connection between Neuron i on the left and Neuron 
 * i on the right is called a scale.
 * 
 * <p>Activation of RightNeuron(i) = scale(i) * Activation of LeftNeuron(i) + shift(i)
 *
 * <p>These Axons are parameterised by a scale vector and a shift vector, each of length matching 
 * the number of Neurons on the right.
 * 
 * @author Michael Lavelle
 *
 */
public interface ScaleAndShiftAxons<N extends Neurons>
    extends TrainableAxons<N, N, ScaleAndShiftAxons<N>> {

  /**
   * 
   * @return The column vector containing the scaling weights - one for each non-bias Neuron.
   */
  Matrix getScaleColumnVector();

  /**
   * 
   * @return The column vector containing the shift weights - one for each non-bias Neuron.
   */
  Matrix getShiftColumnVector();
}
