package com.hrnchshn.finance.common;


import java.util.List;

public interface CommonService<DTOEntity> {

    DTOEntity save(DTOEntity entity);

    void update(Long id, DTOEntity entity);

    DTOEntity findById(Long id);

    List<DTOEntity> findAll(Long userId);

    void delete(Long id);

}
