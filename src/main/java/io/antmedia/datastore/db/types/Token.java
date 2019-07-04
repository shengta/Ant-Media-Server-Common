package io.antmedia.datastore.db.types;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity("token")

@Indexes({ @Index(fields = @Field("tokenId")) })
@ApiModel(value="Token", description="The one-time token class")
public class Token {
	
	
	@JsonIgnore
	@Id
	@ApiModelProperty(value = "the db id of the token")
	private ObjectId dbId;
	
	public static final String PUBLISH_TOKEN = "publish";
	public static final String PLAY_TOKEN = "play";
	
	/**
	 * random tokenID
	 */
	@ApiModelProperty(value = "the token id of the token")
	private String tokenId;
	
	/**
	 * related streamId with token
	 */
	@ApiModelProperty(value = "the stream id of the token")
	private String streamId;
	
	/**
	 * expiration date of the token
	 */
	@ApiModelProperty(value = "the expire date of the token")
	private long expireDate;
	
	/**
	 * type of the token, such as publish, play etc.
	 */
	@ApiModelProperty(value = "the type of the token")
	private String type;
	
	/**
	 * token is related with playing streams in a Conference Room
	 */
	@ApiModelProperty(value = "token is related with playing streams in a Conference Room")
	private String roomName;
	
	
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}

	public long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(long expireDate) {
		this.expireDate = expireDate;
	}
	

}
