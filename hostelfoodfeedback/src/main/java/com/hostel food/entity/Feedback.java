package com.hostelfood.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Integer feedbackId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "meal_type", nullable = false)
    private String mealType;

    @Column(name = "food_quality", nullable = false)
    private Integer foodQuality;

    @Column(name = "taste", nullable = false)
    private Integer taste;

    @Column(name = "hygiene", nullable = false)
    private Integer hygiene;

    private String comment;

    @Column(name = "feedback_date", nullable = false)
    private LocalDate feedbackDate;

    public Feedback() {}

    public Integer getFeedbackId() { return feedbackId; }
    public void setFeedbackId(Integer feedbackId) { this.feedbackId = feedbackId; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public String getMealType() { return mealType; }
    public void setMealType(String mealType) { this.mealType = mealType; }

    public Integer getFoodQuality() { return foodQuality; }
    public void setFoodQuality(Integer foodQuality) { this.foodQuality = foodQuality; }

    public Integer getTaste() { return taste; }
    public void setTaste(Integer taste) { this.taste = taste; }

    public Integer getHygiene() { return hygiene; }
    public void setHygiene(Integer hygiene) { this.hygiene = hygiene; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDate getFeedbackDate() { return feedbackDate; }
    public void setFeedbackDate(LocalDate feedbackDate) { this.feedbackDate = feedbackDate; }
}   