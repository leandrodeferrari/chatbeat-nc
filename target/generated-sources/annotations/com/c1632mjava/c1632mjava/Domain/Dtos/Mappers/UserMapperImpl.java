package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.ArtistDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.GenreDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Artist;
import com.c1632mjava.c1632mjava.Domain.Entities.Enums.Gender;
import com.c1632mjava.c1632mjava.Domain.Entities.Enums.SocialBattery;
import com.c1632mjava.c1632mjava.Domain.Entities.Genre;
import com.c1632mjava.c1632mjava.Domain.Entities.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T13:29:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private ArtistMapper artistMapper;
    @Autowired
    private GenreMapper genreMapper;

    @Override
    public UserReadDto convertUserToRead(User user) {
        if ( user == null ) {
            return null;
        }

        List<ArtistDto> artists = null;
        List<GenreDto> genres = null;
        Long userId = null;
        String name = null;
        LocalDate birthdate = null;
        String photo = null;
        Gender gender = null;
        String pronouns = null;
        String description = null;
        SocialBattery socialBattery = null;
        String currentSong = null;
        List<Long> bannedUsers = null;

        artists = artistMapper.convertArtistListToDtoList( user.getArtists() );
        genres = genreMapper.convertGenreListToDtoList( user.getGenres() );
        userId = user.getUserId();
        name = user.getName();
        birthdate = user.getBirthdate();
        photo = user.getPhoto();
        gender = user.getGender();
        pronouns = user.getPronouns();
        description = user.getDescription();
        socialBattery = user.getSocialBattery();
        currentSong = user.getCurrentSong();
        List<Long> list2 = user.getBannedUsers();
        if ( list2 != null ) {
            bannedUsers = new ArrayList<Long>( list2 );
        }

        UserReadDto userReadDto = new UserReadDto( userId, name, birthdate, photo, gender, pronouns, description, socialBattery, currentSong, artists, genres, bannedUsers );

        return userReadDto;
    }

    @Override
    public User convertCreateToUser(UserCreateDto userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userCreateDto.name() );
        user.email( userCreateDto.email() );
        user.password( userCreateDto.password() );
        user.birthdate( userCreateDto.birthdate() );
        user.photo( userCreateDto.photo() );
        user.gender( userCreateDto.gender() );
        user.pronouns( userCreateDto.pronouns() );
        user.description( userCreateDto.description() );

        return user.build();
    }

    @Override
    public User convertReadToUser(UserReadDto userReadDto) {
        if ( userReadDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userId( userReadDto.userId() );
        user.name( userReadDto.name() );
        user.birthdate( userReadDto.birthdate() );
        user.photo( userReadDto.photo() );
        user.gender( userReadDto.gender() );
        user.pronouns( userReadDto.pronouns() );
        user.description( userReadDto.description() );
        user.socialBattery( userReadDto.socialBattery() );
        user.currentSong( userReadDto.currentSong() );
        user.Artists( artistDtoListToArtistList( userReadDto.Artists() ) );
        user.Genres( genreDtoListToGenreList( userReadDto.Genres() ) );
        List<Long> list2 = userReadDto.bannedUsers();
        if ( list2 != null ) {
            user.bannedUsers( new ArrayList<Long>( list2 ) );
        }

        return user.build();
    }

    protected List<Artist> artistDtoListToArtistList(List<ArtistDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Artist> list1 = new ArrayList<Artist>( list.size() );
        for ( ArtistDto artistDto : list ) {
            list1.add( artistMapper.convertDtoToArtist( artistDto ) );
        }

        return list1;
    }

    protected List<Genre> genreDtoListToGenreList(List<GenreDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Genre> list1 = new ArrayList<Genre>( list.size() );
        for ( GenreDto genreDto : list ) {
            list1.add( genreMapper.convertDtoToGenre( genreDto ) );
        }

        return list1;
    }
}
