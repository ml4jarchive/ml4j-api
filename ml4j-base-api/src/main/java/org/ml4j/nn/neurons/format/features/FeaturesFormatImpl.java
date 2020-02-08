/*
 * Copyright 2020 the original author or authors.
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
package org.ml4j.nn.neurons.format.features;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FeaturesFormat built from a list of dimensions.
 * 
 * @author Michael Lavelle
 */
public class FeaturesFormatImpl implements FeaturesFormat {

	private List<Dimension> dimensions;
	
	public FeaturesFormatImpl(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}
	
	@Override
	public String toString() {
		return getDimensions().stream().map(d -> d.getName()).collect(Collectors.toList()).toString();
	}

	@Override
	public List<Dimension> getDimensions() {
		return dimensions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
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
		FeaturesFormatImpl other = (FeaturesFormatImpl) obj;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
		return true;
	}
	
	
}
