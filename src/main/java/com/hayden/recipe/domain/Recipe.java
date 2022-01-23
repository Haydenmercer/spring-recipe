package com.hayden.recipe.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@EqualsAndHashCode
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;
    //TODO: private Difficulty difficulty

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL) //Deletes notes if recipe is deleted. Bidirectional relationship.
    private Note notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") //Why not ManyToMany?
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

}
