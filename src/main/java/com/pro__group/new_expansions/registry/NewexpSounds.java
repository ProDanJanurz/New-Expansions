package com.pro__group.new_expansions.registry;

import com.pro__group.new_expansions.NewExpansions;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewexpSounds {
    public static SoundEvent MUSIC_DISC_THE_WAY_RECORD = register("music_disc.the_way");
    public static SoundEvent MUSIC_DISC_THE_WHISPER_RECORD = register("music_disc.the_whisper");
    public static SoundEvent MUSIC_DISC_RESIDENCE_OF_CORRUPTION_RECORD = register("music_disc.residence_of_corruption");
    public static SoundEvent ENCHANTED_NETHERITE_STATUE_ATTACK_SOUND = register("enchanted_netherite_statue.attack");
    public static SoundEvent BANDAGE_USE_SOUND = register("bandage.use");
    public static SoundEvent SYRINGE_USE_SOUND = register("syringe.use");
    public static SoundEvent SMALL_MEDKIT_USE_SOUND = register("small_medkit.use");

    private static SoundEvent register(String id) {
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(new Identifier(NewExpansions.MOD_ID,id)));
    }
}
