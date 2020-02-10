package ru.sbrf.emoAuth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.emoAuth.dto.ComponentDto;
import ru.sbrf.emoAuth.entity.Component;
import ru.sbrf.emoAuth.entity.View;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class ComponentMapper {
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "onViews", target = "on"),
            @Mapping(source = "offViews", target = "off"),
            @Mapping(source = "disabledViews", target = "disabled")
    })
    public abstract ComponentDto componentToComponentDto(Component component);

    protected abstract Set<String> mapSetComponentToSetString(Set<View> views);

    protected String mapViewToString(View view) {
        return view.getName();
    }
}
