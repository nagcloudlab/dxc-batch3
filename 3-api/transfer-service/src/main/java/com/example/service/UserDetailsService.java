package com.example.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> roles = userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(userEntity.getEmail(),
                userEntity.getPassword(), roles);
        return userDetails;
    }

}
