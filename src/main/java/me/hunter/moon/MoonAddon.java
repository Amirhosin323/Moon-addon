package me.hunter.moon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;



public class MoonAddon extends JavaPlugin implements SlimefunAddon {
    @Override
    public void onEnable() {
        Config cfg = new Config(this);
        NamespacedKey categoryId = new NamespacedKey(this, "moon_category");
        CustomItemStack categoryItem = new CustomItemStack(Material.END_STONE ,"&7Moon");

        ItemGroup ItemGroup = new ItemGroup(categoryId , categoryItem);

        SlimefunItemStack itemStack = new SlimefunItemStack("MY_ADDON_ITEM", Material.EMERALD, "&aPretty cool Emerald", "", "&7This is awesome");

// A 3x3 shape representing our recipe
        ItemStack[] recipe = {
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
        };

        SlimefunItem sfItem = new SlimefunItem(ItemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        sfItem.register(this);
    }
    @Override
    public void onDisable() {

    }
    @Override
    public JavaPlugin getJavaPlugin() {

        return this;
    }
    @Override
    public String getBugTrackerURL(){
        return null;
    }
}
