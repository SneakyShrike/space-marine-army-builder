package main_test;

import java.util.Scanner;


import troops.scout.ScoutSergeant;
import troops.scout.ScoutSquad;
import wargear.weapon.WeaponList;

public class ArmyBuilderDemo
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the squad name: ");
		String name = input.nextLine(); //assigns the name input to 'String name'
		
		System.out.println("Enter the squad size: ");
		int size = input.nextInt(); //assigns the size to 'integer size'
			
		ScoutSquad squad1 = new ScoutSquad("squad1");

		
		//Scout details = new Scout();
		
		//System.out.println(details.getCharacteristics());
						
		squad1.addScout(new ScoutSergeant()); //a scout sergeant is first added to the squad
		//squad1.addScoutSquad(new Scout(), size );

		//for (int i = 1; i < 5; i++) //then the rest of the scouts are added to the squad
		//{
			//squad1.addScout(new Scout());			  							
		//}
			             
        //apply weapon upgrades to certain scouts in the squad       
        squad1.getScout(3).scoutWeaponUpgrade(WeaponList.getScoutWeapon("Sniper Rifle"));
        //scouts.getScout(1).scoutWeaponUpgrade(WeaponList.getRanged("Plasma Pistol"));  
        //squad1.getScout(4).scoutWeaponUpgrade(WeaponList.getHeavy("Heavy Bolter"));
        //squad1.getScout(5).scoutWeaponUpgrade(WeaponList.getHeavy("Heavy Bolter"));
        
        //apply a weapon check on certain weapons, to ensure there are no more than 1 per squad
        //squad1.SquadWeaponsCheck();
        
        //print out the updated squad        
        System.out.println(squad1.getScoutSquad());        
        

               
       // input.close();
	}	
}
