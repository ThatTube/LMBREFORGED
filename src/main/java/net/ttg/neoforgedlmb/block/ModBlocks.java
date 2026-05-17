package net.ttg.neoforgedlmb.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ttg.neoforgedlmb.ReforgedLMod;
import net.ttg.neoforgedlmb.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ReforgedLMod.MOD_ID);

    /*
    * Modelo de regsitrar Blocos
    *   public static final DeferredBlock<Block> NOME_DO_BLOCO = registerBlock("nome_do_bloco",
             () ->
                  new Block(BlockBehaviour.Properties.of().strength(1f, 10f)
                          .sound(SoundType.STONE).emissiveRendering((bs, br, bp) -> true)
                          .lightLevel(s->15)));
    *
    */
    public static final DeferredBlock<Block> GREEN_MAGMA_BLOCK = registerBlock("green_magma_block",
            () ->
                    new Block(BlockBehaviour.Properties.of().strength(0.5f, 05f)
                            .sound(SoundType.STONE).emissiveRendering((bs, br, bp) -> true)
                            .lightLevel(s -> 15)));

    public static final DeferredBlock<Block> POLISHED_CRACKED_BLACKSTONE_BLOCK = registerBlock("polished_cracked_blackstone_block",
            () ->
                    new Block(BlockBehaviour.Properties.of().strength(1.5f, 6f)
                            .sound(SoundType.STONE).requiresCorrectToolForDrops()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
