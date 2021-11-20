
package net.mcreator.warheads.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.warheads.item.NoWeakItem;
import net.mcreator.warheads.WarheadsModElements;

@WarheadsModElements.ModElement.Tag
public class WarheadsItemsItemGroup extends WarheadsModElements.ModElement {
	public WarheadsItemsItemGroup(WarheadsModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwarheads_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NoWeakItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
