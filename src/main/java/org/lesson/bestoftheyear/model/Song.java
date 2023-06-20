package org.lesson.bestoftheyear.model;

public class Song {

    private int id;
    private String title;

    public Song(int id, String title){
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return " title='" + title + '\'' ;
    }

}