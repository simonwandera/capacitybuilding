package com.capacitybuilding.training.bean;

import com.capacitybuilding.training.action.UploadFile;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.Upload;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UploadsBean implements UploadsBeanI{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Upload> getUploads(Training training) {
        return entityManager.createQuery("FROM Upload u WHERE u.training.id=:trainingId", Upload.class)
                 .setParameter("trainingId", training.getId())
                 .getResultList();
    }
}
