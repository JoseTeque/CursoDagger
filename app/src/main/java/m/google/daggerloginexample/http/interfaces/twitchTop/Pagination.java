package m.google.daggerloginexample.http.interfaces.twitchTop;


import com.google.gson.annotations.SerializedName;


public class Pagination{

	@SerializedName("cursor")
	private String cursor;

	public void setCursor(String cursor){
		this.cursor = cursor;
	}

	public String getCursor(){
		return cursor;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"cursor = '" + cursor + '\'' + 
			"}";
		}
}