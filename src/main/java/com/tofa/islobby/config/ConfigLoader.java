package com.tofa.islobby.config;

import com.tofa.islobby.config.serializer.LobbySerializers;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ConfigLoader {

    private final SpawnConfiguration spawnConfiguration;
    private final InteractionConfiguration interactionConfiguration;
    private final MiscConfiguration miscConfiguration;
    private final EventsConfiguration eventsConfiguration;

    private final CommentedConfigurationNode rootNode;
    private final HoconConfigurationLoader loader;


    public ConfigLoader(String resourceConfigurationName, String pluginFolderPath) {
        Path pluginPath = Paths.get(pluginFolderPath);
        Path configurationPath = pluginPath.resolve(resourceConfigurationName);

        createFileConfigurationIfNotExists(configurationPath);

        loader = HoconConfigurationLoader.builder().path(configurationPath).defaultOptions(opts -> opts.serializers(build -> build.registerAll(LobbySerializers.getSerializers()))).build();

        try {
            rootNode = loader.load();
            spawnConfiguration = rootNode.node("spawn").get(SpawnConfiguration.class);
            interactionConfiguration = rootNode.node("interaction-filter").get(InteractionConfiguration.class);
            miscConfiguration = rootNode.node("misc").get(MiscConfiguration.class);
            eventsConfiguration = rootNode.node("events").get(EventsConfiguration.class);
        } catch (ConfigurateException e) {
            throw new RuntimeException(e);
        }
    }

    private void createFileConfigurationIfNotExists(Path configurationPath) {
        if (!Files.exists(configurationPath)) {
            try {
                Files.createDirectories(configurationPath.getParent());
                try (InputStream inputStream = ConfigLoader.class.getResourceAsStream("/config.conf")) {
                    if (inputStream == null)
                        throw new IllegalStateException("jar file must have a settings.conf in resource folder!");
                    Files.copy(inputStream, configurationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public SpawnConfiguration getSpawnConfiguration() {
        return spawnConfiguration;
    }

    public EventsConfiguration getEventsConfiguration() {
        return eventsConfiguration;
    }

    public InteractionConfiguration getInteractionConfiguration() {
        return interactionConfiguration;
    }

    public MiscConfiguration getMiscConfiguration() {
        return miscConfiguration;
    }

    public CommentedConfigurationNode getRootNode() {
        return rootNode;
    }

    public void save() throws ConfigurateException {
        loader.save(rootNode);
    }

    public HoconConfigurationLoader getLoader() {
        return loader;
    }
}
