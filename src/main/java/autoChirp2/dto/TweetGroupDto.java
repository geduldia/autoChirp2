package autoChirp2.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import autoChirp2.entity.User;

public class TweetGroupDto {

	private long id;
	private UserDto user;
	private String title;
	private String description;
	private boolean enabled;
	private boolean threaded;
	private String flashcard;

	public TweetGroupDto(UserDto user, String title) {
		this.user = user;
		this.title = title;
	}

	public TweetGroupDto() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isThreaded() {
		return threaded;
	}

	public void setThreaded(boolean threaded) {
		this.threaded = threaded;
	}

	public String getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(String flashcard) {
		this.flashcard = flashcard;
	}

}
