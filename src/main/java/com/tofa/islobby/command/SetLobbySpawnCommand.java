package com.tofa.islobby.command;

import com.tofa.islobby.config.ConfigLoader;
import com.tofa.islobby.config.SpawnConfiguration;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.spongepowered.configurate.ConfigurateException;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Dependency;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("islobby")
public class SetLobbySpawnCommand {

    @Dependency
    private ConfigLoader configLoader;

    @Subcommand("setlobbyspawn")
    @CommandPermission("islobby.setlobbyspawn")
    private void setLobbySpawn(Player player) {

        Location playerLocation = player.getLocation();
        SpawnConfiguration spawnConfiguration = configLoader.getSpawnConfiguration();

        try {
            spawnConfiguration.setLocationConfiguration(new SpawnConfiguration.LocationConfiguration(playerLocation));
            configLoader.getRootNode().node("spawn").set(SpawnConfiguration.class, spawnConfiguration);
            configLoader.save();
        } catch (ConfigurateException e) {
            player.sendMessage("error while updating spawn location, contact to the server administrator");
        }
    }
}
