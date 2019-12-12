package org.ml4j.nn.datasets;

public interface LabeledData<E, L> {

	E getData();

	L getLabel();
}
