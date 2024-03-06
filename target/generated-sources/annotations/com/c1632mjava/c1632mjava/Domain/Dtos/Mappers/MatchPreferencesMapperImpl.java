package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.MatchPreferences.MatchPreferencesCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.MatchPreferences.MatchPreferencesReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Enums.CompatibilityPercentage;
import com.c1632mjava.c1632mjava.Domain.Entities.Enums.Distance;
import com.c1632mjava.c1632mjava.Domain.Entities.MatchPreferences;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T13:29:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class MatchPreferencesMapperImpl implements MatchPreferencesMapper {

    @Override
    public MatchPreferencesReadDto convertMatchPreferencesToRead(MatchPreferences matchPreferences) {
        if ( matchPreferences == null ) {
            return null;
        }

        Long userId = null;
        boolean female = false;
        boolean male = false;
        boolean other = false;
        int minAge = 0;
        int maxAge = 0;
        Distance distance = null;
        CompatibilityPercentage compatibilityPercentage = null;
        boolean longTermRelationship = false;
        boolean justFriends = false;
        boolean rightNow = false;

        userId = matchPreferences.getUserId();
        female = matchPreferences.isFemale();
        male = matchPreferences.isMale();
        other = matchPreferences.isOther();
        minAge = matchPreferences.getMinAge();
        maxAge = matchPreferences.getMaxAge();
        distance = matchPreferences.getDistance();
        compatibilityPercentage = matchPreferences.getCompatibilityPercentage();
        longTermRelationship = matchPreferences.isLongTermRelationship();
        justFriends = matchPreferences.isJustFriends();
        rightNow = matchPreferences.isRightNow();

        MatchPreferencesReadDto matchPreferencesReadDto = new MatchPreferencesReadDto( userId, female, male, other, minAge, maxAge, distance, compatibilityPercentage, longTermRelationship, justFriends, rightNow );

        return matchPreferencesReadDto;
    }

    @Override
    public MatchPreferences convertCreateToMatchPreferences(MatchPreferencesCreateDto matchPreferencesCreateDto) {
        if ( matchPreferencesCreateDto == null ) {
            return null;
        }

        MatchPreferences matchPreferences = new MatchPreferences();

        matchPreferences.setUserId( matchPreferencesCreateDto.userId() );
        matchPreferences.setFemale( matchPreferencesCreateDto.female() );
        matchPreferences.setMale( matchPreferencesCreateDto.male() );
        matchPreferences.setOther( matchPreferencesCreateDto.other() );
        matchPreferences.setMinAge( matchPreferencesCreateDto.minAge() );
        matchPreferences.setMaxAge( matchPreferencesCreateDto.maxAge() );
        matchPreferences.setDistance( matchPreferencesCreateDto.distance() );
        matchPreferences.setCompatibilityPercentage( matchPreferencesCreateDto.compatibilityPercentage() );
        matchPreferences.setLongTermRelationship( matchPreferencesCreateDto.longTermRelationship() );
        matchPreferences.setJustFriends( matchPreferencesCreateDto.justFriends() );
        matchPreferences.setRightNow( matchPreferencesCreateDto.rightNow() );

        return matchPreferences;
    }
}
