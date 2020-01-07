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

/**
 * Default config for 3D Axons.
 * 
 * @author Michael Lavelle
 *
 */
public class Axons3DConfig extends AxonsConfig {

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

	public Integer getFilterWidth() {
		return filterWidth;
	}

	public Integer getFilterHeight() {
		return filterHeight;
	}

	public Axons3DConfig withStrideWidth(int strideWidth) {
		this.strideWidth = strideWidth;
		return this;
	}

	public Axons3DConfig withStrideHeight(int strideHeight) {
		this.strideHeight = strideHeight;
		return this;
	}

	public Axons3DConfig withFilterWidth(int filterWidth) {
		this.filterWidth = filterWidth;
		return this;
	}

	public Axons3DConfig withFilterHeight(int filterHeight) {
		this.filterHeight = filterHeight;
		return this;
	}

	public Axons3DConfig withPaddingWidth(int paddingWidth) {
		this.paddingWidth = paddingWidth;
		return this;
	}

	public Axons3DConfig withPaddingHeight(int paddingHeight) {
		this.paddingHeight = paddingHeight;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filterHeight == null) ? 0 : filterHeight.hashCode());
		result = prime * result + ((filterWidth == null) ? 0 : filterWidth.hashCode());
		result = prime * result + paddingHeight;
		result = prime * result + paddingWidth;
		result = prime * result + strideHeight;
		result = prime * result + strideWidth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Axons3DConfig other = (Axons3DConfig) obj;
		if (filterHeight == null) {
			if (other.filterHeight != null)
				return false;
		} else if (!filterHeight.equals(other.filterHeight))
			return false;
		if (filterWidth == null) {
			if (other.filterWidth != null)
				return false;
		} else if (!filterWidth.equals(other.filterWidth))
			return false;
		if (paddingHeight != other.paddingHeight)
			return false;
		if (paddingWidth != other.paddingWidth)
			return false;
		if (strideHeight != other.strideHeight)
			return false;
		if (strideWidth != other.strideWidth)
			return false;
		return true;
	}

}
