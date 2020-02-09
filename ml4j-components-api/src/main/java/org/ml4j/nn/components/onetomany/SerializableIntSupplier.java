package org.ml4j.nn.components.onetomany;

import java.io.Serializable;
import java.util.function.IntSupplier;

@FunctionalInterface
public interface SerializableIntSupplier extends IntSupplier, Serializable{

}
