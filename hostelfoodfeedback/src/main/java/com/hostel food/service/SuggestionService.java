package com.hostelfood.service;

import com.hostelfood.dao.MenuSuggestionDAO;
import com.hostelfood.entity.MenuSuggestion;

import java.util.List;

public class SuggestionService {

    private MenuSuggestionDAO suggestionDAO = new MenuSuggestionDAO();

    public void createSuggestion(MenuSuggestion suggestion) {
        suggestionDAO.save(suggestion);
    }

    public List<MenuSuggestion> getAllSuggestions() {
        return suggestionDAO.findAll();
    }

    public void updateSuggestion(MenuSuggestion suggestion) {
        suggestionDAO.update(suggestion);
    }
}