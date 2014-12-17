package ca.pascoej.itembug;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by john on 12/16/14.
 */
public class ItemBug extends JavaPlugin{
    public void onEnable() {
        saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        Player p = (Player) sender;
        ItemStack item = p.getItemInHand();
        if (item == null || item.getType() == Material.AIR)
            return false;
        getConfig().set("test-item",item);
        saveConfig();
        reloadConfig();
        ItemStack itemBack = getConfig().getItemStack("test-item");
        p.getInventory().addItem(itemBack);
        p.sendMessage(ChatColor.GREEN + "replaced item");
        return true;
    }
}
