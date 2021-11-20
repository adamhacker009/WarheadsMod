
package net.mcreator.warheads.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.warheads.WarheadsModElements;

@WarheadsModElements.ModElement.Tag
public class AmbrosiumberrysItem extends WarheadsModElements.ModElement {
	@ObjectHolder("warheads:ambrosiumberrys")
	public static final Item block = null;
	public AmbrosiumberrysItem(WarheadsModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(9).saturation(0.3f).build()));
			setRegistryName("ambrosiumberrys");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
