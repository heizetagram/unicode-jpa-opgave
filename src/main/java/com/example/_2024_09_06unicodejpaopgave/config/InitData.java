package com.example._2024_09_06unicodejpaopgave.config;

import com.example._2024_09_06unicodejpaopgave.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private CharacterService characterService;

    @Override
    public void run(String... args) throws Exception {
        characterService.saveUnicodeToDB();
    }
}
