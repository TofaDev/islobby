package com.tofa.islobby.listener;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.SpawnConfiguration;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final IsLobby plugin;
    public PlayerJoinListener(IsLobby plugin) {
        this.plugin = plugin;

    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        SpawnConfiguration spawnConfiguration = plugin.getConfigLoader().getSpawnConfiguration();
        Player p = e.getPlayer();
        Location spawnLocation = spawnConfiguration.getLocationConfiguration().asLocation();

        if(!p.hasPlayedBefore() && spawnConfiguration.isSpawnOnFirstConnect()) {
            p.teleport(spawnLocation);
        }

        if(spawnConfiguration.isAlwaysTpToSpawnOnJoin()) {
            p.teleport(spawnLocation);
        }
    }
}
