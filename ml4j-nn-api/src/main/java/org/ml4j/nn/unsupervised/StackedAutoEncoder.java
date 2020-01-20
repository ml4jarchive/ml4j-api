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

package org.ml4j.nn.unsupervised;

import java.util.List;

import org.ml4j.nn.LayeredFeedForwardNeuralNetwork;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Interface for a stacked AutoEncoder.
 * 
 * @author Michael Lavelle
 */
public interface StackedAutoEncoder extends UnsupervisedNeuralNetwork<StackedAutoEncoderContext, StackedAutoEncoder>,
		LayeredFeedForwardNeuralNetwork<StackedAutoEncoderContext, StackedAutoEncoder> {

	/**
	 * @param inputActivations The input activations
	 * @param context          The context.
	 */
	public void trainGreedilyLayerwise(NeuronsActivation inputActivations, StackedAutoEncoderContext context);

	List<AutoEncoder> getAutoEncoderStack();

}
