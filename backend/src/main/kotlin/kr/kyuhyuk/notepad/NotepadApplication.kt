package kr.kyuhyuk.notepad

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class NotepadApplication

fun main(args: Array<String>) {
    runApplication<NotepadApplication>(*args)
}
