

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.*;

public class Therapist{

		public String name;
		public String specialization;
		public int type;
		public String location;
		
		public String phone;
		public int availabity;
		public double cost;
		public int gender;
		
	
				
	
	
	public Therapist(String[] info)
	{
		name = info[0];
		specialization =  info[1];
		type= Integer.parseInt( info[2]);
		location = info[3];
		phone =  info[4];
		availabity = Integer.parseInt(info[5]);
		cost = Integer.parseInt(info[6]);
		gender = Integer.parseInt(info[7]);
		
	}
	
	public static void main(String args[]) throws FileNotFoundException
	{
		ArrayList<Therapist> psychs = new ArrayList<Therapist>();
		
		
		File file = new File("theTherapy.txt");
		Scanner sc = new Scanner(file);
		
		/*
		
		Schachner Associates , Depression/Anxiety,
		CBT, 128 N. Craig St Suite 210 Pittsburgh, PA 15213, 
		(412) 683-1000, yes, 150, female
		
		*/
		
		String[] stuff = new String[8];
		
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			int comma;
			
			for(int i = 0; i < 8; i++)
			{
				comma = line.indexOf(',');
				if(comma < 0)
					stuff[i] = line;
				else{
					stuff[i] = line.substring(0, comma);
					line = line.substring(comma + 2);
					
				}
				
				//System.out.print("|" + stuff[i] + "|");
			}
			
			psychs.add(new Therapist(stuff));
			//System.out.println();
		}
		
		findTherapist(psychs);
		
		
		
	}
	
	//CBT = 1, CT = 2, GESTALT = 3, PSYCHO = 4
	//YES = 1 NO = 2
	//FEMALE = 1, MALE = 2, ANY = 3
		
	public static void findTherapist(ArrayList<Therapist> helpers) {
		
		System.out.println("Mental Illness: ");
		String illness = "Depression/Anxiety";
		
		System.out.println("Type of Therapy: ");
		int therapyType = 1;		
		
		System.out.println("Radius: "); //too difficult
		int radius = 5;
		
		System.out.println("Gender Preference: ");
		int genderPref = 3; 
		
		
		System.out.println("Max Cost: ");
		double maxCost = 125;
		
		System.out.println("\n");
		
		
		
		ArrayList<Therapist> tempHelper = new ArrayList<Therapist>();
		tempHelper = helpers;
		
		for(int i = 0; i < tempHelper.size(); i++)
		{
			if(!tempHelper.get(i).specialization.equals(illness)){
				tempHelper.remove(i);
				i -= 1;
			}
			else if(tempHelper.get(i).type != therapyType)
			{
				tempHelper.remove(i);
				i -= 1;
			}
			else if(tempHelper.get(i).gender != genderPref && genderPref != 3)
			{
				tempHelper.remove(i);
				i -= 1;
			}
			else if(tempHelper.get(i).cost > maxCost)
			{
				tempHelper.remove(i);
				i-=1;
			}
			
		}
		
		System.out.println("Here is the list of available therapists");
		for(int i = 0; i < tempHelper.size(); i++)
		{
		
			System.out.println("\n\n" +(i + 1) + ".");
			System.out.println("Name: " + tempHelper.get(i).name);		
			System.out.println(tempHelper.get(i).specialization);
			System.out.print("Type of Therapy: ");
			
			if(tempHelper.get(i).type == 1)
				System.out.println("CBT");
			else if(tempHelper.get(i).type == 2)
				System.out.println("CT");
			else if(tempHelper.get(i).type == 3 )
				System.out.println("Gestalt Therapy");
			else if(tempHelper.get(i).type == 4)
				System.out.println("Pyschotherapy");
			
			

			System.out.println("Address: " + tempHelper.get(i).location);
			System.out.println("Phone Number: " + tempHelper.get(i).phone);

				
			System.out.print("Availablity: ");
			
			if(tempHelper.get(i).availabity ==1)
				System.out.println("Avilable");
			else if (tempHelper.get(i).availabity == 2)
				System.out.println("Not Available");
			
			
			System.out.println("Cost: " + tempHelper.get(i).cost);
			
			System.out.print("Gender: ");
			if(tempHelper.get(i).gender == 1)
				System.out.println("Female");
			else if(tempHelper.get(i).gender == 2)
				System.out.println("Male");
			
			
			System.out.println("\n");
			
			
			
			
		}
			
	}
	
	
	
	
}


