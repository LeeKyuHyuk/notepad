package kr.kyuhyuk.notepad.dto

import kr.kyuhyuk.notepad.model.entity.Notepad

data class CreateNotepadDto(
    val content: String,
) {
    fun toEntity(): Notepad {
        var preview = content
        if (content.length > 20) preview = content.substring(0, 20) + "..."
        return Notepad(userId = "TEMP_USER_ID", preview = preview, content = content)
    }
}
