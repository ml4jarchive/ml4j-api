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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.ml4j.nn.neurons.format.features.Dimension;

/**
 * WeightsFormat built from a list of input dimensions and a list of output dimensions.
 * 
 * @author Michael Lavelle
 */
public class WeightsFormatImpl implements WeightsFormat {

	private List<Dimension> inputDimensions;
	private List<Dimension> outputDimensions;
	private WeightsMatrixOrientation weightsMatrixOrientation;
	
	public WeightsFormatImpl(List<Dimension> inputDimensions, List<Dimension> outputDimensions, 
			WeightsMatrixOrientation weightsMatrixOrientation) {
		this.inputDimensions = inputDimensions;
		this.outputDimensions = outputDimensions;
		this.weightsMatrixOrientation = weightsMatrixOrientation;
	}

	public List<Dimension> getInputDimensions() {
		return inputDimensions;
	}

	public List<Dimension> getOutputDimensions() {
		return outputDimensions;
	}

	@Override
	public WeightsMatrixOrientation getOrientation() {
		return weightsMatrixOrientation;
	}
	
	@Override
	public List<Dimension> getDimensions() {
		List<Dimension> dimensions = new ArrayList<>();
		if (weightsMatrixOrientation == WeightsMatrixOrientation.ROWS_SPAN_OUTPUT_DIMENSIONS) {
			dimensions.addAll(outputDimensions);
			dimensions.addAll(inputDimensions);
		} else {
			dimensions.addAll(inputDimensions);
			dimensions.addAll(outputDimensions);
		}
		return dimensions;
	}
	
	@Override
	public String toString() {
		return getDimensions().stream().map(d -> d.getName()).collect(Collectors.toList()).toString();
	}
}
