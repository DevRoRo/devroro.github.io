package CharacterSystem;

import InventorySistem.Inventory;
import RoleSystem.Role;

public class Character {
    private String name;
    private Role role;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
