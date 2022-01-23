package com.hayden.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //No cascade. We don't want the recipe to delete with the notes.
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
