package com.svennieke.statues.blocks.StatueBase;

import com.svennieke.statues.blocks.BaseBlock.BaseNormal;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockPig extends BaseNormal{
	
	private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(6, 0, 6, 10, 10.5, 10);
	
	public BlockPig(Block.Properties builder) {
		super(builder.sound(SoundType.PLANT));
	}
	
	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
    }
    
}
