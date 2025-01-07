package com.portal.jobportal.services;

import com.portal.jobportal.model.JobSeekerProfile;
import com.portal.jobportal.model.RecruiterProfile;
import com.portal.jobportal.model.Users;
import com.portal.jobportal.repository.JobSeekerProfileRepository;
import com.portal.jobportal.repository.RecruiterProfileRepository;
import com.portal.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser=usersRepository.save(users);
        int usersTypeId= users.getUserTypeId().getUserTypeId();
        if(usersTypeId ==1){
            recruiterProfileRepository.save(new RecruiterProfile(users));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(users));
        }

        return savedUser;
    }

    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }
}
