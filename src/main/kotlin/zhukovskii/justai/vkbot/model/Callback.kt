package zhukovskii.justai.vkbot.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Callback(
    val type: String,
    val `object`: CallbackObject? = null,
    @JsonProperty("group_id")
    val groupId: Long,
    val secret: String? = null,
) {
    data class CallbackObject(
        val message: MessageObject? = null,
        @JsonProperty("client_info")
        val clientInfo: Any? = null
    ) {
        data class MessageObject(
            val id: Long,
            val date: Long,
            @JsonProperty("peer_id")
            val peerId: Long,
            @JsonProperty("from_id")
            val fromId: Long,
            val text: String,
            @JsonProperty("random_id")
            val randomId: Long,
            val ref: String? = null,
            @JsonProperty("ref_source")
            val refSource: String? = null,
            val attachments: Any? = null,
            val important: Boolean? = null,
            val geo: Any? = null,
            val payload: String? = null,
            val keyboard: Any? = null,
            @JsonProperty("fwd_messages")
            val fwdMessages: Any? = null,
            @JsonProperty("reply_message")
            val replyMessage: Any? = null,
            val action: Any? = null,
            @JsonProperty("admin_author_id")
            val adminAuthorId: Long? = null,
            @JsonProperty("conversation_message_id")
            val conversationMessageId: Long? = null,
            @JsonProperty("is_cropped")
            val isCropped: Boolean? = null,
            @JsonProperty("members_count")
            val membersCount: Int? = null,
            @JsonProperty("update_time")
            val updateTime: Long? = null,
            @JsonProperty("was_listened")
            val wasListened: Boolean? = null,
            @JsonProperty("pinned_at")
            val pinnedAt: Long? = null,
            @JsonProperty("message_tag")
            val messageTag: String? = null,
            @JsonProperty("is_mentioned_user")
            val isMentionedUser: Boolean? = null
        )
    }
}
