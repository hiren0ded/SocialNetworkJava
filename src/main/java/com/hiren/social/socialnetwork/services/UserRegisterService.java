package com.hiren.social.socialnetwork.services;

import com.hiren.social.socialnetwork.datamodel.User;
import com.hiren.social.socialnetwork.repository.UserRepository;
import com.hiren.social.socialnetwork.utils.HashGenerator;
import com.hiren.social.socialnetwork.utils.PatternMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
/**
 * UserRegisterService provides basic checks like email pattern check.
 * after building User object it will store User object in database.
 */
public class UserRegisterService {

    @Autowired
    private UserRepository userRepository;


    /**
     *
     * @param user_id : it should be unique
     * @param firstName
     * @param lastName
     * @param email : it should be unique
     * @param password
     * @return
     */
    public boolean addUser(final String user_id,
                           final String firstName,
                           final String lastName,
                           final String email,
                           final String password) {

        String[] passwordObject = HashGenerator.hashPassword(password);

        if(passwordObject == null) return false;

        UUID uniqueKey = UUID.randomUUID();
        User user = User.builder().userid(user_id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .salt(passwordObject[0])
                .hashedPassword(passwordObject[1])
                .uuid(uniqueKey.toString())
                .build();

        if(!checkInputData(user)) return false;

        userRepository.saveAndFlush(user);
        //TODO: Replace this with logger
        System.out.println(user);
        return true;
    }

    public boolean checkInputData(final User user){
        boolean emailCheck = PatternMatcher.emailMatcher(user.getEmail());
        return emailCheck;
    }
}
