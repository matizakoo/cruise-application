package com.zak.cruise.config;

import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.zak.cruise.config.JwtAuthorizationFilter.TOKEN_PREFIX;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@RequestMapping("/security")
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @GetMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

        String refreshToken = request.getHeader(AUTHORIZATION);
        String username = jwtUtil.extractUsernameFromRefreshToken(refreshToken, true);
        if (username != null) {
            User user = userRepository.findByEmail(username);;
//            String accessToken = jwtUtil.generateAccessToken(
//                    username,
//                    user.getRoles().stream().map(Role::getName).collect(Collectors.toList()),
//                    request.getRequestURL().toString());
            String accessToken = jwtUtil.generateAccessToken(username, List.of("USER","MOD","ADMIN"), request.getRequestURL().toString());
            response.setHeader("access_token", TOKEN_PREFIX + accessToken);
            response.setHeader("refresh_token", refreshToken);
        }
    }
}