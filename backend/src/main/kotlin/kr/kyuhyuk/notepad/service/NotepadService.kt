package kr.kyuhyuk.notepad.service

import kr.kyuhyuk.notepad.dto.CreateNotepadDto
import kr.kyuhyuk.notepad.dto.ReadNotepadDto
import kr.kyuhyuk.notepad.dto.UpdateNotepadDto
import kr.kyuhyuk.notepad.model.repository.NotepadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class NotepadService {
    @Autowired
    lateinit var notepadRepository: NotepadRepository

    fun getNotepads(): List<ReadNotepadDto> {
        val notepad = notepadRepository.findAll()
        return notepad.map { it.toReadNotepadDTO() }
    }

    fun getNotepad(id: Long): ReadNotepadDto {
        return notepadRepository.findById(id).get().toReadNotepadDTO()
    }

    @Transactional
    fun createNotepad(createNotepadDto: CreateNotepadDto): CreateNotepadDto {
        val notepad = notepadRepository.save(createNotepadDto.toEntity())
        return notepad.toCreateNotepadDTO()
    }

    @Transactional
    fun updateNotepad(id: Long, updateNotepadDto: UpdateNotepadDto): UpdateNotepadDto {
        if (notepadRepository.findById(id).isPresent) {
            val notepad = updateNotepadDto.toEntity()
            notepad.id = id
            return notepadRepository.save(notepad).toUpdateNotepadDTO()
        }
        throw Exception()
    }

    @Transactional
    fun deleteNotepad(id: Long) {
        return notepadRepository.deleteById((id))
    }
}