package autoChirp2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import autoChirp2.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
