/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ml4j.nn.neurons;

/**
 * Format specification for a ImageNeuronsActivation, encapsulating the ImageFeaturesFormat, and
 * the NeuronsActivationFeaturesOrientation for matrix representation of multiple examples.
 * 
 * @author Michael Lavelle
 *
 * @param <F> The type of FeaturesFormat representing the data features.
 */
public class ImageNeuronsActivationFormat extends NeuronsActivationFormat<ImageFeaturesFormat> {

	public final static ImageNeuronsActivationFormat ML4J_DEFAULT_IMAGE_FORMAT
	 	= new ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation.ROWS_SPAN_FEATURE_SET, 
	 			ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH);
	
	public final static ImageNeuronsActivationFormat DL4J_DEFAULT_IMAGE_FORMAT
 	= new ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
 			ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH);
	
	public final static ImageNeuronsActivationFormat KERAS_CHANNELS_FIRST_IMAGE_FORMAT
 	= new ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
 			ImageFeaturesFormat.DEPTH_HEIGHT_WIDTH);
	
	public final static ImageNeuronsActivationFormat KERAS_CHANNELS_LAST_IMAGE_FORMAT
 	= new ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
 			ImageFeaturesFormat.HEIGHT_WIDTH_DEPTH);
	
	public final static ImageNeuronsActivationFormat TENSORFLOW_IMAGE_FORMAT
 	= new ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation.COLUMNS_SPAN_FEATURE_SET, 
 			ImageFeaturesFormat.HEIGHT_WIDTH_DEPTH);
	
	public ImageNeuronsActivationFormat(NeuronsActivationFeatureOrientation featureOrientation,
			ImageFeaturesFormat featuresFormat) {
		super(featureOrientation, featuresFormat);
	}
}
