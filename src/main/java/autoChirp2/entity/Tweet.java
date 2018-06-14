package autoChirp2.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tweets")
public class Tweet implements Comparable<Tweet>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	TweetGroup group;
	
	@NotNull
	@Column(nullable = false)
	private String tweetDate;
	@NotNull
	@Column(nullable = false)
	private String content;
	
	@Column (columnDefinition="boolean default 0")
	private boolean scheduled;
	@Column (columnDefinition="boolean default 0")
	private boolean tweeted;
	private String imageUrl;
	private float longitude;
	private float latitude;
	private long statusID;
	@Transient
	private String trimmedContent;
	@Transient
	private int adjustedLength = -1;
	@Transient
	public static final int MAX_TWEET_LENGTH = 280;
	
	
	public Tweet(TweetGroup group, String date, String content){
		this.group = group;
		this.tweetDate = date;
		this.content = content;
	}
	
	//jpa
	public Tweet(){
		
	}

	@Override
	public int compareTo(Tweet tweet) {
		return this.tweetDate.compareTo(tweet.tweetDate);
	}
	
	private String trimContent(String toTrim, String url) {
		int maxLength = MAX_TWEET_LENGTH;
		if(url!= null){
			maxLength = maxLength - 25;
		}
		StringBuffer sb = new StringBuffer();
		char[] chars = toTrim.toCharArray();
		int counter = 0;
		for(int i = 0; i < chars.length; i++){
			counter++;
			if(Character.codePointAt(chars, i)>= 4352){
				counter++;
			}
			sb.append(chars[i]);
			if(counter == maxLength){
				break;
			}
			if(counter > maxLength){
				sb.deleteCharAt(sb.length()-1);
				break;
			}
		}
		if (url != null) {
			sb.append(" "+url);
		}
		this.trimmedContent = sb.toString();
		return sb.toString();
	}
	
	public String getTrimmedContent(){
		if(trimmedContent != null) return trimmedContent;
		String trimmed = this.content;
		String urlRegex = "(http(s)?:\\/\\/(.*))(\\s)?" ;
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(trimmed);
		String url = null;
		if(matcher.find()){
			url = matcher.group(1);
			trimmed = trimmed.replace(url, "");
		}	
		return trimContent(trimmed, url);
	}
	

	/**
	 * Get adjusted Tweet length (Twitter replaces URLs with t.co shortURLs,
	 * resulting in the necessity to adjust the content string lengths).
	 *
	 * @return The adjustet Tweet content length
	 */
	public int getAdjustedLength() {
		if(adjustedLength != -1){
			return adjustedLength;
		}
		String placeholder = String.format("%24s", "");
		String adjusted = this.content.replaceAll("https?://[^\\s]*", placeholder);
		char[] chars = adjusted.toCharArray();
		int counter = 0;
		for(int i = 0; i < chars.length; i++){
			counter++;
			if(Character.codePointAt(chars, i) >= 4352){
				counter++;
			}
		}
		return counter;
	}
	
	public String formatDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(tweetDate,dtf);
		dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		return dtf.format(date);
	}

	public TweetGroup getGroup() {
		return group;
	}

	public void setGroup(TweetGroup group) {
		this.group = group;
	}

	public String getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(String tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isScheduled() {
		return scheduled;
	}

	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}

	public boolean isTweeted() {
		return tweeted;
	}

	public void setTweeted(boolean tweeted) {
		this.tweeted = tweeted;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public long getStatusID() {
		return statusID;
	}

	public void setStatusID(long statusID) {
		this.statusID = statusID;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}

}
