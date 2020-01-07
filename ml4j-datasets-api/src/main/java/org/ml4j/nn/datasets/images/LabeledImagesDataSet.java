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
package org.ml4j.nn.datasets.images;

import java.util.function.Supplier;

import org.ml4j.images.Image;
import org.ml4j.nn.datasets.LabeledDataSet;

/**
 * Convenience interface for a LabeledDataSet of suppliers of Image instances with labels of type L - allowing for lazy-read of images.
 * 
 * @author Michael Lavelle
 * 
 * @param <L> The type of label associated with each Image.
 */
public interface LabeledImagesDataSet<L> extends LabeledDataSet<Supplier<Image>, L> {

	/**
	 * @return An ImagesDataSet consisting of only the images of this LabeledImagesDataSet 
	 */
	ImagesDataSet getDataSet();
}
