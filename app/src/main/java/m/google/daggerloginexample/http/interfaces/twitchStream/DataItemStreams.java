package m.google.daggerloginexample.http.interfaces.twitchStream;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class DataItemStreams {

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_name")
	private String userName;

	@SerializedName("community_ids")
	private List<String> communityIds;

	@SerializedName("started_at")
	private String startedAt;

	@SerializedName("language")
	private String language;

	@SerializedName("id")
	private String id;

	@SerializedName("viewer_count")
	private int viewerCount;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("thumbnail_url")
	private String thumbnailUrl;

	@SerializedName("game_id")
	private String gameId;

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setCommunityIds(List<String> communityIds){
		this.communityIds = communityIds;
	}

	public List<String> getCommunityIds(){
		return communityIds;
	}

	public void setStartedAt(String startedAt){
		this.startedAt = startedAt;
	}

	public String getStartedAt(){
		return startedAt;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setViewerCount(int viewerCount){
		this.viewerCount = viewerCount;
	}

	public int getViewerCount(){
		return viewerCount;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	public void setGameId(String gameId){
		this.gameId = gameId;
	}

	public String getGameId(){
		return gameId;
	}
}