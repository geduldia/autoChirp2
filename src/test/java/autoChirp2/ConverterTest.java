package autoChirp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.internal.engine.groups.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import autoChirp2.dto.TweetDto;
import autoChirp2.dto.TweetGroupDto;
import autoChirp2.dto.UserDto;
import autoChirp2.entity.Tweet;
import autoChirp2.entity.TweetGroup;
import autoChirp2.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterTest {
	
	private ModelMapper mapper = new ModelMapper();
	
	
	
	@Test
	public void convertUserToEntity(){
		UserDto user = new UserDto("twitterId", "oauthToken", "tokenSecret");
		User entity = mapper.map(user, User.class);	
		assertEquals(user.getId(), entity.getId());
		assertEquals(user.getOauthToken(), entity.getOauthToken());
		assertEquals(user.getOauthTokenSecret(), entity.getOauthTokenSecret());
		assertEquals(user.getTwitterId(), entity.getTwitterId());
	}	
	
	@Test
	public void convertUserToDto(){
		User user = new User("twitterId", "token", "secret");
		UserDto dto = mapper.map(user, UserDto.class);	
		assertEquals(user.getId(), dto.getId());
		assertEquals(user.getOauthToken(), dto.getOauthToken());
		assertEquals(user.getOauthTokenSecret(), dto.getOauthTokenSecret());
		assertEquals(user.getTwitterId(), dto.getTwitterId());
	}
	
	@Test
	public void convertGroupToEntity(){
		UserDto user = new UserDto("twitterId", "token", "secret");
		TweetGroupDto group = new TweetGroupDto(user, "title");
		TweetGroup entity = mapper.map(group, TweetGroup.class);
		assertEquals(group.getId(), entity.getId());
		assertEquals(group.getUser().getId(), entity.getUser().getId());
		assertEquals(group.getDescription(), entity.getDescription());
		assertEquals(group.getTitle(), entity.getTitle());
		assertTrue(group.isEnabled() == entity.isEnabled());
		assertTrue(group.isThreaded() == entity.isThreaded());
	}
	
	@Test
	public void convertGroupToDto(){
		User user = new User("twitterId", "oauthToken", "tokenSecret");
		TweetGroup group = new TweetGroup(user, "title");
		TweetGroupDto dto = mapper.map(group, TweetGroupDto.class);
		assertEquals(group.getId(), dto.getId());
		assertEquals(group.getUser().getId(), dto.getUser().getId());
		assertEquals(group.getDescription(), dto.getDescription());
		assertEquals(group.getTitle(), dto.getTitle());
		assertTrue(group.isEnabled() == dto.isEnabled());
		assertTrue(group.isThreaded() == dto.isThreaded());
	}
	
	@Test
	public void convertTweetToEntity() {
		UserDto user = new UserDto("twitterId", "oauthToken", "tokenSecret");
		TweetGroupDto group = new TweetGroupDto(user, "title");
		TweetDto tweet = new TweetDto(group, "date", "content");
		Tweet entity = mapper.map(tweet, Tweet.class);
		assertEquals(tweet.getId(), entity.getId());
		assertEquals(tweet.getGroup().getId(), entity.getGroup().getId());
		assertEquals(tweet.getGroup().getUser().getId(), entity.getGroup().getUser().getId());
		assertEquals(tweet.getContent(), entity.getContent());
		assertEquals(tweet.getTweetDate(), entity.getTweetDate());
	
	}


	@Test
	public void convertTweetToDto() {
		User user = new User("twitterId", "oauthToken", "tokenSecret");
		TweetGroup group = new TweetGroup(user, "title");
		Tweet tweet = new Tweet(group, "date", "content");
		TweetDto dto = mapper.map(tweet, TweetDto.class);
		assertEquals(tweet.getId(), dto.getId());
		assertEquals(tweet.getGroup().getId(), dto.getGroup().getId());
		assertEquals(tweet.getGroup().getUser().getId(), dto.getGroup().getUser().getId());
		assertEquals(tweet.getContent(), dto.getContent());
		assertEquals(tweet.getTweetDate(), dto.getTweetDate());
		
	}

	
	
	
	


	
	
}
