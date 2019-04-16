package m.google.daggerloginexample.http.interfaces.TwitchGame;


import com.google.gson.annotations.SerializedName;

public class DataItemGame {

	@SerializedName("box_art_url")
	private String boxArtUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setBoxArtUrl(String boxArtUrl){
		this.boxArtUrl = boxArtUrl;
	}

	public String getBoxArtUrl(){
		return boxArtUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

}