package vn.t3h.java2109.controller.common;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = AccessDeniedException.class)
    public String notPermission()
    {
        return "error/403";
    }
}
