package net.ttg.neoforgedlmb.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ttg.neoforgedlmb.ReforgedLMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReforgedLMod.MOD_ID);
    /*
    Molde para Registro de Item:
    	public static final DeferredItem<Item> NOME_DO_ITEM = ITEMS.register("nome_do_item",
            () -> new Item(new Item.Properties());
     */
    public static final DeferredItem<Item> GREEN_MAGMA_CREAM = ITEMS.register("green_magma_cream",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
