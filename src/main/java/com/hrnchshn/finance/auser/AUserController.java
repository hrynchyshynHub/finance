package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.common.AbstractController;
import com.hrnchshn.finance.constants.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(Api.USER_PATH)
public class AUserController extends AbstractController<AUserDto, AUserService> {

    public AUserController(AUserService aUserService){
        super(aUserService);
    }
}
