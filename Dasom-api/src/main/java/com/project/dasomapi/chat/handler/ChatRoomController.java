package com.project.dasomapi.chat.handler;


import com.project.dasomapi.chat.usecase.ChatUseCase;
import com.project.dasomcore.chat.application.ChatService;
import com.project.dasomcore.chat.domain.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatUseCase chatUseCase;

    /**
     * 채팅방 리스트 보기
     */
    @GetMapping("/roomList")
    public List<ChatRoom> roomList() {
        return chatUseCase.findAllRoom();
    }

}
