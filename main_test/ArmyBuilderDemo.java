package main_test;

import java.util.Scanner;
import troops.scout.Scout;
import troops.scout.ScoutSergeant;
import troops.scout.ScoutSquad;
import troops.scout.ScoutWeaponList;
import wargear.weapon.WeaponList;

public class ArmyBuilderDemo
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the squad name: ");
		String name = input.nextLine(); //assigns the name input to 'String name'
		
		System.out.println("Enter the squad size: ");
		int size = input.nextInt(); //assigns the size to 'int size'
			
		ScoutSquad scouts = new ScoutSquad(name); //new scout squad is created, with user name
		
		//Scout details = new Scout();
		
		//System.out.println(details.getCharacteristics());
						
		scouts.addScout(new ScoutSergeant()); //a scout sergeant is first added to the squad

		for (int i = 1; i < size; i++) //then the rest of the scouts are added to the squad
		{
			scouts.addScout(new Scout());			  							
		}		
				
        System.out.println(scouts.getScoutSquad()); //print out the initial squad
         
        
        //apply weapon upgrades to certain scouts in the squad
        
        scouts.getScout(3).weaponUpgrade(ScoutWeaponList.getscoutWeapons("Sniper Rifle"));
        scouts.getScout(1).weaponUpgrade(WeaponList.getRanged("Plasma Pistol"));  
        scouts.getScout(4).weaponUpgrade(WeaponList.getHeavy("Heavy Bolter"));
        scouts.getScout(5).weaponUpgrade(WeaponList.getHeavy("Heavy Bolter"));
        
        //apply a weapon check on certain weapons, to ensure there are no more than 1 per squad
        scouts.SquadWeaponsCheck();
        
        //print out the updated squad        
        System.out.println(scouts.getScoutSquad());
               
        input.close();
	}	
}
