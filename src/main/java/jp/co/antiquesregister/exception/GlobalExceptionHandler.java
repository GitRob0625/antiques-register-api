package jp.co.antiquesregister.exception;

import jp.co.antiquesregister.dto.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全体例外ハンドリング
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 認証失敗時
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CommonResponse<Void>> handleBadCredentials(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(CommonResponse.error("メールアドレスまたはパスワードが正しくありません"));
    }
}
