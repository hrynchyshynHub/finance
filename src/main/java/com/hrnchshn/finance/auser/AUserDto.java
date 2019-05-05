package com.hrnchshn.finance.auser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AUserDto {
    private Long id;
    private String nickname;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer age;
}
