package com.tofa.islobby.command;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.ConfigLoader;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandRegisterer {

    private final IsLobby plugin;

    public CommandRegisterer(IsLobby plugin) {
        this.plugin = plugin;
    }

    public void register() {
        BukkitCommandHandler handler = BukkitCommandHandler.create(plugin);
        handler.registerDependency(ConfigLoader.class, plugin.getConfigLoader());
        handler.register(new SetLobbySpawnCommand());
    }
}
