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

import java.util.function.Consumer;

import org.ml4j.nn.axons.Axons3DConfigBuilderBase;
import org.ml4j.nn.layers.builders.FeedForward3DLayerPropertiesBuilder;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Base Session interface for the creation of a specific type
 * of builder of a feed forward layer with 3D Neurons - includes the
 * initial step of builder logic and an intermediate step.
 * 
 * @author Michael Lavelle
 *
 */
public interface FeedForward3DLayerBuilderSession<C, A extends Axons3DConfigBuilderBase<?, ?>, B extends FeedForward3DLayerPropertiesBuilder<?, A>> {

	B withInputNeurons(Neurons3D neurons);
	
	C withConfig(Consumer<A> configConfigurer);
}
