package com.hrnchshn.finance.common;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

public interface CommonController<DtoEntity> {

    DtoEntity save( DtoEntity entity);


    DtoEntity getById(Long id);

    List<DtoEntity> getAll();

    void update( Long id, DtoEntity e);

    void delete(Long id);

}
