package org.ml4j.nn.datasets;

import org.ml4j.MatrixFactory;
import org.ml4j.nn.neurons.NeuronsActivation;

public interface LabeledDataBatch<E, L> extends LabeledDataSet<E, L> {

	DataBatch<E> getDataSet();

	int size();

	void add(E element, L label);

	boolean isEmpty();

	LabeledData<NeuronsActivation, NeuronsActivation> toNeuronsActivations(MatrixFactory matrixFactory,
			FeatureExtractor<E> featureExtractor, LabelMapper<L> labelMapper);

}
