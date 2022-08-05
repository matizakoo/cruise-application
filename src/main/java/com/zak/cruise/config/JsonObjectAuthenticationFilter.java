package com.zak.cruise.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zak.cruise.dto.LoginCredentialsDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@RequiredArgsConstructor
public class JsonObjectAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    Logger logger = LoggerFactory.getLogger("Checking JsonObjectAuthenticationFilter");
    private final ObjectMapper objectMapper;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("Authentication attemptAuthentication");
        try {
            BufferedReader reader = request.getReader();
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            LoginCredentialsDto loginCredentialsDto = objectMapper.readValue(stringBuilder.toString(), LoginCredentialsDto.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginCredentialsDto.getUsername(), loginCredentialsDto.getPassword()
            );
            logger.info(loginCredentialsDto.getUsername() + " " + loginCredentialsDto.getPassword());
            setDetails(request, token);
            return this.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}