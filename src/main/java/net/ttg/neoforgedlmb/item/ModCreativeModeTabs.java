package net.ttg.neoforgedlmb.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ttg.neoforgedlmb.ReforgedLMod;
import net.ttg.neoforgedlmb.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ReforgedLMod.MOD_ID);

    public static final Supplier<CreativeModeTab> LMB_ITEMS_TAB = CREATIVE_MODE_TAB.register("lmb_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GREEN_MAGMA_CREAM.get()))
                    .title(Component.translatable("creativetab.neoforgedlmb.lmb_items"))
                    .displayItems((itemDiplayParameters, output) -> {
                        output.accept(ModItems.GREEN_MAGMA_CREAM.get());
                        output.accept(ModItems.GREEN_MAGMA_BUCKET.get());
                        output.accept(ModItems.RAW_MAGMA_BUCKET.get());
                        output.accept(ModItems.STONE_CUIRLASS.get());
                        output.accept(ModItems.GERADOR_DE_WAVES.get());
                    })

                    .build()
    );

    public static final Supplier<CreativeModeTab> LMB_BLOCKS_TAB = CREATIVE_MODE_TAB.register("lmb_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.GREEN_MAGMA_BLOCK.get()))
                    .title(Component.translatable("creativetab.neoforgedlmb.lmb_blocks"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ReforgedLMod.MOD_ID, "lmb_items_tab"))
                    .displayItems((itemDiplayParameters, output) -> {
                        output.accept(ModBlocks.GREEN_MAGMA_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_CRACKED_BLACKSTONE_BLOCK.get());
                    })

                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
