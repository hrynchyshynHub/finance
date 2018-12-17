package com.hrnchshn.finance.common;

import java.util.List;
import java.util.function.Consumer;

public interface EntityToDtoConverter< Entity extends EntityBase, DTO > {

    Entity doForward(DTO dto, Entity entity);

    DTO doBackward(Entity entity);

    List<DTO> doBackward(List<Entity> entity);

    default <T> void setIfNotNull(final Consumer<T> setter, final T value){
        if(value != null){
            setter.accept(value);
        }
    }
}
