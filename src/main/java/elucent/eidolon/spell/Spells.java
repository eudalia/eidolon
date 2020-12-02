package elucent.eidolon.spell;

import elucent.eidolon.Eidolon;
import elucent.eidolon.capability.Deities;
import elucent.eidolon.util.ColorUtil;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spells {
    static List<Spell> spells = new ArrayList<>();
    static Map<ResourceLocation, Spell> spellMap = new HashMap<>();

    public static Spell find(ResourceLocation loc) {
        return spellMap.getOrDefault(loc, null);
    }

    public static Spell find(List<Sign> signs) {
        for (Spell spell : spells) if (spell.matches(signs)) return spell;
        return null;
    }

    public static Spell register(Spell spell) {
        spells.add(spell);
        spellMap.put(spell.getRegistryName(), spell);
        return spell;
    }

    public static List<Spell> getSpells() {
        return spells;
    }

    public static Spell
        DARK_PRAYER = register(new PrayerSpell(
            new ResourceLocation(Eidolon.MODID, "dark_prayer"),
            Deities.DARK,
            Signs.WICKED_SIGN, Signs.WICKED_SIGN, Signs.WICKED_SIGN
        ));
}