package com.hrnchshn.finance.common;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@NoArgsConstructor
public abstract class AbstractController<DtoEntity,
        S extends CommonService<DtoEntity>>
        implements CommonController<DtoEntity> {

    @Override
    @PostMapping
    public DtoEntity save(@RequestBody DtoEntity dtoEntity) {
        return getService().save(dtoEntity);
    }

    @Override
    @GetMapping("/{id}")
    public DtoEntity getById(@PathParam("id") Long id) {
        return getService().findById(id);
    }

    @Override
    public List<DtoEntity> getAll() {
        return getService().findAll(0L);
    }

    @Override
    @PutMapping("/{id}")
    public void update(@PathParam("id") Long id, DtoEntity e) {
        getService().update(id, e);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathParam("id") Long id) {
        getService().delete(id);
    }

    protected abstract S getService();

}
