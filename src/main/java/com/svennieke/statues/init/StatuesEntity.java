package com.svennieke.statues.init;

import com.svennieke.statues.Reference;
import com.svennieke.statues.Statues;
import com.svennieke.statues.entity.EntityStatueBat;
import com.svennieke.statues.entity.fakeentity.FakeBlaze;
import com.svennieke.statues.entity.fakeentity.FakeCreeper;
import com.svennieke.statues.entity.fakeentity.FakeEnderman;
import com.svennieke.statues.entity.fakeentity.FakeGhast;
import com.svennieke.statues.entity.fakeentity.FakeGuardian;
import com.svennieke.statues.entity.fakeentity.FakeHusk;
import com.svennieke.statues.entity.fakeentity.FakeMagmaCube;
import com.svennieke.statues.entity.fakeentity.FakeShulker;
import com.svennieke.statues.entity.fakeentity.FakeSkeleton;
import com.svennieke.statues.entity.fakeentity.FakeSlime;
import com.svennieke.statues.entity.fakeentity.FakeSpider;
import com.svennieke.statues.entity.fakeentity.FakeStray;
import com.svennieke.statues.entity.fakeentity.FakeWitch;
import com.svennieke.statues.entity.fakeentity.FakeWitherSkeleton;
import com.svennieke.statues.entity.fakeentity.FakeZombie;
import com.svennieke.statues.entity.fakeentity.FakeZombiePigman;
import com.svennieke.statues.entity.fakeentity.fakeprojectiles.FakeFireball;
import com.svennieke.statues.entity.fakeentity.fakeprojectiles.FakeLargeFireball;
import com.svennieke.statues.entity.fakeentity.fakeprojectiles.FakeShulkerBullet;
import com.svennieke.statues.tileentity.PlayerStatueTileEntity;
import com.svennieke.statues.tileentity.ShulkerStatueTileEntity;
import com.svennieke.statues.tileentity.StatueTileEntity;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StatuesEntity {
	
	static int ID = 0;
	
	public static void register() {		
		registerEntity("statue_bat", EntityStatueBat.class, "StatueBat", 80, 3, true, 3421236, 3556687);
		
		registerEntity("fake_zombie", FakeZombie.class, "FakeZombie", 80, 3, true);
		registerEntity("fake_husk", FakeHusk.class, "FakeHusk", 80, 3, true);
		registerEntity("fake_skeleton", FakeSkeleton.class, "FakeSkeleton", 80, 3, true);
		registerEntity("fake_blaze", FakeBlaze.class, "FakeBlaze", 80, 3, true);
		registerEntity("fake_fireball", FakeFireball.class, "FakeFireball", 80, 3, true);
		registerEntity("fake_creeper", FakeCreeper.class, "FakeCreeper", 80, 3, true);
		registerEntity("fake_enderman", FakeEnderman.class, "FakeEnderman", 80, 3, true);
		registerEntity("fake_ghast", FakeGhast.class, "FakeGhast", 80, 3, true);
		registerEntity("fake_largefireball", FakeLargeFireball.class, "FakeLargeFireball", 80, 3, true);
		registerEntity("fake_guardian", FakeGuardian.class, "FakeGuardian", 80, 3, true);
		registerEntity("fake_slime", FakeSlime.class, "FakeSlime", 80, 3, true);
		registerEntity("fake_magmacube", FakeMagmaCube.class, "FakeMagmaCube", 80, 3, true);
		registerEntity("fake_shulker", FakeShulker.class, "FakeShulker", 80, 3, true);
		registerEntity("fake_shulker_bullet", FakeShulkerBullet.class, "FakeShulkerBullet", 80, 3, true);
		registerEntity("fake_witch", FakeWitch.class, "FakeWitch", 80, 3, true);
		registerEntity("fake_spider", FakeSpider.class, "FakeSpider", 80, 3, true);
		registerEntity("fake_stray", FakeStray.class, "FakeStray", 80, 3, true);
		registerEntity("fake_zombie_pigman", FakeZombiePigman.class, "FakeZombiePigman", 80, 3, true);
		registerEntity("fake_wither_skeleton", FakeWitherSkeleton.class, "FakeWitherSkeleton", 80, 3, true);
		
		registerTileEntity(StatueTileEntity.class, "_tileentity");
		registerTileEntity(PlayerStatueTileEntity.class, "_playertileentity");
		registerTileEntity(ShulkerStatueTileEntity.class, "_shulkerstatue");
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, Statues.instance, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
		ID++;
	}
	
	public static void registerEntity(String registryName, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, registryName), entityClass, Reference.MOD_PREFIX + entityName, ID, Statues.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		ID++;
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> tileentityClass, String tilename) {
		GameRegistry.registerTileEntity(tileentityClass, Reference.MOD_ID + tilename);
	}
}
