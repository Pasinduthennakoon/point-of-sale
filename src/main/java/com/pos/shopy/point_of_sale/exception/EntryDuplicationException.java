package com.pos.shopy.point_of_sale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class EntryDuplicationException extends RuntimeException{
    public EntryDuplicationException(String message){
        super(message);
    }
}
