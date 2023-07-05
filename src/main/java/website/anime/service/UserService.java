package website.anime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import website.anime.model.User;

@Service
public interface UserService {
    public List<User> getAllUser();

    public void updateUser(User user);

    public void removeUserById(int id);

    public Optional<User> getUseById(int id);

    public Optional<User> getUserByEmail(String email);
}
