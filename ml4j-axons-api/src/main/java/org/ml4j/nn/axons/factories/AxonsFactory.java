/*
 * Copyright 2019 the original author or authors.
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
package org.ml4j.nn.axons.factories;

import java.io.Serializable;

import org.ml4j.nn.axons.AveragePoolingAxons;
import org.ml4j.nn.axons.Axons;
import org.ml4j.nn.axons.Axons3DConfig;
import org.ml4j.nn.axons.AxonsConfig;
import org.ml4j.nn.axons.AxonsType;
import org.ml4j.nn.axons.BiasMatrix;
import org.ml4j.nn.axons.ConvolutionalAxons;
import org.ml4j.nn.axons.FullyConnectedAxonsFactory;
import org.ml4j.nn.axons.MaxPoolingAxons;
import org.ml4j.nn.axons.ScaleAndShiftAxons;
import org.ml4j.nn.axons.WeightsMatrix;
import org.ml4j.nn.neurons.Neurons;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * A factory for different types of Axons.
 * 
 * @author Michael Lavelle
 */
public interface AxonsFactory extends FullyConnectedAxonsFactory, Serializable {

	/**
	 * Construct a ConvolutionalAxons instance.
	 * 
	 * @param axons3DConfig     The Axons3DConfig
	 * @param connectionWeights The convolutional connection weights.
	 * @param biases            The convolutional biases.
	 * @return A ConvolutionalAxons instance.
	 */
	ConvolutionalAxons createConvolutionalAxons(Axons3DConfig axons3DConfig, WeightsMatrix connectionWeights, BiasMatrix biases);

	
	/**
	 * Create an Axons instance by type.
	 * 
	 * @param axonsType The type of the axons.
	 * @param axonsConfig The config for the axons.
	 * @return The axons component.
	 */
	Axons<Neurons, Neurons, ?> createAxons(AxonsType axonsType,  AxonsConfig<Neurons, Neurons> axonsConfig);
	

	/**
	 * Create an Axons instance by type.
	 * 
	 * @param axonsType The type of the axons.
	 * @param axonsConfig The config for the axons.
	 * @return The axons component.
	 */
	Axons<Neurons3D, Neurons3D, ?> createAxons3D(AxonsType axonsType,  AxonsConfig<Neurons3D, Neurons3D> axonsConfig);
	
	/**
	 * Create an Axons instance by type.
	 * 
	 * @param axonsType The type of the axons.
	 * @param axonsConfig The config for the axons.
	 * @return The axons component.
	 */
	Axons<Neurons3D, Neurons3D, ?> createAxons3DWith3DConfig(AxonsType axonsType,  Axons3DConfig axonsConfig);
	
	/**
	 * Construct a MaxPoolingAxons instance.
	 *
	 * @param scaleOutputs  Whether to scale the output of these max pooling axons
	 *                      by a scaling factor to compensate for the max-pooling
	 *                      dropout.
	 * @param axons3DConfig The Axons3DConfig
	 * @return A MaxPoolingAxons instance.
	 */
	MaxPoolingAxons createMaxPoolingAxons(Axons3DConfig axons3DConfig, boolean scaleOutputs);

	/**
	 * Construct an AveragePoolingAxons instance
	 * 
	 * @param axons3DConfig The Axons3DConfig
	 * @return An AveragePoolingAxons instance.
	 */
	AveragePoolingAxons createAveragePoolingAxons(Axons3DConfig axons3DConfig);

	/**
	 * Construct a scale-and-shift Axons instance.
	 * 
	 * @param <N>          The type of Neurons on the LHS and RHS of these axons.
	 * @param axonsConfig The config for the axons.
	 * @param gamma        The scaling column vector.
	 * @param beta         The shifting beta vector.
	 * @return A scale-and-shift Axons instance.
	 */
	<N extends Neurons> ScaleAndShiftAxons<N> createScaleAndShiftAxons(AxonsConfig<N, N> axonsConfig, WeightsMatrix gamma, BiasMatrix beta);
}
