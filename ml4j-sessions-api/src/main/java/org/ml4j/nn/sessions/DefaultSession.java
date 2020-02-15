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

import org.ml4j.nn.components.factories.DirectedComponentFactory;
import org.ml4j.nn.components.onetone.DefaultChainableDirectedComponent;
import org.ml4j.nn.layers.DirectedLayerFactory;
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
	 * @param neuralNetworkName The name for the neural network.
	 * @return Start a new SupervisedFeedForwardNeuralNetworkBuilderSession which allows
	 * a SupervisedFeedForwardNeuralNetworkBuilderSession to be built.
	 */
	SupervisedFeedForwardNeuralNetwork3DBuilderSession buildNeuralNetwork(String neuralNetworkName);
	
	
	
	DirectedLayerBuilderSession buildLayer();
	

}
