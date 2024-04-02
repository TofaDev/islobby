package com.tofa.islobby.config.serializer;

import com.tofa.islobby.config.event.ClassNameEventFilter;
import com.tofa.islobby.config.event.EventFilter;
import com.tofa.islobby.config.event.EventType;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.serialize.TypeSerializer;

import java.lang.reflect.Type;

public class EventFilterTypeSerializer implements TypeSerializer<EventFilter> {

    @Override
    public EventFilter deserialize(Type type, ConfigurationNode node) throws SerializationException {
        if (node.hasChild("class-name")) {
            return new ClassNameEventFilter(node.node("class-name").getString());
        }

        if (node.hasChild("type")) {
            return EventType.valueOf(node.node("type").getString());
        }

        return null;
    }

    @Override
    public void serialize(Type type, @Nullable EventFilter obj, ConfigurationNode node) throws SerializationException {
        throw new UnsupportedOperationException("the serialize is not supported");
    }
}
