package com.tofa.islobby.command;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.ConfigLoader;
import revxrsal.commands.Lamp;
import revxrsal.commands.bukkit.BukkitLamp;
import revxrsal.commands.bukkit.actor.BukkitCommandActor;

public class CommandRegisterer {

    private final IsLobby plugin;

    public CommandRegisterer(IsLobby plugin) {
        this.plugin = plugin;
    }

    public void register() {
        Lamp<BukkitCommandActor> lamp = BukkitLamp.builder(plugin)
                .dependency(ConfigLoader.class, plugin.getConfigLoader())
                .build();

        lamp.register(new SetLobbySpawnCommand());
    }
}
