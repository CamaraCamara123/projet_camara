package ma.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.projet.entities.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

}
