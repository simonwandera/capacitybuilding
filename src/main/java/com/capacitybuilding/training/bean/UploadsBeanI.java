package com.capacitybuilding.training.bean;

import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.Upload;

import java.util.List;

public interface UploadsBeanI {

    List<Upload> getUploads(Training training);

    Upload upload(Upload file) throws Exception;
}
