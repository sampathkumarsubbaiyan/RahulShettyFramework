package UtilityFiles.SetRequestGoogleApi;

import org.example.RequestPayloadPOJO.GoogleApis.AddPlaceRequest;
import org.example.RequestPayloadPOJO.GoogleApis.Location;

import java.util.ArrayList;
import java.util.List;

public class RequestBodyForGoogleApi {
    public AddPlaceRequest Serialization(String name ,String phoneNumber){
        AddPlaceRequest addPlaceRequest=new AddPlaceRequest();
        addPlaceRequest.setAccuracy(50);
        addPlaceRequest.setName(name);
        addPlaceRequest.setAddress("4/91,Kallangadu Thottam");
        addPlaceRequest.setPhoneNumber(phoneNumber);
        addPlaceRequest.setWebsite("www.velubrothers.com");
        addPlaceRequest.setLanguage("Tamil");
        Location location=new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlaceRequest.setLocation(location);
        List<String> list = new ArrayList<>();
        list.add("Kanakupillai Thottam");
        list.add("Ramasamy Thottam");
        addPlaceRequest.setTypes(list);
        return addPlaceRequest;
    }
}
