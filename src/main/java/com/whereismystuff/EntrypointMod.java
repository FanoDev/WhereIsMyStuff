package com.whereismystuff;

import com.whereismystuff.common.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntrypointMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("whereismystuff");

	@Override
	public void onInitialize() {
		ModItems.initialize();

		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
			ItemStack key = ModItems.KEY_ITEM.getDefaultStack();
			key.setCount(1);
			newPlayer.getInventory().setStack(newPlayer.getInventory().selectedSlot, key);
		});
	}
}