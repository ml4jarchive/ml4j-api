/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.ml4j.nn.datasets;

/**
 * Responsible for labelling elements of type E with a label of type L.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element being labelled.
 * @param <L> The type of label being attached to each element.
 */
public interface DataLabeler<E, L> {

	/**
	 * Obtain a label for the specified element index and element.
	 *  
	 * @param elementIndex The index of the element in the parent batch.
	 * @param element The element to obtain the label for.
	 * @return The label of the element.
	 */
	public L getLabel(long elementIndex, E element);

}
