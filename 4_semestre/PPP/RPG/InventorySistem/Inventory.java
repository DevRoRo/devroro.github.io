package InventorySistem;

import java.util.ArrayList;
import java.util.List;

import WeaponSystem.Weapon;

public class Inventory {
    private String name;
    private List itemBag;
    private Weapon rightHand;
    private Weapon leftHand;

    public Inventory(String characterName) {
        this.name = characterName+" Inventory";
        this.itemBag = new ArrayList<Weapon>();
    }
}

