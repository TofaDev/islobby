package com.tofa.islobby.config;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class MiscConfiguration {
    @Setting("sync-server-time-to-game")
    private TimeSynchronizationConfiguration timeSynchronizationConfiguration;

    @ConfigSerializable
    public static class TimeSynchronizationConfiguration {
        private boolean enabled;
        private String timezone;

        public boolean isEnabled() {
            return enabled;
        }

        public String getTimezone() {
            return timezone;
        }
    }

    public TimeSynchronizationConfiguration getTimeSynchronizationConfiguration() {
        return timeSynchronizationConfiguration;
    }
}
