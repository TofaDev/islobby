package com.tofa.islobby.config.serializer;

import com.tofa.islobby.config.event.EventFilter;
import org.spongepowered.configurate.serialize.TypeSerializerCollection;

import java.util.List;

public class LobbySerializers {

    public static TypeSerializerCollection getSerializers() {
        return TypeSerializerCollection
                .builder()
                .register(EventFilter.class, new EventFilterTypeSerializer())
                .build();
    }
}
