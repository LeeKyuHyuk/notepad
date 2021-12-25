package kr.kyuhyuk.notepad.domain.entity

import lombok.AccessLevel
import lombok.Builder
import lombok.NoArgsConstructor
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(
    AuditingEntityListener::class
) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
class Notepad(
    @Id @GeneratedValue var id: Long? = null,
    @Column(nullable = false) var userId: String,
    @Column(nullable = false) var preview: String,
    @Column(columnDefinition = "TEXT", nullable = false) var content: String,
    @Column(nullable = false) var date: LocalDateTime = LocalDateTime.now()
)