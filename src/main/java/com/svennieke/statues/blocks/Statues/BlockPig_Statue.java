package com.svennieke.statues.blocks.Statues;

import com.svennieke.statues.blocks.IStatue;
import com.svennieke.statues.blocks.StatueBase.BlockPig;
import com.svennieke.statues.compat.list.StatueLootList;
import com.svennieke.statues.init.StatuesBlocks;
import com.svennieke.statues.tileentity.StatueTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockPig_Statue extends BlockPig implements ITileEntityProvider, IStatue {
	
	private int TIER;
	
	public BlockPig_Statue(String unlocalised) {
		super();
		setTranslationKey(unlocalised);
	}
	
	@Override
	public Block setTier(int tier)
	{
		this.TIER = tier;
		setTranslationKey(super.getTranslationKey().replace("tile.", "") + (tier > 1 ? "t" + tier : ""));
		setRegistryName("block" + super.getTranslationKey().replace("tile.", ""));
		return this;
	}
	
	@Override
	public int getTier()
	{
		return this.TIER;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) 
	{
		if(this.TIER == 1)
		{
	    	Block block = worldIn.getBlockState(pos.down()).getBlock();
			if (block == Blocks.SAND) {
	    		worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, pos.down().getX(), pos.down().getY(), pos.down().getZ(), 0.0D, 0.0D, 0.0D, new int[0]);
	    		worldIn.setBlockState(pos.down(), StatuesBlocks.wasteland_statue[0].getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()));
	    		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
	    	}
		}
    	super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (this.TIER >= 2)
		{
			return new StatueTileEntity(this.TIER);
		}
		else
		return null;
	}
	
	private StatueTileEntity getTE(World world, BlockPos pos) {
        return (StatueTileEntity) world.getTileEntity(pos);
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(this.TIER >= 2)
		{
	        if (!worldIn.isRemote) {
	        	StatueTileEntity tile = getTE(worldIn, pos);
	        	
	        	int statuetier = tile.getTier();
	        	if(statuetier != this.TIER)
	        	{
	        		tile.setTier(this.TIER);
	        	}
	        	
	        	ArrayList<ItemStack> stackList = new ArrayList<>(StatueLootList.getStacksForStatue("pig"));
	        	ItemStack stack1 = stackList.get(0);
        		ItemStack stack2 = stackList.get(1);
        		ItemStack stack3 = stackList.get(2);

	        	tile.PlaySound(SoundEvents.ENTITY_PIG_AMBIENT, pos, worldIn);
	        	tile.GiveItem(stack1, stack2, stack3, playerIn);
	        	
	        	tile.SpawnMob(new EntityPig(worldIn), worldIn);
	        }
	        return true;
		}
		else
		return false;
	}
}
