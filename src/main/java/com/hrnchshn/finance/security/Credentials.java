package com.hrnchshn.finance.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author ivan.hrynchyshyn
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Credentials {
    @NotNull
    private String username;
    @NotNull
    private String password;
}