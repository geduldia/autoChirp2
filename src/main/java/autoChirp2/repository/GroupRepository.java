package autoChirp2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import autoChirp2.entity.TweetGroup;

@Repository
public interface GroupRepository extends CrudRepository<TweetGroup, Long> {

}
