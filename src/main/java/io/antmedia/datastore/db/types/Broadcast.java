package io.antmedia.datastore.db.types;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity("broadcast")
@Indexes({
		@Index(fields = @Field("name")),
		@Index(fields = @Field("streamId"))
})
public class Broadcast {

	/**
	 * id of the broadcast
	 */
	@JsonIgnore
	@Id
	private ObjectId dbId;


	private String streamId;

	/**
	 * "finished", "broadcasting", "created" 
	 */
	private String status;

	/**
	 * name of the broadcast
	 */
	private String name;

	/**
	 * description of the broadcast
	 */
	private String description;

	/**
	 * It is a video filter for the service, 
	 * this value is controlled by the user, 
	 * default value is true in the db
	 */
	private boolean publish = true;

	/**
	 * date when record is created in milliseconds
	 */
	private Long date;

	/**
	 * Planned start date
	 */
	private Long plannedStartDate;

	/**
	 * duration of the stream in milliseconds
	 */
	private Long duration;

	@Embedded
	private List<Endpoint> endPointList;

	/**
	 * is public
	 */
	private boolean publicStream = true;

	/**
	 * If this stream is a 360 degree video
	 */
	private boolean is360 = false;;

	/**
	 * This is the url that will be notified when stream is published, ended and muxing finished
	 * 
	 * It sends some variables with POST UrlEncodedForm
	 * 
	 * variables are
	 * "id" mandatory 
	 * This is the id of the broadcast
	 * 
	 * "action" mandatory
	 * 	This parameter defines what happened. Values can be
	 * 		"liveStreamStarted"
	 * 		this parameter is sent when stream is started
	 * 
	 * 		"liveStreamEnded"
	 *  		this parameter is sent when stream is finished
	 *  
	 *  		"vodReady"
	 *  		this parameter is sent when vod(mp4) file ready. It is typically a few seconds later after "liveStreamEnded"
	 * 
	 * 
	 * "vodName" 
	 * 	It is send with "vodReady" action. This is the name of the file physicall recorded file
	 *  
	 * "streamName" optional
	 *  It is send with above parameters if stream name exists
	 *  
	 * "category" optional
	 *  It is send if category exists
	 * 
	 */
	private String listenerHookURL;

	private String category;

	/**
	 * This is the expire time in milliseconds 
	 * For instance if this value is 10000 then
	 * broadcast should be started in 10 seconds after it is created.
	 * 
	 * If expire duration is 0, then stream will never expire
	 */
	private int expireDurationMS;

	/**
	 * RTMP URL where to publish live stream to
	 */
	private String rtmpURL;


	public Broadcast(String status, String name) {
		this.setStatus(status);
		this.setName(name);
	}

	public Broadcast() {
	}

	public String getStreamId() {
		return streamId;
	}

	public void setStreamId(String id) throws Exception {
		if (id == null) {
			throw new Exception("stream id cannot be null");
		}
		this.streamId = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Long plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public List<Endpoint> getEndPointList() {
		return endPointList;
	}

	public void setEndPointList(List<Endpoint> endPointList) {
		this.endPointList = endPointList;
	}


	public boolean isIs360() {
		return is360;
	}

	public void setIs360(boolean is360) {
		this.is360 = is360;
	}

	public boolean isPublicStream() {
		return publicStream;
	}

	public void setPublicStream(boolean publicStream) {
		this.publicStream = publicStream;
	}

	public String getListenerHookURL() {
		return listenerHookURL;
	}

	public void setListenerHookURL(String listenerHookURL) {
		this.listenerHookURL = listenerHookURL;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getExpireDurationMS() {
		return expireDurationMS;
	}

	public void setExpireDurationMS(int expireDurationMS) {
		this.expireDurationMS = expireDurationMS;
	}

	public String getRtmpURL() {
		return rtmpURL;
	}

	public void setRtmpURL(String rtmpURL) {
		this.rtmpURL = rtmpURL;
	}

	public ObjectId getDbId() {
		return dbId;
	}

	public void setDbId(ObjectId dbId) {
		this.dbId = dbId;
	}


}