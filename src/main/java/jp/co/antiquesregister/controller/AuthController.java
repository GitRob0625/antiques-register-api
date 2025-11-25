package jp.co.antiquesregister.controller;

import jakarta.servlet.http.HttpServletResponse;
import jp.co.antiquesregister.dto.LoginRequestDTO;
import jp.co.antiquesregister.dto.LoginUserDTO;
import jp.co.antiquesregister.dto.common.CommonResponse;
import jp.co.antiquesregister.model.entity.User;
import jp.co.antiquesregister.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginUserDTO>> login(@RequestBody LoginRequestDTO loginRequest
            , HttpServletResponse response) {
        Authentication authentication = authenticate(loginRequest);
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalStateException("認証ユーザーが登録されていません。"));
        LoginUserDTO responseData = buildLoginUserDTO(user);
        return ResponseEntity.ok(CommonResponse.success(responseData, "ログインに成功しました。"));
    }

    private Authentication authenticate(LoginRequestDTO loginRequest) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));
    }

    private LoginUserDTO buildLoginUserDTO(User user) {
        LoginUserDTO.LoginUserDTOBuilder builder = LoginUserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName());
        return builder.build();
    }
}