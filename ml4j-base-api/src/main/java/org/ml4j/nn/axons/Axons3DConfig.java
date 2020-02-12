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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.ml4j.nn.neurons.Neurons3D;

/**
 * Default config for 3D Axons.
 * 
 * @author Michael Lavelle
 *
 */
public class Axons3DConfig extends AxonsConfig<Neurons3D, Neurons3D> {

	/**
	 * Default serialization id.
	 */
	private static final long serialVersionUID = 1L;
	
	private int strideWidth = 1;
	private int strideHeight = 1;
	private int paddingWidth = 0;
	private int paddingHeight = 0;
	private Integer filterWidth;
	private Integer filterHeight;
	
	public Axons3DConfig(Neurons3D leftNeurons, Neurons3D rightNeurons) {
		super(leftNeurons, rightNeurons);
	}

	public int getStrideWidth() {
		return strideWidth;
	}

	public int getStrideHeight() {
		return strideHeight;
	}

	public int getPaddingWidth() {
		return paddingWidth;
	}

	public int getPaddingHeight() {
		return paddingHeight;
	}

	public int getFilterWidth() {

		int inputWidthWithPadding = leftNeurons.getWidth() + paddingWidth * 2;

		int calculatedFilterWidth = inputWidthWithPadding + (1 - rightNeurons.getWidth()) * (strideWidth);

		if (filterWidth != null && filterWidth.intValue() != calculatedFilterWidth) {
			throw new IllegalStateException("Explicitly set filter width of:" + filterWidth
					+ " is inconsistent with calculated filter width of:" + calculatedFilterWidth);
		}

		return calculatedFilterWidth;
	}

	public int getFilterHeight() {

		int inputHeightWithPadding = leftNeurons.getHeight() + paddingHeight * 2;

		int calculatedFilterHeight = inputHeightWithPadding + (1 - rightNeurons.getHeight()) * (strideHeight);

		if (filterHeight != null && filterHeight.intValue() != calculatedFilterHeight) {
			throw new IllegalStateException("Explicitly set filter height of:" + filterHeight
					+ " is inconsistent with calculated filter height of:" + calculatedFilterHeight);
		}
		return calculatedFilterHeight;
	}


	public Axons3DConfig withStrideWidth(int strideWidth) {
		if (strideWidth < 1) {
			throw new IllegalArgumentException("Stride width must be >= 1");
		}
		this.strideWidth = strideWidth;
		return this;
	}

	public Axons3DConfig withStrideHeight(int strideHeight) {
		if (strideHeight < 1) {
			throw new IllegalArgumentException("Stride height must be >= 1");
		}
		this.strideHeight = strideHeight;
		return this;
	}

	public Axons3DConfig withFilterWidth(int filterWidth) {
		if (filterWidth < 1) {
			throw new IllegalArgumentException("Filter width must be >= 1");
		}
		this.filterWidth = filterWidth;
		return this;
	}

	public Axons3DConfig withFilterHeight(int filterHeight) {
		if (filterHeight < 1) {
			throw new IllegalArgumentException("Filter height must be >= 1");
		}
		this.filterHeight = filterHeight;
		return this;
	}

	public Axons3DConfig withPaddingWidth(int paddingWidth) {
		if (paddingWidth < 0) {
			throw new IllegalArgumentException("Padding width must be >= 0");
		}
		this.paddingWidth = paddingWidth;
		return this;
	}

	public Axons3DConfig withPaddingHeight(int paddingHeight) {
		if (paddingHeight < 0) {
			throw new IllegalArgumentException("Padding height must be >= 0");
		}
		this.paddingHeight = paddingHeight;
		return this;
	}
	
	@Override
	Axons3DConfig dup() {
		Axons3DConfig dupConfig = new Axons3DConfig(leftNeurons, rightNeurons).withStrideHeight(strideHeight)
				.withStrideWidth(strideWidth).withPaddingHeight(paddingHeight).withPaddingWidth(paddingWidth);
		if (filterHeight != null) {
			dupConfig = dupConfig.withFilterHeight(filterHeight);
		}
		if (filterWidth != null) {
			dupConfig = dupConfig.withFilterWidth(filterWidth);
		}
		return dupConfig;
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
