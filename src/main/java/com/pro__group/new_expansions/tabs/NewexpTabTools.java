package com.pro__group.new_expansions.tabs;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.registry.NewexpItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NewexpTabTools {
    public static void tabTools() {
        final ItemGroup GROUP_TOOLS = FabricItemGroupBuilder.create(
                        new Identifier(NewExpansions.MOD_ID, "tools"))
                .icon(() -> new ItemStack(NewexpItems.NPICKAXE))
                .appendItems(stacks -> {

                    stacks.add(new ItemStack(NewexpItems.WPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.WAXE));
                    stacks.add(new ItemStack(NewexpItems.WHOE));
                    stacks.add(new ItemStack(NewexpItems.WSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.WSWORD));
                    stacks.add(new ItemStack(NewexpItems.LHELMET));
                    stacks.add(new ItemStack(NewexpItems.LCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.LLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.LBOOTS));

                    stacks.add(new ItemStack(NewexpItems.SPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.SAXE));
                    stacks.add(new ItemStack(NewexpItems.SHOE));
                    stacks.add(new ItemStack(NewexpItems.SSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.SSWORD));
                    stacks.add(new ItemStack(NewexpItems.CHELMET));
                    stacks.add(new ItemStack(NewexpItems.CCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.CLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.CBOOTS));

                    stacks.add(new ItemStack(NewexpItems.IPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.IAXE));
                    stacks.add(new ItemStack(NewexpItems.IHOE));
                    stacks.add(new ItemStack(NewexpItems.ISHOVEL));
                    stacks.add(new ItemStack(NewexpItems.ISWORD));
                    stacks.add(new ItemStack(NewexpItems.IHELMET));
                    stacks.add(new ItemStack(NewexpItems.ICHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.ILEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.IBOOTS));

                    stacks.add(new ItemStack(NewexpItems.BPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.BAXE));
                    stacks.add(new ItemStack(NewexpItems.BHOE));
                    stacks.add(new ItemStack(NewexpItems.BSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.BSWORD));
                    stacks.add(new ItemStack(NewexpItems.BHELMET));
                    stacks.add(new ItemStack(NewexpItems.BCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.BLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.BBOOTS));

                    stacks.add(new ItemStack(NewexpItems.GPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.GAXE));
                    stacks.add(new ItemStack(NewexpItems.GHOE));
                    stacks.add(new ItemStack(NewexpItems.GSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.GSWORD));
                    stacks.add(new ItemStack(NewexpItems.GHELMET));
                    stacks.add(new ItemStack(NewexpItems.GCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.GLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.GBOOTS));

                    stacks.add(new ItemStack(NewexpItems.DPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.DAXE));
                    stacks.add(new ItemStack(NewexpItems.DHOE));
                    stacks.add(new ItemStack(NewexpItems.DSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.DSWORD));
                    stacks.add(new ItemStack(NewexpItems.DHELMET));
                    stacks.add(new ItemStack(NewexpItems.DCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.DLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.DBOOTS));

                    stacks.add(new ItemStack(NewexpItems.NPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.NAXE));
                    stacks.add(new ItemStack(NewexpItems.NHOE));
                    stacks.add(new ItemStack(NewexpItems.NSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.NSWORD));
                    stacks.add(new ItemStack(NewexpItems.NHELMET));
                    stacks.add(new ItemStack(NewexpItems.NCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.NLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.NBOOTS));

                    stacks.add(new ItemStack(NewexpItems.EPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.EAXE));
                    stacks.add(new ItemStack(NewexpItems.EHOE));
                    stacks.add(new ItemStack(NewexpItems.ESHOVEL));
                    stacks.add(new ItemStack(NewexpItems.ESWORD));
                    stacks.add(new ItemStack(NewexpItems.EHELMET));
                    stacks.add(new ItemStack(NewexpItems.ECHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.ELEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.EBOOTS));

                    //upgrades
                    //gold
                    stacks.add(new ItemStack(NewexpItems.GGPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.GGAXE));
                    stacks.add(new ItemStack(NewexpItems.GGHOE));
                    stacks.add(new ItemStack(NewexpItems.GGSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.GGSWORD));
                    stacks.add(new ItemStack(NewexpItems.GGHELMET));
                    stacks.add(new ItemStack(NewexpItems.GGCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.GGLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.GGBOOTS));

                    stacks.add(new ItemStack(NewexpItems.GDPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.GDAXE));
                    stacks.add(new ItemStack(NewexpItems.GDHOE));
                    stacks.add(new ItemStack(NewexpItems.GDSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.GDSWORD));
                    stacks.add(new ItemStack(NewexpItems.GDHELMET));
                    stacks.add(new ItemStack(NewexpItems.GDCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.GDLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.GDBOOTS));

                    stacks.add(new ItemStack(NewexpItems.GNPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.GNAXE));
                    stacks.add(new ItemStack(NewexpItems.GNHOE));
                    stacks.add(new ItemStack(NewexpItems.GNSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.GNSWORD));
                    stacks.add(new ItemStack(NewexpItems.GNHELMET));
                    stacks.add(new ItemStack(NewexpItems.GNCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.GNLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.GNBOOTS));

                    stacks.add(new ItemStack(NewexpItems.GEPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.GEAXE));
                    stacks.add(new ItemStack(NewexpItems.GEHOE));
                    stacks.add(new ItemStack(NewexpItems.GESHOVEL));
                    stacks.add(new ItemStack(NewexpItems.GESWORD));
                    stacks.add(new ItemStack(NewexpItems.GEHELMET));
                    stacks.add(new ItemStack(NewexpItems.GECHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.GELEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.GEBOOTS));

                    //diamond
                    stacks.add(new ItemStack(NewexpItems.DGPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.DGAXE));
                    stacks.add(new ItemStack(NewexpItems.DGHOE));
                    stacks.add(new ItemStack(NewexpItems.DGSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.DGSWORD));
                    stacks.add(new ItemStack(NewexpItems.DGHELMET));
                    stacks.add(new ItemStack(NewexpItems.DGCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.DGLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.DGBOOTS));

                    stacks.add(new ItemStack(NewexpItems.DDPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.DDAXE));
                    stacks.add(new ItemStack(NewexpItems.DDHOE));
                    stacks.add(new ItemStack(NewexpItems.DDSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.DDSWORD));
                    stacks.add(new ItemStack(NewexpItems.DDHELMET));
                    stacks.add(new ItemStack(NewexpItems.DDCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.DDLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.DDBOOTS));

                    stacks.add(new ItemStack(NewexpItems.DNPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.DNAXE));
                    stacks.add(new ItemStack(NewexpItems.DNHOE));
                    stacks.add(new ItemStack(NewexpItems.DNSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.DNSWORD));
                    stacks.add(new ItemStack(NewexpItems.DNHELMET));
                    stacks.add(new ItemStack(NewexpItems.DNCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.DNLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.DNBOOTS));

                    stacks.add(new ItemStack(NewexpItems.DEPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.DEAXE));
                    stacks.add(new ItemStack(NewexpItems.DEHOE));
                    stacks.add(new ItemStack(NewexpItems.DESHOVEL));
                    stacks.add(new ItemStack(NewexpItems.DESWORD));
                    stacks.add(new ItemStack(NewexpItems.DEHELMET));
                    stacks.add(new ItemStack(NewexpItems.DECHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.DELEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.DEBOOTS));

                    //netherite
                    stacks.add(new ItemStack(NewexpItems.NGPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.NGAXE));
                    stacks.add(new ItemStack(NewexpItems.NGHOE));
                    stacks.add(new ItemStack(NewexpItems.NGSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.NGSWORD));
                    stacks.add(new ItemStack(NewexpItems.NGHELMET));
                    stacks.add(new ItemStack(NewexpItems.NGCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.NGLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.NGBOOTS));

                    stacks.add(new ItemStack(NewexpItems.NDPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.NDAXE));
                    stacks.add(new ItemStack(NewexpItems.NDHOE));
                    stacks.add(new ItemStack(NewexpItems.NDSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.NDSWORD));
                    stacks.add(new ItemStack(NewexpItems.NDHELMET));
                    stacks.add(new ItemStack(NewexpItems.NDCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.NDLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.NDBOOTS));

                    stacks.add(new ItemStack(NewexpItems.NNPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.NNAXE));
                    stacks.add(new ItemStack(NewexpItems.NNHOE));
                    stacks.add(new ItemStack(NewexpItems.NNSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.NNSWORD));
                    stacks.add(new ItemStack(NewexpItems.NNHELMET));
                    stacks.add(new ItemStack(NewexpItems.NNCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.NNLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.NNBOOTS));

                    stacks.add(new ItemStack(NewexpItems.NEPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.NEAXE));
                    stacks.add(new ItemStack(NewexpItems.NEHOE));
                    stacks.add(new ItemStack(NewexpItems.NESHOVEL));
                    stacks.add(new ItemStack(NewexpItems.NESWORD));
                    stacks.add(new ItemStack(NewexpItems.NEHELMET));
                    stacks.add(new ItemStack(NewexpItems.NECHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.NELEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.NEBOOTS));

                    //endite
                    stacks.add(new ItemStack(NewexpItems.EGPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.EGAXE));
                    stacks.add(new ItemStack(NewexpItems.EGHOE));
                    stacks.add(new ItemStack(NewexpItems.EGSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.EGSWORD));
                    stacks.add(new ItemStack(NewexpItems.EGHELMET));
                    stacks.add(new ItemStack(NewexpItems.EGCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.EGLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.EGBOOTS));

                    stacks.add(new ItemStack(NewexpItems.EDPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.EDAXE));
                    stacks.add(new ItemStack(NewexpItems.EDHOE));
                    stacks.add(new ItemStack(NewexpItems.EDSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.EDSWORD));
                    stacks.add(new ItemStack(NewexpItems.EDHELMET));
                    stacks.add(new ItemStack(NewexpItems.EDCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.EDLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.EDBOOTS));

                    stacks.add(new ItemStack(NewexpItems.ENPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.ENAXE));
                    stacks.add(new ItemStack(NewexpItems.ENHOE));
                    stacks.add(new ItemStack(NewexpItems.ENSHOVEL));
                    stacks.add(new ItemStack(NewexpItems.ENSWORD));
                    stacks.add(new ItemStack(NewexpItems.ENHELMET));
                    stacks.add(new ItemStack(NewexpItems.ENCHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.ENLEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.ENBOOTS));

                    stacks.add(new ItemStack(NewexpItems.EEPICKAXE));
                    stacks.add(new ItemStack(NewexpItems.EEAXE));
                    stacks.add(new ItemStack(NewexpItems.EEHOE));
                    stacks.add(new ItemStack(NewexpItems.EESHOVEL));
                    stacks.add(new ItemStack(NewexpItems.EESWORD));
                    stacks.add(new ItemStack(NewexpItems.EEHELMET));
                    stacks.add(new ItemStack(NewexpItems.EECHESTPALTE));
                    stacks.add(new ItemStack(NewexpItems.EELEGGINGS));
                    stacks.add(new ItemStack(NewexpItems.EEBOOTS));

                    stacks.add(new ItemStack(NewexpItems.THELMET));
                    stacks.add(new ItemStack(NewexpItems.DRILL));
                    stacks.add(new ItemStack(NewexpItems.DEDALUS_WINGS));

                }).build();
    }
}
