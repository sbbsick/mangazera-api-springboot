package io.mangazera.mangaspringapi.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ChapterDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
}
