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

package org.ml4j.nn;

import java.util.List;

import org.ml4j.nn.layers.Layer;

/**
 * Base interface for classes representing a NeuralNetwork.
 *
 * @author Michael Lavelle
 * 
 * @param <L> The type of Layer used within this NeuralNetwork
 * @param <C> The NeuralNetworkContext used with this NeuralNetwork
 * @param <N> The type of NeuralNetwork
 */
public interface LayeredNeuralNetwork<L extends Layer<?, ?, ?>, C extends LayeredNeuralNetworkContext, N extends LayeredNeuralNetwork<L, C, N>>
		extends NeuralNetwork<C, N> {

	/**
	 * Obtains the list of Layers in this NeuralNetwork.
	 * 
	 * @return the list of Layers in this NeuralNetwork
	 */
	List<L> getLayers();

	/**
	 * Obtains the number of Layers in this NeuralNetwork.
	 * 
	 * @return the number of Layers in this NeuralNetwork
	 */
	int getNumberOfLayers();

	/**
	 * Obtains the Layer at the specified index in this NeuralNetwork.
	 * 
	 * @param layerIndex The index of the Layer we wish to obtain
	 * @return the Layer at the specified index in this NeuralNetwork
	 */
	L getLayer(int layerIndex);

	/**
	 * Obtains the first Layer in the list of Layers in this NeuralNetwork.
	 * 
	 * @return the first Layer in the list of Layers in this NeuralNetwork
	 */
	L getFirstLayer();

	/**
	 * Obtains the final Layer in the list of Layers in this NeuralNetwork.
	 * 
	 * @return the final Layer in the list of Layers in this NeuralNetwork
	 */
	L getFinalLayer();
}
