package jp.co.antiquesregister.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * ログイン成功時に返却するユーザー情報DTOクラス
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserDTO {

    /** ユーザーID */
    private Long id;

    /** ユーザー名 */
    private String name;

    /** Eメール１ */
    private String email1;

    /** 権限フラグ */
    private Integer authorityFlag;
}
