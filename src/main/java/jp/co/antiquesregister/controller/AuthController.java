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

/**
 * ログイン処理コントローラクラス
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /** Spring Securityの認証処理を行うコンポーネント */
    private final AuthenticationManager authenticationManager;

    /** ユーザー情報を取得するためのリポジトリ */
    private final UserRepository userRepository;

    /**
     * コンストラクタ（依存性注入）
     *
     * @param authenticationManager 認証処理を行うマネージャ
     * @param userRepository ユーザー情報取得用リポジトリ
     */
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    /**
     * ログインAPI
     * 入力されたメールアドレス・パスワードで認証を行い、ユーザー情報を返却する。
     *
     * @param loginRequest ログインリクエスト
     * @param response HTTPレスポンス
     * @return ログインユーザー情報を含む共通レスポンス
     * @throws BadCredentialsException 認証に失敗した場合
     * @throws IllegalStateException 認証成功後にユーザー情報が取得できない場合
     */
    @PostMapping("/login")
    public ResponseEntity<CommonResponse<LoginUserDTO>> login(@RequestBody LoginRequestDTO loginRequest
            , HttpServletResponse response) {

        // 認証処理
        Authentication authentication = authenticate(loginRequest);

        // 認証済みユーザーのメール取得
        String email = authentication.getName();

        // ユーザー情報取得
        User user = userRepository.findByEmail1(email)
                .orElseThrow(() -> new IllegalStateException("ユーザーが登録されていません。"));
        // DTO変換
        LoginUserDTO responseData = buildLoginUserDTO(user);

        // 成功レスポンス返却
        return ResponseEntity.ok(CommonResponse.success(responseData, "ログインに成功しました。"));
    }

    /**
     * 認証処理
     *
     * @param loginRequest ログインリクエスト
     * @return 認証成功時のAuthenticationオブジェクト
     * @throws BadCredentialsException 認証に失敗した場合
     */
    private Authentication authenticate(LoginRequestDTO loginRequest) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));
    }

    /**
     * ログインユーザー用DTO生成
     *
     * @param user ログインユーザー情報
     * @return 画面返却用のログインユーザーDTO
     */
    private LoginUserDTO buildLoginUserDTO(User user) {
        LoginUserDTO.LoginUserDTOBuilder builder = LoginUserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email1(user.getEmail1())
                .authorityFlag(user.getAuthorityFlag());
        return builder.build();
    }
}