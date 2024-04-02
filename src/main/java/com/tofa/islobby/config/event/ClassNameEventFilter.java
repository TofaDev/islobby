package com.tofa.islobby.config.event;

import org.bukkit.event.*;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.util.Optional;

public class ClassNameEventFilter implements EventFilter {

    private static final Reflections EVENT_PACKAGE = new Reflections("org.bukkit.event");
    private final String className;


    public ClassNameEventFilter(String className) {
        this.className = className;
    }

    @Override
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException {
        if (event.getClass().getSimpleName().equals(className) && event instanceof Cancellable) {
            Cancellable cancellableEvent = (Cancellable) event;
            cancellableEvent.setCancelled(true);
        }
    }

    @Override
    public Class<? extends Event> eventClass() {

        Optional<Class<? extends Event>> eventOptional = EVENT_PACKAGE.getSubTypesOf(Event.class).stream()
                .filter(clazz -> clazz.getSimpleName().equals(className)).findFirst();

        if(!eventOptional.isPresent()) throw new IllegalStateException("event by name not found " + className);

        return eventOptional.get();
    }
}
