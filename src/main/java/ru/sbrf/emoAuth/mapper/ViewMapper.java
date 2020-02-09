package ru.sbrf.emoAuth.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.emoAuth.dto.ViewDto;
import ru.sbrf.emoAuth.entity.Component;
import ru.sbrf.emoAuth.entity.View;

import java.util.Set;

@Mapper (componentModel = "spring")
public abstract class ViewMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "onComponents", target = "on")
    })
    public abstract ViewDto viewToViewDto(View view);

    protected abstract Set<String> mapSetComponentToSetString(Set<Component> onComponents);

    protected String mapComponentToString(Component onComponent) {
        return onComponent.getName();
    }
}
