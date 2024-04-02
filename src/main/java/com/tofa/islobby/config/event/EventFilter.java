package com.tofa.islobby.config.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.EventExecutor;

public interface EventFilter extends EventExecutor {

    default EventPriority eventPriority() {
        return EventPriority.NORMAL;
    }

    Class<? extends Event> eventClass();
}

