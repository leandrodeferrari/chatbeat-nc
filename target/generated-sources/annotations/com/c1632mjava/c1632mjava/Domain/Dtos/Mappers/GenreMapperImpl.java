package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.GenreDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T18:09:18-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public GenreDto convertGenreToDto(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        Long genreId = null;
        String genreName = null;

        genreId = genre.getGenreId();
        genreName = genre.getGenreName();

        GenreDto genreDto = new GenreDto( genreId, genreName );

        return genreDto;
    }

    @Override
    public Genre convertDtoToGenre(GenreDto genreDto) {
        if ( genreDto == null ) {
            return null;
        }

        Genre genre = new Genre();

        genre.setGenreId( genreDto.genreId() );
        genre.setGenreName( genreDto.genreName() );

        return genre;
    }

    @Override
    public List<GenreDto> convertGenreListToDtoList(List<Genre> genre) {
        if ( genre == null ) {
            return null;
        }

        List<GenreDto> list = new ArrayList<GenreDto>( genre.size() );
        for ( Genre genre1 : genre ) {
            list.add( convertGenreToDto( genre1 ) );
        }

        return list;
    }
}
