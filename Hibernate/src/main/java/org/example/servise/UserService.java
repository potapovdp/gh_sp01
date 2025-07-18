package org.example.servise;

import org.example.repo.interfaces.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void allUserOperations() {
        log.info("User with the id = 1 is " + userRepository.findById("1").toString());
        log.info(userRepository.findAll().toString());
    }
}
