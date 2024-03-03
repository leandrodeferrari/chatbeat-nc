package com.c1632mjava.c1632mjava.Domain.Dtos.Match;

import com.c1632mjava.c1632mjava.Domain.Dtos.Chat.ChatReadDto;
import com.c1632mjava.c1632mjava.Domain.Dtos.User.UserReadDto;

import java.time.LocalDateTime;

public record MatchReadDto(
    Long matchId,
    Float compatibilityPercentage,
    LocalDateTime dateOfMatch,
    UserReadDto user1,
    UserReadDto user2,
    ChatReadDto chat
) {
}
