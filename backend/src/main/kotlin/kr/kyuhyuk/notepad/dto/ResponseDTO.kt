package kr.kyuhyuk.notepad.dto

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
class ResponseDTO<T>(
    var error: String,
    var data: List<T>
)