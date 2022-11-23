package com.capacitybuilding.training.bean;

import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.training.model.Upload;
import org.apache.commons.lang3.StringUtils;

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


    public Upload upload(Upload file) throws Exception {


        if (StringUtils.isBlank(file.getFileName()))
            throw new Exception("Filename is required");
        if (file.getTraining().getId() == null)
            throw new Exception("Invalid training");
        return entityManager.merge(file);

    }
    @Override
    public List<Upload> getUploads(Training training) {
        return entityManager.createQuery("FROM Upload u WHERE u.training.id=:trainingId", Upload.class)
                 .setParameter("trainingId", training.getId())
                 .getResultList();
    }
}
