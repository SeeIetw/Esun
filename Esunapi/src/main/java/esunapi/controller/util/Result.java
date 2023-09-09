package esunapi.controller.util;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private Object data;
    private String msg;
    public Result(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
