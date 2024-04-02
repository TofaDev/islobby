package com.tofa.islobby.scheduler;

import com.tofa.islobby.config.SpawnConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerFallScheduler implements Runnable {

    private final SpawnConfiguration spawnConfiguration;

    public PlayerFallScheduler(SpawnConfiguration spawnConfiguration) {

        this.spawnConfiguration = spawnConfiguration;
    }

    @Override
    public void run() {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getLocation().getY() < 0)
                onlinePlayer.teleport(spawnConfiguration.getLocationConfiguration().asLocation());
        }
    }
}
