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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Base builder for subclasses of 3DAxonsConfig.
 * 
 * @author Michael Lavelle
 *
 */
public abstract class Axons3DConfigBuilderBase<C extends Axons3DConfig, T extends Axons3DConfigBuilderBase<C, T>> implements Serializable {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;

	protected int strideWidth;
	protected int strideHeight;
	protected Integer paddingWidth;
	protected Integer paddingHeight;
	protected Integer filterWidth;
	protected Integer filterHeight;
	protected Integer outputDepth;
	protected boolean outputBiasUnit;
	protected Neurons3D leftNeurons;
	protected Neurons3D rightNeurons;
	protected Boolean samePadding;

	public Axons3DConfigBuilderBase() {
		this.strideWidth = 1;
		this.strideHeight = 1;
	}
	
	public boolean isFullyPopulated() {
		return paddingHeight != null && paddingWidth != null && filterWidth != null && filterHeight != null && outputDepth != null
				&& leftNeurons != null && rightNeurons != null && samePadding != null;
	}
	
	public Axons3DConfigBuilderBase(Neurons3D leftNeurons) {
		this();
		if (leftNeurons == null) {
			throw new IllegalArgumentException("Left neurons cannot be null for this constructor");
		}
		this.leftNeurons = leftNeurons;
	}

	public int getStrideWidth() {
		return strideWidth;
	}

	public int getStrideHeight() {
		return strideHeight;
	}

	public Integer getPaddingWidth() {
		return paddingWidth;
	}

	public Integer getPaddingHeight() {
		return paddingHeight;
	}

	public Integer getFilterWidth() {
		return filterWidth;
	}

	public Integer getFilterHeight() {
		return filterHeight;
	}

	public Integer getOutputDepth() {
		return outputDepth;
	}

	public boolean isOutputBiasUnit() {
		return outputBiasUnit;
	}

	public Neurons3D getLeftNeurons() {
		return leftNeurons;
	}

	public Neurons3D getRightNeurons() {
		return rightNeurons;
	}

	public Boolean getSamePadding() {
		return samePadding;
	}

	public C build(Axons3DConfigPopulator<T> configPopulator) {

		if (leftNeurons == null) {
			throw new IllegalStateException("Input neurons have not been specified");
		}

		if (samePadding == null) {
			// Not same padding unless explicitly requested.
			samePadding = false;
		}
		return configPopulator.populateAndValidate(getInstance()).build();
	}
	
	protected abstract C createDefaultConfig(Neurons3D leftNeurons, Neurons3D rightNeurons);
	
	protected abstract T getInstance();
	
	C build() {
		
		C config = createDefaultConfig(leftNeurons, rightNeurons);
		
		if (filterHeight != null) {
			config.withFilterHeight(filterHeight);
		}
		
		if (filterWidth != null) {
			config.withFilterWidth(filterWidth);
		}
		
		if (paddingHeight != null) {
			config.withPaddingHeight(paddingHeight);
		} 
		if (paddingWidth != null) {
			config.withPaddingWidth(paddingWidth);
		} 
		
		config.withStrideHeight(strideHeight);
		config.withStrideWidth(strideWidth);
			
		return config;
	}

	public T withInputNeurons(Neurons3D neurons3D) {

		if (leftNeurons == null) {
			this.leftNeurons = neurons3D;
		} else {
			if (!leftNeurons.equals(neurons3D)) {
				throw new IllegalArgumentException(
						"Inconsistency been the passed in input neurons and those already set");
			}
		}

		return getInstance();
	}

	public T withFilterCount(int filterCount) {
		this.outputDepth = filterCount;
		return getInstance();
	}

	public T withSamePadding() {
		if (samePadding != null && !samePadding.booleanValue()) {
			throw new IllegalStateException("Valid padding has already been configured on this builder");
		}
		this.samePadding = true;
		return getInstance();
	}

	public T withValidPadding() {
		if (samePadding != null && samePadding.booleanValue()) {
			throw new IllegalStateException("Same padding has already been configured on this builder");
		}
		this.samePadding = false;
		return getInstance();
	}

	public T withOutputNeurons(Neurons3D rightNeurons) {
		if (rightNeurons == null) {
			throw new IllegalArgumentException("Output neurons cannot be set to null");
		}
		this.rightNeurons = rightNeurons;
		this.outputDepth = rightNeurons.getDepth();
		this.outputBiasUnit = rightNeurons.hasBiasUnit();
		return getInstance();
	}

	public T withStrideWidth(int strideWidth) {
		if (strideWidth < 1) {
			throw new IllegalArgumentException("Stride width must be >= 1");
		}
		this.strideWidth = strideWidth;
		return getInstance();
	}

	public T withStrideHeight(int strideHeight) {
		if (strideHeight < 1) {
			throw new IllegalArgumentException("Stride height must be >= 1");
		}
		this.strideHeight = strideHeight;
		return getInstance();
	}

	public T withFilterWidth(int filterWidth) {
		if (filterWidth < 1) {
			throw new IllegalArgumentException("Filter width must be >= 1");
		}
		this.filterWidth = filterWidth;
		return getInstance();
	}

	public T withFilterHeight(int filterHeight) {
		if (filterHeight < 1) {
			throw new IllegalArgumentException("Filter height must be >= 1");
		}
		this.filterHeight = filterHeight;
		return getInstance();
	}

	public T withPaddingWidth(int paddingWidth) {
		if (paddingWidth < 0) {
			throw new IllegalArgumentException("Padding width must be >= 0");
		}
		this.paddingWidth = paddingWidth;
		return getInstance();
	}

	public T withPaddingHeight(int paddingHeight) {
		if (paddingHeight < 0) {
			throw new IllegalArgumentException("Padding height must be >= 0");
		}
		this.paddingHeight = paddingHeight;
		return getInstance();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
