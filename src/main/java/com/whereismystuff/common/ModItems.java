package com.whereismystuff.common;

import com.whereismystuff.item.KeyItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item KEY_ITEM = new KeyItem();

    public static void initialize() {
        Registry.register(Registry.ITEM, new Identifier("whereismystuff", "key_item"), KEY_ITEM);
    }
}
