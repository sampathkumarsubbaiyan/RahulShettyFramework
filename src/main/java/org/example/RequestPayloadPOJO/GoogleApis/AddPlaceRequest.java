package org.example.RequestPayloadPOJO.GoogleApis;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AddPlaceRequest{

	@SerializedName("types")
	private List<String> types;

	@SerializedName("website")
	private String website;

	@SerializedName("address")
	private String address;

	@SerializedName("name")
	private String name;

	@SerializedName("accuracy")
	private int accuracy;

	@SerializedName("location")
	private Location location;

	@SerializedName("phone_number")
	private String phoneNumber;

	@SerializedName("language")
	private String language;

	public void setTypes(List<String> types){
		this.types = types;
	}

	public List<String> getTypes(){
		return types;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAccuracy(int accuracy){
		this.accuracy = accuracy;
	}

	public int getAccuracy(){
		return accuracy;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setLanguage(String language){
		this.language = language;
	}

	public String getLanguage(){
		return language;
	}
}