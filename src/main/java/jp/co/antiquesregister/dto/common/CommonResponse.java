package jp.co.antiquesregister.dto.common;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private String status;
    private String message;
    private T data;

    private CommonResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>("success", "処理が正常に完了しました。。", data);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>("success", message, data);
    }

    public static <T> CommonResponse<T> error(String message) {
        return new CommonResponse<>("error", message, null);
    }

    public static <T> CommonResponse<T> error(String message, T data) {
        return new CommonResponse<>("error", message, data);
    }
}