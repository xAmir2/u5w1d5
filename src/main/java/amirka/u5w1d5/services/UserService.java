package amirka.u5w1d5.services;

import amirka.u5w1d5.entities.User;
import amirka.u5w1d5.exceptions.UserNotFoundEx;
import amirka.u5w1d5.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundEx(username));
    }
}
