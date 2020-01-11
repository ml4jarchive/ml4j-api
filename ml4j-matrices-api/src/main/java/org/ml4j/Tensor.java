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
package org.ml4j;

import java.io.Serializable;

public interface Tensor<T extends Tensor<T, E, I>, E extends T, I extends T> extends Serializable {
	
	int argmax();
	float get(int i);
	float sum();
	int getLength();
	
	T mul(float v);
	T add(float v);
	T div(float v);
	T sub(float v);
	
	T div(T other);
	T sub(T other);
	T mul(T other);
	T add(T other);


	T sigmoid();
	T log();
	T logi();
	
	void close();
	boolean isClosed();

	
	T dup();

	E asEditableMatrix();
	I asInterrimMatrix();

	
	boolean isImmutable();
	void setImmutable(boolean immutable);


}
