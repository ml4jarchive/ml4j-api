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

package org.ml4j.nn.neurons;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Enum allowing a determination to be made whether the features of a
 * NeuronsActivation instance are represented by the rows or the columns of the
 * NeuronsActivation's Matrix.
 * 
 * @author Michael Lavelle
 */
public enum NeuronsActivationFeatureOrientation {

	/**
	 * Indicates that the matrix within a NeuronsActivation instance is oriented so
	 * that the columns span the feature set and the rows hold parallel activations.
	 */
	COLUMNS_SPAN_FEATURE_SET,

	/**
	 * Indicates that the matrix within a NeuronsActivation instance is oriented so
	 * that the rows span the feature set and the columns hold parallel activations.
	 */
	ROWS_SPAN_FEATURE_SET;
	
	public static Optional<NeuronsActivationFeatureOrientation> intersectOptionals(List<Optional<NeuronsActivationFeatureOrientation>> values) {
		return values.stream().reduce(Optional.empty(), (u, t) -> intersectOptionals(u, t));
	}
	
	public static Optional<NeuronsActivationFeatureOrientation> intersectOptionals(Optional<NeuronsActivationFeatureOrientation> first, 
			Optional<NeuronsActivationFeatureOrientation> second) {
		return first.isPresent() && second.isPresent() ? (first.get().equals(second.get()) ? first : Optional.empty()) : 
			first.isPresent() ? first : (second.isPresent() ? second : Optional.empty());
	}

	public static List<NeuronsActivationFeatureOrientation> intersectLists(
			List<NeuronsActivationFeatureOrientation> first, List<NeuronsActivationFeatureOrientation> second) {
		return first.stream().filter(f -> second.contains(f)).collect(Collectors.toList());
	}
	
	public static List<NeuronsActivationFeatureOrientation> intersectLists(List<List<NeuronsActivationFeatureOrientation>> values) {
		return values.stream().reduce(Arrays.asList(), (u, t) -> intersectLists(u, t));
	}	
}
