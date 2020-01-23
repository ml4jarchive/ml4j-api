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
package org.ml4j.nn.neurons;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Format specification for a NeuronsActivation, encapsulating the FeaturesFormat, and
 * the NeuronsActivationFeaturesOrientation for matrix representation of multiple examples.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The type of FeaturesFormat representing the data features.
 */
public class NeuronsActivationFormat<F extends FeaturesFormat> {

	public static final NeuronsActivationFormat<?> ROWS_SPAN_FEATURE_SET = new NeuronsActivationFormat<>(NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, 
			new FlatFeaturesFormat());
	
	public static final NeuronsActivationFormat<?> COLUMNS_SPAN_FEATURE_SET = new NeuronsActivationFormat<>(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
			new FlatFeaturesFormat());
	
	protected NeuronsActivationFeatureOrientation featureOrientation;
	protected F featuresFormat;
	
	public NeuronsActivationFormat(NeuronsActivationFeatureOrientation featureOrientation,
			F featuresFormat) {
		this.featureOrientation = featureOrientation;
		this.featuresFormat = featuresFormat;
	}
	
	public NeuronsActivationFeatureOrientation getFeatureOrientation() {
		return featureOrientation;
	}



	public F getFeaturesFormat() {
		return featuresFormat;
	}

	@Override
	public String toString() {
		if (featureOrientation == NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET) {
			return featuresFormat.toString() + ",E";
		} else {
			return "E," + featuresFormat.getId();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((featureOrientation == null) ? 0 : featureOrientation.hashCode());
		result = prime * result + ((featuresFormat == null || featuresFormat.getId() == null) ? 0 : featuresFormat.getId().hashCode());
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
		NeuronsActivationFormat<?> other = (NeuronsActivationFormat<?>) obj;
		if (featureOrientation != other.featureOrientation)
			return false;
		if (featuresFormat == null) {
			if (other.featuresFormat != null)
				return false;
		} else if (featuresFormat.getId() == null || other.featuresFormat.getId() == null) {
			return false;
		} else if (!featuresFormat.getId().equals(other.featuresFormat.getId())) {
			return false;
		}
		return true;
	}
	
	public static Optional<NeuronsActivationFormat<?>> intersectOptionals(
			List<Optional<NeuronsActivationFormat<?>>> values) {
		return values.stream().reduce(Optional.empty(), (u, t) -> intersectOptionals(u, t));
	}

	public static Optional<NeuronsActivationFormat<?>> intersectOptionals(
			Optional<NeuronsActivationFormat<?>> first, Optional<NeuronsActivationFormat<?>> second) {
		return first.isPresent() && second.isPresent() ? (first.get().equals(second.get()) ? first : Optional.empty())
				: first.isPresent() ? first : (second.isPresent() ? second : Optional.empty());
	}

	public static List<NeuronsActivationFormat<?>> intersectLists(
			List<NeuronsActivationFormat<?>> first, List<NeuronsActivationFormat<?>> second) {
		return first.stream().filter(f -> second.contains(f)).collect(Collectors.toList());
	}

	public static List<NeuronsActivationFormat<?>> intersectLists(
			List<List<NeuronsActivationFormat<?>>> values) {
		return values.stream().reduce(Arrays.asList(), (u, t) -> intersectLists(u, t));
	}
}
