package com.team2.mosoo_backend.chatting.mapper;

import com.team2.mosoo_backend.bid.entity.Bid;
import com.team2.mosoo_backend.chatting.dto.ChatRoomRequestDto;
import com.team2.mosoo_backend.chatting.dto.ChatRoomResponseDto;
import com.team2.mosoo_backend.chatting.entity.ChatRoom;
import com.team2.mosoo_backend.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatRoomMapper {

//    @Mapping(source="post", target = "postId")
//    @Mapping(source="bid", target = "bidId")
    @Mapping(source = "id", target = "chatRoomId")
    ChatRoomResponseDto toChatRoomResponseDto(ChatRoom chatRoom);

    default Long mapPostToLong(Post post) { return post != null ? post.getId() : null; }
    default Long mapBidToLong(Bid bid) { return bid != null ? bid.getId() : null; }

    @Mapping(target = "post", ignore = true)
    @Mapping(target = "bid", ignore = true)
    @Mapping(source = "userId", target = "userId")
    ChatRoom toEntity(ChatRoomRequestDto chatRoomRequestDto, Long userId);
}
