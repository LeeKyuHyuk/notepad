package kr.kyuhyuk.notepad.model.entity

import kr.kyuhyuk.notepad.dto.CreateNotepadDto
import kr.kyuhyuk.notepad.dto.ReadNotepadDto
import kr.kyuhyuk.notepad.dto.UpdateNotepadDto
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Entity
/* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
@EntityListeners(
    AuditingEntityListener::class
)
data class Notepad(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    @Column(nullable = false) var userId: String,
    @Column(nullable = false) var preview: String,
    @Column(columnDefinition = "TEXT", nullable = false) var content: String,
    @Column(nullable = false) var date: LocalDateTime = LocalDateTime.now()
) {
    fun toReadNotepadDTO(): ReadNotepadDto {
        return ReadNotepadDto(id = id, preview = preview, content = content, date = date)
    }

    fun toCreateNotepadDTO(): CreateNotepadDto {
        return CreateNotepadDto(content = content)
    }

    fun toUpdateNotepadDTO(): UpdateNotepadDto {
        return UpdateNotepadDto(id = id!!, content = content)
    }
}
