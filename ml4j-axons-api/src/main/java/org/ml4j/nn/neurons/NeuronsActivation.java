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
package org.ml4j.nn.neurons;

import org.ml4j.FloatModifier;
import org.ml4j.FloatPredicate;
import org.ml4j.Matrix;
import org.ml4j.MatrixFactory;

public interface NeuronsActivation {
	
	int getFeatureCount();
	int getExampleCount();
	int getRows();
	int getColumns();
	void setImmutable(boolean immutable);
	boolean isImmutable();
	Matrix getActivations(MatrixFactory matrixFactory);
	NeuronsActivationFeatureOrientation getFeatureOrientation();
	void addInline(MatrixFactory matrixFactory, NeuronsActivation other);
	void combineFeaturesInline(NeuronsActivation other, MatrixFactory matrixFactory);
	void close();
	Neurons getNeurons();	
	void applyValueModifier(FloatPredicate condition, FloatModifier modifier);
	void applyValueModifier(FloatModifier modifier);
	NeuronsActivation dup();
	ImageNeuronsActivation asImageNeuronsActivation(Neurons3D neurons);

}
