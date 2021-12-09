package com.example.pupilservice.proxy;

import com.example.pupilservice.dto.LanguageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.util.List;

@FeignClient("LANGUAGE-SERVICE")
public interface LanguageServiceProxy {
    @GetMapping("/app/lang")
    List<LanguageDTO> getAllLangs();


    @GetMapping("/app/lang/{id}")
    LanguageDTO getById(@PathVariable("id") Long id);

}