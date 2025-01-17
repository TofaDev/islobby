![GitHub Release](https://img.shields.io/github/v/release/tofadev/isLobby) ![GitHub last commit](https://img.shields.io/github/last-commit/tofadev/isLobby) ![GitHub Downloads (all assets, latest release)](https://img.shields.io/github/downloads/tofadev/isLobby/latest/total)


# IsLobby [1.19 - 1.21.4] 

A simple and convenient plugin for configuring a lobby server in Minecraft.  
**IsLobby** provides flexible options for lobby management: event configuration, time synchronization, interaction permissions/denials, and setting spawn points with a single command!

---

## Plugin Features

1. **Fine-tuned event control**  
   Easily enable or disable any events on the server (damage, block destruction, etc.) with just a few clicks.

2. **Time synchronization**  
   Supports real-time synchronization — experience day and night cycles matching real-world time!

3. **Interaction management**  
   Allow players to open doors, press buttons, or break blocks according to your rules. A flexible system of permissions and prohibitions.

4. **Quick spawn setup**  
   Easily set a spawn point for all players with a single command.

---

## Installation and Setup

1. **Download the plugin**  
   Ensure you’re using the plugin version compatible with your Minecraft version (1.19 - 1.21.4).

2. **Place it in the `plugins` folder**  
   Drag and drop the plugin file into your server’s `plugins` folder.

3. **Restart the server**  
   After the server starts, the plugin will automatically generate the necessary configuration files.

4. **Edit the configuration (if needed)**  
   In the `plugins/IsLobby` folder, you’ll find the `config.conf` file, allowing you to fine-tune the plugin’s behavior.

---

## Commands

| Command             | Description                           | Permission              |
|---------------------|---------------------------------------|-------------------------|
| `/setlobbyspawn`    | Sets the lobby spawn point            | `islobby.setlobbyspawn` |

> **Example:**
> ```
> /setlobbyspawn
> ```
> After entering this command, the player's current coordinates become the new spawn point.

---

## Example Configuration (config.conf)

```json
interaction-filter: {
  // list here all the blocks that you want to select for interaction.
  // use * to use a group of blocks of different types at once.
  // In this example, doors and buttons of all kinds will be used.
  // you can disable or allow all blocks by leaving * in the list
  // The list of materials can be found here:
  // https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html

  // in the current configuration, all interactions with any blocks are prohibited
  // list: [".*DOOR.*", ".*BUTTON.*"] - any doors and button types
  // list: ["OAK_DOOR","STONE_BUTTON"] - exact material type
  list: [".*"] // to select all materials

  bypass-permission: "islobby.interaction"

  // select one of the types.
  // if ALLOW is selected, then all items from the list will be allowed to interact with,
  // but not with the rest of the items. if DISALLOW is selected, then it will be FORBIDDEN to
  // interact with items from the list, and allowed with the rest
  type: "WHITELIST" // allowed types: WHITELIST, BLACKLIST
}

// list of events that should be cancelled
events: [
  {
    // disable block breaking
    class-name: "BlockBreakEvent"
  }
  {
    // disable block placing

    // see more on:
    // https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html

    class-name: " BlockPlaceEvent"
  }
  {
    type: "CHAT" // disable chat
    // list of all types of events can be cancelled
    // HUNGER, ENTITY_DAMAGE, PVP, CHAT, MOB_SPAWNING
  }
  {
    type: "HUNGER" // disable hunger
  }
  {
    type: "ENTITY_DAMAGE" // disable any damage
  }
  {
    type: "MOB_SPAWNING" // disable mob spawning
  }
]

misc {
  sync-server-time-to-game {
    enabled: true // when enabled, time in game was synced with server time
    timezone: "Asia/Barnaul"
  }
}

spawn: {
  // just use command /setlobbyspawn
  // permission: islobby.setlobbyspawn
  coordinates: {
    world-name: "world" // do not touch it if you have only 1 world on the server
    x: -138
    y: 75
    z: 29
    yaw: 131
    pitch: 15
  }
  spawn-on-first-connect: true
  always-tp-to-spawn-on-join: true
  spawn-on-fall: true //  when enabled, if the player's position on the y coordinate is below 0, he is teleported to spawn
}
