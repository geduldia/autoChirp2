package autoChirp2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autoChirp2.entity.Tweet;
import autoChirp2.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository repo;

	
	public Optional<Tweet> getTweetById(long id){
		return repo.findById(id);
	}
	
	public Tweet saveTweet(Tweet tweet){
		return repo.save(tweet);
	}
	
	public List<Tweet> getTweetsByGroupId(long id){
		return repo.findByGroupId(id);
	}

}
