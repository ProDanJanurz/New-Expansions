package net.new_expansions.mixin.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.new_expansions.registry.NewexpGamerules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Objects;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    @Shadow @Final protected MinecraftClient client;
    
    @Shadow public abstract boolean isSubmergedInWater();
    
    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    /**
     * @author Pro__Dan
     * @reason added a game rule
     */
    @Overwrite
    private boolean canSprint() {
        return (this.hasVehicle() || (float)this.getHungerManager().getFoodLevel() > 6.0F || this.getAbilities().allowFlying) && (Objects.requireNonNull(this.client.getServer()).getGameRules().getBoolean(NewexpGamerules.ALLOW_SPRINTING) || this.isSubmergedInWater() || this.isCreative() || this.isSpectator());
    }

}
