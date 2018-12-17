package com.hrnchshn.finance.common;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
public abstract class AbstractController<DtoEntity,
        S extends CommonService<DtoEntity>>
        implements CommonController<DtoEntity> {

    private S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public DtoEntity save(DtoEntity dtoEntity) {
        return service.save(dtoEntity);
    }

    @Override
    public DtoEntity getById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<DtoEntity> getAll(Long id) {
        return service.findAll(id);
    }

    @Override
    public void update(Long id, DtoEntity e) {
        service.update(id, e);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

}
