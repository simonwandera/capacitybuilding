package com.capacitybuilding.assessment.bean;

import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.user.model.User;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



public class AssessmentBean implements AssessmentBeanI{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Assessment add(Assessment assessment) throws Exception {
        if(StringUtils.isBlank(assessment.getRemarks()))
            throw new Exception("Remarks cannot be null");
        if(assessment.getScore() < 1)
            throw new Exception("Invalid score");
        if(assessment.getEnrollment().getId() == null)
            throw new Exception("Invalid enrollment");

        return entityManager.merge(assessment);

    }

    @Override
    public void update(Assessment assessment) {

    }

    @Override
    public void delete(Assessment assessment) {

    }

    @Override
    public User getAssessment(Long id) {
        return null;
    }

    @Override
    public List<Assessment> list() {
        return null;
    }
}
