package com.c1632mjava.c1632mjava.Domain.Dtos.Mappers;

import com.c1632mjava.c1632mjava.Domain.Dtos.Chat.ChatReadDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.ReportedMessage.ReportedMessageCreateDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.ReportedMessage.ReportedMessageReadDto;
import com.c1632mjava.c1632mjava.Domain.Entities.ReportedMessage;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T13:29:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class ReportedMessageMapperImpl implements ReportedMessageMapper {

    private final ChatMapper chatMapper;

    @Autowired
    public ReportedMessageMapperImpl(ChatMapper chatMapper) {

        this.chatMapper = chatMapper;
    }

    @Override
    public ReportedMessage convertCreateToReported(ReportedMessageCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        ReportedMessage reportedMessage = new ReportedMessage();

        reportedMessage.setMessage( dto.message() );

        return reportedMessage;
    }

    @Override
    public ReportedMessageReadDto convertReportedToRead(ReportedMessage reportedMessage) {
        if ( reportedMessage == null ) {
            return null;
        }

        Long reportedMessageId = null;
        LocalDateTime date = null;
        String message = null;
        Boolean reviewed = null;
        ChatReadDto chat = null;

        reportedMessageId = reportedMessage.getReportedMessageId();
        date = reportedMessage.getDate();
        message = reportedMessage.getMessage();
        reviewed = reportedMessage.getReviewed();
        chat = chatMapper.convertChatToRead( reportedMessage.getChat() );

        ReportedMessageReadDto reportedMessageReadDto = new ReportedMessageReadDto( reportedMessageId, date, message, reviewed, chat );

        return reportedMessageReadDto;
    }
}
