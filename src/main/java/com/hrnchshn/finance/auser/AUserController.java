package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping(Api.USER_PATH)
public class AUserController {

    private final AUserService userService;
}
