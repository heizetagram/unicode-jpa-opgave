package com.example._2024_09_06unicodejpaopgave.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Unicode {
    @Id
    @Column(unique = true)
    private int unicode;
    private char charValue;
    private String description;
    private String name;

    public int getUnicode() {
        return unicode;
    }

    public void setUnicode(int unicode) {
        this.unicode = unicode;
    }

    public char getCharacterValue() {
        return charValue;
    }

    public void setCharValue(char character) {
        this.charValue = character;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
