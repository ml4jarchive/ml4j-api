package org.ml4j.nn.axons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.ml4j.nn.neurons.format.features.Dimension;

public interface BiasFormat extends WeightsFormat {

	@Override
	default WeightsMatrixOrientation getOrientation() {
		return WeightsMatrixOrientation.ROWS_SPAN_OUTPUT_DIMENSIONS;
	}

	public static BiasFormat DEFAULT_BIAS_FORMAT = new BiasFormat() {};
	
	@Override
	default List<Dimension> getInputDimensions() {
		return Arrays.asList(Dimension.INPUT_FEATURE);
	}

	@Override
	default List<Dimension> getOutputDimensions() {
		return Arrays.asList(Dimension.OUTPUT_FEATURE);
	}
	
	@Override
	default List<Dimension> getDimensions() {
		List<Dimension> dimensions = new ArrayList<>();
		if (getOrientation() == WeightsMatrixOrientation.ROWS_SPAN_OUTPUT_DIMENSIONS) {
			dimensions.addAll(getOutputDimensions());
			dimensions.addAll(getInputDimensions());
		} else {
			dimensions.addAll(getInputDimensions());
			dimensions.addAll(getOutputDimensions());
		}
		return dimensions;
	}
}
