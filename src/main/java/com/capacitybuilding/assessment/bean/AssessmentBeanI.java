package com.capacitybuilding.assessment.bean;

import com.capacitybuilding.assessment.model.Assessment;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.user.model.User;

import java.util.List;

public interface AssessmentBeanI {
    Assessment add(Assessment assessment) throws Exception;
    void update(Assessment assessment);
    void delete(Assessment assessment);
    User getAssessment(Long id);
    List<Assessment> list();
    List<Assessment> listByTrainings(Training training);

    List<Assessment> getAssessments(User trainee);

    List<Assessment> getAvgAssessmentsByUser(Training training);

    List<Assessment> getAvgAssessmentsByTraining(Training training);

    List<Assessment> getAvgAssessmentsByTraining();

    List<Assessment> getAvgAssessmentsByUser();

    List<Assessment> trainerAvgAssessmentsByTraining(User trainer);
    List<Assessment> trainerAvgAssessmentsByUser(User trainer);

    List<Assessment> trainerGetAssessments(User trainer);
}
