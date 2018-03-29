package troops.tactical;

import gui.model.Unit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import wargear.weapon.Weapon;
import wargear.weapon.WeaponList;

public class Tactical extends Unit
{	
	public Tactical() 
	{  
		super();
		unitName = "Tactical Squad";
        weapon = WeaponList.getRanged("Boltgun");
        points = 14 + weapon.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 1;
        leadership = 8;
        save = "3+";
        
        unitWeaponsList.add(WeaponList.getSpecial("Flamer"));
        unitWeaponsList.add(WeaponList.getSpecial("Meltagun"));
        unitWeaponsList.add(WeaponList.getSpecial("Grav-Gun"));
        unitWeaponsList.add(WeaponList.getSpecial("Plasma Gun"));
        unitWeaponsList.add(WeaponList.getHeavy("Heavy Bolter"));
        unitWeaponsList.add(WeaponList.getHeavy("Multi-Melta"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Frag)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Krak)"));
        unitWeaponsList.add(WeaponList.getHeavy("Missile Launcher (Flakk)"));
        unitWeaponsList.add(WeaponList.getHeavy("Plasma Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Lascannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Cannon"));
        unitWeaponsList.add(WeaponList.getHeavy("Grav-Amp"));
	}
}
