package com.hostelfood.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menu_suggestions")
public class MenuSuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suggestion_id")
    private Integer suggestionId;

    @ManyToOne
    @JoinColumn(name = "committee_user_id", nullable = false)
    private User committeeUser;

    @Column(name = "problem_description", nullable = false)
    private String problemDescription;

    @Column(name = "suggestion", nullable = false)
    private String suggestion;

    private String status = "PENDING";

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "decision_date")
    private LocalDate decisionDate;

    public MenuSuggestion() {}

    public Integer getSuggestionId() { return suggestionId; }
    public void setSuggestionId(Integer suggestionId) { this.suggestionId = suggestionId; }

    public User getCommitteeUser() { return committeeUser; }
    public void setCommitteeUser(User committeeUser) { this.committeeUser = committeeUser; }

    public String getProblemDescription() { return problemDescription; }
    public void setProblemDescription(String problemDescription) { this.problemDescription = problemDescription; }

    public String getSuggestion() { return suggestion; }
    public void setSuggestion(String suggestion) { this.suggestion = suggestion; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public LocalDate getDecisionDate() { return decisionDate; }
    public void setDecisionDate(LocalDate decisionDate) { this.decisionDate = decisionDate; }
}
