package com.example.Guardian.security;

import com.example.Guardian.entity.User;
import com.example.Guardian.repository.AdminRepository;
import com.example.Guardian.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        // Try user table first
        return userRepository.findByEmailOrUsername(identifier, identifier)
                .map(this::mapUserToDetails)
                .orElseGet(() ->
                        adminRepository.findByEmailOrUsername(identifier, identifier)
                                .map(this::mapAdminToDetails)
                                .orElseThrow(() ->
                                        new UsernameNotFoundException("User not found: " + identifier)));
    }

    private UserDetails mapUserToDetails(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())))
                .accountExpired(false)
                .accountLocked(!user.isAccountNonLocked())
                .credentialsExpired(false)
                .disabled(!user.isEnabled())
                .build();
    }

    private UserDetails mapAdminToDetails(Admin admin) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(admin.getEmail())
                .password(admin.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + admin.getRole().name())))
                .accountExpired(false)
                .accountLocked(!admin.isAccountNonLocked())
                .credentialsExpired(false)
                .disabled(!admin.isEnabled())
                .build();
    }
}