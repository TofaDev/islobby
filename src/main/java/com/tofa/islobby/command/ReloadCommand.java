package com.tofa.islobby.command;

import com.tofa.islobby.config.ConfigLoader;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.command.CommandActor;

@Command("islobby")
public class ReloadCommand {

    @Dependency
    private ConfigLoader configLoader;

    @Subcommand("reload")
    @CommandPermission("islobby.reload")
    private void reload(CommandActor actor) {
        configLoader.reload();

        actor.sendRawMessage("plugin config.conf was reloaded!");
    }
}
