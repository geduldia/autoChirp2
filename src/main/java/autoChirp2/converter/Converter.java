package autoChirp2.converter;

import org.modelmapper.ModelMapper;

import autoChirp2.dto.TweetDto;
import autoChirp2.dto.TweetGroupDto;
import autoChirp2.dto.UserDto;
import autoChirp2.entity.Tweet;
import autoChirp2.entity.TweetGroup;
import autoChirp2.entity.User;

public class Converter {
	private ModelMapper mapper = new ModelMapper();
	
	public User UserDtoToUser(UserDto userDto){
		return mapper.map(userDto, User.class);
		
	}
	
	public UserDto UserToDto(User user){
		return mapper.map(user, UserDto.class);
	}
	
	public Tweet tweetToEntity(TweetDto tweetDto){
		return mapper.map(tweetDto, Tweet.class);
	}

	public TweetDto tweetToDto(Tweet tweet){
		return mapper.map(tweet, TweetDto.class);
	}
	
	public TweetGroup groupToEntity(TweetGroupDto groupDto){
		return mapper.map(groupDto, TweetGroup.class);
	}
	
	public TweetGroupDto groupToDto(TweetGroup group){
		return mapper.map(group, TweetGroupDto.class);
	}
}
