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
package org.ml4j.nn.neurons.format.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FeaturesFormat for images.
 * 
 * @author Michael Lavelle
 */
public enum ImageFeaturesFormat implements FeaturesFormat {
	HEIGHT_WIDTH_DEPTH(Arrays.asList(Dimension.HEIGHT, Dimension.WIDTH, Dimension.DEPTH)), 
	DEPTH_HEIGHT_WIDTH(Arrays.asList(Dimension.DEPTH, Dimension.HEIGHT, Dimension.WIDTH)),
	IM_TO_COL_POOL(Arrays.asList(Dimension.FILTER_HEIGHT, Dimension.FILTER_WIDTH)),
	IM_TO_COL_CONV(Arrays.asList(Dimension.FILTER_HEIGHT, Dimension.FILTER_WIDTH, Dimension.DEPTH));
	
	List<Dimension> dims;
	
	ImageFeaturesFormat(List<Dimension> dims) {
		this.dims = dims;
	}
	
	public String toString() {
		return getDimensions().stream().map(d -> d.getName()).collect(Collectors.toList()).toString();
	}
	
	@Override
	public List<Dimension> getDimensions() {
		return dims;
	}
}
