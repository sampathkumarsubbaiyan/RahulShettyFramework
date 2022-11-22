package UtilityFiles.ResourcesPath;

public enum ApiPath {
    AddPlaceApi("maps/api/place/add/json"),
    GetPlaceApi("/maps/api/place/get/json");
    String path;
    ApiPath(String path){
        this.path=path;
    }
    public String getPath(){
        return path;
    }
}
