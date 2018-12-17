package com.hrnchshn.finance.common;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
public abstract class AbstractService
        <E extends EntityBase ,
        DtoEntity,
        R extends CommonRepository<E>,
        Converter extends EntityToDtoConverter<E, DtoEntity>>
                                                 implements CommonService<DtoEntity> {

    @Autowired
    protected R repository;

    @Autowired
    protected Converter converter;


    @Override
    public DtoEntity save(DtoEntity dtoEntity){
        try {
            E e = (E)ReflectionUtils.getGenericParameterClass(this.getClass(), AbstractService.class, 0).newInstance();
            e = converter.doForward(dtoEntity, e);
            e = repository.saveAndFlush(e);
            return converter.doBackward(e);
        }catch (Exception e){
            System.err.println("Error");
        }
        return null;
    }

    @Override
    public void update(Long id, DtoEntity dtoEntity) {
        E e = repository.findById(id).get();
        e = converter.doForward(dtoEntity, e);
        converter.doBackward(repository.save(e));
    }

    @Override
    public DtoEntity findById(Long id) {
        E e = repository.findById(id).get();
        return converter.doBackward(e);
    }

    @Override
    public List<DtoEntity> findAll(Long userId) {
        List<E> list = repository.findAll();
        return converter.doBackward(list);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
