package com.svennieke.statues.blocks.Statues;

import com.svennieke.statues.blocks.IStatue;
import com.svennieke.statues.blocks.StatueBase.BlockMagmaSlime;
import com.svennieke.statues.compat.list.StatueLootList;
import com.svennieke.statues.entity.fakeentity.FakeMagmaCube;
import com.svennieke.statues.tileentity.StatueTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockMagmaSlime_Statue extends BlockMagmaSlime implements IStatue{
	
	private int TIER;
	
	public BlockMagmaSlime_Statue(Block.Properties builder) {
		super(builder);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Block setTier(int tier)
	{
		this.TIER = tier;
		return this;
	}
	
	@Override
	public int getTier()
	{
		return this.TIER;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		if (this.TIER >= 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		if (this.TIER >= 2)
		{
			return new StatueTileEntity(this.TIER);
		}
		else
		{
			return null;
		}
	}
	
	private StatueTileEntity getTE(World world, BlockPos pos) {
        return (StatueTileEntity) world.getTileEntity(pos);
    }
	
	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(this.TIER >= 2)
		{
	        if (!worldIn.isRemote) {
	        	int statuetier = getTE(worldIn, pos).getTier();
	        	if(statuetier != this.TIER)
	        	{
	        		getTE(worldIn, pos).setTier(this.TIER);
	        	}
	
	        	ArrayList<ItemStack> stackList = new ArrayList<>(StatueLootList.getStacksForStatue("magma_slime"));
	        	ItemStack stack1 = stackList.get(0);
        		ItemStack stack2 = stackList.get(1);
        		ItemStack stack3 = stackList.get(2);
        		
	        	getTE(worldIn, pos).PlaySound(SoundEvents.ENTITY_MAGMA_CUBE_SQUISH, pos, worldIn);
	        	getTE(worldIn, pos).GiveItem(stack1, stack2, stack3, playerIn);
	        	
	        	getTE(worldIn, pos).FakeMobs(new FakeMagmaCube(worldIn), worldIn, pos, false);
	        }
	        return true;
		}
		else
		return false;
	}
}
