package net.stopho.backpack.item;

import net.stopho.backpack.BackpackPlugin;
import net.stopho.backpack.data.ItemPDC;
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

    public static final ItemStack BP_LEATHER = createBaseBackpack("leather");
    public static final ItemStack BP_COPPER = createBaseBackpack("copper");
    public static final ItemStack BP_IRON = createBaseBackpack("iron");
    public static final ItemStack BP_GOLD = createBaseBackpack("gold");
    public static final ItemStack BP_DIAMOND = createBaseBackpack("diamond");
    public static final ItemStack BP_NETHERITE = createBaseBackpack("netherite");

    static ItemStack createBaseBackpack(String level) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        PlayerProfile profile = getProfile(level);

        meta.setOwnerProfile(profile);
        meta.setDisplayName("§3" + BackpackPlugin.getPlugin().getConfig().getString("Backpack.level." + level + ".name"));
        head.setItemMeta(meta);

        ItemPDC.setLevel(head, level);
        ItemPDC.setUpgradeDefault(head);

        return head;
    }

    static PlayerProfile getProfile(String level) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.fromString("000dd0c0-0b00-00d0-b00d-f00000fd00bc"));
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(BackpackPlugin.getPlugin().getConfig().getString("Backpack.level." + level + ".texture-link"));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL", e);
        }
        textures.setSkin(urlObject);
        return profile;
    }

}
