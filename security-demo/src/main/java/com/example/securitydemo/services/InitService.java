package com.example.securitydemo.services;

import com.example.securitydemo.model.entities.UserEntity;
import com.example.securitydemo.model.entities.UserRoleEntity;
import com.example.securitydemo.model.enums.UserRoleEnum;
import com.example.securitydemo.repositories.UserRepository;
import com.example.securitydemo.repositories.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitService {

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct


    private void initRoles() {
        if(userRoleRepository.count() == 0) {
            var moderatorRole = new UserRoleEntity().setRole(UserRoleEnum.MODERATOR);
            var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);

            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
        }
    }

    private void initUsers() {
        if(userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();

        }
    }
    private void initAdmin() {
        var adminUser = new UserEntity()
                .setEmail("admin@example.com")
                .setFirstName("Admin")
                .setLastName("Adminov")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setRoles(userRoleRepository.findAll());

        userRepository.save(adminUser);

    }

    private void initModerator() {

        var moderatorRole =
                userRoleRepository.findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow();

        var moderatorUser = new UserEntity()
                .setEmail("moderator@example.com")
                .setFirstName("moderator")
                .setLastName("moderatorov")
                .setPassword(passwordEncoder.encode("topsecret"))
                .setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);

    }

    private void initNormalUser() {

        var normalUser = new UserEntity().
                setEmail("user@example.com").
                setFirstName("User").
                setLastName("Userov").
                setPassword(passwordEncoder.encode("topsecret"));

        userRepository.save(normalUser);
    }

}
