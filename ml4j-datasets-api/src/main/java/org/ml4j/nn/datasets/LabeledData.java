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
 * Container for labeled data - associating elements of type E with a label of type L.
 * 
 * @author Michael Lavelle
 *
 * @param <E> The type of element being labelled.
 * @param <L> The type of label associated with each element.s
 */
public interface LabeledData<E, L> {

	/**
	 * @return The data element.
	 */
	E getData();

	/**
	 * 
	 * @return The label associated with the data element.
	 */
	L getLabel();
}
