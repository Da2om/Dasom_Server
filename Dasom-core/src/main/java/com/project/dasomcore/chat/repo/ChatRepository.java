package com.project.dasomcore.chat.repo;

import com.project.dasomcore.chat.domain.entity.Chat;
import com.project.dasomcore.chat.domain.entity.ChatRoom;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Query(value = "select * from tbl_chat " +
            "where fk_room_id = :roomId",nativeQuery = true)
    List<Chat> findAllByRoomId(@Param("roomId") Long roomId);
}
