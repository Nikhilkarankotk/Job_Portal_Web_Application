package com.portal.jobportal.controller;


import ch.qos.logback.core.util.StringUtil;
import com.portal.jobportal.Util.FileUploadUtil;
import com.portal.jobportal.model.RecruiterProfile;
import com.portal.jobportal.model.Users;
import com.portal.jobportal.repository.UsersRepository;
import com.portal.jobportal.services.RecruiterProfileService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.spi.SyncResolver;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {

    private final UsersRepository usersRepository;

    private final RecruiterProfileService recruiterProfileService;

    public RecruiterProfileController(UsersRepository usersRepository, RecruiterProfileService recruiterProfileService) {
        this.usersRepository = usersRepository;
        this.recruiterProfileService = recruiterProfileService;
    }

    @GetMapping("/")
    public String recruiterProfile(Model model){
         Authentication authentication =
                 SecurityContextHolder.getContext().getAuthentication();
         if(!(authentication instanceof AnonymousAuthenticationToken)){
             String currentUsername = authentication.getName();
             Users users = usersRepository.findByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("Could not found User"));

             Optional<RecruiterProfile> recruiterProfile =
                     recruiterProfileService.getOne(users.getUserId());

             recruiterProfile.ifPresent(profile -> model.addAttribute("profile", profile));
         }
        return "recruiter_profile";
    }

    @PostMapping("/addNew")
    public String addNew(RecruiterProfile recruiterProfile,
                         @RequestParam("image")MultipartFile multipartFile,
                         Model model){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if(!(authentication instanceof AnonymousAuthenticationToken)){
           String currentUsername = authentication.getName();
           Users users =
                   usersRepository.findByEmail(currentUsername).orElseThrow(
                   () -> new UsernameNotFoundException("Could not found User"));
           recruiterProfile.setUserId(users);
           recruiterProfile.setUserAccountId(users.getUserId());
       }
       model.addAttribute("profile",recruiterProfile);
       String fileName = "";
       if(!multipartFile.getOriginalFilename().equals("")){
           fileName= StringUtils.getFilename(Objects.requireNonNull(multipartFile.getOriginalFilename()));
           recruiterProfile.setProfilePhoto(fileName);
       }
       RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

       String uploadDir = "photos/recruiter/"+savedUser.getUserAccountId();
       try{
           // read profile image from request multipartfile
           // save image on the server in directory: photos/recruiter
           FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
       }catch(Exception ex){
           ex.printStackTrace();
       }
       return "redirect:/dashboard/";
    }

}
