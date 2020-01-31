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

import java.awt.image.BufferedImage;
import java.util.function.Supplier;



/**
 * Convenience interface for a DataSet, where the elements are suppliers of labeled data pairs of the 
 * scaled images and original BufferedImage.
 * 
 * @author Michael Lavelle
 * 
 * @param <L> The type of label associated with each Image.
 */
public interface ImagesWithBufferedImagesDataSet extends LabeledImagesDataSet<Supplier<BufferedImage>> {

}
