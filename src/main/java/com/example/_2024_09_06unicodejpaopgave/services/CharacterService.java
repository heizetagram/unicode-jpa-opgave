package com.example._2024_09_06unicodejpaopgave.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService {

    // Get a list of characters by entered amount
    public List<Character> getCharactersByAmount(char c, int i) {
        List<Character> characterList = new ArrayList<>();
        for (int n = 0; n < i; n++) {
            characterList.add(c);
        }
        return characterList;
    }
}
