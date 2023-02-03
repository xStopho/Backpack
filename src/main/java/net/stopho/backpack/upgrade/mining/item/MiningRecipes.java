package net.stopho.backpack.upgrade.mining.item;

import net.stopho.backpack.BackpackPlugin;
import net.stopho.backpack.item.Backpack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class MiningRecipes {

    public static void registerRecipes() {
        BackpackPlugin.getPlugin().getLogger().info("register mining upgrade recipes");
        Bukkit.addRecipe(createBackpackRecipe("leather", Backpack.BP_LEATHER, MiningBackpack.BP_LEATHER_MINING));
        Bukkit.addRecipe(createBackpackRecipe("copper", Backpack.BP_COPPER, MiningBackpack.BP_COPPER_MINING));
        Bukkit.addRecipe(createBackpackRecipe("iron", Backpack.BP_IRON, MiningBackpack.BP_IRON_MINING));
        Bukkit.addRecipe(createBackpackRecipe("gold", Backpack.BP_GOLD, MiningBackpack.BP_GOLD_MINING));
        Bukkit.addRecipe(createBackpackRecipe("diamond", Backpack.BP_DIAMOND, MiningBackpack.BP_DIAMOND_MINING));
        Bukkit.addRecipe(createBackpackRecipe("netherite", Backpack.BP_NETHERITE, MiningBackpack.BP_NETHERITE_MINING));
    }

    public static ShapedRecipe createBackpackRecipe(String level, ItemStack backpack, ItemStack result) {
        NamespacedKey key = new NamespacedKey(BackpackPlugin.getPlugin(), level + "_mining_backpack");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("PB");
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(backpack));
        return recipe;
    }
}
