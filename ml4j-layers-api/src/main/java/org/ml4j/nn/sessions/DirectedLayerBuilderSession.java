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

import org.ml4j.nn.axons.Axons3DConfigBuilder;
import org.ml4j.nn.layers.AveragePoolingFeedForwardLayer;
import org.ml4j.nn.layers.ConvolutionalFeedForwardLayer;
import org.ml4j.nn.layers.DirectedLayerFactory;
import org.ml4j.nn.layers.FullyConnectedFeedForwardLayer;
import org.ml4j.nn.layers.MaxPoolingFeedForwardLayer;
import org.ml4j.nn.layers.builders.AveragePoolingFeedForwardLayerPropertiesBuilder;
import org.ml4j.nn.layers.builders.MaxPoolingFeedForwardLayerPropertiesBuilder;

/**
 * Session interface for the creation of sub-sessions to be used for the creation of a single layer 
 * for various base types.
 * 
 * @author Michael Lavelle
 */
public interface DirectedLayerBuilderSession   {

	DirectedLayerFactory getDirectedLayerFactory();
	
	FullyConnectedFeedForwardLayerBuilderSession<FullyConnectedFeedForwardLayer> buildFullyConnectedLayer(String layerName);
	
	FeedForward3DLayerBuilderSession<AveragePoolingFeedForwardLayer, Axons3DConfigBuilder, 
		AveragePoolingFeedForwardLayerPropertiesBuilder<AveragePoolingFeedForwardLayer>> buildAveragePoolingLayer(String layerName);
	
	FeedForward3DLayerBuilderSession<MaxPoolingFeedForwardLayer, Axons3DConfigBuilder,
	MaxPoolingFeedForwardLayerPropertiesBuilder<MaxPoolingFeedForwardLayer>> buildMaxPoolingLayer(String layerName);
	
	ConvolutionalFeedForwardLayerBuilderSession<ConvolutionalFeedForwardLayer>
	 buildConvolutionalLayer(String layerName);
}
