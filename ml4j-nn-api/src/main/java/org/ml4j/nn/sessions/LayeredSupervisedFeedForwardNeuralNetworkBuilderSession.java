/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.sessions;

import org.ml4j.nn.NeuralNetworkComponentsContainer;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.layers.DirectedLayerFactory;
import org.ml4j.nn.layers.FeedForwardLayer;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.supervised.LayeredSupervisedFeedForwardNeuralNetwork;

/**
 * Session interface for the creation of SupervisedFeedForwardNeuralNetworks containing
 * only FeedForwardLayers,  operating on non-3D neurons (ie. flat data)
 * 
 * @author Michael Lavelle
 *
 */
public interface LayeredSupervisedFeedForwardNeuralNetworkBuilderSession extends NeuralNetworkComponentsContainer<FeedForwardLayer<?, ?>>  {

	DirectedComponentFactory getDirectedComponentFactory();
	
	DirectedLayerFactory getDirectedLayerFactory();	

	FullyConnectedFeedForwardLayerBuilderSession
	<LayeredSupervisedFeedForwardNeuralNetworkBuilderSession> withFullyConnectedLayer(String layerName);
		
	LayeredSupervisedFeedForwardNeuralNetwork build();

	<A extends Axons<Neurons, Neurons, ?>, L extends FeedForwardLayer<A, L>> LayeredSupervisedFeedForwardNeuralNetworkBuilderSession withLayer(L layer);

}
