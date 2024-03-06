package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.Chat.ChatCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.Chat.ChatReadDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.Chat;
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
public class ChatMapperImpl implements ChatMapper {

    private final UserMapper userMapper;

    @Autowired
    public ChatMapperImpl(UserMapper userMapper) {

        this.userMapper = userMapper;
    }

    @Override
    public Chat convertCreateToChat(ChatCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Chat chat = new Chat();

        chat.setLastMessage( dto.lastMessage() );
        ArrayList<String> arrayList = dto.previousMessages();
        if ( arrayList != null ) {
            chat.setPreviousMessages( new ArrayList<String>( arrayList ) );
        }

        return chat;
    }

    @Override
    public ChatReadDto convertChatToRead(Chat chat) {
        if ( chat == null ) {
            return null;
        }

        Long chatId = null;
        String lastMessage = null;
        LocalDateTime date = null;
        ArrayList<String> previousMessages = null;
        UserReadDto sender = null;
        UserReadDto receiver = null;

        chatId = chat.getChatId();
        lastMessage = chat.getLastMessage();
        date = chat.getDate();
        ArrayList<String> arrayList = chat.getPreviousMessages();
        if ( arrayList != null ) {
            previousMessages = new ArrayList<String>( arrayList );
        }
        sender = userMapper.convertUserToRead( chat.getSender() );
        receiver = userMapper.convertUserToRead( chat.getReceiver() );

        ChatReadDto chatReadDto = new ChatReadDto( chatId, lastMessage, date, previousMessages, sender, receiver );

        return chatReadDto;
    }
}
