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
	ROWS_SPAN_FEATURE_SET
}
