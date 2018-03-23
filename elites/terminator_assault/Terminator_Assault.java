package elites.terminator_assault;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Terminator_Assault extends Unit 
{
	public Terminator_Assault()
	{
		super();
		unitName = "Terminator Assault Squad"; //default name of a scout squad
		COMBOMAXSIZE = 9; //max number of values in the combo box, NEEDS TO INHERIT FROM SCOUT SQUAD SQUAD MAXSIZE SOMEHOW
        weapon = WeaponList.getTerminator("Duel Lightning Claws");
		points = 35 + weapon.getWeaponPoints();//default weapon of a scout
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
