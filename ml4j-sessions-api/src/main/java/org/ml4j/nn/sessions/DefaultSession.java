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

import org.ml4j.nn.FeedForwardNeuralNetworkContext;
import org.ml4j.nn.LayeredFeedForwardNeuralNetworkContext;
import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.layers.DirectedLayerFactory;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;
import org.ml4j.nn.supervised.LayeredSupervisedFeedForwardNeuralNetworkFactory;
import org.ml4j.nn.supervised.SupervisedFeedForwardNeuralNetworkFactory;

/**
 * Convenience interface for a Session for the creation of graphs of DefaultChainableDirectedComponents.
 * 
 * Also provides access to a DirectedLayerFactory and a SupervisedFeedForwardNeuralNetworkFactory that enables the building of
 * higher-level components of DirectedLayer and SupervisedFeedForwardNeuralNetwork.
 * 
 * @author Michael Lavelle
 */
public interface DefaultSession extends Session<DefaultChainableDirectedComponent<?, ?>> {
	
	@Override
	DirectedComponentFactory getNeuralComponentFactory();
	
	/**
	 * @return The configured SupervisedFeedForwardNeuralNetworkFactory for this session.
	 */
	SupervisedFeedForwardNeuralNetworkFactory getSupervisedFeedForwardNeuralNetworkFactory();
	
	
	/**
	 * @return The configured LayeredSupervisedFeedForwardNeuralNetworkFactory for this session.
	 */
	LayeredSupervisedFeedForwardNeuralNetworkFactory getLayeredSupervisedFeedForwardNeuralNetworkFactory();

	/**
	 * @return The configured DirectedLayerFactory for this DefaultSession.
	 */
	DirectedLayerFactory getDirectedLayerFactory();
	
	/**
	 * Create a new builder session for a LayeredSupervisedFeedForwardNeuralNetwork or 
	 * operating on Neurons3D ( ie. image data) - builds a network with only FeedForwardLayer components)
	 * 
	 * @param neuralNetworkName The name for the neural network.
	 * @return  a new builder session for a LayeredSupervisedFeedForwardNeuralNetwork or 
	 * operating on Neurons3D ( ie. image data) - builds a network with only FeedForwardLayer components)
	 */
	LayeredSupervisedFeedForwardNeuralNetwork3DBuilderSession buildLayeredSupervised3DNeuralNetwork(String neuralNetworkName);

	/**
	 * Create a new builder session for a LayeredSupervisedFeedForwardNeuralNetwork (containing only FeedForwardLayer components, 
	 * operating on Neurons ( ie. flat data).
	 * 
	 * @param neuralNetworkName The name for the neural network.
	 * @return a new builder session for a LayeredSupervisedFeedForwardNeuralNetwork (containing only FeedForwardLayer components, 
	 * operating on Neurons ( ie. flat data).
	 */
	LayeredSupervisedFeedForwardNeuralNetworkBuilderSession buildLayeredSupervisedNeuralNetwork(String neuralNetworkName);
	
	
	/**
	 * Create a new builder session for a SupervisedFeedForwardNeuralNetwork operating on Neurons3D ( ie. image data).
	 * 
	 * @param neuralNetworkName The name for the neural network.
	 * @param initialNeurons The initial neurons.
	 * @return a new builder session for a SupervisedFeedForwardNeuralNetwork operating on Neurons3D ( ie. image data).
	 */
	SupervisedFeedForwardNeuralNetwork3DBuilderSession buildSupervised3DNeuralNetwork(String neuralNetworkName, Neurons3D initialNeurons);

	/**
	 * Create a new builder session for a SupervisedFeedForwardNeuralNetwork operating on Neurons ( ie. flat data).
	 * 
	 * @param neuralNetworkName The name for the neural network.
	 * @param initialNeurons The initial neurons.
	 * @return a new builder session for a SupervisedFeedForwardNeuralNetwork operating on Neurons ( ie. flat data).
	 */
	SupervisedFeedForwardNeuralNetworkBuilderSession buildSupervisedNeuralNetwork(String neuralNetworkName, Neurons initialNeurons);

	/**
	 * Create a new builder session for a single DirectedLayer
	 * 
	 * @return  a new builder session for a single DirectedLayer.
	 */
	DirectedLayerBuilderSession buildLayer();
	
	/**
	 * @return A FeedForwardNeuralNetworkContext 
	 */
	FeedForwardNeuralNetworkContext createSupervisedFeedForwardNeuralNetworkContext();
	
	
	/**
	 * @return A LayeredFeedForwardNeuralNetworkContext 
	 */
	LayeredFeedForwardNeuralNetworkContext createLayeredSupervisedFeedForwardNeuralNetworkContext();
	
	/**
	 * @return A lightweight wrapper around the current session, 
	 * with shared factories and configuration, but with training mode set to true.
	 * This will not change the training status of any previous contexts that have been generated
	 * using this session, but will change the status of any generated future contexts.
	 */
	DefaultSession asTrainingSession();
	
	/**
	 * @return A lightweight wrapper around the current session, 
	 * with shared factories and configuration, but with training mode set to false.
	 * This will not change the training status of any previous contexts that have been generated
	 * using this session, but will change the status of any generated future contexts.
	 */
	DefaultSession asNonTrainingSession();

	/**
	 * @return Whether this session is a training session.
	 */
	boolean isTrainingSession();
	

}
