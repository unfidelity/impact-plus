/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemAppleGold
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.network.play.server.SPacketSoundEffect
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.CombatRules
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.SoundCategory
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.Explosion
 *  net.minecraft.world.World
 */
package me.axua.impactplus.module.modules.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.chat.AutoEz;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CrystalAura
extends Module {
    /* synthetic */ Setting.i espR;
    public static /* synthetic */ boolean isActive;
    private /* synthetic */ Setting.b rainbow;
    /* synthetic */ EnumFacing f;
    private /* synthetic */ Entity renderEnt;
    private /* synthetic */ Setting.i walls;
    /* synthetic */ Setting.i espA;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Send> packetSendListener;
    /* synthetic */ Setting.i espG;
    private /* synthetic */ Setting.b raytrace;
    private /* synthetic */ Setting.b autoSwitch;
    private static /* synthetic */ boolean isSpoofingAngles;
    private /* synthetic */ boolean isSneaking;
    private /* synthetic */ Setting.b rotate;
    private /* synthetic */ Setting.i waitTick;
    private /* synthetic */ Setting.b newversion;
    private static /* synthetic */ double yaw;
    private /* synthetic */ Setting.b renderDamage;
    /* synthetic */ Setting.i w;
    private /* synthetic */ Setting.i maxSelfDmg;
    private static /* synthetic */ double pitch;
    private /* synthetic */ Setting.i minDmg;
    private /* synthetic */ Setting.i facePlace;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> packetReceiveListener;
    private /* synthetic */ BlockPos render;
    private /* synthetic */ int waitCounter;
    private /* synthetic */ int oldSlot;
    private /* synthetic */ boolean isAttacking;
    private /* synthetic */ Setting.i range;
    public /* synthetic */ int crystals;
    private /* synthetic */ int newSlot;
    private /* synthetic */ boolean switchCooldown;
    /* synthetic */ Setting.i espB;

    public CrystalAura() {
        super("CrystalAura", Module.Category.COMBAT, "Attacks nearby players");
        CrystalAura llllllllllllllllIIllIIllIIlIllIl;
        llllllllllllllllIIllIIllIIlIllIl.isSneaking = false;
        llllllllllllllllIIllIIllIIlIllIl.switchCooldown = false;
        llllllllllllllllIIllIIllIIlIllIl.isAttacking = false;
        llllllllllllllllIIllIIllIIlIllIl.oldSlot = -1;
        llllllllllllllllIIllIIllIIlIllIl.packetSendListener = new Listener<PacketEvent.Send>(llllllllllllllllIIllIIlIIIIlllII -> {
            Packet llllllllllllllllIIllIIlIIIIlllIl = llllllllllllllllIIllIIlIIIIlllII.getPacket();
            if (llllllllllllllllIIllIIlIIIIlllIl instanceof CPacketPlayer && isSpoofingAngles) {
                ((CPacketPlayer)llllllllllllllllIIllIIlIIIIlllIl).yaw = (float)yaw;
                ((CPacketPlayer)llllllllllllllllIIllIIlIIIIlllIl).pitch = (float)pitch;
            }
        }, new Predicate[0]);
        llllllllllllllllIIllIIllIIlIllIl.packetReceiveListener = new Listener<PacketEvent.Receive>(llllllllllllllllIIllIIlIIIlIIlIl -> {
            SPacketSoundEffect llllllllllllllllIIllIIlIIIlIIllI;
            if (llllllllllllllllIIllIIlIIIlIIlIl.getPacket() instanceof SPacketSoundEffect && (llllllllllllllllIIllIIlIIIlIIllI = (SPacketSoundEffect)llllllllllllllllIIllIIlIIIlIIlIl.getPacket()).func_186977_b() == SoundCategory.BLOCKS && llllllllllllllllIIllIIlIIIlIIllI.func_186978_a() == SoundEvents.field_187539_bB) {
                for (Entity llllllllllllllllIIllIIlIIIlIIlll : Minecraft.getMinecraft().theWorld.loadedEntityList) {
                    if (!(llllllllllllllllIIllIIlIIIlIIlll instanceof EntityEnderCrystal) || !(llllllllllllllllIIllIIlIIIlIIlll.getDistance(llllllllllllllllIIllIIlIIIlIIllI.getX(), llllllllllllllllIIllIIlIIIlIIllI.getY(), llllllllllllllllIIllIIlIIIlIIllI.getZ()) <= 6.0)) continue;
                    llllllllllllllllIIllIIlIIIlIIlll.setDead();
                }
            }
        }, new Predicate[0]);
    }

    public static float calculateDamage(double llllllllllllllllIIllIIlIlIIIllII, double llllllllllllllllIIllIIlIlIIIlIll, double llllllllllllllllIIllIIlIlIIIlIlI, Entity llllllllllllllllIIllIIlIIlllllIl) {
        float llllllllllllllllIIllIIlIlIIIlIII = 12.0f;
        double llllllllllllllllIIllIIlIlIIIIlll = llllllllllllllllIIllIIlIIlllllIl.getDistance(llllllllllllllllIIllIIlIlIIIllII, llllllllllllllllIIllIIlIlIIIlIll, llllllllllllllllIIllIIlIlIIIlIlI) / (double)llllllllllllllllIIllIIlIlIIIlIII;
        Vec3d llllllllllllllllIIllIIlIlIIIIllI = new Vec3d(llllllllllllllllIIllIIlIlIIIllII, llllllllllllllllIIllIIlIlIIIlIll, llllllllllllllllIIllIIlIlIIIlIlI);
        double llllllllllllllllIIllIIlIlIIIIlIl = llllllllllllllllIIllIIlIIlllllIl.worldObj.getBlockDensity(llllllllllllllllIIllIIlIlIIIIllI, llllllllllllllllIIllIIlIIlllllIl.getEntityBoundingBox());
        double llllllllllllllllIIllIIlIlIIIIlII = (1.0 - llllllllllllllllIIllIIlIlIIIIlll) * llllllllllllllllIIllIIlIlIIIIlIl;
        float llllllllllllllllIIllIIlIlIIIIIll = (int)((llllllllllllllllIIllIIlIlIIIIlII * llllllllllllllllIIllIIlIlIIIIlII + llllllllllllllllIIllIIlIlIIIIlII) / 2.0 * 7.0 * (double)llllllllllllllllIIllIIlIlIIIlIII + 1.0);
        double llllllllllllllllIIllIIlIlIIIIIlI = 1.0;
        if (llllllllllllllllIIllIIlIIlllllIl instanceof EntityLivingBase) {
            llllllllllllllllIIllIIlIlIIIIIlI = CrystalAura.getBlastReduction((EntityLivingBase)llllllllllllllllIIllIIlIIlllllIl, CrystalAura.getDamageMultiplied(llllllllllllllllIIllIIlIlIIIIIll), new Explosion((World)CrystalAura.mc.theWorld, null, llllllllllllllllIIllIIlIlIIIllII, llllllllllllllllIIllIIlIlIIIlIll, llllllllllllllllIIllIIlIlIIIlIlI, 6.0f, false, true));
        }
        return (float)llllllllllllllllIIllIIlIlIIIIIlI;
    }

    public BlockPos crypos() {
        CrystalAura llllllllllllllllIIllIIllIIlIlIII;
        if (llllllllllllllllIIllIIllIIlIlIII.render == null) {
            return null;
        }
        return llllllllllllllllIIllIIllIIlIlIII.render;
    }

    public static float getBlastReduction(EntityLivingBase llllllllllllllllIIllIIlIIllIlIII, float llllllllllllllllIIllIIlIIllIlIlI, Explosion llllllllllllllllIIllIIlIIllIlIIl) {
        if (llllllllllllllllIIllIIlIIllIlIII instanceof EntityPlayer) {
            EntityPlayer llllllllllllllllIIllIIlIIllIllll = (EntityPlayer)llllllllllllllllIIllIIlIIllIlIII;
            DamageSource llllllllllllllllIIllIIlIIllIlllI = DamageSource.setExplosionSource((Explosion)llllllllllllllllIIllIIlIIllIlIIl);
            llllllllllllllllIIllIIlIIllIlIlI = CombatRules.func_189427_a((float)llllllllllllllllIIllIIlIIllIlIlI, (float)llllllllllllllllIIllIIlIIllIllll.getTotalArmorValue(), (float)((float)llllllllllllllllIIllIIlIIllIllll.getEntityAttribute(SharedMonsterAttributes.field_189429_h).getAttributeValue()));
            int llllllllllllllllIIllIIlIIllIllIl = EnchantmentHelper.getEnchantmentModifierDamage((Iterable)llllllllllllllllIIllIIlIIllIllll.func_184193_aE(), (DamageSource)llllllllllllllllIIllIIlIIllIlllI);
            float llllllllllllllllIIllIIlIIllIllII = MathHelper.clamp_float((float)llllllllllllllllIIllIIlIIllIllIl, (float)0.0f, (float)20.0f);
            llllllllllllllllIIllIIlIIllIlIlI *= 1.0f - llllllllllllllllIIllIIlIIllIllII / 25.0f;
            if (llllllllllllllllIIllIIlIIllIlIII.isPotionActive(Potion.func_188412_a((int)11))) {
                llllllllllllllllIIllIIlIIllIlIlI -= llllllllllllllllIIllIIlIIllIlIlI / 4.0f;
            }
            return llllllllllllllllIIllIIlIIllIlIlI;
        }
        llllllllllllllllIIllIIlIIllIlIlI = CombatRules.func_189427_a((float)llllllllllllllllIIllIIlIIllIlIlI, (float)llllllllllllllllIIllIIlIIllIlIII.getTotalArmorValue(), (float)((float)llllllllllllllllIIllIIlIIllIlIII.getEntityAttribute(SharedMonsterAttributes.field_189429_h).getAttributeValue()));
        return llllllllllllllllIIllIIlIIllIlIlI;
    }

    private static void resetRotation() {
        if (isSpoofingAngles) {
            yaw = CrystalAura.mc.thePlayer.rotationYaw;
            pitch = CrystalAura.mc.thePlayer.rotationPitch;
            isSpoofingAngles = false;
        }
    }

    @Override
    public void onEnable() {
        CrystalAura llllllllllllllllIIllIIlIIIlIllll;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIIllIIlIIIlIllll);
        isActive = false;
    }

    private static float getDamageMultiplied(float llllllllllllllllIIllIIlIIlIlllll) {
        int llllllllllllllllIIllIIlIIlIllllI = CrystalAura.mc.theWorld.getDifficulty().getDifficultyId();
        return llllllllllllllllIIllIIlIIlIlllll * (llllllllllllllllIIllIIlIIlIllllI == 0 ? 0.0f : (llllllllllllllllIIllIIlIIlIllllI == 2 ? 1.0f : (llllllllllllllllIIllIIlIIlIllllI == 1 ? 0.5f : 1.5f)));
    }

    @Override
    public void onDisable() {
        CrystalAura llllllllllllllllIIllIIlIIIlIllII;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIIllIIlIIIlIllII);
        llllllllllllllllIIllIIlIIIlIllII.render = null;
        llllllllllllllllIIllIIlIIIlIllII.renderEnt = null;
        CrystalAura.resetRotation();
        isActive = false;
    }

    @Override
    public void onUpdate() {
        int llllllllllllllllIIllIIllIIIIllII;
        CrystalAura llllllllllllllllIIllIIllIIIIlllI;
        isActive = false;
        if (CrystalAura.mc.thePlayer == null || CrystalAura.mc.thePlayer.isDead) {
            return;
        }
        EntityEnderCrystal llllllllllllllllIIllIIllIIIIllIl = CrystalAura.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIllIIlIIIIIIllI -> llllllllllllllllIIllIIlIIIIIIllI instanceof EntityEnderCrystal).filter(llllllllllllllllIIllIIlIIIIIlIIl -> {
            CrystalAura llllllllllllllllIIllIIlIIIIIllII;
            return CrystalAura.mc.thePlayer.getDistanceToEntity(llllllllllllllllIIllIIlIIIIIlIIl) <= (float)llllllllllllllllIIllIIlIIIIIllII.range.getValue();
        }).map(llllllllllllllllIIllIIlIIIIIllll -> (EntityEnderCrystal)llllllllllllllllIIllIIlIIIIIllll).min(Comparator.comparing(llllllllllllllllIIllIIlIIIIlIIll -> Float.valueOf(CrystalAura.mc.thePlayer.getDistanceToEntity((Entity)llllllllllllllllIIllIIlIIIIlIIll)))).orElse(null);
        if (llllllllllllllllIIllIIllIIIIllIl != null) {
            if (!CrystalAura.mc.thePlayer.canEntityBeSeen((Entity)llllllllllllllllIIllIIllIIIIllIl) && CrystalAura.mc.thePlayer.getDistanceToEntity((Entity)llllllllllllllllIIllIIllIIIIllIl) > (float)llllllllllllllllIIllIIllIIIIlllI.walls.getValue()) {
                return;
            }
            if (llllllllllllllllIIllIIllIIIIlllI.waitTick.getValue() > 0) {
                if (llllllllllllllllIIllIIllIIIIlllI.waitCounter < llllllllllllllllIIllIIllIIIIlllI.waitTick.getValue()) {
                    ++llllllllllllllllIIllIIllIIIIlllI.waitCounter;
                    return;
                }
                llllllllllllllllIIllIIllIIIIlllI.waitCounter = 0;
            }
            if (CrystalAura.mc.thePlayer.isPotionActive(MobEffects.weakness)) {
                if (!llllllllllllllllIIllIIllIIIIlllI.isAttacking) {
                    llllllllllllllllIIllIIllIIIIlllI.oldSlot = CrystalAura.mc.thePlayer.inventory.currentItem;
                    llllllllllllllllIIllIIllIIIIlllI.isAttacking = true;
                }
                llllllllllllllllIIllIIllIIIIlllI.newSlot = -1;
                for (int llllllllllllllllIIllIIllIIIlIllI = 0; llllllllllllllllIIllIIllIIIlIllI < 9; ++llllllllllllllllIIllIIllIIIlIllI) {
                    ItemStack llllllllllllllllIIllIIllIIIlIlll = CrystalAura.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIllIIllIIIlIllI);
                    if (llllllllllllllllIIllIIllIIIlIlll == ItemStack.field_190927_a) continue;
                    if (llllllllllllllllIIllIIllIIIlIlll.getItem() instanceof ItemSword) {
                        llllllllllllllllIIllIIllIIIIlllI.newSlot = llllllllllllllllIIllIIllIIIlIllI;
                        break;
                    }
                    if (!(llllllllllllllllIIllIIllIIIlIlll.getItem() instanceof ItemTool)) continue;
                    llllllllllllllllIIllIIllIIIIlllI.newSlot = llllllllllllllllIIllIIllIIIlIllI;
                    break;
                }
                if (llllllllllllllllIIllIIllIIIIlllI.newSlot != -1) {
                    CrystalAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIIllIIllIIIIlllI.newSlot;
                    llllllllllllllllIIllIIllIIIIlllI.switchCooldown = true;
                }
            }
            isActive = true;
            if (llllllllllllllllIIllIIllIIIIlllI.rotate.getValue()) {
                llllllllllllllllIIllIIllIIIIlllI.lookAtPacket(llllllllllllllllIIllIIllIIIIllIl.posX, llllllllllllllllIIllIIllIIIIllIl.posY, llllllllllllllllIIllIIllIIIIllIl.posZ, (EntityPlayer)CrystalAura.mc.thePlayer);
            }
            CrystalAura.mc.playerController.attackEntity((EntityPlayer)CrystalAura.mc.thePlayer, (Entity)llllllllllllllllIIllIIllIIIIllIl);
            CrystalAura.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            isActive = false;
            return;
        }
        CrystalAura.resetRotation();
        if (llllllllllllllllIIllIIllIIIIlllI.oldSlot != -1) {
            CrystalAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIIllIIllIIIIlllI.oldSlot;
            llllllllllllllllIIllIIllIIIIlllI.oldSlot = -1;
        }
        llllllllllllllllIIllIIllIIIIlllI.isAttacking = false;
        isActive = false;
        int n = llllllllllllllllIIllIIllIIIIllII = CrystalAura.mc.thePlayer.func_184614_ca().getItem() == Items.field_185158_cP ? CrystalAura.mc.thePlayer.inventory.currentItem : -1;
        if (llllllllllllllllIIllIIllIIIIllII == -1) {
            for (int llllllllllllllllIIllIIllIIIlIlIl = 0; llllllllllllllllIIllIIllIIIlIlIl < 9; ++llllllllllllllllIIllIIllIIIlIlIl) {
                if (CrystalAura.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIllIIllIIIlIlIl).getItem() != Items.field_185158_cP) continue;
                llllllllllllllllIIllIIllIIIIllII = llllllllllllllllIIllIIllIIIlIlIl;
                break;
            }
        }
        boolean llllllllllllllllIIllIIllIIIIlIll = false;
        if (CrystalAura.mc.thePlayer.func_184592_cb().getItem() == Items.field_185158_cP) {
            llllllllllllllllIIllIIllIIIIlIll = true;
        } else if (llllllllllllllllIIllIIllIIIIllII == -1) {
            return;
        }
        List<BlockPos> llllllllllllllllIIllIIllIIIIlIlI = llllllllllllllllIIllIIllIIIIlllI.findCrystalBlocks();
        ArrayList llllllllllllllllIIllIIllIIIIlIIl = new ArrayList();
        llllllllllllllllIIllIIllIIIIlIIl.addAll(CrystalAura.mc.theWorld.playerEntities.stream().filter(llllllllllllllllIIllIIlIIIIlIllI -> !Friends.isFriend(llllllllllllllllIIllIIlIIIIlIllI.getName())).sorted(Comparator.comparing(llllllllllllllllIIllIIlIIIIllIIl -> Float.valueOf(CrystalAura.mc.thePlayer.getDistanceToEntity((Entity)llllllllllllllllIIllIIlIIIIllIIl)))).collect(Collectors.toList()));
        BlockPos llllllllllllllllIIllIIllIIIIlIII = null;
        double llllllllllllllllIIllIIllIIIIIlll = 0.5;
        for (Entity llllllllllllllllIIllIIllIIIlIIII : llllllllllllllllIIllIIllIIIIlIIl) {
            if (llllllllllllllllIIllIIllIIIlIIII == CrystalAura.mc.thePlayer || ((EntityLivingBase)llllllllllllllllIIllIIllIIIlIIII).getHealth() <= 0.0f || llllllllllllllllIIllIIllIIIlIIII.isDead || CrystalAura.mc.thePlayer == null) continue;
            for (BlockPos llllllllllllllllIIllIIllIIIlIIIl : llllllllllllllllIIllIIllIIIIlIlI) {
                double llllllllllllllllIIllIIllIIIlIlII;
                double llllllllllllllllIIllIIllIIIlIIlI;
                double llllllllllllllllIIllIIllIIIlIIll = llllllllllllllllIIllIIllIIIlIIII.getDistanceSq(llllllllllllllllIIllIIllIIIlIIIl);
                if (llllllllllllllllIIllIIllIIIlIIll >= 169.0 || (llllllllllllllllIIllIIllIIIlIIlI = (double)CrystalAura.calculateDamage((double)llllllllllllllllIIllIIllIIIlIIIl.getX() + 0.5, llllllllllllllllIIllIIllIIIlIIIl.getY() + 1, (double)llllllllllllllllIIllIIllIIIlIIIl.getZ() + 0.5, llllllllllllllllIIllIIllIIIlIIII)) < (double)llllllllllllllllIIllIIllIIIIlllI.minDmg.getValue() && ((EntityLivingBase)llllllllllllllllIIllIIllIIIlIIII).getHealth() + ((EntityLivingBase)llllllllllllllllIIllIIllIIIlIIII).getAbsorptionAmount() > (float)llllllllllllllllIIllIIllIIIIlllI.facePlace.getValue() || !(llllllllllllllllIIllIIllIIIlIIlI > llllllllllllllllIIllIIllIIIIIlll) || (llllllllllllllllIIllIIllIIIlIlII = (double)CrystalAura.calculateDamage((double)llllllllllllllllIIllIIllIIIlIIIl.getX() + 0.5, llllllllllllllllIIllIIllIIIlIIIl.getY() + 1, (double)llllllllllllllllIIllIIllIIIlIIIl.getZ() + 0.5, (Entity)CrystalAura.mc.thePlayer)) > llllllllllllllllIIllIIllIIIlIIlI && !(llllllllllllllllIIllIIllIIIlIIlI < (double)((EntityLivingBase)llllllllllllllllIIllIIllIIIlIIII).getHealth()) || llllllllllllllllIIllIIllIIIlIlII - 0.5 > (double)CrystalAura.mc.thePlayer.getHealth() || llllllllllllllllIIllIIllIIIlIlII > (double)llllllllllllllllIIllIIllIIIIlllI.maxSelfDmg.getValue()) continue;
                llllllllllllllllIIllIIllIIIIIlll = llllllllllllllllIIllIIllIIIlIIlI;
                llllllllllllllllIIllIIllIIIIlIII = llllllllllllllllIIllIIllIIIlIIIl;
                llllllllllllllllIIllIIllIIIIlllI.renderEnt = llllllllllllllllIIllIIllIIIlIIII;
            }
        }
        if (llllllllllllllllIIllIIllIIIIIlll == 0.5) {
            llllllllllllllllIIllIIllIIIIlllI.render = null;
            llllllllllllllllIIllIIllIIIIlllI.renderEnt = null;
            CrystalAura.resetRotation();
            return;
        }
        llllllllllllllllIIllIIllIIIIlllI.render = llllllllllllllllIIllIIllIIIIlIII;
        if (CrystalAura.mc.thePlayer == null) {
            return;
        }
        isActive = true;
        if (llllllllllllllllIIllIIllIIIIlllI.rotate.getValue()) {
            llllllllllllllllIIllIIllIIIIlllI.lookAtPacket((double)llllllllllllllllIIllIIllIIIIlIII.getX() + 0.5, (double)llllllllllllllllIIllIIllIIIIlIII.getY() - 0.5, (double)llllllllllllllllIIllIIllIIIIlIII.getZ() + 0.5, (EntityPlayer)CrystalAura.mc.thePlayer);
        }
        RayTraceResult llllllllllllllllIIllIIllIIIIllll = CrystalAura.mc.theWorld.rayTraceBlocks(new Vec3d(CrystalAura.mc.thePlayer.posX, CrystalAura.mc.thePlayer.posY + (double)CrystalAura.mc.thePlayer.getEyeHeight(), CrystalAura.mc.thePlayer.posZ), new Vec3d((double)llllllllllllllllIIllIIllIIIIlIII.getX() + 0.5, (double)llllllllllllllllIIllIIllIIIIlIII.getY() - 0.5, (double)llllllllllllllllIIllIIllIIIIlIII.getZ() + 0.5));
        if (llllllllllllllllIIllIIllIIIIlllI.raytrace.getValue()) {
            if (llllllllllllllllIIllIIllIIIIllll == null || llllllllllllllllIIllIIllIIIIllll.sideHit == null) {
                llllllllllllllllIIllIIllIIIIlIII = null;
                llllllllllllllllIIllIIllIIIIlllI.f = null;
                llllllllllllllllIIllIIllIIIIlllI.render = null;
                CrystalAura.resetRotation();
                isActive = false;
                return;
            }
            llllllllllllllllIIllIIllIIIIlllI.f = llllllllllllllllIIllIIllIIIIllll.sideHit;
        }
        if (!llllllllllllllllIIllIIllIIIIlIll && CrystalAura.mc.thePlayer.inventory.currentItem != llllllllllllllllIIllIIllIIIIllII) {
            if (llllllllllllllllIIllIIllIIIIlllI.autoSwitch.getValue()) {
                if (llllllllllllllllIIllIIllIIIIlllI.isEatingGap()) {
                    isActive = false;
                    CrystalAura.resetRotation();
                    return;
                }
                isActive = true;
                CrystalAura.mc.thePlayer.inventory.currentItem = llllllllllllllllIIllIIllIIIIllII;
                CrystalAura.resetRotation();
                llllllllllllllllIIllIIllIIIIlllI.switchCooldown = true;
            }
            return;
        }
        if (llllllllllllllllIIllIIllIIIIlllI.switchCooldown) {
            llllllllllllllllIIllIIllIIIIlllI.switchCooldown = false;
            return;
        }
        if (llllllllllllllllIIllIIllIIIIlIII != null && CrystalAura.mc.thePlayer != null) {
            isActive = true;
            if (llllllllllllllllIIllIIllIIIIlllI.raytrace.getValue() && llllllllllllllllIIllIIllIIIIlllI.f != null) {
                CrystalAura.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llllllllllllllllIIllIIllIIIIlIII, llllllllllllllllIIllIIllIIIIlllI.f, llllllllllllllllIIllIIllIIIIlIll ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            } else {
                CrystalAura.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llllllllllllllllIIllIIllIIIIlIII, EnumFacing.UP, llllllllllllllllIIllIIllIIIIlIll ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            }
            if (ModuleManager.isModuleEnabled("AutoEz")) {
                AutoEz.INSTANCE.addTargetedPlayer(llllllllllllllllIIllIIllIIIIlllI.renderEnt.getName());
            }
        }
        isActive = false;
    }

    public static float calculateDamage(EntityEnderCrystal llllllllllllllllIIllIIlIIlIllIIl, Entity llllllllllllllllIIllIIlIIlIlIllI) {
        return CrystalAura.calculateDamage(llllllllllllllllIIllIIlIIlIllIIl.posX, llllllllllllllllIIllIIlIIlIllIIl.posY, llllllllllllllllIIllIIlIIlIllIIl.posZ, llllllllllllllllIIllIIlIIlIlIllI);
    }

    private void lookAtPacket(double llllllllllllllllIIllIIlIlllIIIIl, double llllllllllllllllIIllIIlIllIllIll, double llllllllllllllllIIllIIlIllIllIlI, EntityPlayer llllllllllllllllIIllIIlIllIllllI) {
        double[] llllllllllllllllIIllIIlIllIlllIl = CrystalAura.calculateLookAt(llllllllllllllllIIllIIlIlllIIIIl, llllllllllllllllIIllIIlIllIllIll, llllllllllllllllIIllIIlIllIllIlI, llllllllllllllllIIllIIlIllIllllI);
        CrystalAura.setYawAndPitch((float)llllllllllllllllIIllIIlIllIlllIl[0], (float)llllllllllllllllIIllIIlIllIlllIl[1]);
    }

    static {
        isActive = false;
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(CrystalAura.mc.thePlayer.posX), Math.floor(CrystalAura.mc.thePlayer.posY), Math.floor(CrystalAura.mc.thePlayer.posZ));
    }

    private boolean isEatingGap() {
        return CrystalAura.mc.thePlayer.func_184614_ca().getItem() instanceof ItemAppleGold && CrystalAura.mc.thePlayer.func_184587_cr();
    }

    public List<BlockPos> getSphere(BlockPos llllllllllllllllIIllIIlIlIllIIII, float llllllllllllllllIIllIIlIlIlIllll, int llllllllllllllllIIllIIlIlIlIlllI, boolean llllllllllllllllIIllIIlIlIlIllIl, boolean llllllllllllllllIIllIIlIlIlIllII, int llllllllllllllllIIllIIlIlIlIlIll) {
        ArrayList<BlockPos> llllllllllllllllIIllIIlIlIlIlIlI = new ArrayList<BlockPos>();
        int llllllllllllllllIIllIIlIlIlIlIIl = llllllllllllllllIIllIIlIlIllIIII.getX();
        int llllllllllllllllIIllIIlIlIlIlIII = llllllllllllllllIIllIIlIlIllIIII.getY();
        int llllllllllllllllIIllIIlIlIlIIlll = llllllllllllllllIIllIIlIlIllIIII.getZ();
        int llllllllllllllllIIllIIlIlIllIIlI = llllllllllllllllIIllIIlIlIlIlIIl - (int)llllllllllllllllIIllIIlIlIlIllll;
        while ((float)llllllllllllllllIIllIIlIlIllIIlI <= (float)llllllllllllllllIIllIIlIlIlIlIIl + llllllllllllllllIIllIIlIlIlIllll) {
            int llllllllllllllllIIllIIlIlIllIIll = llllllllllllllllIIllIIlIlIlIIlll - (int)llllllllllllllllIIllIIlIlIlIllll;
            while ((float)llllllllllllllllIIllIIlIlIllIIll <= (float)llllllllllllllllIIllIIlIlIlIIlll + llllllllllllllllIIllIIlIlIlIllll) {
                int llllllllllllllllIIllIIlIlIllIlII = llllllllllllllllIIllIIlIlIlIllII ? llllllllllllllllIIllIIlIlIlIlIII - (int)llllllllllllllllIIllIIlIlIlIllll : llllllllllllllllIIllIIlIlIlIlIII;
                while (true) {
                    float f = llllllllllllllllIIllIIlIlIllIlII;
                    float f2 = llllllllllllllllIIllIIlIlIlIllII ? (float)llllllllllllllllIIllIIlIlIlIlIII + llllllllllllllllIIllIIlIlIlIllll : (float)(llllllllllllllllIIllIIlIlIlIlIII + llllllllllllllllIIllIIlIlIlIlllI);
                    if (!(f < f2)) break;
                    double llllllllllllllllIIllIIlIlIllIlIl = (llllllllllllllllIIllIIlIlIlIlIIl - llllllllllllllllIIllIIlIlIllIIlI) * (llllllllllllllllIIllIIlIlIlIlIIl - llllllllllllllllIIllIIlIlIllIIlI) + (llllllllllllllllIIllIIlIlIlIIlll - llllllllllllllllIIllIIlIlIllIIll) * (llllllllllllllllIIllIIlIlIlIIlll - llllllllllllllllIIllIIlIlIllIIll) + (llllllllllllllllIIllIIlIlIlIllII ? (llllllllllllllllIIllIIlIlIlIlIII - llllllllllllllllIIllIIlIlIllIlII) * (llllllllllllllllIIllIIlIlIlIlIII - llllllllllllllllIIllIIlIlIllIlII) : 0);
                    if (!(!(llllllllllllllllIIllIIlIlIllIlIl < (double)(llllllllllllllllIIllIIlIlIlIllll * llllllllllllllllIIllIIlIlIlIllll)) || llllllllllllllllIIllIIlIlIlIllIl && llllllllllllllllIIllIIlIlIllIlIl < (double)((llllllllllllllllIIllIIlIlIlIllll - 1.0f) * (llllllllllllllllIIllIIlIlIlIllll - 1.0f)))) {
                        BlockPos llllllllllllllllIIllIIlIlIllIllI = new BlockPos(llllllllllllllllIIllIIlIlIllIIlI, llllllllllllllllIIllIIlIlIllIlII + llllllllllllllllIIllIIlIlIlIlIll, llllllllllllllllIIllIIlIlIllIIll);
                        llllllllllllllllIIllIIlIlIlIlIlI.add(llllllllllllllllIIllIIlIlIllIllI);
                    }
                    ++llllllllllllllllIIllIIlIlIllIlII;
                }
                ++llllllllllllllllIIllIIlIlIllIIll;
            }
            ++llllllllllllllllIIllIIlIlIllIIlI;
        }
        return llllllllllllllllIIllIIlIlIlIlIlI;
    }

    private static void setYawAndPitch(float llllllllllllllllIIllIIlIIlIlIIll, float llllllllllllllllIIllIIlIIlIlIIII) {
        yaw = llllllllllllllllIIllIIlIIlIlIIll;
        pitch = llllllllllllllllIIllIIlIIlIlIIII;
        isSpoofingAngles = true;
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIIllIIlIlllIllIl) {
        CrystalAura llllllllllllllllIIllIIlIlllIlllI;
        if (llllllllllllllllIIllIIlIlllIlllI.render != null) {
            int llllllllllllllllIIllIIlIllllIIll = Rainbow.getColor().getRed();
            int llllllllllllllllIIllIIlIllllIIlI = Rainbow.getColor().getGreen();
            int llllllllllllllllIIllIIlIllllIIIl = Rainbow.getColor().getBlue();
            if (llllllllllllllllIIllIIlIlllIlllI.rainbow.getValue()) {
                Tessellator.prepare(7);
                Tessellator.drawBox(llllllllllllllllIIllIIlIlllIlllI.render, llllllllllllllllIIllIIlIllllIIll, llllllllllllllllIIllIIlIllllIIlI, llllllllllllllllIIllIIlIllllIIIl, llllllllllllllllIIllIIlIlllIlllI.espA.getValue(), 63);
                Tessellator.release();
                ImpactPlusTessellator.prepare(7);
                ImpactPlusTessellator.drawBoundingBoxBlockPos(llllllllllllllllIIllIIlIlllIlllI.render, llllllllllllllllIIllIIlIlllIlllI.w.getValue(), llllllllllllllllIIllIIlIllllIIll, llllllllllllllllIIllIIlIllllIIlI, llllllllllllllllIIllIIlIllllIIIl, 255);
            } else {
                Tessellator.prepare(7);
                Tessellator.drawBox(llllllllllllllllIIllIIlIlllIlllI.render, llllllllllllllllIIllIIlIlllIlllI.espR.getValue(), llllllllllllllllIIllIIlIlllIlllI.espG.getValue(), llllllllllllllllIIllIIlIlllIlllI.espB.getValue(), llllllllllllllllIIllIIlIlllIlllI.espA.getValue(), 63);
                Tessellator.release();
                ImpactPlusTessellator.prepare(7);
                ImpactPlusTessellator.drawBoundingBoxBlockPos(llllllllllllllllIIllIIlIlllIlllI.render, llllllllllllllllIIllIIlIlllIlllI.w.getValue(), llllllllllllllllIIllIIlIlllIlllI.espR.getValue(), llllllllllllllllIIllIIlIlllIlllI.espG.getValue(), llllllllllllllllIIllIIlIlllIlllI.espB.getValue(), 255);
            }
            ImpactPlusTessellator.release();
        }
        if (llllllllllllllllIIllIIlIlllIlllI.renderDamage.getValue() && llllllllllllllllIIllIIlIlllIlllI.render != null && llllllllllllllllIIllIIlIlllIlllI.renderEnt != null) {
            GlStateManager.pushMatrix();
            ImpactPlusTessellator.glBillboardDistanceScaled((float)llllllllllllllllIIllIIlIlllIlllI.render.getX() + 0.5f, (float)llllllllllllllllIIllIIlIlllIlllI.render.getY() + 0.5f, (float)llllllllllllllllIIllIIlIlllIlllI.render.getZ() + 0.5f, (EntityPlayer)CrystalAura.mc.thePlayer, 1.0f);
            double llllllllllllllllIIllIIlIllllIIII = CrystalAura.calculateDamage((double)llllllllllllllllIIllIIlIlllIlllI.render.getX() + 0.5, llllllllllllllllIIllIIlIlllIlllI.render.getY() + 1, (double)llllllllllllllllIIllIIlIlllIlllI.render.getZ() + 0.5, llllllllllllllllIIllIIlIlllIlllI.renderEnt);
            String llllllllllllllllIIllIIlIlllIllll = String.valueOf(new StringBuilder().append(Math.floor(llllllllllllllllIIllIIlIllllIIII) == llllllllllllllllIIllIIlIllllIIII ? Integer.valueOf((int)llllllllllllllllIIllIIlIllllIIII) : String.format("%.1f", llllllllllllllllIIllIIlIllllIIII)).append(""));
            GlStateManager.disableDepth();
            GlStateManager.translate((double)(-((double)CrystalAura.mc.fontRendererObj.getStringWidth(llllllllllllllllIIllIIlIlllIllll) / 2.0)), (double)0.0, (double)0.0);
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIllIIlIlllIllll, 0.0f, 0.0f, -1);
            GlStateManager.popMatrix();
        }
    }

    private boolean canPlaceCrystal(BlockPos llllllllllllllllIIllIIlIllIIlllI) {
        CrystalAura llllllllllllllllIIllIIlIllIlIIll;
        BlockPos llllllllllllllllIIllIIlIllIlIIIl = llllllllllllllllIIllIIlIllIIlllI.add(0, 1, 0);
        BlockPos llllllllllllllllIIllIIlIllIlIIII = llllllllllllllllIIllIIlIllIIlllI.add(0, 2, 0);
        if (llllllllllllllllIIllIIlIllIlIIll.newversion.getValue()) {
            return (CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIIlllI).getBlock() == Blocks.bedrock || CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIIlllI).getBlock() == Blocks.obsidian) && CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIlIIIl).getBlock() == Blocks.air && CrystalAura.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(llllllllllllllllIIllIIlIllIlIIIl)).isEmpty();
        }
        return (CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIIlllI).getBlock() == Blocks.bedrock || CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIIlllI).getBlock() == Blocks.obsidian) && CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIlIIIl).getBlock() == Blocks.air && CrystalAura.mc.theWorld.getBlockState(llllllllllllllllIIllIIlIllIlIIII).getBlock() == Blocks.air && CrystalAura.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(llllllllllllllllIIllIIlIllIlIIIl)).isEmpty() && CrystalAura.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(llllllllllllllllIIllIIlIllIlIIII)).isEmpty();
    }

    public static double[] calculateLookAt(double llllllllllllllllIIllIIlIIlIIIlIl, double llllllllllllllllIIllIIlIIIlllIIl, double llllllllllllllllIIllIIlIIIlllIII, EntityPlayer llllllllllllllllIIllIIlIIIllIlll) {
        double llllllllllllllllIIllIIlIIlIIIIIl = llllllllllllllllIIllIIlIIIllIlll.posX - llllllllllllllllIIllIIlIIlIIIlIl;
        double llllllllllllllllIIllIIlIIlIIIIII = llllllllllllllllIIllIIlIIIllIlll.posY - llllllllllllllllIIllIIlIIIlllIIl;
        double llllllllllllllllIIllIIlIIIllllll = llllllllllllllllIIllIIlIIIllIlll.posZ - llllllllllllllllIIllIIlIIIlllIII;
        double llllllllllllllllIIllIIlIIIlllllI = Math.sqrt(llllllllllllllllIIllIIlIIlIIIIIl * llllllllllllllllIIllIIlIIlIIIIIl + llllllllllllllllIIllIIlIIlIIIIII * llllllllllllllllIIllIIlIIlIIIIII + llllllllllllllllIIllIIlIIIllllll * llllllllllllllllIIllIIlIIIllllll);
        double llllllllllllllllIIllIIlIIIllllIl = Math.asin(llllllllllllllllIIllIIlIIlIIIIII /= llllllllllllllllIIllIIlIIIlllllI);
        double llllllllllllllllIIllIIlIIIllllII = Math.atan2(llllllllllllllllIIllIIlIIIllllll /= llllllllllllllllIIllIIlIIIlllllI, llllllllllllllllIIllIIlIIlIIIIIl /= llllllllllllllllIIllIIlIIIlllllI);
        llllllllllllllllIIllIIlIIIllllIl = llllllllllllllllIIllIIlIIIllllIl * 180.0 / Math.PI;
        llllllllllllllllIIllIIlIIIllllII = llllllllllllllllIIllIIlIIIllllII * 180.0 / Math.PI;
        return new double[]{llllllllllllllllIIllIIlIIIllllII += 90.0, llllllllllllllllIIllIIlIIIllllIl};
    }

    private List<BlockPos> findCrystalBlocks() {
        CrystalAura llllllllllllllllIIllIIlIllIIIlll;
        NonNullList llllllllllllllllIIllIIlIllIIlIII = NonNullList.func_191196_a();
        llllllllllllllllIIllIIlIllIIlIII.addAll((Collection)llllllllllllllllIIllIIlIllIIIlll.getSphere(CrystalAura.getPlayerPos(), llllllllllllllllIIllIIlIllIIIlll.range.getValue(), llllllllllllllllIIllIIlIllIIIlll.range.getValue(), false, true, 0).stream().filter(llllllllllllllllIIllIIlIllIIIlll::canPlaceCrystal).collect(Collectors.toList()));
        return llllllllllllllllIIllIIlIllIIlIII;
    }

    @Override
    public void setup() {
        CrystalAura llllllllllllllllIIllIIllIIlIlIlI;
        llllllllllllllllIIllIIllIIlIlIlI.autoSwitch = llllllllllllllllIIllIIllIIlIlIlI.registerB("AutoSwitch", true);
        llllllllllllllllIIllIIllIIlIlIlI.rotate = llllllllllllllllIIllIIllIIlIlIlI.registerB("Rotate", true);
        llllllllllllllllIIllIIllIIlIlIlI.raytrace = llllllllllllllllIIllIIllIIlIlIlI.registerB("Raytrace", false);
        llllllllllllllllIIllIIllIIlIlIlI.renderDamage = llllllllllllllllIIllIIllIIlIlIlI.registerB("RenderDMG", true);
        llllllllllllllllIIllIIllIIlIlIlI.range = llllllllllllllllIIllIIllIIlIlIlI.registerI("Range", 5, 0, 10);
        llllllllllllllllIIllIIllIIlIlIlI.walls = llllllllllllllllIIllIIllIIlIlIlI.registerI("WallRange", 4, 0, 10);
        llllllllllllllllIIllIIllIIlIlIlI.waitTick = llllllllllllllllIIllIIllIIlIlIlI.registerI("Delay", 1, 0, 20);
        llllllllllllllllIIllIIllIIlIlIlI.minDmg = llllllllllllllllIIllIIllIIlIlIlI.registerI("MinDMG", 8, 0, 36);
        llllllllllllllllIIllIIllIIlIlIlI.maxSelfDmg = llllllllllllllllIIllIIllIIlIlIlI.registerI("MaxSelfDmg", 10, 0, 36);
        llllllllllllllllIIllIIllIIlIlIlI.facePlace = llllllllllllllllIIllIIllIIlIlIlI.registerI("FacePlaceHP", 6, 0, 36);
        llllllllllllllllIIllIIllIIlIlIlI.newversion = llllllllllllllllIIllIIllIIlIlIlI.registerB("1.13+ Placement", false);
        llllllllllllllllIIllIIllIIlIlIlI.espR = llllllllllllllllIIllIIllIIlIlIlI.registerI("Red", 255, 0, 255);
        llllllllllllllllIIllIIllIIlIlIlI.espG = llllllllllllllllIIllIIllIIlIlIlI.registerI("Green", 255, 0, 255);
        llllllllllllllllIIllIIllIIlIlIlI.espB = llllllllllllllllIIllIIllIIlIlIlI.registerI("Blue", 255, 0, 255);
        llllllllllllllllIIllIIllIIlIlIlI.espA = llllllllllllllllIIllIIllIIlIlIlI.registerI("Alpha", 26, 26, 255);
        llllllllllllllllIIllIIllIIlIlIlI.rainbow = llllllllllllllllIIllIIllIIlIlIlI.registerB("Rainbow", true);
        llllllllllllllllIIllIIllIIlIlIlI.w = llllllllllllllllIIllIIllIIlIlIlI.registerI("Width", 1, 1, 5);
    }
}

