package com.sshproject.bookstore.Service;

import com.sshproject.bookstore.Entity.Genre;
import com.sshproject.bookstore.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements GenreServiceInterface{
    @Autowired
    private GenreRepository genreRepository;
    @Override
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
    @Override
    public Optional<Genre> getGenreById(int id){
        Optional<Genre> genreOptional = genreRepository.findById(id);
        if(genreOptional.isPresent()){
            return genreOptional;
        }
        return null;
    }
    @Override
    public int deleteGenreById(int id){
        Optional<Genre> genreOptional = getGenreById(id);
        if(genreOptional.isPresent()){
            genreRepository.deleteById(id);
            return id;
        }
        return -1;
    }

    @Override
    public int saveGenre(Genre genre){
        Genre newGenre = new Genre(genre.getName());
        genreRepository.save(newGenre);
        return newGenre.getId();
    }

    @Override
    public int getGenreIdByName(String name){
        Optional<Genre> genre1 = genreRepository.findByName(name);
        if(genre1 != null){
            return genre1.get().getId();
        }else {
            return -1;
        }
    }
}
