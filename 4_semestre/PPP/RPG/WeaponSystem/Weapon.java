package WeaponSystem;

import DamageSystem.*;

public class Weapon {
    private String name;
    private int damageValue;
    private DamageType typeOfDamage;
    private Range range;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamageValue() {
        return damageValue;
    }
    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }
    public DamageType getTypeOfDamage() {
        return typeOfDamage;
    }
    public void setTypeOfDamage(DamageType typeOfDamage) {
        this.typeOfDamage = typeOfDamage;
    }
    public Range getRange() {
        return range;
    }
    public void setRange(Range range) {
        this.range = range;
    }
}