package RoleSystem;

import DamageSystem.Range;
import InventorySistem.InventoryManagement;
import WeaponSystem.Weapon;

public class Archer extends Role implements InventoryManagement {
    
    public void equipWeapontoCombatHand(Weapon weapon) {
        if (weapon.getRange() == Range.LONG){
            super.getInventory();   //Armazenar weapon no atributo rightHand da classe Character
        }
    }
}
