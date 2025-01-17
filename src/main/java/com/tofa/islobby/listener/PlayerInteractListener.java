package com.tofa.islobby.listener;

import com.tofa.islobby.IsLobby;
import com.tofa.islobby.config.ConfigLoader;
import com.tofa.islobby.config.InteractionConfiguration;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    ConfigLoader configLoader;

    public PlayerInteractListener(IsLobby plugin) {
        configLoader = plugin.getConfigLoader();
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        InteractionConfiguration interactionConfiguration = configLoader.getInteractionConfiguration();

        Player p = e.getPlayer();

        if(p.hasPermission(interactionConfiguration.getBypassPermission())) return;

        Block clickedBlock = e.getClickedBlock();

        if (clickedBlock == null) return;
        Material blockType = clickedBlock.getType();

        boolean isBlocked = interactionConfiguration.getFilterType()
                .filter(interactionConfiguration.getInteractionList(), blockType);


        e.setCancelled(isBlocked);
    }
}

