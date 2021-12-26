package kr.kyuhyuk.notepad.domain.repository

import kr.kyuhyuk.notepad.domain.entity.Notepad
import org.springframework.data.repository.CrudRepository

interface NotepadRepository : CrudRepository<Notepad, Long> {
    fun findAllByUserId(userId: String): Iterable<Notepad>
}
