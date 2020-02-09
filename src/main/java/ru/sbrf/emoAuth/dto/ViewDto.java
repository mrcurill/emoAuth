package ru.sbrf.emoAuth.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ViewDto {
    private String name;
    private Set<String> on;
}
