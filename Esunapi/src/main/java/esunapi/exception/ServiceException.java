package esunapi.exception;

public class ServiceException extends RuntimeException{
    private Integer code;
    private String message;

    public ServiceException() {

    }

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
