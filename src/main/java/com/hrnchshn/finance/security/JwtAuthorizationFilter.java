package com.hrnchshn.finance.security;

import com.hrnchshn.finance.constants.Api;
import io.jsonwebtoken.Jwts;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

/**
 * @author ivan.hrynchyshyn
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Value("finance.security.secret-key")
    private String secretKey = "QkhKSEdZR1lVR0tKTg==";

    public JwtAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        authenticate(request);
        chain.doFilter(request, response);
    }

    private void authenticate(HttpServletRequest request) {
        String token = request.getHeader(Api.AUTH_HEADER);
        if (Objects.isNull(token) || token.isEmpty()) {
            return;
        }
        val claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token.replace(Api.BEARER, ""))
                .getBody();
        val user = claims.getSubject();
        val authentication = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}