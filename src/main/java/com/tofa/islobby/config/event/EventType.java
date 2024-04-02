package com.tofa.islobby.config.event;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.jetbrains.annotations.NotNull;

public enum EventType implements EventFilter {
    ENTITY_DAMAGE(EntityDamageEvent.class),
    PVP(EntityDamageByEntityEvent.class),
    HUNGER(FoodLevelChangeEvent.class),
    CHAT(AsyncChatEvent.class),
    MOB_SPAWNING(CreatureSpawnEvent.class);

    EventType(Class<? extends Event> clazz) {
        this.clazz = clazz;
    }

    private final Class<? extends Event> clazz;

    @Override
    public void execute(@NotNull Listener listener, @NotNull Event event) throws EventException {
        if(clazz.isAssignableFrom(event.getClass()) && event instanceof Cancellable) {
            Cancellable cancellableEvent = (Cancellable) event;
            cancellableEvent.setCancelled(true);
        }
    }

    @Override
    public Class<? extends Event> eventClass() {
        return clazz;
    }
}
