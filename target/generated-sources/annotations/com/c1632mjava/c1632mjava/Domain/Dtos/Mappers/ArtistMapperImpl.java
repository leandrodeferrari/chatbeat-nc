package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.ArtistDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Artist;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T13:29:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ArtistMapperImpl implements ArtistMapper {

    @Override
    public ArtistDto convertArtistToDto(Artist artist) {
        if ( artist == null ) {
            return null;
        }

        String artistId = null;
        String artistName = null;

        artistId = artist.getArtistId();
        artistName = artist.getArtistName();

        ArtistDto artistDto = new ArtistDto( artistId, artistName );

        return artistDto;
    }

    @Override
    public Artist convertDtoToArtist(ArtistDto artistDto) {
        if ( artistDto == null ) {
            return null;
        }

        Artist artist = new Artist();

        artist.setArtistId( artistDto.artistId() );
        artist.setArtistName( artistDto.artistName() );

        return artist;
    }

    @Override
    public List<ArtistDto> convertArtistListToDtoList(List<Artist> artist) {
        if ( artist == null ) {
            return null;
        }

        List<ArtistDto> list = new ArrayList<ArtistDto>( artist.size() );
        for ( Artist artist1 : artist ) {
            list.add( convertArtistToDto( artist1 ) );
        }

        return list;
    }
}
