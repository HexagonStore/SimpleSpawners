package com.hexagon.spawners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.EntityType;

public enum Mobs {
    ZOMBIE_PIGMAN("Porco Zombie", EntityType.PIG_ZOMBIE),
    BLAZE("Blaze", EntityType.BLAZE),
    RABBIT("Coelho", EntityType.RABBIT),
    MUSHROOM_COW("Vaca cogumelo", EntityType.MUSHROOM_COW),
    VILLAGER("Aldeao", EntityType.VILLAGER),
    IRON_GOLEM("Iron golem", EntityType.IRON_GOLEM),
    ENDERMAN("Enderman", EntityType.ENDERMAN),
    CREEPER("Creeper", EntityType.CREEPER),
    CAVE_SPIDER("Aranha venenosa", EntityType.CAVE_SPIDER),
    SPIDER("Aranha", EntityType.SPIDER),
    SKELETON("Esqueleto", EntityType.SKELETON),
    ZOMBIE("Zombie", EntityType.ZOMBIE),
    COW("Vaca", EntityType.COW),
    PIG("Porco", EntityType.PIG),
    SHEEP("Ovelha", EntityType.SHEEP);
    String displayName;
    public String getDisplayName() {
        return displayName;
    }
    public EntityType getBukkitType() {
        return bukkitType;
    }
    EntityType bukkitType; 
    private Mobs(String displayName, EntityType bukkitType) {
        this.displayName = displayName;
        this.bukkitType = bukkitType;
    }
    public static Mobs getByItemName(Main pluginInstance, String name){
        
        List<Mobs> valuesList = Arrays.asList(values()); 
        return valuesList.stream().filter(mob-> pluginInstance.getSpawnerName(mob.displayName).equals(name)).findAny().orElse(null);
    }
}
