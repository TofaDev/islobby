package com.tofa.islobby.config;

import com.tofa.islobby.config.event.FilterType;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

import java.util.List;

@ConfigSerializable
public class InteractionConfiguration {

    private String bypassPermission;
    @Setting("list")
    private List<String> interactionList;

    @Setting("type")
    private FilterType filterType;

    public List<String> getInteractionList() {
        return interactionList;
    }

    public String getBypassPermission() {
        return bypassPermission;
    }

    public FilterType getFilterType() {
        return filterType;
    }
}