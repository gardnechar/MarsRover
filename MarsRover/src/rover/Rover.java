package rover;

import java.util.Arrays;
import java.util.Scanner;

public class Rover {
	
	
	//Constructor
	static int[] map = new int[2];
	static int[] rover1Position = new int[2];
	static int[] rover2Position = new int[2];
	
	static String[] rover1Direction = new String[1];
	static String[] rover2Direction = new String[1];
	
	
	//Method to move the rover forward by 1 position degrees
	public static void moveForward(String direction, int[] rover) {
		
		System.out.println("Rover moved forward 1 position");
		
		switch(direction) {
		
		case "N":
			//move north
			rover[1] = rover[1]+1;
			break;
		
		case "E": 
			//move east
			rover[0] = rover[0]+1;
			break;
			
		case "S":
			//move south
			rover[1] = rover[1]-1;
			break;
			
		case "W":
			//move west
			rover[0] = rover[0]-1;
			break;
			
		}
		
		//check to make sure the rover is not off the map
		if (rover[0] > map[0] || rover[0] < 0 || rover[1] > map[1] || rover[1] < 0) {
			
			System.out.println("Error: rover has moved off the map");
    		System.exit(0);
			
		}
	}
	
	
	//Method to rotate the rover left or right by 90 degrees
    public static void rotate(String direction, String[] rover) {
		
		if (direction.contains("L")) {
			
			System.out.println("Rover rotated left 90 degress");
			
			//rotate Rover 90 degrees left
			if (rover[0].equals("N")) {
				rover[0] = "W";
				
			} else if (rover[0].equals("E")) {
				rover[0] = "N";
				
			}else if (rover[0].equals("S")) {
				rover[0] = "E";
				
			}else if (rover[0].equals("W")) {
				rover[0] = "S";
				
			}
			
		} else if (direction.contains("R")) {
			
			System.out.println("Rover rotated right 90 degrees");
			
			//rotate Rover 90 degrees right
			if (rover[0].equals("N")) {
				rover[0] = "E";
			} else if (rover[0].equals("E")) {
				rover[0] = "S";
			}else if (rover[0].equals("S")) {
				rover[0] = "W";
			}else if (rover[0].equals("W")) {
				rover[0] = "N";
			}
			
		} else {
			System.out.println("Error " + direction + " is not an accepted input" );
			System.exit(0);
		}
	}

    
    
    
    
    
	//Method to start the application
	public static void start() {
		
		
		
		//Get map size
		Scanner reader = new Scanner(System.in);  
	    System.out.println("To set the map size, please enter the upper-right coordinates of the plateau e.g. 5 5");
	    for (int i = 0; i < 2; i++) {	
	    	map[i] = reader.nextInt(); 
	    }
	    
	    
	    
	    
	    //Get starting position of Rover1
	    System.out.println("Please enter the starting position of Rover1 and its orientation  e.g. 1 2 N");
	    
	    for (int i = 0; i < 2; i++) {
	    	
	    	int position = reader.nextInt();
	    	
	    	if (position > map[i] || position < 0) {
	    		System.out.println("Error: rover1 is outside the map");
	    		System.exit(0);
	    	} else {
	    	rover1Position[i] = position; 
	    	}
	    }
	    
	    String orientation = reader.next().toUpperCase();
	    
	    if (orientation.equals("N") || orientation.equals("E") || orientation.equals("S") || orientation.equals("W")) {
	    	rover1Direction[0] = orientation;
	    } else {
	    	System.out.println("Error: '" + orientation + "' is not an accepted input" );
	    	System.exit(0);
	    }
	    
	    System.out.println("Rover1 starting position " + Arrays.toString(rover1Position) + " " + Arrays.toString(rover1Direction) + "\n");
	    

	    
	    
	    
	    //Get movement commands for Rover 1
	    System.out.println("Acceptable movement commands are 'L' for left, 'R' for right or 'M' for move one space");
	    System.out.println("Please enter movement commands for Rover1 e.g. LMLMLMLMM");
	    
	    String command = reader.next().toUpperCase(); 	
    	
    	for(int i = 0; i < command.length(); i++) {
    	    
    	    String letter = String.valueOf(command.charAt(i));
    	
	    	if (letter.contains("M")) {
	 
	    		moveForward(rover1Direction[0], rover1Position);
	    		
	    	} else if (letter.contains("L") || letter.contains("R")) {
		    	
	    		rotate(letter, rover1Direction); 
	    		
	    	} else {
	    		System.out.println("Error: '" + letter + "' is not an accepted input" );
	    		System.exit(0);
	    		
	    	}
    	}
    	
    	System.out.println("\nRover1's new position " + Arrays.toString(rover1Position) + " " + Arrays.toString(rover1Direction) + "\n");
    	
    	
    	
    	
    	//Get starting position of Rover2
	    System.out.println("Please enter the starting position of Rover2 and its orientation  e.g. 3 3 E");
	    
	    for (int i = 0; i < 2; i++) {
	    	
	    	int position = reader.nextInt();
	    	
	    	//check to make sure the rover is not off the map
	    	if (position > map[i] || position < 0) {
	    		System.out.println("Error: rover2 is outside the map");
	    		System.exit(0);
	    	} else {
	    	rover2Position[i] = position; 
	    	}
	    }
	    
	    rover2Direction[0] = reader.next().toUpperCase();
	    
	    System.out.println("Rover2 starting position " + Arrays.toString(rover1Position) + " " + Arrays.toString(rover1Direction) + "\n");
	    
    	
	    
	    
	    //Get movement commands for Rover 2
	    System.out.println("Acceptable movement commands are 'L' for left, 'R' for right or 'M' for move one space");
	    System.out.println("Please enter movement commands for Rover2 e.g. MMRMMRMRRM");
	    
	    String command2 = reader.next().toUpperCase(); 	
    	
    	for(int i = 0; i < command2.length(); i++) {
    	    
    	    
    	    String letter = String.valueOf(command2.charAt(i));
    	
	    	if (letter.contains("M")) {
	    		
	    		moveForward(rover2Direction[0], rover2Position);
	    		
	    	} else if (letter.contains("L") || letter.contains("R")) {
		    	
	    		rotate(letter, rover2Direction); 
	    		
	    	} else {
	    		System.out.println("Error: '" + letter + "' is not an accepted input" );
	    		System.exit(0);
	    		
	    	}
    	}
    	
    	System.out.println("\nRover2's new position " + Arrays.toString(rover2Position) + " " + Arrays.toString(rover2Direction));
		
	  
	    reader.close(); 


	}
	
	
	public static void main(String[] args) {
	
	    start();
		
		
	}

}
