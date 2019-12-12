package org.ml4j.nn.datasets.images;

import java.nio.file.Path;

import org.ml4j.nn.datasets.DataSet;

public interface ImagesWithPathsDataSet extends LabeledImagesDataSet<Path> {

	DataSet<Path> getPathsDataSet();
}
