package com.hrnchshn.finance.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public interface EntityToDtoConverter< Entity extends EntityBase, DTO > {

    Entity doForward(DTO dto, Entity entity);

    DTO doBackward(Entity entity);

    default List<DTO> doBackward(List<Entity> entity){
        entity = Optional.ofNullable(entity)
                .orElse(new ArrayList<>());
        return entity.stream().map(this::doBackward).collect(Collectors.toList());
    }

    default <T> void setIfNotNull(final Consumer<T> setter, final T value){
        if(value != null){
            setter.accept(value);
        }
    }
}
