package autoChirp2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="groups")
public class TweetGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="group_id", nullable = false)
	private User user;
	
	@NotNull
	@Column(nullable = false)
	private String title;

	private String description;
	@Column(columnDefinition = "boolean default 0")
	private boolean enabled;

	@Column(columnDefinition = "boolean default 0")
	private boolean threaded;
	
	@Column(columnDefinition = "VARCHAR(100) default 'default'")
	private String flashcard;
	
	public TweetGroup(User user, String title){
		this.user = user;
		this.title = title;
	}
	
	//jpa
	public TweetGroup(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
