package com.example.watchlist;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class Media implements Serializable {

    String title;
    String genre;
    String streamingService;
    String runTime; //might turn back into int
    boolean watched;
    int ratingNumber;

    static ArrayList<Media> toWatchMedia = new ArrayList<Media>();
    static ArrayList<Media> watchedMedia = new ArrayList<Media>();

    public Media() {
        toWatchMedia.add(this);
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
        toWatchMedia.remove(this);
        watchedMedia.add(this);
        this.watched = watched;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public static ArrayList<Media> getAllMedia() {
        return toWatchMedia;
    }

    public static void setAllMedia(ArrayList<Media> allMedia) {
        Media.toWatchMedia = allMedia;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    static void saveData() throws Exception {
        FileOutputStream fileOut = new FileOutputStream("SavedMovies");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(toWatchMedia);
        objectOut.writeObject(watchedMedia);
        objectOut.close();
        fileOut.close();
    }

    static void restoreData() throws Exception {
        FileInputStream fileIn = new FileInputStream("SavedMovies");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        toWatchMedia = (ArrayList<Media>) objectIn.readObject();
        watchedMedia = (ArrayList<Media>) objectIn.readObject();

        objectIn.close();
        fileIn.close();
    }

    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        // write NON-transient fields
        s.defaultWriteObject();
        // write transient fields
    }

}
