package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ivan.hrynchyshyn
 */
@Component
public class AUserToAUserDtoConverter implements EntityToDtoConverter<AUser, AUserDto> {

    @Override
    public AUser doForward(AUserDto aUserDto, AUser user) {
        setIfNotNull(user::setAge, aUserDto.getAge());
        setIfNotNull(user::setFullName, aUserDto.getFullName());
        setIfNotNull(user::setNickname, aUserDto.getNickname());
        setIfNotNull(user::setUsername, aUserDto.getUsername());
        setIfNotNull(user::setEmail, aUserDto.getEmail());
        setIfNotNull(user::setPhone, aUserDto.getPhone());
        return user;
    }

    @Override
    public AUserDto doBackward(AUser aUser) {
        return AUserDto.builder()
                .id(aUser.getId())
                .username(aUser.getUsername())
                .age(aUser.getAge())
                .fullName(aUser.getFullName())
                .nickname(aUser.getNickname())
                .email(aUser.getEmail())
                .phone(aUser.getPhone())
                .build();
    }

}
