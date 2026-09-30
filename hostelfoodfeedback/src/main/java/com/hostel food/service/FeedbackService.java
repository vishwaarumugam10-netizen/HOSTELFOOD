package com.hostelfood.service;

import com.hostelfood.dao.FeedbackDAO;
import com.hostelfood.entity.Feedback;

import java.time.LocalDate;

public class FeedbackService {

    private FeedbackDAO feedbackDAO = new FeedbackDAO();

    public boolean submitFeedback(Feedback feedback) {

        boolean exists = feedbackDAO.exists(
                feedback.getStudent().getStudentId(),
                feedback.getMealType(),
                feedback.getFeedbackDate()
        );

        if (exists) {
            return false;
        }

        feedbackDAO.save(feedback);
        return true;
    }

    public boolean alreadySubmitted(
            Integer studentId,
            String mealType,
            LocalDate date) {

        return feedbackDAO.exists(studentId, mealType, date);
    }
}