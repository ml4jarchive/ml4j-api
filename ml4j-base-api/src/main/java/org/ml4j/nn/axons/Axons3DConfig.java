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
	
	private int strideWidth;
	private int strideHeight;
	private int paddingWidth;
	private int paddingHeight;
	private Integer filterWidth;
	private Integer filterHeight;
	private Integer outputDepth;
	private boolean outputBiasUnit;
	
	public Axons3DConfig(Neurons3D leftNeurons, Neurons3D rightNeurons) {
		super(leftNeurons, rightNeurons);
		this.strideWidth = 1;
		this.strideHeight = 1;
		if (rightNeurons != null) {
			outputDepth = rightNeurons.getDepth();
			outputBiasUnit = rightNeurons.hasBiasUnit();
		}	
	}
	
	@Override
	public boolean isFullyPopulated() {
		try {
			getFilterWidth();
			getFilterHeight();
		} catch (Exception e) {
			return false;
		}
		return super.isFullyPopulated() && outputDepth != null;
	}
	
	protected Axons3DConfig(Neurons3D leftNeurons) {
		super(leftNeurons);
		this.strideWidth = 1;
		this.strideHeight = 1;
		if (rightNeurons != null) {
			outputDepth = rightNeurons.getDepth();
			outputBiasUnit = rightNeurons.hasBiasUnit();
		}	
	}

	@Override
	public Neurons3D getRightNeurons() {
		Neurons3D explictlySetRightNeurons = this.rightNeurons;
		if (explictlySetRightNeurons != null) {
			return explictlySetRightNeurons;
		} else {
			if (this.leftNeurons == null || outputDepth == null || filterWidth == null || filterHeight == null) {
				throw new IllegalStateException("Invalid configuration - right neurons have not been specified "
						+ "and they cannot be calculated from the provided configuration");
			} else {	
	
					int filterWidthMinusInputWidthWithPadding = filterWidth - leftNeurons.getWidth() + paddingWidth * 2;
					int filterWidthMinusInputWidthWithPaddingDividedByStrideWidth = filterWidthMinusInputWidthWithPadding/strideWidth;
					
					if (filterWidthMinusInputWidthWithPaddingDividedByStrideWidth * strideWidth != filterWidthMinusInputWidthWithPadding) {
						throw new IllegalStateException("The input width with padding is not an integer multiple of the stride width");
					}
					
					int rightNeuronsWidth = 1 - filterWidthMinusInputWidthWithPaddingDividedByStrideWidth;
					int filterHeightMinusInputHeightWithPadding = filterHeight - leftNeurons.getHeight() + paddingHeight * 2;
					int filterHeightMinusInputHeightWithPaddingDividedByStrideHeight= filterHeightMinusInputHeightWithPadding/strideHeight;
					
					if (filterHeightMinusInputHeightWithPaddingDividedByStrideHeight * strideHeight != filterHeightMinusInputHeightWithPadding) {
						throw new IllegalStateException("The input height with padding is not an integer multiple of the stride height");
					}
					
					int rightNeuronsHeight = 1 - filterHeightMinusInputHeightWithPaddingDividedByStrideHeight;
					
					if (rightNeuronsWidth < 1 || rightNeuronsHeight < 1) {
						throw new IllegalStateException("Invalid configuration - neither right neurons have been specified "
								+ "and the calculated right neurons base on the specified parameters would have dimensions < 1");
					} else {
						return new Neurons3D(rightNeuronsWidth, rightNeuronsHeight, outputDepth, outputBiasUnit);
					}		
				}
		}
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
		
		if (filterWidth == null && (leftNeurons == null || rightNeurons == null)) {
			throw new IllegalStateException("Invalid configuration - filterWidth has not been explicitly set, and"
					+ " leftNeurons and rightNeurons have not both been specified");
		}
		
		if (leftNeurons == null || rightNeurons == null) {
			return filterWidth;
		} else {
			
			// Left neurons and right neurons specified, filterWidth specified

			int inputWidthWithPadding = leftNeurons.getWidth() + paddingWidth * 2;

			int calculatedFilterWidth = inputWidthWithPadding + (1 - rightNeurons.getWidth()) * (strideWidth);

			if (calculatedFilterWidth < 1) {
				throw new IllegalStateException(
						"Invalid configuration - calculated filter width cannot be less than 1");
			}
	
			if (filterWidth != null && filterWidth.intValue() != calculatedFilterWidth) {
				throw new IllegalStateException("Explicitly set filter width of:" + filterWidth
						+ " is inconsistent with calculated filter width of:" + calculatedFilterWidth);
			}

			return calculatedFilterWidth;

		}
	}

	public int getFilterHeight() {

		if (filterHeight == null && (leftNeurons == null || rightNeurons == null)) {
			throw new IllegalStateException(
					"Invalid configuration -  filterHeight has not been explicitly set, and"
							+ " leftNeurons and rightNeurons have not both been specified");
		}

		if (leftNeurons == null || rightNeurons == null) {
			return filterHeight;
		} else {

			int inputHeightWithPadding = leftNeurons.getHeight() + paddingHeight * 2;

			int calculatedFilterHeight = inputHeightWithPadding + (1 - rightNeurons.getHeight()) * (strideHeight);

			if (calculatedFilterHeight < 1) {
				throw new IllegalStateException(
						"Invalid configuration - calculated filter height cannot be less than 1");
			}

			if (filterHeight != null && filterHeight.intValue() != calculatedFilterHeight) {
				throw new IllegalStateException("Explicitly set filter height of:" + filterHeight
						+ " is inconsistent with calculated filter height of:" + calculatedFilterHeight);
			}
			return calculatedFilterHeight;

		}
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
