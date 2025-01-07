package com.portal.jobportal.services;

import com.portal.jobportal.Util.CustomUserDetails;
import com.portal.jobportal.model.Users;
import com.portal.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public final class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Users user = usersRepository.findByEmail(username)
                 .orElseThrow(() -> new UsernameNotFoundException("Could not found user"));

        return new CustomUserDetails(user);
    }
}
