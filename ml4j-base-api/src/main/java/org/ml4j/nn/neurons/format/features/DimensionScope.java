package org.ml4j.nn.neurons.format.features;

public enum DimensionScope {
	INPUT, OUTPUT, ANY;
	
	boolean isValidWithin(DimensionScope other) {
		if (this == DimensionScope.ANY) {
			return true;
		} else {
			return this == other;
		}
	}
}
