package org.br.poorbnb.poorbnb.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HotelException extends Exception {
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String causedFor;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String stTrace;

    public HotelException(final String message, final String causedFor, final String stTrace) {
        super();
        this.message = message;
        this.causedFor = causedFor;
        this.stTrace = stTrace;
    }

    public HotelException(final String message, final String causedFor) {
        super();
        this.message = message;
        this.causedFor = causedFor;
    }

}
