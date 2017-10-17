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

import org.ml4j.nn.neurons.NeuronsActivation;
import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 * Encapsulates a function to create an output NeuronsActivation
 * from an input NeuronsActivation - typically applied to the output
 * of Axons within Layers to introduce non linearities.
 * 
 * @author Michael Lavelle
 *
 */
public interface ActivationFunction {
  
  /**
  * Create an output activation from input activations.
  * 
  * @param input The input NeuronsActivation
  * @param context The activation context
  * @return The activation
  */
  NeuronsActivation activate(NeuronsActivation input, NeuronsActivationContext context);
}
