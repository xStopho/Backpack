package net.stopho.backpack.item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class Backpack {

    public static final ItemStack BP_LEATHER = createBaseBackpack("leather", "§rLeather Backpack", "40b1b53674918391a07a9d00582c058f9280bc526a716c796ee5eab4be10a760");
    public static final ItemStack BP_COPPER = createBaseBackpack("leather", "§rCopper Backpack", "1e583cb771581d3b27b23f617c7b8a43dcd7220447ff95ff1960414d2350bdb9");
    public static final ItemStack BP_IRON = createBaseBackpack("leather", "§rIron Backpack", "ddaf8edc32afb461aee0713058023101f924e2a7efa883dae72d5d57d4c053d7");
    public static final ItemStack BP_GOLD = createBaseBackpack("leather", "§rGold Backpack", "cf87525ad84efd16806a26ca01984b280e5ba6403505b6f6c9803c24642abfc7");
    public static final ItemStack BP_DIAMOND = createBaseBackpack("leather", "§rDiamond Backpack", "10d1b0732bf7a70de4dc01559cc5c9811068ef7b6095010382709f94093927f6");
    public static final ItemStack BP_NETHERITE = createBaseBackpack("leather", "§rNetherite Backpack", "835d7cc09fffbca3e1c00d421afaa432cf71fcb09555f54523e5220d1af0f97d");

    static ItemStack createBaseBackpack(String level, String name, String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        PlayerProfile profile = getProfile(url);

        meta.setOwnerProfile(profile);
        meta.setDisplayName(name);
        head.setItemMeta(meta);

        return head;
    }

    static PlayerProfile getProfile(String url) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.fromString("000dd0c0-0b00-00d0-b00d-f00000fd00bc"));
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL("https://textures.minecraft.net/texture/" + url);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL", e);
        }
        textures.setSkin(urlObject);
        return profile;
    }
}
