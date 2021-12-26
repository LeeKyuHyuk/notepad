package kr.kyuhyuk.notepad.dto

import java.time.LocalDateTime

data class ReadNotepadDto(
    val id: Long? = null,
    val preview: String,
    val content: String,
    val date: LocalDateTime
)