package com.tranquyet.service.impl;

import com.tranquyet.entity.UserEntity;
import com.tranquyet.repository.UserRepository;
import com.tranquyet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public void processOAuthPostLogin(String username, String idUser, String email) {
        UserEntity existUser = userRepository.getUserByIdFacebook(idUser);
        Optional<UserEntity> checkUserEntity = Optional.of(existUser);
        checkUserEntity.ifPresentOrElse(
                (value)->{
            log.info("------------------->Login successfully ");
                },
                ()->{
                    UserEntity newUser = new UserEntity();
                    newUser.setUsername(username);
                    newUser.setGmail(email);
                    newUser.setIdFacebook(idUser);
                    userRepository.save(newUser);
                    System.out.println("Created new user: " + username);
                });
    }
}
