package autoChirp2;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import autoChirp2.entity.Tweet;
import autoChirp2.entity.TweetGroup;
import autoChirp2.entity.User;
import autoChirp2.service.GroupService;
import autoChirp2.service.TweetService;
import autoChirp2.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@ContextConfiguration(classes = { UserService.class, GroupService.class, TweetService.class })
@AutoConfigurationPackage

public class PersistanceTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserService userService;

	@Autowired
	private TweetService tweetService;

	@Autowired
	private GroupService groupServie;

	@Test
	public void userPersistanceTest() {
		User user = new User("twitterId", "token", "secret");
		Long id = (Long) entityManager.persistAndGetId(user);
		Optional<User> found = userService.getUserById(id);
		assertTrue(found.get().getId() == user.getId());
		User saved = userService.saveUser(user);
		assertTrue(saved.getId() == user.getId());
		assertTrue(saved.getTwitterId().equals(user.getTwitterId()));
		assertTrue(saved.getOauthTokenSecret().equals(found.get().getOauthTokenSecret()));
	}

	@Test
	public void groupPersistanceTest() {
		User user = new User("twitterId", "token", "secret");
		entityManager.persist(user);
		TweetGroup group = new TweetGroup(user, "title");
		Long id = (Long) entityManager.persistAndGetId(group);
		Optional<TweetGroup> found = groupServie.getGroupById(id);
		assertTrue(found.get().getId() == group.getId());
		assertTrue(found.get().getTitle().equals(group.getTitle()));
		TweetGroup saved = groupServie.saveGroup(group);
		assertTrue(saved.getId() == group.getId());
		assertTrue(saved.getId() == found.get().getId());
	}

	@Test
	public void tweetPeristanceTest() {
		User user = new User("twitterId", "token", "secret");
		entityManager.persist(user);
		TweetGroup group = new TweetGroup(user, "title");
		entityManager.persist(group);
		Tweet tweet = new Tweet(group, "date", "content");
		Long id = (Long) entityManager.persistAndGetId(tweet);
		Optional<Tweet> found = tweetService.getTweetById(id);
		assertTrue(found.get().getId() == tweet.getId());
		assertTrue(found.get().getGroup().equals(tweet.getGroup()));
		assertTrue(found.get().getGroup().getUser().equals(tweet.getGroup().getUser()));
		Tweet saved = tweetService.saveTweet(found.get());
		assertTrue(saved.getId() == found.get().getId());
		assertTrue(saved.getGroup().getUser().equals(tweet.getGroup().getUser()));
	}
}
