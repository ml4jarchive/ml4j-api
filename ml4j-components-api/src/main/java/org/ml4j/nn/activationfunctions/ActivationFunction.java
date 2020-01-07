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

package org.ml4j.nn.activationfunctions;

import java.io.Serializable;

import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 *
 * Encapsulates a function to create an output ActivationFunctionActivation from an input NeuronsActivation -
 * typically applied to the output of Axons to introduce non linearities.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The specific class of this ActivationFunction.
 * @param <G> The specific class of ActivationFunctionActivation produced on activation.
 */
public interface ActivationFunction<F extends ActivationFunction<F, G>, 
    G extends ActivationFunctionActivation<F, G>>
    extends Serializable {

  /**
   * Create an output ActivationFunctionActivation from input activations.
   * 
   * @param input The input NeuronsActivation
   * @param context The activation context
   * @return The ActivationFunctionActivation
   */
  G activate(NeuronsActivation input, NeuronsActivationContext context);
  
  /**
   * @return The ActivationFunctionType.
   */
  ActivationFunctionType getActivationFunctionType();

}
