package com.hayden.recipe.domain;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }

    @Test
    void getId() {
        long id = 4;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    void getRecipes() {
    }
}