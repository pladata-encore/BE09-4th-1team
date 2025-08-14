package com.playvoice.userservice.setup;

import com.playvoice.userservice.entity.PasswordStatus;
import com.playvoice.userservice.entity.User;
import com.playvoice.userservice.entity.UserRole;
import com.playvoice.userservice.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {

            List<User> user = List.of(

            User.builder()
                .email("서현@playvoice.com")
                .username("manager1")
                .password(passwordEncoder.encode("manager1"))
                .name("박서현")
                .role(UserRole.MANAGER)
                .course("수석매니저")
                .isBanned(false)
                .passwordStatus(PasswordStatus.INIT)
                .createdAt(LocalDateTime.now())
                .lastChangedPassword(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .profileImageUrl("/uploads/user_1_1752729780232.png")
                .build(),

            // -------------------------------------------------------------------

            User.builder()
                    .email("student1@example.com")
                    .username("student1")
                    .password(passwordEncoder.encode("student1"))
                    .name("만수르")
                    .role(UserRole.STUDENT)
                    .course("Full-Stack The 1st")
                    .isBanned(false)
                    .passwordStatus(PasswordStatus.INIT)
                    .createdAt(LocalDateTime.now())
                    .lastChangedPassword(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .profileImageUrl(null)
                    .build(),

            // -------------------------------------------------------------------

            User.builder()
                    .email("student2@example.com")
                    .username("student2")
                    .password(passwordEncoder.encode("student2"))
                    .name("트럼프")
                    .role(UserRole.STUDENT)
                    .course("Full-Stack The 1st")
                    .isBanned(false)
                    .passwordStatus(PasswordStatus.INIT)
                    .createdAt(LocalDateTime.now())
                    .lastChangedPassword(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .profileImageUrl(null)
                    .build()
            );

            userRepository.saveAll(user);
            System.out.println("User Data Inserted");
        }
    }

}
