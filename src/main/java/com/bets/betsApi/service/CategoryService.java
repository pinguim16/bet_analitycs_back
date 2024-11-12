package com.bets.betsApi.service;

import com.bets.betsApi.beans.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void delete(Long id);

}
