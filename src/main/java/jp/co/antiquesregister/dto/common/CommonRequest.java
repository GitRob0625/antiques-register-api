package jp.co.antiquesregister.dto.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommonRequest<T> {
    @Valid
    @NotNull
    private T data;
}