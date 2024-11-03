package com.project.dasomapi.chat.usecase;

import com.project.dasomcore.chat.application.ChatService;
import com.project.dasomcore.chat.domain.entity.Chat;
import com.project.dasomcore.chat.domain.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatUseCase {
    private final ChatService chatService;


    public Chat createChat(Long roomId, String sender, String senderEmail, String message) {
        return chatService.createChat(roomId, sender, senderEmail, message);
    }

    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }
}
