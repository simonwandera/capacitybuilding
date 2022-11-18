package com.capacitybuilding.assessment.bean;

import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.user.model.User;
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
@Named("assessmentBean")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AssessmentBean implements AssessmentBeanI{

    @PersistenceContext
    EntityManager entityManager;
    public Assessment add(Assessment assessment) throws Exception {
        if(StringUtils.isBlank(assessment.getRemarks()))
            throw new Exception("Remarks cannot be null");
        if(assessment.getScore() < 1)
            throw new Exception("Invalid score");
        if(assessment.getEnrollment().getId() == null)
            throw new Exception("Invalid enrollment");

        return entityManager.merge(assessment);

    }

    public void update(Assessment assessment) {

    }

    public void delete(Assessment assessment) {

    }

    public User getAssessment(Long id) {
        return null;
    }

    public List<Assessment> list() {
        return entityManager.createNamedQuery(Assessment.FIND_ALL, Assessment.class)
                .getResultList();
    }
}
