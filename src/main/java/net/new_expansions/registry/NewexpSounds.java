package net.new_expansions.registry;

import net.minecraft.registry.Registries;
import net.new_expansions.NewExpansions;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class NewexpSounds {
    public static SoundEvent MUSIC_DISC_THE_WAY_RECORD = register("music_disc.the_way");
    public static SoundEvent MUSIC_DISC_THE_WHISPER_RECORD = register("music_disc.the_whisper");
    public static SoundEvent MUSIC_DISC_RESIDENCE_OF_CORRUPTION_RECORD = register("music_disc.residence_of_corruption");
    public static SoundEvent MUSIC_DISC_TRIBAL_THOUGHT = register("music_disc.tribal_thought");
    public static SoundEvent ENCHANTED_NETHERITE_STATUE_ATTACK_SOUND = register("enchanted_netherite_statue.attack");
    public static SoundEvent BANDAGE_USE_SOUND = register("bandage.use");
    public static SoundEvent SYRINGE_USE_SOUND = register("syringe.use");
    public static SoundEvent SMALL_MEDKIT_USE_SOUND = register("small_medkit.use");

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(new Identifier(NewExpansions.MOD_ID,id)));
    }
}
