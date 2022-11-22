package ResponsePayloadPOJO;

import com.google.gson.annotations.SerializedName;

public class AddPlaceResponse{

	@SerializedName("reference")
	private String reference;

	@SerializedName("scope")
	private String scope;

	@SerializedName("id")
	private String id;

	@SerializedName("place_id")
	private String placeId;

	@SerializedName("status")
	private String status;

	public void setReference(String reference){
		this.reference = reference;
	}

	public String getReference(){
		return reference;
	}

	public void setScope(String scope){
		this.scope = scope;
	}

	public String getScope(){
		return scope;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPlaceId(String placeId){
		this.placeId = placeId;
	}

	public String getPlaceId(){
		return placeId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}