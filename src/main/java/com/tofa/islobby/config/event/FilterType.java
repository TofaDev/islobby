package com.tofa.islobby.config.event;

import org.bukkit.Material;

import java.util.List;

public enum FilterType {
    BLACKLIST {
        @Override
        public boolean filter(List<String> interactionList, Material material) {
            return interactionList.stream().anyMatch(interaction -> material.name().matches(interaction));
        }
    },
    WHITELIST {
        @Override
        public boolean filter(List<String> interactionList, Material material) {
            return interactionList.stream().noneMatch(interaction -> material.name().matches(interaction));
        }
    };

    public abstract boolean filter(List<String> interactionList, Material material);
}

