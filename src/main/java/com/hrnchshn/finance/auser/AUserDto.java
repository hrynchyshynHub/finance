package com.hrnchshn.finance.auser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AUserDto {
    private Long id;
    private String nickname;
    private String fullName;
    private String login;
    @JsonIgnore
    private String password;
    private Integer age;
    private Double monthIncoming;
    private Double dayOutgoings;
}
