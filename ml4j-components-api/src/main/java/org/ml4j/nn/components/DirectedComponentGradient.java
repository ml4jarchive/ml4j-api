package org.ml4j.nn.components;

import java.util.List;
import java.util.function.Supplier;

import org.ml4j.nn.axons.AxonsGradient;

public interface DirectedComponentGradient<O> {

	O getOutput();

	void addTotalTrainableAxonsGradient(Supplier<AxonsGradient> axonsGradient);

	List<Supplier<AxonsGradient>> getTotalTrainableAxonsGradients();

	List<Supplier<AxonsGradient>> getAverageTrainableAxonsGradients();

}
