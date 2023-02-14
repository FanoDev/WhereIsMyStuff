package com.whereismystuff.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KeyItem extends Item {
    public KeyItem() {
        super(new FabricItemSettings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) return TypedActionResult.success(user.getStackInHand(hand));

        user.getStackInHand(hand).setCount(0);

        BlockPos pos = user.getLastDeathPos().get().getPos();

        user.teleport(pos.getX(), pos.getY(), pos.getZ());

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
