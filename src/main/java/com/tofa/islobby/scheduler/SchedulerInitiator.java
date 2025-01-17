package com.tofa.islobby.scheduler;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.MiscConfiguration;
import com.tofa.islobby.config.SpawnConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;

public class SchedulerInitiator {

    private final IsLobby plugin;

    public SchedulerInitiator(IsLobby plugin) {
        this.plugin = plugin;

    }

    public void run() {

        SpawnConfiguration spawnConfiguration = plugin.getConfigLoader().getSpawnConfiguration();
        MiscConfiguration miscConfiguration = plugin.getConfigLoader().getMiscConfiguration();

        if (spawnConfiguration.isSpawnOnFall())
            Bukkit.getScheduler().runTaskTimer(plugin, new PlayerFallScheduler(spawnConfiguration), 20, 20);

        if (miscConfiguration.getTimeSynchronizationConfiguration().isEnabled()) {
            spawnConfiguration.getLocationConfiguration().asLocation().getWorld().setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            Bukkit.getScheduler().runTaskTimer(plugin, new TimeSynchronizationScheduler(
                    plugin.getConfigLoader()
            ), 10, 10);
        }
    }
}
