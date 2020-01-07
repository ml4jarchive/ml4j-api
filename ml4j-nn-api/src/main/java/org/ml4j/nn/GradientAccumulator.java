package org.ml4j.nn;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.ml4j.nn.axons.AxonsGradient;

public interface GradientAccumulator {

	/**
	 * Submit the CostAndGradients for a forward/back-propagation through the Neural Network to the
	 * GradientAccumulator, optionally returning a future handle to the most recently calculated
	 * average gradients.
	 * 
	 * By returning Optional.empty() this method indicates the the Neural Network that the 
	 * forward-propagation on the next batch should continue to use the previous weights without any updates - in
	 * effect increasing the local batch size.
	 * 
	 * If the method returns a non-null Future, then this indicates that the Neural Network should
	 * update its weights using the returned list of AxonsGradients before processing the next batch
	 * 
	 * @param costAndGradients The cost and gradients calculated after a forward/back-propagate through
	 * the Neural Network of a batch.
	 * 
	 * @return Either Optional.empty(), or a future handle to a list of average AxonsGradients as calculated
	 * determined by the GradientAccumulator
	 */
	Optional<Future<List<AxonsGradient>>> submitCostAndGradients(CostAndGradients costAndGradients);
}
