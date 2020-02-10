package ru.sbrf.emoAuth.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ComponentDto {
    private String name;
    private Set<String> on;
    private Set<String> off;
    private Set<String> disabled;
}
