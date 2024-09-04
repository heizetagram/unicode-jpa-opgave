package com.example._2024_09_06unicodejpaopgave.services;

import com.example._2024_09_06unicodejpaopgave.models.Unicode;
import com.example._2024_09_06unicodejpaopgave.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CharacterService {
    @Autowired
    private UnicodeRepository unicodeRepository;

    // Get a list of characters by entered amount
    public List<Character> getCharactersByAmount(char c, int i) {
        List<Character> characterList = new ArrayList<>();
        for (int n = 0; n < i; n++) {
            characterList.add(c);
        }
        return characterList;
    }

    // Save unicodes to database
    public void saveUnicodeToDB() {
        Set<Character> characterSet = new HashSet<>();
        int n = 0;
        char charValue = (char) n;
        Unicode unicode = new Unicode();

        while (characterSet.add(charValue)) {
            unicode.setUnicode(n);
            unicode.setCharValue(charValue);
            unicode.setName(Character.getName(n));
            unicode.setDescription(checkCharType(charValue));

            unicodeRepository.save(unicode);
            n++;
            charValue = (char) n;
        }
    }

    // Check character type
    private String checkCharType(Character c) {
        String charType;
        if (Character.isLetter(c)) {
            charType = "Letter";
        } else if (Character.isDigit(c)) {
            charType = "Digit";
        } else if (Character.isEmoji(c)) {
            charType = "Emoji";
        } else {
            charType = null;
        }
        return charType;
    }
}
