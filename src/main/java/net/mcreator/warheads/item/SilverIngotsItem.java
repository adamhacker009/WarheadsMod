
package net.mcreator.warheads.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.warheads.itemgroup.WarheadsItemsItemGroup;
import net.mcreator.warheads.WarheadsModElements;

@WarheadsModElements.ModElement.Tag
public class SilverIngotsItem extends WarheadsModElements.ModElement {
	@ObjectHolder("warheads:silver_ingots")
	public static final Item block = null;
	public SilverIngotsItem(WarheadsModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(WarheadsItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("silver_ingots");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
