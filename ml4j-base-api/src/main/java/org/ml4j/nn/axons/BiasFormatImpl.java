package org.ml4j.nn.axons;

import java.util.List;

import org.ml4j.nn.neurons.format.features.Dimension;

public class BiasFormatImpl extends WeightsFormatImpl implements BiasFormat {

	public BiasFormatImpl(List<Dimension> inputDimensions, List<Dimension> outputDimensions, WeightsMatrixOrientation orientation) {
		super(inputDimensions, outputDimensions, orientation);
	}
}
