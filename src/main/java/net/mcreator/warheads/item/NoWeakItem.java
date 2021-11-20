
package net.mcreator.warheads.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.warheads.itemgroup.WarheadsItemsItemGroup;
import net.mcreator.warheads.WarheadsModElements;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

@WarheadsModElements.ModElement.Tag
public class NoWeakItem extends WarheadsModElements.ModElement {
	@ObjectHolder("warheads:no_weak")
	public static final Item block = null;
	public NoWeakItem(WarheadsModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent(
						"\u0413\u043E\u0432\u043E\u0440\u044F\u0442 \u0447\u0442\u043E \u044D\u0442\u043E\u0442 \u043F\u0440\u0435\u0434\u043C\u0435\u0442 \u043F\u043E\u043C\u043E\u0433\u0430\u043B \u0431\u043E\u0433\u0430\u043C \u0434\u0435\u043B\u0430\u0442\u044C \u043D\u0430\u0448 \u043C\u0438\u0440"));
			}
		}.setRegistryName("no_weak"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(WarheadsItemsItemGroup.tab).maxDamage(10130).isImmuneToFire());
		}

		@Override
		public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
				builder.putAll(super.getAttributeModifiers(equipmentSlot));
				builder.put(Attributes.ATTACK_DAMAGE,
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 10.299999999999999f, AttributeModifier.Operation.ADDITION));
				builder.put(Attributes.ATTACK_SPEED,
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3.2, AttributeModifier.Operation.ADDITION));
				return builder.build();
			}
			return super.getAttributeModifiers(equipmentSlot);
		}

		@Override
		public boolean canHarvestBlock(BlockState state) {
			return 21231 >= state.getHarvestLevel();
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			return 90.5f;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(1, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 28;
		}
	}
}
