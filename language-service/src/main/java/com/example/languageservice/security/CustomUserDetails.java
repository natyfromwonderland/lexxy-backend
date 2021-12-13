package com.example.languageservice.security;//package com.example.pupilservice.security;
//
//import com.example.pupilservice.dao.Pupil;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//public class CustomUserDetails implements UserDetails {
//
//    private Pupil pupil;
//
//    public CustomUserDetails(Pupil pupil) {
//        this.pupil = pupil;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        Collection<GrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + pupil.getRole()));
//        return authorities;
//    }
//
//    @Override
//    public String getPassword(){
//        return pupil.getPassword();
//    }
//
//    @Override
//    public String getUsername(){
//        return pupil.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
