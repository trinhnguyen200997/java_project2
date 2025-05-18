import java.util.Random;

public class Hero_TN623245 {
	
	// Attributes of heroes
	private String name;							//Name of the hero
	private String type;							//Type of character a hero represent
	private int health;								//The health point of the hero
	private double power; 							//The power level of the hero(like becoming stronger, more intelligent)
	private String attackAbility;					//The skill of the hero (like create big fire or can swing sword)
	private double speed;							//Speed of the hero
	private Random random;							//Random instance for random values
	
	//Constructor to initialize the fields
	public Hero_TN623245(String fields) {
		String[] info =fields.split(", ");			//Split the input by comma and space, storing each in the array
		this.name = info[0];						//Set the name of hero using first element in array	
		this.type = info[1];						//Set the type for hero using second element in array
		this.health =Integer.parseInt(info[2]);		//Set the health score for hero by parsing the third element into integer and assign to hero's health
		this.power = Double.parseDouble(info[3]);	//Set the power level for hero by parsing the fourth element into double and assign to hero's power
		this.attackAbility = info[4];				//Set the ability to attack of the hero using fifth element in array	
		this.speed = Double.parseDouble(info[5]);	//Set the speed of hero by parsing the sixth element into double and assign to hero's speed
		this.random = new Random();					//Initialize random instance
	}
	
	//Method to get the name of hero in the game
	public String getName() {
		return name;	//Return the hero's name
	}
	
	//Method to get the health of hero in the game
	public int getHealth() {
		return health;	//Return the hero's health
	}
	
	//Method to set the health of hero in the game
	public void setHealth(int h) {
		health = h;		//Update hero's health
	}
	
	//Method to get the power of hero in the game
	public double getPower() {
		return power;	//Return hero's power
	}
	
	//Method to get the speed of hero in the game
	public String getAttackAbility() {
		return attackAbility;	//Return hero's attackAbility
	}
		
		
	//Override toString to provide a more meaningful description of the hero's full information
	public String toString() {
		return " (name: " + name + ", "+ 
				"Type: "+ type + ", " +
				"Health: " +health + ", " + 
				"Power: " +power +", " + 
				"AttackAbility: "+ attackAbility +", "  +
				"Speed: "+speed +")";
	}
	
	//Method to get random value from -5 to 5
	public int getRandom() {
		return random.nextInt(11)-5;	//Return a random value from -5 to 5
	}
	
	//Method to update health value after factoring in the random value 
	public void updateHealth() {
		this.health += getRandom();		//Update health with random factor
	}
}
