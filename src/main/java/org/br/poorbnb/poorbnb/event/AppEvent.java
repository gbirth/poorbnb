package org.br.poorbnb.poorbnb.event;

import org.springframework.context.ApplicationEvent;

public class AppEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public AppEvent(Object source) {
        super(source);
    }
}
