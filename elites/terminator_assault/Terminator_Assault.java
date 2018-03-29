package elites.terminator_assault;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Terminator_Assault extends Unit 
{
	public Terminator_Assault()
	{
		super();
		unitName = "Terminator Assault Squad"; 
        weapon = WeaponList.getTerminator("Duel Lightning Claws");
		points = 35 + weapon.getWeaponPoints();
        weaponSkill = 4;
        ballisticSkill = 4;
        strength = 4;
        toughness = 4; 
        wounds = 1;
        initiative = 4;
        attacks = 2;
        leadership = 9;
        save = "2+";
        
        unitWeaponsList.add(WeaponList.getTerminator("Duel Lightning Claws"));
        unitWeaponsList.add(WeaponList.getTerminator("Thunder Hammer and Storm Shield"));       
	}
}
