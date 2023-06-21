package com.excercises.bestoftheyear;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("name", "Vincenzo");
        return "index";
    }

    private List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Il Signore degli Anelli"));
        movies.add(new Movie(2, "The Game"));
        movies.add(new Movie(3, "Full Metal Jacket"));
        movies.add(new Movie(4, "Interstellar"));
        return movies;
    }

    private List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Knockin` on Heaven's Door"));
        songs.add(new Song(2, "Imagine"));
        songs.add(new Song(3, "I Will Survive"));
        songs.add(new Song(4, "Billy Jean"));
        return songs;

    }


    @GetMapping("/movies")
    public String getMovieIndex(Model model) {
        List<Movie> movies = getMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(@PathVariable Integer id, Model model) {
        Movie foundMovie = null;
        if (id > getMovies().size()) return "redirect:/movies";
        for (Movie movie : getMovies()) {
                if (movie.getId() == id) foundMovie = movie;
            }

        model.addAttribute("movie", foundMovie);
        return "moviedetails";
    }

    @GetMapping("/songs")
    public String getSongIndex(Model model) {
        List<Song> songs = getSongs();
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String getSongById(@PathVariable Integer id, Model model) {
        if (id > getMovies().size()) return "redirect:/songs";
        Song foundSong = null;
        for (Song song : getSongs()) {
            if (song.getId() == id) foundSong = song;
        }
        model.addAttribute("song", foundSong);
        return "songdetails";
    }


    // Metodi stringa
//    @GetMapping("/movies")
//    public String getMovieIndex(Model model) {
//        List<Movie> movies = getMovies();
//        String movieList = "";
//        for (Movie movie : movies) {
//            if (movies.get(movies.size() -1 ).equals(movie)) movieList += movie.getTitle() + "."; // se è l'ultimo elemento aggiungo il punto
//            else movieList += movie.getTitle() + ", "; // altrimenti la virgola
//        }
//model.addAttribute("movielist", movieList);
//        return "movies";
//    }

//        @GetMapping("/songs")
//        public String getSongIndex(Model model) {
//            List<Song> songs = getSongs();
//            String songList = "";
//            for (Song song : songs) {
//                if (songs.get(songs.size() -1 ).equals(song)) songList += song.getTitle() + "."; // se è l'ultimo elemento aggiungo il punto
//                else songList += song.getTitle() + ", "; // altrimenti la virgola
//            }
//            model.addAttribute("songlist", songList);
//            return "songs";
//        }

}



