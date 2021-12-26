package kr.kyuhyuk.notepad.model.repository

import kr.kyuhyuk.notepad.model.entity.Notepad
import org.springframework.data.repository.CrudRepository

interface NotepadRepository : CrudRepository<Notepad, Long> {
}