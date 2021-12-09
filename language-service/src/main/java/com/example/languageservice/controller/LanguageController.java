package com.example.languageservice.controller;

import com.example.languageservice.dto.LanguageDTO;
import com.example.languageservice.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/app/lang")
@CrossOrigin(origins = "*")
public class LanguageController {

    @Autowired
    LangService langService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LanguageDTO> getAllLangs() { return langService.getAllLangs(); }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LanguageDTO getById(@PathVariable("id") Long id) throws ParseException {
        return langService.getById(id);
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public LanguageDTO getByName(@PathVariable("name") String name) throws ParseException {
        return langService.getByName(name);
    }
}
