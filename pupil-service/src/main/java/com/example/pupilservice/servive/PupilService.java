package com.example.pupilservice.servive;

import com.example.pupilservice.dao.Avatar;
import com.example.pupilservice.dao.Learning;
import com.example.pupilservice.dao.Pupil;
import com.example.pupilservice.dto.*;
import com.example.pupilservice.proxy.LanguageServiceProxy;
import com.example.pupilservice.proxy.LessonServiceProxy;
import com.example.pupilservice.proxy.ShopServiceProxy;
import com.example.pupilservice.repository.AvatarRepository;
import com.example.pupilservice.repository.LearningRepository;
import com.example.pupilservice.repository.PupilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PupilService {
    @Autowired
    private PupilRepository pupilRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private LearningRepository learningRepository;

    @Autowired
    private LessonServiceProxy lessonServiceProxy;

    @Autowired
    private LanguageServiceProxy languageServiceProxy;

    @Autowired
    private ShopServiceProxy shopServiceProxy;

    @Autowired
    private ModelMapper modelMapper;


    public List<PupilDTO> getAllPupils() {
        List<Pupil> pupils = pupilRepository.findAll();
        return pupils.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<PupilDTO> getTopTen() {
        List<Pupil> pupils = pupilRepository.findTopTen();
        return pupils.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PupilDTO getById(Long id) {
        Optional<Pupil> pupil = pupilRepository.findById(id);
        if (pupil.isPresent()) {
            return convertToDto(pupil.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Pupil with id " + id);
        }
    }

    public PupilDTO getByUsername(String username) {
        Optional<Pupil> pupil = pupilRepository.findByUsername(username);
        if (pupil.isPresent()) {
            return convertToDto(pupil.get());
        } else {
            return null;
        }
    }

    public PupilDTO getByEmail(String email) {
        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        if (pupil.isPresent()) {
            return convertToDto(pupil.get());
        } else {
            return null;
        }
    }

    @Transactional
    public void addCoins(String email, double coins){
          Optional<Pupil> pupil = pupilRepository.findByEmail(email);
//          LessonDTO lessonDTO = lessonServiceProxy.getById(lessonId);
          if (pupil.isPresent() ) {
               pupil.get().increaseCoins(coins);
               pupilRepository.save(pupil.get());
          }
      }

    @Transactional
    public void deductCoins(String email, Long itemId){
        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        UpdateItemDTO updateItemDTO = shopServiceProxy.getById(itemId);
        if (pupil.isPresent() && updateItemDTO!= null) {
            pupil.get().decreaseCoins(updateItemDTO.getPrice());
            pupilRepository.save(pupil.get());
        }
    }

    @Transactional
    public void updateLevel(String email){
        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        if (pupil.isPresent()) {
            pupil.get().updateLevel();
            pupilRepository.save(pupil.get());
        }
    }

    @Transactional
    public void createLearning(LearningDTO learningDTO) throws ParseException {
        if (!learningRepository.findById(learningDTO.getId()).isPresent()
        && !learningRepository.existsLearningByLangIdAndPupilId(learningDTO.getLangId(), learningDTO.getPupilId())) {
            Learning newLearning = convertLearnToEntity(learningDTO);
            learningRepository.save(newLearning);
        }
    }

    @Transactional
    public void removeLearning(Long id){
        learningRepository.deleteByLangId(id);
    }

    public List<LearningDTO> getAllLangs() {
        List<Learning> learnings = learningRepository.findAll();
        return learnings.stream()
                .map(this::convertLearningToDto)
                .collect(Collectors.toList());
    }

    public List<LearningDTO> getAllLangsByPupil(String email) {
        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        List<Learning> learnings = learningRepository.findByPupilId(pupil.get().getId());
        return learnings.stream()
                .map(this::convertLearningToDto)
                .collect(Collectors.toList());
    }

    public List<LanguageDTO> getLangsByPupil(String email){
        List<LanguageDTO> langsByPupil = new ArrayList<>();
        List<LearningDTO> langsTemp = getAllLangsByPupil(email);
        for(LearningDTO learningDTO: langsTemp){
            LanguageDTO languageDTO = languageServiceProxy.getById(learningDTO.getLangId());
            if(languageDTO!=null){
                langsByPupil.add(languageDTO);
            }
        }
        return langsByPupil;
    }

    public void deletePupil(Long id) {
        pupilRepository.deleteById(id);
    }

    public PupilDTO createPupil(PupilDTO pupilDTO) throws ParseException {

        if (pupilRepository.findByEmail(pupilDTO.getEmail()).isPresent()) {
            return convertToDto(pupilRepository.findByEmail(pupilDTO.getEmail()).get());
        } else {
            Pupil createdPupil = convertToEntity(pupilDTO);
            createdPupil = pupilRepository.save(createdPupil);

            return convertToDto(pupilRepository.findByEmail(createdPupil.getEmail()).get());
        }
    }


    public Pupil dtoToDao(PupilDTO pupilDTO) throws ParseException {
        return convertToEntity(pupilDTO);
    }

    public PupilDTO convertToDto(Pupil pupil) {
        PupilDTO pupilDTO = modelMapper.map(pupil, PupilDTO.class);
        return pupilDTO;
    }

    public LearningDTO convertLearningToDto(Learning learning) {
        LearningDTO learningDTO = modelMapper.map(learning, LearningDTO.class);
        return learningDTO;
    }

    public Pupil convertToEntity(PupilDTO pupilDTO) throws ParseException {
        Pupil pupil = modelMapper.map(pupilDTO, Pupil.class);
        return pupil;
    }

    public Learning convertLearnToEntity(LearningDTO learningDTO) throws ParseException {
        Learning learning = modelMapper.map(learningDTO, Learning.class);
        return learning;
    }

    public Long storeImage(String email, MultipartFile multipartImage) throws IOException {
        Avatar avatar = new Avatar();
        avatar.setName(multipartImage.getName());
        avatar.setContent(multipartImage.getBytes());

        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        if (pupil.get().getAvatar() != null) {
            avatar.setId(pupil.get().getAvatar().getId());
        }
        pupil.get().setAvatar(avatarRepository.save(avatar));
        return pupilRepository.save(pupil.get()).getAvatar().getId();
    }

    public Long storeImageUrl(String email, String name) throws IOException {
        Avatar avatar = new Avatar();
        avatar.setName(name);
        avatarRepository.save(avatar);
        Optional<Pupil> pupil = pupilRepository.findByEmail(email);
        pupil.get().setAvatar(avatar);
        return pupilRepository.save(pupil.get()).getAvatar().getId();
    }

    public Resource getImage(Long imageId) {

        byte[] image = avatarRepository.findById(imageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getContent();
        return new ByteArrayResource(image);
    }

    public String getImageName(Long imageId){
        String name = avatarRepository.findById(imageId).get().getName();
        return name;
    }

}
