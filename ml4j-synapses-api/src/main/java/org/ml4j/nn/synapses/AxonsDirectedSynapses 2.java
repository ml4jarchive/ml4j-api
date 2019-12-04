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

import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.graph.DirectedDipoleGraph;
import org.ml4j.nn.neurons.Neurons;

/**
 * AxonsDirectedSynapses are containers for Axons with a DifferentiableActivationFunction applied
 * to the right hand Axons output on a push of data left-to-right during forward propagation.
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left of these DirectedSynapses.
 * @param <R> The type of Neurons on the right of these DirectedSynapses.
 */
public interface AxonsDirectedSynapses<L extends Neurons, R extends Neurons>
    extends DirectedSynapses<L, R> {

  /**
   * @return The primary Axons within these DirectedSynapses.
   */
  Axons<? ,? ,?> getPrimaryAxons();
  
  /**
   * @return The Axons graph within these DirectedSynapses.
   */
  DirectedDipoleGraph<Axons<?, ? ,?>> getAxonsGraph();
 
}
