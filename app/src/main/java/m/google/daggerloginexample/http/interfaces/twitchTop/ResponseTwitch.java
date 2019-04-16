package m.google.daggerloginexample.http.interfaces.twitchTop;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ResponseTwitch{

	@SerializedName("pagination")
	private Pagination pagination;

	@SerializedName("data")
	private List<DataItem> data;

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseTwitch{" + 
			"pagination = '" + pagination + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}