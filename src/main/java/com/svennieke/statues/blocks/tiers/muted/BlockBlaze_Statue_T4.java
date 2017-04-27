package com.svennieke.statues.blocks.tiers.muted;

import com.svennieke.statues.Reference;
import com.svennieke.statues.blocks.tiers.base.BlockBlaze_Statue;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBlaze_Statue_T4 extends BlockBlaze_Statue{
	
	private final String TAG_COOLDOWN = "cooldown";
	public static double cooldown;
	
	public BlockBlaze_Statue_T4() {
		super();
		setUnlocalizedName(Reference.StatuesBlocks.BLAZESTATUET4.getUnlocalisedName());
		setRegistryName(Reference.StatuesBlocks.BLAZESTATUET4.getRegistryName());
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		cooldown = Math.random();
		if (cooldown < 0.15) cooldown = StatueBehavior(this, playerIn);
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
	
	public int StatueBehavior(BlockBlaze_Statue_T4 statue, EntityPlayer playerIn) {
		playerIn.dropItem(new ItemStack(Items.BLAZE_ROD, 1), true);
		
		return 0;
	}

}
