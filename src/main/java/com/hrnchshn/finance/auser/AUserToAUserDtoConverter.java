package com.hrnchshn.finance.auser;

import com.hrnchshn.finance.common.EntityToDtoConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AUserToAUserDtoConverter implements EntityToDtoConverter<AUser, AUserDto> {

    @Override
    public AUser doForward(AUserDto aUserDto, AUser user) {
        setIfNotNull(user::setAge, aUserDto.getAge());
        setIfNotNull(user::setFullName, aUserDto.getFullName());
        setIfNotNull(user::setNickname, aUserDto.getNickname());
        if(user.getPassword() == null) user.setPassword(aUserDto.getPassword());
        if(user.getLogin() == null) user.setLogin(aUserDto.getLogin());
        return user;
    }

    @Override
    public AUserDto doBackward(AUser aUser) {
        return AUserDto.builder()
                .id(aUser.getId())
                .age(aUser.getAge())
                .fullName(aUser.getFullName())
                .login(aUser.getLogin())
                .nickname(aUser.getNickname())
                .build();
    }

    @Override
    public List<AUserDto> doBackward(List<AUser> entity) {
        return entity.stream().map(this::doBackward).collect(Collectors.toList());
    }
}
