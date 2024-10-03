package com.project.dasomapi.chat.handler;

import com.project.dasomapi.chat.usecase.ChatMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "채팅", description = "채팅 API")
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/sendMessage")  // 클라이언트가 "/app/sendMessage"로 메시지를 보내면 호출됨.
//    @SendTo("/topic/public")  // 해당 채널을 구독한 클라이언트에게 메시지 전송
    @Operation(summary = "메시지 전송", description = "메시지 전송")
    public void sendMessage(ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/chat/room/" + message.getRoomId(), message);
        // /topic/chat/room/{roomId} + payload 데이터(message) 를 해당 채널을 구독하 클라이언트에게 메시지 전송
    }
}
