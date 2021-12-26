package kr.kyuhyuk.notepad.controller

import kr.kyuhyuk.notepad.dto.CreateNotepadDto
import kr.kyuhyuk.notepad.dto.ResponseDto
import kr.kyuhyuk.notepad.dto.UpdateNotepadDto
import kr.kyuhyuk.notepad.service.NotepadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class NotepadController {
    @Autowired
    private lateinit var notepadService: NotepadService

    @GetMapping("/list")
    fun getNotepads(): ResponseEntity<ResponseDto> {
        return try {
            ResponseEntity.ok().body(ResponseDto(null, notepadService.getNotepads()))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ResponseDto(e.message, null))
        }
    }

    @PostMapping("/add")
    fun createNotepad(@RequestBody createNotepadDto: CreateNotepadDto): ResponseEntity<ResponseDto> {
        return try {
            notepadService.createNotepad(createNotepadDto)
            ResponseEntity.ok().body(ResponseDto(null, true))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ResponseDto(e.message, null))
        }
    }

    @GetMapping("/read/{id}")
    fun getNotepad(@PathVariable("id") id: Long): ResponseEntity<ResponseDto> {
        return try {
            ResponseEntity.ok().body(ResponseDto(null, notepadService.getNotepad(id)))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ResponseDto(e.message, null))
        }
    }

    @PutMapping("/update/{id}")
    fun updateNotepad(
        @PathVariable("id") id: Long,
        @RequestBody updateNotepadDto: UpdateNotepadDto
    ): ResponseEntity<ResponseDto> {
        return try {
            notepadService.updateNotepad(id, updateNotepadDto)
            ResponseEntity.ok().body(ResponseDto(null, true))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ResponseDto(e.message, null))
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteNotepad(@PathVariable("id") id: Long): ResponseEntity<ResponseDto> {
        return try {
            notepadService.deleteNotepad(id)
            ResponseEntity.ok().body(ResponseDto(null, true))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(ResponseDto(e.message, null))
        }
    }
}