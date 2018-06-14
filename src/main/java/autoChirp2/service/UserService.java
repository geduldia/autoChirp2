package autoChirp2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import autoChirp2.entity.User;
import autoChirp2.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public Optional<User> getUserById(long id){
		return repo.findById(id);
	}
	
	public User saveUser(User user){
		return repo.save(user);
	}

}
