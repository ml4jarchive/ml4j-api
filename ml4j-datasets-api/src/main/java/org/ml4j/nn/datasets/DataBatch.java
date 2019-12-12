package org.ml4j.nn.datasets;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.neurons.NeuronsActivation;

/**
 * Encapsulates a finite size batch of elements of a defined type
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within this DataSet
 */
public interface DataBatch<E> extends DataSet<E> {

	int size();

	void add(E element);

	boolean isEmpty();

	NeuronsActivation toNeuronsActivation(MatrixFactory matrixFactory, FeatureExtractor<E> featureExtractor);

	NeuronsActivation toNeuronsActivation(MatrixFactory matrixFactory, LabelMapper<E> featureExtractor);

	// NeuronsActivationDataSet toNeuronsActivationDataSet(MatrixFactory
	// matrixFactory, FeatureExtractor<E> featureExtractor);

}
