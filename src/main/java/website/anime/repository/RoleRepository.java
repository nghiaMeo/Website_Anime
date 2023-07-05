package website.anime.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import website.anime.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
