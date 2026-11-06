package com.movieflix.service.impl;

import com.movieflix.dto.MovieDto;
import com.movieflix.entities.movies;
import com.movieflix.service.FileService;
import com.movieflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    /*@Autowired
    private MovieRepo movieRepo;*/
    @Autowired
    private FileService fileService;

    @Value("${project.poster}") // value from .yml
    private String path;

    @Override
    public List<MovieDto> getMovies() throws IOException {
        return List.of();
    }

    @Override
    public MovieDto getMovie(Integer id) throws IOException {
        return null;
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
        String uploadedFileName = fileService.uploadFile(path, file);

        movies movie = new movies(
                movieDto.setId(),
                movieDto.setTitle();
        );
        movieDto.setPoster(uploadedFileName);

        return null;
    }
}
