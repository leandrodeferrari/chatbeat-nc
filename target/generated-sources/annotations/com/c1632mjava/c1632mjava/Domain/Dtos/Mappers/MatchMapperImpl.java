package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.Chat.ChatReadDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.Match.MatchCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.Match.MatchReadDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Chat;
import com.c1632mjava.c1632mjava.Domain.Entities.Match;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T13:29:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class MatchMapperImpl implements MatchMapper {

    private final ChatMapper chatMapper;
    private final UserMapper userMapper;

    @Autowired
    public MatchMapperImpl(ChatMapper chatMapper, UserMapper userMapper) {

        this.chatMapper = chatMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Match convertCreateToMatch(MatchCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        Match match = new Match();

        match.setCompatibilityPercentage( createDto.compatibilityPercentage() );

        return match;
    }

    @Override
    public MatchReadDto convertMatchToRead(Match match) {
        if ( match == null ) {
            return null;
        }

        Long matchId = null;
        Float compatibilityPercentage = null;
        LocalDateTime dateOfMatch = null;
        UserReadDto user1 = null;
        UserReadDto user2 = null;
        ChatReadDto chat = null;

        matchId = match.getMatchId();
        compatibilityPercentage = match.getCompatibilityPercentage();
        dateOfMatch = match.getDateOfMatch();
        user1 = userMapper.convertUserToRead( match.getUser1() );
        user2 = userMapper.convertUserToRead( match.getUser2() );
        chat = chatMapper.convertChatToRead( match.getChat() );

        MatchReadDto matchReadDto = new MatchReadDto( matchId, compatibilityPercentage, dateOfMatch, user1, user2, chat );

        return matchReadDto;
    }

    @Override
    public Match convertReadToMatch(MatchReadDto readDto) {
        if ( readDto == null ) {
            return null;
        }

        Match match = new Match();

        match.setMatchId( readDto.matchId() );
        match.setCompatibilityPercentage( readDto.compatibilityPercentage() );
        match.setDateOfMatch( readDto.dateOfMatch() );
        match.setUser1( userMapper.convertReadToUser( readDto.user1() ) );
        match.setUser2( userMapper.convertReadToUser( readDto.user2() ) );
        match.setChat( chatReadDtoToChat( readDto.chat() ) );

        return match;
    }

    protected Chat chatReadDtoToChat(ChatReadDto chatReadDto) {
        if ( chatReadDto == null ) {
            return null;
        }

        Chat chat = new Chat();

        chat.setChatId( chatReadDto.chatId() );
        chat.setLastMessage( chatReadDto.lastMessage() );
        chat.setDate( chatReadDto.date() );
        ArrayList<String> arrayList = chatReadDto.previousMessages();
        if ( arrayList != null ) {
            chat.setPreviousMessages( new ArrayList<String>( arrayList ) );
        }
        chat.setSender( userMapper.convertReadToUser( chatReadDto.sender() ) );
        chat.setReceiver( userMapper.convertReadToUser( chatReadDto.receiver() ) );

        return chat;
    }
}
