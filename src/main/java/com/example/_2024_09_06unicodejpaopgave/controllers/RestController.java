package com.example._2024_09_06unicodejpaopgave.controllers;

import com.example._2024_09_06unicodejpaopgave.models.Unicode;
import com.example._2024_09_06unicodejpaopgave.repositories.UnicodeRepository;
import com.example._2024_09_06unicodejpaopgave.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UnicodeRepository unicodeRepository;

    @Autowired
    private CharacterService characterService;

    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {
        int i = (int) c;
        return "char=" + c + " unicode=" + i;
    }

    @GetMapping("/unicodes")
    public List<Unicode> getUnicodes() {
        return unicodeRepository.findAll();
    }

    @GetMapping("/unicode/{c}/{i}")
    public List<Character> getCharactersByAmount(@PathVariable char c, @PathVariable int i) {
        return characterService.getCharactersByAmount(c, i);
    }
}
