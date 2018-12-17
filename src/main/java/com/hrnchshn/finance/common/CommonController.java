package com.hrnchshn.finance.common;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

public interface CommonController<DtoEntity> {

    @PostMapping
    DtoEntity save(@RequestBody DtoEntity entity);

    @GetMapping("/{id}")
    DtoEntity getById(@PathParam("id") Long id);

    @GetMapping
    List<DtoEntity> getAll(Long id);

    @PutMapping("/{id}")
    void update(@PathParam("id") Long id, DtoEntity e);

    @DeleteMapping("/{id}")
    void delete(@PathParam("id") Long id);

}
