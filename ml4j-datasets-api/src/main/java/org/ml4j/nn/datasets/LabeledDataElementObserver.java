package org.ml4j.nn.datasets;

public interface LabeledDataElementObserver<E, L, T extends LabeledDataSet<E, L>> {

	LabeledData<E, L> observe(LabeledData<E, L> labeledData);

}
