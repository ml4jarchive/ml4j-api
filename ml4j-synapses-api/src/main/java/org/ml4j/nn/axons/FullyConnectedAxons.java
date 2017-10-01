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

import org.ml4j.nn.neurons.Neurons;

/**
 * Encapsulates the connections between two sets of Neurons which are fully connected (ie. each
 * Neuron on the left of the Axons is connected to each Neuron on the right )
 * 
 * @author Michael Lavelle
 *
 * @param <L> The type of Neurons on the left hand side of these FullyConnectedAxons
 * @param <R> The type of Neurons on the right hand side of these FullyConnectedAxons
 */
public interface FullyConnectedAxons<L extends Neurons, R extends Neurons> 
    extends Axons<L, R, FullyConnectedAxons<L, R>> {

}
