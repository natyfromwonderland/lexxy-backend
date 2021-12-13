package com.example.lessonservice.security;//package com.example.pupilservice.security;
//
//import com.example.pupilservice.controller.PupilController;
//import com.example.pupilservice.dao.Pupil;
//import com.example.pupilservice.repository.PupilRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private PupilRepository pupilRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username)
//            throws UsernameNotFoundException {
//        Pupil pupil = pupilRepository.findByUsername(username);
//
//        if (pupil == null) {
//            throw new UsernameNotFoundException("Could not find user");
//        }
//
//        return new CustomUserDetails(pupil);
//    }
//}
