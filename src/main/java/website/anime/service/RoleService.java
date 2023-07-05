package website.anime.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import website.anime.model.Role;

@Service
public interface RoleService {
    public List<Role> getAllRole();

    public Optional<Role> findRoleById(int id);
}
