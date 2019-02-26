package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.constants.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.USER_PATH)
public class AUserController {

    private final AUserService userService;

    @PostMapping("/sign-up")
    public AUserDto signUp(@RequestBody AUserDto user) {
        return userService.createUser(user);
    }

}
