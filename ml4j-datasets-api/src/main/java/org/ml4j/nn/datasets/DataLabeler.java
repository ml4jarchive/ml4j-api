package org.ml4j.nn.datasets;

/**
 * Resposible for label
 * 
 * @author Michael Lavelle
 *
 * @param <E>
 * @param <L>
 */
public interface DataLabeler<E, L> {

	public L getLabel(long elementIndex, E element);

}
