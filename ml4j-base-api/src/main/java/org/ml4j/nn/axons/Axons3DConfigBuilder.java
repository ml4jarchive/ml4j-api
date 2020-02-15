/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ml4j.nn.axons;

import java.io.Serializable;

import org.ml4j.nn.neurons.Neurons3D;

/**
 * Default builder for 3DAxonsConfig.
 * 
 * @author Michael Lavelle
 *
 */
public class Axons3DConfigBuilder extends Axons3DConfigBuilderBase<Axons3DConfig, Axons3DConfigBuilder> implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	public Axons3DConfigBuilder() {
		super();
	}

	public Axons3DConfigBuilder(Neurons3D leftNeurons) {
		super(leftNeurons);
	}

	@Override
	protected Axons3DConfig createDefaultConfig(Neurons3D leftNeurons, Neurons3D rightNeurons) {
		return new Axons3DConfig(leftNeurons, rightNeurons);
	}

	@Override
	protected Axons3DConfigBuilder getInstance() {
		return this;
	}
}
