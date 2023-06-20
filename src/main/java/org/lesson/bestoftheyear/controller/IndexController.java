package org.lesson.bestoftheyear.controller;

//IMPORT
import org.lesson.bestoftheyear.model.Movie;
import org.lesson.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private String name = "Felo";

    public String getName() {
        return name;
    }
    String passedName = getName();


    ArrayList<Movie> myMoviesArrayList = new ArrayList<>();
    ArrayList<Song> mySongsArrayList = new ArrayList<Song>();

    private void generateBestMovieArrayList(){
        myMoviesArrayList.add(new Movie(1,"Interstellar"));
        myMoviesArrayList.add(new Movie(2,"Django"));
    };

    private void generateBestSongArrayList(){
        mySongsArrayList.add(new Song(1,"Bloodbath - polyphia"));
        mySongsArrayList.add(new Song(2,"Butterfly - kmac2021"));
    };

    public ArrayList<Movie> getBestMovies(){
        generateBestMovieArrayList();
        return myMoviesArrayList;
    };

    public ArrayList<Song> getBestSongs(){
        generateBestSongArrayList();
        return mySongsArrayList;
    };




    //url mapping
    @GetMapping
    public String home(Model model){
        model.addAttribute("userName", passedName);
        return "index";
    }

    @GetMapping("/movies")
    public  String movies(Model model){
        model.addAttribute("moviesList", getBestMovies().toString());
        model.addAttribute("userName", passedName);
        return "movies";
    }

    @GetMapping("/songs")
    public  String songs(Model model){
        model.addAttribute("songsList", getBestSongs().toString());
        model.addAttribute("userName", passedName);
        return "songs";
    }

}