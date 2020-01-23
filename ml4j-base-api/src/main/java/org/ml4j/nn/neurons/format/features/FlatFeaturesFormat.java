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
 * FeaturesFormat for a flat array of data without specified dimensions.
 * 
 * @author Michael Lavelle
 */
public class FlatFeaturesFormat implements FeaturesFormat {

	@Override
	public String toString() {
		return getDimensions().stream().map(d -> d.getName()).collect(Collectors.toList()).toString();
	}

	@Override
	public List<Dimension> getDimensions() {
		return Arrays.asList(Dimension.FEATURE);
	}
}
