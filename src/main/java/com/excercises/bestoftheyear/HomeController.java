package com.excercises.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "Vincenzo Tavassi");
        return "index";
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie(1, "Il Signore degli Anelli");
        Movie movie2 = new Movie(2, "The Game");
        Movie movie3 = new Movie(3, "Full Metal Jacket");
        Movie movie4 = new Movie(4, "Interstellar");
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        return movies;
    }

    private List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song(1, "Knockin` on Heaven's Door");
        Song song2 = new Song(2, "Imagine");
        Song song3 = new Song(1, "I Will Survive");
        Song song4 = new Song(1, "Billy Jean");
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        return songs;

    }

    @GetMapping("/movies")
    public String getMovieIndex(Model model) {
        List<Movie> movies = getMovies();
        String movieList = "";
        for (Movie movie : movies) {
            if (movies.get(movies.size() -1 ).equals(movie)) movieList += movie.getTitle() + "."; // se è l'ultimo elemento aggiungo il punto
            else movieList += movie.getTitle() + ", "; // altrimenti la virgola
        }
model.addAttribute("movielist", movieList);
        return "movies";
    }

        @GetMapping("/songs")
        public String getSongIndex(Model model) {
            List<Song> songs = getSongs();
            String songList = "";
            for (Song song : songs) {
                if (songs.get(songs.size() -1 ).equals(song)) songList += song.getTitle() + "."; // se è l'ultimo elemento aggiungo il punto
                else songList += song.getTitle() + ", "; // altrimenti la virgola
            }
            model.addAttribute("songlist", songList);
            return "songs";
        }
    }


