package net.stopho.backpack.item;

import net.stopho.backpack.BackpackPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {

    public static void registerBaseRecipes() {
        BackpackPlugin.getPlugin().getLogger().info("register base recipes");
        Bukkit.addRecipe(createBackpackRecipe("leather", new ItemStack(Material.STRING), Material.LEATHER, Backpack.BP_LEATHER));
        Bukkit.addRecipe(createBackpackRecipe("copper", Backpack.BP_LEATHER, Material.COPPER_INGOT, Backpack.BP_COPPER));
        Bukkit.addRecipe(createBackpackRecipe("iron", Backpack.BP_COPPER, Material.IRON_INGOT, Backpack.BP_IRON));
        Bukkit.addRecipe(createBackpackRecipe("gold", Backpack.BP_IRON, Material.GOLD_INGOT, Backpack.BP_GOLD));
        Bukkit.addRecipe(createBackpackRecipe("diamond", Backpack.BP_GOLD, Material.DIAMOND, Backpack.BP_DIAMOND));
        Bukkit.addRecipe(createBackpackRecipe("netherite", Backpack.BP_DIAMOND, Material.NETHERITE_SCRAP, Backpack.BP_NETHERITE));
    }

    public static ShapedRecipe createBackpackRecipe(String level, ItemStack backpack, Material upgradeMaterial, ItemStack result) {
        NamespacedKey key = new NamespacedKey(BackpackPlugin.getPlugin(), level + "_backpack");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("UUU","UBU","UUU");
        recipe.setIngredient('U', upgradeMaterial);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(backpack));
        return recipe;
    }
}
