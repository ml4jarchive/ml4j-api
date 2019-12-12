package org.ml4j.nn.datasets.images;

import java.util.function.Supplier;

import org.ml4j.images.Image;
import org.ml4j.nn.datasets.DataSet;

public interface ImagesDataSet extends DataSet<Supplier<Image>> {

}
