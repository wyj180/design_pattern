package com.neimeng.workflow.exception;

import com.neimeng.workflow.entity.Response;
import com.neimeng.workflow.entity.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return Response.failure("Internal Server Exception:" + e.getMessage());
    }

    @ExceptionHandler(GlobalException.class)
    public Response handleBusinessException(GlobalException e) {
        LOGGER.error(e.getMessage(), e);
        return new Response(ResponseCode.GLOBAL_ERROR, e.getMessage());
    }

}
