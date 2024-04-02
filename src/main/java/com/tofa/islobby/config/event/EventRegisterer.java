package com.tofa.islobby.config.event;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.EventsConfiguration;
import com.tofa.islobby.listener.PlayerInteractListener;
import com.tofa.islobby.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class EventRegisterer {

    private final IsLobby plugin;

    public EventRegisterer(IsLobby plugin) {
        this.plugin = plugin;

    }

    public void register() {

        EventsConfiguration eventsConfiguration = plugin.getConfigLoader().getEventsConfiguration();

        eventsConfiguration.getFilters().forEach(eventFilter ->
                Bukkit.getPluginManager().registerEvent(eventFilter.eventClass(), new Listener() {
                }, eventFilter.eventPriority(), eventFilter, plugin));

        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(plugin), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(plugin), plugin);
    }
}
