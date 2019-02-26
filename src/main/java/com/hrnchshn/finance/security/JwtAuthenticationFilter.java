package com.hrnchshn.finance.security;

/**
 * @author ivan.hrynchyshyn
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrnchshn.finance.constants.Api;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String secretKey = "QkhKSEdZR1lVR0tKTg==";
    private final Integer duration = 7000000;

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
                Credentials credentials = new ObjectMapper()
                        .readValue(request.getInputStream(), Credentials.class);
                val userDetails = FinanceUserDetails.of(credentials);
                return authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userDetails.getUsername(),
                                userDetails.getPassword(),
                                Collections.emptySet())
                );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
            val claims = Jwts.claims();
            claims.setSubject(((FinanceUserDetails) auth.getPrincipal()).getUsername());
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + duration))
                    .signWith(SignatureAlgorithm.HS512,secretKey)
                    .compact();
            response.addHeader(Api.AUTH_HEADER, Api.BEARER + token);

    }
}
