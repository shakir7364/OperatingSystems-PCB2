package pcb2;

import java.util.LinkedList;

public class PCB_Driver 
{

	public static void main(String[] args) 
	{
		//Initialize 
		LinkedList<PCB> PCBList = new LinkedList<PCB>();
		int time = 0;
		
		//Populate linked list
		for(int i = 0; i < 10; i++)
			PCBList.add(new PCB());
		
		//Print contents of linked list
		System.out.println("The contents of the linked list are:" );
		for(int i = 0; i < PCBList.size(); i++)
			System.out.println(PCBList.get(i).showPCB());
		
		//Iterate until linked list is empty
		while(!PCBList.isEmpty())
		{
			//Amount of time needed to run
			time = (int)(Math.random() * 11) + 10;
			
			//Update PCBs
			for(int i = 0; i < PCBList.size(); i++)
				PCBList.get(i).set_timeWaiting(PCBList.get(i).get_timeWaiting() + time);
			PCBList.get(0).set_CPU_used(PCBList.get(0).get_CPU_used() + ((int)(Math.random() * 100) + 1));
			
			//Print contents of linked list
			System.out.println("\nThe contents of the linked list are:" );
			for(int i = 0; i < PCBList.size(); i++)
				System.out.println(PCBList.get(i).showPCB());
			
			//Test for termination
			if(PCBList.get(0).get_CPU_used() > PCBList.get(0).get_CPU_max())
				PCBList.remove();
			else
			{
				PCBList.add(PCBList.get(0));
				PCBList.remove();
			}
		}
		
		//Final message
		System.out.println("\nAll processes compleated. Program terminated.");
	}

}
