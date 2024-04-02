package com.tofa.islobby.util;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MinecraftTime {

    public static final long REAL_FULL_DAY_SECONDS = Duration.ofDays(1).get(ChronoUnit.SECONDS);
    public static final long MINECRAFT_FULL_DAY_SECONDS = Duration.ofMinutes(20).get(ChronoUnit.SECONDS);

    public static long getCurrentTimeInMinecraftTime(String zoneId) {
        return ((getCurrentTimeInSeconds(zoneId) * MINECRAFT_FULL_DAY_SECONDS) / REAL_FULL_DAY_SECONDS);
    }

    private static long getCurrentTimeInSeconds(String zoneId) {
        ZonedDateTime utc = new Date().toInstant().atZone(ZoneOffset.UTC);
        ZonedDateTime zonedDateTime = utc.withZoneSameInstant(ZoneId.of(zoneId));
        Instant midnight = zonedDateTime.toLocalDate().atStartOfDay(zonedDateTime.getZone()).toInstant();
        Duration duration = Duration.between(midnight, Instant.now());

        return duration.getSeconds();
    }
}
