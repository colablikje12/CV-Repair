package nl.craftville.repair;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RepairSign implements Listener{

	@EventHandler
	public void onClick (PlayerInteractEvent e) {
		final Action a = e.getAction();
		final Player player = e.getPlayer();

		if (a == Action.RIGHT_CLICK_BLOCK) {
			if (!(e.getClickedBlock().getState() instanceof Sign)) {
				return;
			}
			final Sign s = (Sign)e.getClickedBlock().getState();
			if (!s.getLine(1).equals(ChatColor.translateAlternateColorCodes('&', "Repair"))) {
				return;
			}
			e.setCancelled(true);
			if (!(player.hasPermission("CV.Repair"))) {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&6&lCV&f] &cJe hebt de permission CV.Repair niet!"));
				return;
			}
			@SuppressWarnings("deprecation")
			final ItemStack i = player.getItemInHand();
			if (i == null) {
				return;
			}
			if (i.getItemMeta() == null) {
				return;
			}
			if (i.getType() == Material.LEATHER_BOOTS || i.getType() == Material.LEATHER_LEGGINGS || i.getType() == Material.LEATHER_CHESTPLATE ||
					i.getType() == Material.LEATHER_HELMET || i.getType() == Material.CHAINMAIL_BOOTS || i.getType() == Material.CHAINMAIL_LEGGINGS ||
					i.getType() == Material.CHAINMAIL_HELMET || i.getType() == Material.CHAINMAIL_CHESTPLATE || i.getType() == Material.IRON_BOOTS ||
					i.getType() == Material.IRON_LEGGINGS || i.getType() == Material.IRON_CHESTPLATE || i.getType() == Material.IRON_HELMET ||
					i.getType() == Material.DIAMOND_BOOTS || i.getType() == Material.DIAMOND_LEGGINGS || i.getType() == Material.DIAMOND_CHESTPLATE ||
					i.getType() == Material.DIAMOND_HELMET) {
				i.setDurability((short )0);
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "[&6&lCV&f] &aHet item in je hand is succesvol gerepareerd!"));
			}

		}

	}

}
