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

package org.ml4j.nn.axons;

import org.ml4j.Matrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.NeuronsActivation;

import java.io.Serializable;

/**
 * Encapsulates the connections between two sets of Neurons.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left hand side of these Axons
 * @param <R> The type of Neurons on the right hand side of these Axons
 * @param <A> The type of these Axons
 */
public interface Axons<L extends Neurons, R extends Neurons, A extends Axons<L, R, A>>
    extends Serializable {

  /**
   * Get the Neurons on the left hand side of these Axons.
   * 
   * @return The Neurons on the left hand side of these Axons
   */
  L getLeftNeurons();

  /**
   * Get the Neurons on the right hand side of these Axons.
   * 
   * @return The Neurons on the right hand side of these Axons
   */
  R getRightNeurons();

  /**
   * Push the activations from left to right through these Axons.
   * 
   * @param leftNeuronsActivation The activation applied to the left hand side of these Axons
   * @param previousRightToLeftActivation If this push from left to right depends on a previous push
   *        from right to left, the previous right-to-left activation should be provided as an input
   *        here. It is up to concrete implementations of Axons to determine whether this input is
   *        required or not and to validate this is present - if not required this input can be left
   *        as null.
   * 
   * @param axonsContext The context of the activation
   * @return The activation resulting at the right hand side of these Axons
   */
  AxonsActivation pushLeftToRight(NeuronsActivation leftNeuronsActivation,
      AxonsActivation previousRightToLeftActivation, AxonsContext axonsContext);

  /**
   * Push the activations from right to left through these Axons.
   * 
   * @param rightNeuronsActivation The activation applied to the left hand side of these Axons
   * @param previousLeftToRightActivation If this push from right to left depends on a previous push
   *        from left to right, the previous left-to-right activation should be provided as an input
   *        here. It is up to concrete implementations of Axons to determine whether this input is
   *        required or not and to validate this is present - if not required this input can be left
   *        as null.
   * @param axonsContext The context of the activation
   * @return The activation resulting at the left hand side of these Axons
   */
  AxonsActivation pushRightToLeft(NeuronsActivation rightNeuronsActivation,
      AxonsActivation previousLeftToRightActivation, AxonsContext axonsContext);
  
  
  /**
   * @return A clone of the connection weights Matrix for these Axons.
   */
  Matrix getDetachedConnectionWeights();
  
  /**
   * @return A deep copy of these Axons.
   */
  A dup();
  
  /**
   * @param axonsContext The Axons context
   * @return Whether these Axons are trainable within this context.
   */
  boolean isTrainable(AxonsContext axonsContext);
  
}
