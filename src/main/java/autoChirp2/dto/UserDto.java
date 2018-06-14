package autoChirp2.dto;

public class UserDto {
	
	private long id;
	
	private String twitterId;
	
	private String oauthToken;
	
	private String oauthTokenSecret;
	
	public UserDto(String twitterId, String oauthToken, String oauthTokenSecret){
		this.twitterId = twitterId;
		this.oauthToken = oauthToken;
		this.oauthTokenSecret = oauthTokenSecret;
	}
	

	public UserDto(){
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	public String getOauthToken() {
		return oauthToken;
	}
	public void setOauthToken(String oauthToken) {
		this.oauthToken = oauthToken;
	}
	public String getOauthTokenSecret() {
		return oauthTokenSecret;
	}
	public void setOauthTokenSecret(String oauthTokenSecret) {
		this.oauthTokenSecret = oauthTokenSecret;
	}

	
}
