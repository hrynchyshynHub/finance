package com.hrnchshn.finance.security;

import com.hrnchshn.finance.auser.AUserRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author ivan.hrynchyshyn
 */
@Service
@AllArgsConstructor
public class FinanceUserDetailsServiceImpl implements UserDetailsService {
    private final AUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = this.userRepository.findByUsername(username);
        return FinanceUserDetails.of(user);
    }
}
