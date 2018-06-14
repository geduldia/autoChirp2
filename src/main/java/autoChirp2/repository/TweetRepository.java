package autoChirp2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import autoChirp2.entity.Tweet;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long>{

	List<Tweet> findByGroupId(long id);

}
