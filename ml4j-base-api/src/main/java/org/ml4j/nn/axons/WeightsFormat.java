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
package org.ml4j.nn.axons;

import java.io.Serializable;
import java.util.List;

import org.ml4j.nn.neurons.format.features.Dimension;

/**
 * Interface for a format for data features (eg. "D,H,W" or "H,W,D" for images ).
 * 
 * @author Michael Lavelle
 */
public interface WeightsFormat extends Serializable {
	/**
	 * @return The input dimensions of this format
	 */
	List<Dimension> getInputDimensions();
	
	/**
	 * @return The output dimensions of this format
	 */
	List<Dimension> getOutputDimensions();
	
	/**
	 * @return The orientation of any associated matrix
	 */
	WeightsMatrixOrientation getOrientation();
	
	/**
	 * @return The dimensions of this format, according to the orientation.
	 */
	List<Dimension> getDimensions();
}
