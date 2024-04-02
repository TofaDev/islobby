package com.tofa.islobby.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@ConfigSerializable
public class SpawnConfiguration {

    @Setting("coordinates")
    private LocationConfiguration locationConfiguration;
    private boolean spawnOnFirstConnect;
    private boolean alwaysTpToSpawnOnJoin;
    private boolean spawnOnFall;

    @ConfigSerializable
    public static class LocationConfiguration {

        public LocationConfiguration(Location location) {
            worldName = location.getWorld().getName();
            x = location.getX();
            y = location.getY();
            z = location.getZ();
            yaw = location.getYaw();
            pitch = location.getPitch();
        }

        public LocationConfiguration() {

        }

        private double x, y, z;


        private String worldName;

        private float yaw, pitch;

        public Location asLocation() {
            World world = Bukkit.getWorld(worldName);

            if (world == null) throw new IllegalStateException("world " + worldName + " doesn't exists!");
            return new Location(world, x, y, z, yaw, pitch);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public float getYaw() {
            return yaw;
        }

        public float getPitch() {
            return pitch;
        }

        public String getWorldName() {
            return worldName;
        }
    }


    public LocationConfiguration getLocationConfiguration() {
        return locationConfiguration;
    }

    public void setLocationConfiguration(LocationConfiguration locationConfiguration) {
        this.locationConfiguration = locationConfiguration;
    }

    public boolean isSpawnOnFirstConnect() {
        return spawnOnFirstConnect;
    }


    public boolean isAlwaysTpToSpawnOnJoin() {
        return alwaysTpToSpawnOnJoin;
    }

    public boolean isSpawnOnFall() {
        return spawnOnFall;
    }
}
