package com.example.roombooking.exception.handler;

import com.example.roombooking.common.rest.r.R;
import com.example.roombooking.exception.todo.TodoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 待实现异常拦截
     *
     * @param todoException 异常
     * @return 返回错误提示
     */
    @ExceptionHandler(TodoException.class)
    public R<Object> todoExceptionHandler(TodoException todoException) {
        LOGGER.error("未完成异常拦截,异常信息如下:", todoException);

        return R.todo();
    }

    /**
     * 异常拦截
     *
     * @param exception 异常
     * @return 返回错误提示
     */
    @ExceptionHandler(Exception.class)
    public R<Object> exceptionHandler(Exception exception) {
        LOGGER.error("统一异常拦截,异常信息如下:", exception);

        return R.error("服务异常,请联系管理员!");
    }
}
