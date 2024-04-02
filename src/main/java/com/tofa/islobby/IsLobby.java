package com.tofa.islobby;

import com.tofa.islobby.command.CommandRegisterer;
import com.tofa.islobby.config.ConfigLoader;
import com.tofa.islobby.config.event.EventRegisterer;
import com.tofa.islobby.scheduler.SchedulerInitiator;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class IsLobby extends JavaPlugin {

    private final int METRICS_PLUGIN_ID = 21485;
    private ConfigLoader configLoader;

    @Override
    public void onEnable() {
        this.configLoader = new ConfigLoader("config.conf", getDataFolder().getAbsolutePath());

        new Metrics(this, METRICS_PLUGIN_ID);

        new CommandRegisterer(this).register();
        new EventRegisterer(this).register();
        new SchedulerInitiator( this).run();
    }


    public ConfigLoader getConfigLoader() {
        return configLoader;
    }
}
