package esunapi.controller.util;

import esunapi.exception.FormNotMatchException;
import esunapi.exception.NoInputException;
import esunapi.exception.NoSelectionException;
import esunapi.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        return new Result(500,null,"伺服器忙碌中");
    }

    @ExceptionHandler(ServiceException.class)
    public Result doSystemException(ServiceException ex){
        Result result = new Result(400,null,"系統忙碌中");
        if(ex instanceof NoInputException){
            result.setMsg("請輸入英文名子");
        } else if (ex instanceof NoSelectionException) {
            result.setMsg("請至少選擇一項");
        } else if (ex instanceof FormNotMatchException) {
            result.setMsg("請輸入20字以下英文字，禁止輸入空白及特殊符號");
        }
        return result;
    }

}
