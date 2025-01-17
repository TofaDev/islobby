package com.tofa.islobby.scheduler;

import com.tofa.islobby.config.ConfigLoader;
import com.tofa.islobby.config.MiscConfiguration;
import com.tofa.islobby.config.SpawnConfiguration.LocationConfiguration;
import org.bukkit.World;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeSynchronizationScheduler implements Runnable {

    private final ConfigLoader configLoader;

    public TimeSynchronizationScheduler(ConfigLoader configLoader) {
        this.configLoader = configLoader;
    }

    @Override
    public void run() {

        LocationConfiguration locationConfiguration = configLoader.getSpawnConfiguration().getLocationConfiguration();
        MiscConfiguration miscConfiguration = configLoader.getMiscConfiguration();

        World world = locationConfiguration.asLocation().getWorld();
        String timezone = miscConfiguration.getTimeSynchronizationConfiguration().getTimezone();
        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of(timezone));
        Calendar calendar = Calendar.getInstance(timeZone);
        world.setTime((1000L * calendar.get(Calendar.HOUR_OF_DAY)) + (16 * (calendar.get(Calendar.MINUTE) + 1)) - 6000);
    }
}
