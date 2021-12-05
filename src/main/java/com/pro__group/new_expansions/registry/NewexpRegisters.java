package com.pro__group.new_expansions.registry;

import com.pro__group.new_expansions.generation.NewexpOres;

public class NewexpRegisters {
    static public void register()
    {
        NewexpItems.ItemsRegister();
        NewexpBlocks.BloksRegister();
        NewexpFuels.FuelsRegister();
        NewexpOres.OreRegister();
        NewexpPaintings.PaintingsRegister();
    }
}
