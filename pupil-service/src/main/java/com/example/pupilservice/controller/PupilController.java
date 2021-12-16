package com.example.pupilservice.controller;

import com.example.pupilservice.dto.LanguageDTO;
import com.example.pupilservice.dto.LearningDTO;
import com.example.pupilservice.dto.PupilDTO;
import com.example.pupilservice.servive.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/app/pupil")
public class PupilController {
    @Autowired
    PupilService pupilService;


    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return principal.getAccessTokenHash();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PupilDTO> getAllPupils() { return pupilService.getAllPupils(); }

    @GetMapping("/top")
    @ResponseStatus(HttpStatus.OK)
    public List<PupilDTO> getTopTen() { return pupilService.getTopTen(); }


    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public PupilDTO getByUsername(@PathVariable("email") String email) throws ParseException {
        return pupilService.getByEmail(email);
    }

    @GetMapping(path ="/alllangs", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    public List<LanguageDTO> getAllLangsByPupil(@RequestParam(value = "email") String email)
    { return pupilService.getLangsByPupil(email); }


//    @GetMapping(value = "/avatar/{avatarId}", produces = MediaType.IMAGE_JPEG_VALUE)
//    Resource downloadImage(@PathVariable(name="avatarId") Long avatarId) {
//        return pupilService.getImage(avatarId);
//    }

    @GetMapping("/avatar/{avatarId}")
    String downloadImage(@PathVariable(name="avatarId") Long avatarId) {
        return pupilService.getImageName(avatarId);
    }


    @PutMapping("/coins/add/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void addCoins(@PathVariable("email") String email, @RequestBody double coins){
        pupilService.addCoins(email, coins);
    }

    @PutMapping("/coins/deduct/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void deductCoins(@PathVariable("email") String email, @RequestBody Long itemId){
        pupilService.deductCoins(email, itemId);
    }

    @PutMapping("/level/{email}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLevel(@PathVariable("email") String email){
        pupilService.updateLevel(email);
    }

    @PostMapping("/lang/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLang(@RequestBody LearningDTO learningDTO) throws ParseException {
        pupilService.createLearning(learningDTO);
    }

    @DeleteMapping("/lang/remove/{id}")
    public void deleteLang(@PathVariable("id") Long id){
        pupilService.removeLearning(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PupilDTO createPupil(@RequestBody PupilDTO pupilDTO) throws ParseException {
        return pupilService.createPupil(pupilDTO);
    }


//    @PostMapping("/{email}/image")
//    public Long uploadImage(@PathVariable(name="email") String email, @RequestParam MultipartFile multipartImage) throws Exception {
//        return pupilService.storeImage(email, multipartImage);
//    }

    @PostMapping("/{email}/image")
    public Long uploadImage(@PathVariable(name="email") String email, @RequestBody String name) throws Exception {
        return pupilService.storeImageUrl(email, name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        pupilService.deletePupil(id);
    }

}
