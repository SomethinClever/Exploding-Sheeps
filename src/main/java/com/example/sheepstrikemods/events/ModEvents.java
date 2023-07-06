package com.example.sheepstrikemods.events;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.example.sheepstrikemods.SheepStrikeDetector;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.level.Explosion;


import javax.annotation.Nullable;
import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = SheepStrikeDetector.MOD_ID)
public class ModEvents {



    @SubscribeEvent
    public static void explodeSheepWhenHit(AttackEntityEvent event){

        Player player = event.getEntity();
        BlockPos tPos = event.getTarget().getOnPos();

        double x = tPos.getX();
        double y = tPos.getY();
        double z = tPos.getZ();

        Level ee = event.getEntity().level();
        Explosion.BlockInteraction raa = Explosion.BlockInteraction.DESTROY_WITH_DECAY;
        float randomNum = (float) (5 + (Math.random() * 15));
        Explosion explo = new Explosion(ee, event.getEntity(), x, y, z, randomNum, true, raa);


        if(!event.getEntity().level().isClientSide()){


            if(player.getMainHandItem().getItem() == Items.BLAZE_ROD) {
                if(event.getTarget() instanceof Sheep) {
                    event.getTarget().kill();
                    explo.explode();
                    explo.finalizeExplosion(true);
                }
            }
        }
        if(player.getMainHandItem().getItem() == Items.BLAZE_ROD) {
        if(event.getTarget() instanceof Sheep) {
            event.getTarget().kill();
            explo.finalizeExplosion(true);
        }
    }
    }


}



