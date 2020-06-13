package org.br.poorbnb.poorbnb.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HotelException extends Exception {
    private String message;
    private String cause;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String stackTrace;

    public HotelException(final String message, final String cause, final String stackTrace) {
        super();
        this.message = message;
        this.cause = cause;
        this.stackTrace = stackTrace;
    }

    public HotelException(final String message, final String cause) {
        super();
        this.message = message;
        this.cause = cause;
    }

}
