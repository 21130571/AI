package chapter2.agent_AB;

import java.util.Random;

import chapter2.agent_AB.Environment.LocationState;

public class AgentProgram {
private Action selectedVariable;

//lab1
//	public Action execute(Percept p) {// location, status
//		// TODO
//		if (p.getLocationState() == LocationState.DIRTY) {
//			return Environment.SUCK_DIRT;
//
//		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
//			return Environment.MOVE_RIGHT;
//		} else {
//			return Environment.MOVE_LEFT;
//		} 
//		
////		return NoOpAction.NO_OP;
//		
//	}
	//lab2
	public Action execute(Percept p) {// location, status
		// TODO
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT; 
			
		} else if (p.getLocationState() == LocationState.CLEAN) {
			 
	        Action[] variables = {Environment.MOVE_LEFT , Environment.MOVE_RIGHT,Environment.MOVE_UP,Environment.MOVE_DOWN};      
	        Random random = new Random();
	        int randomIndex = random.nextInt(variables.length);

	       
	       Action selectedVariable = variables[randomIndex];}
		
		
		   
	   
		return selectedVariable;
	    

		
		
//	return NoOpAction.NO_OP;
}}