package org.ml4j.nn.datasets.images;

import java.util.function.Supplier;

import org.ml4j.images.Image;
import org.ml4j.nn.datasets.DataBatch;

public interface ImagesBatch extends DataBatch<Supplier<Image>> {

}
