package m.google.daggerloginexample.http.interfaces.twitchStream;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class TwitchStream{

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("data")
	private List<DataItemStreams> data;

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setData(List<DataItemStreams> data){
		this.data = data;
	}

	public List<DataItemStreams> getData(){
		return data;
	}
}