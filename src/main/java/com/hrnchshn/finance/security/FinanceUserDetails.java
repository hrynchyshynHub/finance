package com.hrnchshn.finance.security;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.auser.AUserDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ivan.hrynchyshyn
 */
@Data
@Builder
public class FinanceUserDetails implements UserDetails {
    private String username;
    private String password;
    private Boolean locked;
    private Set<GrantedAuthority> authorities = new TreeSet<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static FinanceUserDetails of(AUser user) {
        return FinanceUserDetails.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static FinanceUserDetails of(Credentials credentials) {
        return FinanceUserDetails.builder()
                .username(credentials.getUsername())
                .password(credentials.getPassword())
                .build();
    }
}
