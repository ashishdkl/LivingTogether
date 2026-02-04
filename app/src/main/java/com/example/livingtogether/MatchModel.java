package com.example.livingtogether;

public class MatchModel {
    private String name;
    private String profilePicUrl;
    private String roomName;

    public MatchModel(String name, String profilePicUrl, String roomName) {
        this.name = name;
        this.profilePicUrl = profilePicUrl;
        this.roomName = roomName;
    }

    public String getName() { return name; }
    public String getProfilePicUrl() { return profilePicUrl; }
    public String getRoomName() { return roomName; }
}