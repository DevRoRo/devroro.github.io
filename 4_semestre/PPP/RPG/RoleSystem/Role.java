package RoleSystem;

import DamageSystem.*;
import CharacterSystem.Character;

public abstract class Role extends Character {
    private String name;
    private DamageType preferredDamage;
    private Range preferredRange;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public DamageType getPreferredDamage() {
        return preferredDamage;
    }
    public void setPreferredDamage(DamageType preferredDamage) {
        this.preferredDamage = preferredDamage;
    }
    public Range getPreferredRange() {
        return preferredRange;
    }
    public void setPreferredRange(Range preferredRange) {
        this.preferredRange = preferredRange;
    }
} 