package com.tofa.islobby.scheduler;

import com.tofa.islobby.config.MiscConfiguration;
import com.tofa.islobby.config.SpawnConfiguration.LocationConfiguration;
import com.tofa.islobby.util.MinecraftTime;
import org.bukkit.World;

public class TimeSynchronizationScheduler implements Runnable {

    private final LocationConfiguration locationConfiguration;
    private final MiscConfiguration miscConfiguration;
    public TimeSynchronizationScheduler(LocationConfiguration locationConfiguration, MiscConfiguration miscConfiguration) {
        this.locationConfiguration = locationConfiguration;
        this.miscConfiguration = miscConfiguration;
    }

    @Override
    public void run() {
        World world = locationConfiguration.asLocation().getWorld();
        String timezone = miscConfiguration.getTimeSynchronizationConfiguration().getTimezone();
        world.setTime(MinecraftTime.getCurrentTimeInMinecraftTime(timezone));
    }
}
