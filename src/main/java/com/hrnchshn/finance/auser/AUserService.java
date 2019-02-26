package com.hrnchshn.finance.auser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author ivan.hrynchyshyn
 */
@Service
public class AUserService implements UserService{
    @Autowired
    private AUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AUserToAUserDtoConverter converter;

    @Override
    public AUserDto createUser(AUserDto userDto) {
        AUser user = converter.doForward(userDto, new AUser());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return converter.doBackward(userRepository.save(user));
    }
}
