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

package org.ml4j.nn.synapses;

import org.ml4j.nn.axons.AxonsContext;

import org.ml4j.nn.neurons.NeuronsActivationContext;

/**
 * Defines the context for activations travelling through Synapses.
 * 
 * @author Michael Lavelle
 *
 */
public interface SynapsesContext extends NeuronsActivationContext {

  /**
   * @param axonsIndex The index of the Axons within these Synapse.
   * @return The context we use for activations travelling through the Axons within these Synapses.
   */
  AxonsContext getAxonsContext(int axonsIndex);
  
  /**
   * @return Whether these Synapses are frozen out of training.
   */
  boolean isWithFreezeOut();
  
  /**
   * @param withFreezeOut Whether these Synapses are frozen out of training.
   */
  public void setWithFreezeOut(boolean withFreezeOut);
}
