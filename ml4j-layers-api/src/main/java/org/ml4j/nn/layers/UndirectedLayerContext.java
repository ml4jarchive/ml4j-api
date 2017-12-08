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

import org.ml4j.nn.synapses.UndirectedSynapsesContext;

/**
 * Encapsulates the runtime context used with an UndirectedLayer.
 * 
 * @author Michael Lavelle
 */
public interface UndirectedLayerContext extends LayerContext {

  /**
   * @param synapsesIndex The index of the synapses within this UndirectedLayer.
   * @return The context we use to propagate data through the undirected 
   *         synapses of this Layer.
   */
  UndirectedSynapsesContext createSynapsesContext(int synapsesIndex);
  
  /**
   * @return Whether to freeze out this Layer for training.
   */
  boolean isWithFreezeOut();
  
  /**
   * @param withFreezeOut Whether to freeze out this Layer for training.
   */
  void setWithFreezeOut(boolean withFreezeOut);
}
