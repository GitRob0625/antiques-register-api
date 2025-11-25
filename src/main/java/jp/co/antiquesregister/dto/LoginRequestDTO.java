package jp.co.antiquesregister.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "メールアドレスは必須です。")
    @Email(message = "有効なメールアドレス形式で入力してください。")
    private String email;

    @NotBlank(message = "パスワードは必須です。")
    private String password;
}
