package com.sandbox.playground1.model.ychord;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MstChord {
        private String chordId;
        private String name;
}
