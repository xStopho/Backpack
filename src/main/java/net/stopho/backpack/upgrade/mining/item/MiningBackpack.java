package net.stopho.backpack.upgrade.mining.item;

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

public class MiningBackpack {

    public static final ItemStack BP_LEATHER_MINING = createMiningBackpack("leather");
    public static final ItemStack BP_COPPER_MINING = createMiningBackpack("copper");
    public static final ItemStack BP_IRON_MINING = createMiningBackpack("iron");
    public static final ItemStack BP_GOLD_MINING = createMiningBackpack("gold");
    public static final ItemStack BP_DIAMOND_MINING = createMiningBackpack("diamond");
    public static final ItemStack BP_NETHERITE_MINING = createMiningBackpack("netherite");

    static ItemStack createMiningBackpack(String level) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        PlayerProfile profile = getProfile(level);

        meta.setOwnerProfile(profile);
        meta.setDisplayName("§3" + BackpackPlugin.getPlugin().getConfig().getString("Backpack.level." + level + ".name.mining"));
        head.setItemMeta(meta);

        ItemPDC.setLevel(head, level);
        ItemPDC.activateUpgrade(head, ItemPDC.KEY_MINING);

        return head;
    }

    static PlayerProfile getProfile(String level) {
        PlayerProfile profile = Bukkit.createPlayerProfile(UUID.fromString("000dd0c0-0b00-00d0-b00d-f00000fd00bc"));
        PlayerTextures textures = profile.getTextures();
        URL urlObject;
        try {
            urlObject = new URL(BackpackPlugin.getPlugin().getConfig().getString("Backpack.level." + level + ".texture-link.mining"));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL", e);
        }
        textures.setSkin(urlObject);
        return profile;
    }
}
