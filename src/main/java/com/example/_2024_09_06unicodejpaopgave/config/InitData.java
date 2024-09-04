package com.example._2024_09_06unicodejpaopgave.config;

import com.example._2024_09_06unicodejpaopgave.models.Unicode;
import com.example._2024_09_06unicodejpaopgave.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        saveUnicodeToDB();
    }

    // Save unicodes to database
    private void saveUnicodeToDB() {
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
