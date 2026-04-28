package org.backend.clientservice.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.backend.clientservice.entity.User;
import org.backend.clientservice.repository.UserRepository;
import org.backend.clientservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElse(User.builder()
                        .id(id)
                        .name("Unknown")
                        .email("unknown@email.com")
                        .build());
    }
}
