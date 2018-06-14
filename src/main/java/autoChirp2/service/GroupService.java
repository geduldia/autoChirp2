package autoChirp2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autoChirp2.entity.TweetGroup;
import autoChirp2.repository.GroupRepository;

@Service
public class GroupService {
	
	@Autowired
	private GroupRepository repo;
	
	public Optional<TweetGroup> getGroupById(long id){
		return repo.findById(id);
	}
	
	public TweetGroup saveGroup(TweetGroup group){
		return repo.save(group);

	}

}
