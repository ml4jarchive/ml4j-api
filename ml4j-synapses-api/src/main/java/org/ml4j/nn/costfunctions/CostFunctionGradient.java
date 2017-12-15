/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.costfunctions;

import org.ml4j.nn.activationfunctions.ActivationFunctionGradient;
import org.ml4j.nn.activationfunctions.DifferentiableActivationFunction;

/**
 * Encapsulates the gradient of a cost function which can be back propagated 
 * through a final activation function
 * (eg. using the delta rule)
 * 
 * @author Michael Lavelle
 */
public interface CostFunctionGradient {

  /**
   * @return The cost function.
   */
  CostFunction getCostFunction();
  
  /**
   * 
   * @param finalActivationFunction The last activation function of a forward propagation chain.
   * @return The cost function gradient back propagated through the final activation function.
   */
  ActivationFunctionGradient backPropagateThroughFinalActivationFunction(
      DifferentiableActivationFunction finalActivationFunction);
   
}
