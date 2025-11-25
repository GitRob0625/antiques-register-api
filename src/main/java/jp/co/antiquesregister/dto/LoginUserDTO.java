package jp.co.antiquesregister.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserDTO {
    private Long id;
    private String name;
    private String email;
}
