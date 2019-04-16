package m.google.daggerloginexample.http.interfaces.TwitchGame;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class TwitchGame{

	@SerializedName("data")
	private List<DataItemGame> data;

	public void setData(List<DataItemGame> data){
		this.data = data;
	}

	public List<DataItemGame> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"TwitchGame{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}