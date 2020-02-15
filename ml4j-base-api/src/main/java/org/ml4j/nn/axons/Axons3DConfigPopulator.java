/*
 * Copyright 2017 the original author or authors.
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

package org.ml4j.nn.axons;

/**
 * Responsible for populating any missing values from a Axons3DConfigBuilder given it's populated values,
 * and validating that the properties are all consistent.
 * 
 * @author Michael Lavelle
 *
 */
public interface Axons3DConfigPopulator<T extends Axons3DConfigBuilderBase<?, ?>> {

	/**
	 * Responsible for populating any missing values from a Axons3DConfigBuilder given it's populated values,
	 * and validating that the properties are all consistent.
	 * 
	 * @param configBuilder The Axons3DConfigBuilder builder to populate and validate
	 * @return The Axons3DConfigBuilder parameter, populated with consistent values for this configuration, if the 
	 * values are valid and consistent.  If the values are not consistent or cannot be calculated, an IllegalStateException
	 * or an IllegalArgumentException will be thrown.
	 */
	T populateAndValidate(T configBuilder);

}
