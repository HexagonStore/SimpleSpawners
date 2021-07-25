package com.hexagon.spawners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public enum Mobs {
    ZOMBIE_PIGMAN("Porco Zombie", EntityType.PIG_ZOMBIE, "95fb2df754c98b742d35e7b81a1eeac9d37c69fc8cfecd3e91c67983516f"),
    BLAZE("Blaze", EntityType.BLAZE,"b78ef2e4cf2c41a2d14bfde9caff10219f5b1bf5b35a49eb51c6467882cb5f0"),
    RABBIT("Coelho", EntityType.RABBIT,"92162dceffac9574298f97c27a7ac23867cc573a9a2f1789d3db76ea4d8ed159"),
    MUSHROOM_COW("Vaca cogumelo", EntityType.MUSHROOM_COW, "2b52841f2fd589e0bc84cbabf9e1c27cb70cac98f8d6b3dd065e55a4dcb70d77"),
    VILLAGER("Aldeao", EntityType.VILLAGER, "41b830eb4082acec836bc835e40a11282bb51193315f91184337e8d3555583"),
    IRON_GOLEM("Iron golem", EntityType.IRON_GOLEM, "89091d79ea0f59ef7ef94d7bba6e5f17f2f7d4572c44f90f76c4819a714"),
    ENDERMAN("Enderman", EntityType.ENDERMAN, "96c0b36d53fff69a49c7d6f3932f2b0fe948e032226d5e8045ec58408a36e951"),
    CREEPER("Creeper", EntityType.CREEPER, "f4254838c33ea227ffca223dddaabfe0b0215f70da649e944477f44370ca6952"),
    CAVE_SPIDER("Aranha venenosa", EntityType.CAVE_SPIDER, "41645dfd77d09923107b3496e94eeb5c30329f97efc96ed76e226e98224"),
    SPIDER("Aranha", EntityType.SPIDER, "cd541541daaff50896cd258bdbdd4cf80c3ba816735726078bfe393927e57f1"),
    SKELETON("Esqueleto", EntityType.SKELETON, "301268e9c492da1f0d88271cb492a4b302395f515a7bbf77f4a20b95fc02eb2"),
    ZOMBIE("Zombie", EntityType.ZOMBIE, "56fc854bb84cf4b7697297973e02b79bc10698460b51a639c60e5e417734e11"),
    COW("Vaca", EntityType.COW, "5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5"),
    PIG("Porco", EntityType.PIG, "621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4"),
    SHEEP("Ovelha", EntityType.SHEEP, "f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70");
    String displayName;
    public String getDisplayName() {
        return displayName;
    }
    public EntityType getBukkitType() {
        return bukkitType;
    }
    EntityType bukkitType;
    String skullTexture;
    public String getSkullTexture() {
        return skullTexture;
    }
    private Mobs(String displayName, EntityType bukkitType, String skullTexture) {
        this.displayName = displayName;
        this.bukkitType = bukkitType;
        this.skullTexture = skullTexture;
    }
    public static Mobs getByItemName(Main pluginInstance, String name){
        
        List<Mobs> valuesList = Arrays.asList(values()); 
        return valuesList.stream().filter(mob-> pluginInstance.getSpawnerName(mob.displayName).equals(name)).findAny().orElse(null);
    }
}
