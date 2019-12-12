package org.ml4j.nn.datasets;

import org.ml4j.streams.Streamable;

/**
 * Encapsulates a DataSet of elements of a defined type
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element within this DataSet
 */
public interface DataSet<E> extends Streamable<E> {

	BatchedDataSet<E> toBatchedDataSet(int batchSize);
}
