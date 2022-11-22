package com.capacitybuilding.training.bean;

import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.Upload;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Stateless
@Remote
@Named("uploadsBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
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
