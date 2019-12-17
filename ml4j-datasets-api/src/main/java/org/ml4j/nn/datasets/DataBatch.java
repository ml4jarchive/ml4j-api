package org.ml4j.nn.datasets;

import org.ml4j.nn.datasets.exceptions.FeatureExtractionException;
import org.ml4j.nn.datasets.floatarray.FloatArrayDataBatch;

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
	
	FloatArrayDataBatch toFloatArrayDataBatch(FeatureExtractor<E> featureExtractor, FeatureExtractionErrorMode featureExtractionErrorMode) throws FeatureExtractionException;

}
