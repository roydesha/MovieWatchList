package com.example.watchlist;

import java.time.LocalTime;
import java.util.ArrayList;

public class Media {

String title;
String genre;
String streamingService;
LocalTime runTime; //might turn back into int
boolean watched;

    static ArrayList<Media> allMedia = new ArrayList<Media>();

    public Media() {
        allMedia.add(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreamingService() {
        return streamingService;
    }

    public void setStreamingService(String streamingService) {
        this.streamingService = streamingService;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalTime getRunTime() {
        return runTime;
    }

    public void setRunTime(LocalTime runTime) {
        this.runTime = runTime;
    }

    public static ArrayList<Media> getAllMedia() {
        return allMedia;
    }

    public static void setAllMedia(ArrayList<Media> allMedia) {
        Media.allMedia = allMedia;
    }
}
