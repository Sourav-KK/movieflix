package com.movieflix.service.impl;

import com.movieflix.dto.MovieDto;
import com.movieflix.entities.Movies;
import com.movieflix.repository.MovieReopsitory;
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
    @Autowired
    private MovieReopsitory movieRepo;

    @Autowired
    private FileService fileService;

    @Value("${project.poster}") // value from .yml
    private String path;

    @Value("${base.url}") // value from .yml
    private String baseurl;

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

        Movies movie = new Movies();
        movieDto.setPoster(uploadedFileName);

        movieRepo.save(movie);

        // generate posterUrl
        String posterUrl= baseurl + "/file/" + uploadedFileName;

        //  map movie object to dto object and return it
        MovieDto movieDto1 = new MovieDto();
        movieDto1.setPoster(posterUrl);
        return null;
    }
}
