package com.tofa.islobby.config;

import com.tofa.islobby.config.event.EventFilter;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.NodeKey;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.util.List;

@ConfigSerializable
public class EventsConfiguration {

    @Setting(nodeFromParent = true)
    private List<EventFilter> filters;

    public List<EventFilter> getFilters() {
        return filters;
    }
}
