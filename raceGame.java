public class raceGame {

public static void main(String args[]) {

//variables that sets starting position, finish line, boolean to end/enter loops,
//Strings to determine winners, and point counters to determine winner
int x1 = 0;
int x2 = 0;
int x3 = 0;
int x = 0;
int max = 620;
boolean end = true;
String firstPlace = "";
String secondPlace = "";
String thirdPlace = "";
boolean blueC = true;
boolean redC = true;
boolean grayC = true;
int redPt = 0;
int grayPt = 0;
int bluePt = 0;

//creating canvas and images
RacerCanvas racer1 = new RacerCanvas(800, 800);
racer1.setFiles("redCar.png", "grayCar.png", "blueCar.png");
racer1.moveRacer1(0,20);
racer1.moveRacer2(0,250);
racer1.moveRacer3(0,500);

//loop that run the race
racer1.delay(3000);
for (int j = 1; j <= 3; j++) { //3 rounds
		racer1.setPlaces("Round " + j, 100, 600, 20); //displays round number
		racer1.showText(true);
	while (end) { //infinite loop to move cars
		x1 += (int)(Math.random()*5);
		racer1.moveRacer1(x1,20);
		racer1.delay(5);
		if (x1 >= max) {
			if (firstPlace == "" && redC) { //conditional for red car 1st place
				firstPlace = "redCar";
				redC = false;
				redPt += 1;
			} else if (secondPlace == "" && redC) {
				secondPlace = "redCar";
				redC = false;
			}
			else if(thirdPlace == "" && redC){
				thirdPlace = "redCar";
				redC = false;
			}
			x1 = max;
			racer1.repaint();
	}
		x2 += (int)(Math.random()*5);
		racer1.moveRacer2(x2,250);
		racer1.delay(5);
		if (x2 >= max) {
			if (firstPlace == "" && grayC) { //conditional for gray car 1st place
				firstPlace = "grayCar";
				grayC = false;
				grayPt += 1;
			}
			else if (secondPlace == "" && grayC) {
					secondPlace = "grayCar";
					grayC = false;
			}
			else if (thirdPlace == "" && grayC){
						thirdPlace = "grayCar";
						grayC = false;
			}
			x2 = max;
			racer1.repaint();
		}
		x3 += (int)(Math.random()*5);
		racer1.moveRacer3(x3,500);
		racer1.delay(5);
		if (x3 >= max) {
			if (firstPlace == "" && blueC) { //conditional for blue car 1st place
				firstPlace = "blueCar";
				blueC = false;
				bluePt += 1;
		}
		else if (secondPlace == "" && blueC) {
			secondPlace = "blueCar";
			blueC = false;
		}
		else if(thirdPlace == "" && blueC){
			thirdPlace = "blueCar";
			blueC = false;
			}
			x3 = max;
			racer1.repaint();
		}
	if (x1 >= max && x2 >= max && x3 >= max) { //conditionals for capping cars at finish line
		if (x1 >= max) {
			x1 = max;
		}
		if (x2 >= max) {
			x2 = max;
		}
		if (x3 >= max) {
			x3 = max;
		}
		end = false;
	}
		racer1.repaint();
}
//determining the winners after each round
	if (firstPlace == "redCar" && secondPlace == "grayCar") {
		racer1.setPlaces("Red was first place. Gray was second place. Blue was third place.", 100, 600, 20);
		racer1.showText(true);
	}
	else if (firstPlace == "redCar" && secondPlace == "blueCar") {
		racer1.setPlaces("Red was first place. Blue was second place. Gray was third place.", 100, 600, 20);
		racer1.showText(true);
	}
	else if (firstPlace == "grayCar" && secondPlace == "redCar") {
		racer1.setPlaces("Gray was first place. Red was second place. Blue was third place.", 100, 600, 20);
		racer1.showText(true);
	}
	else if (firstPlace == "grayCar" && secondPlace == "blueCar") {
			racer1.setPlaces("Gray was first place. Blue was second place. Blue was third place.", 100, 600, 20);
			racer1.showText(true);
	}
	else if (firstPlace == "blueCar" && secondPlace == "redCar") {
			racer1.setPlaces("Blue was first place. Red was second place. Gray was third place.", 100, 600, 20);
			racer1.showText(true);
	}
	else if (firstPlace == "blueCar" && secondPlace == "grayCar") {
			racer1.setPlaces("Blue was first place. Gray was second place. Red was third place.", 100, 600, 20);
			racer1.showText(true);
	}
//resetting racers after each round to starting points along
//with booleans and strings, delayed start by 5 seconds
	racer1.delay(2000);
	x1 = 0;
	x2 = 0;
	x3 = 0;
	end = true;
	firstPlace = "";
	secondPlace = "";
	thirdPlace = "";
	blueC = true;
	grayC = true;
	redC = true;
	racer1.moveRacer1(x1,20);
	racer1.moveRacer2(x2,250);
	racer1.moveRacer3(x3,500);
	racer1.repaint();
	racer1.delay(5000);

//conditionals that determines the final winners
if (redPt == grayPt && redPt == bluePt && grayPt == bluePt) {
	racer1.setPlaces("FINAL SCORE: Red, Gray, and Blue tie", 100, 600, 20);
	racer1.showText(true);
}
else if (redPt > grayPt && redPt > bluePt && grayPt > bluePt) {
	racer1.setPlaces("FINAL SCORE: Red wins, Gray is second, Blue is third", 100, 600, 20);
	racer1.showText(true);
}
else if (redPt == grayPt && redPt > bluePt && grayPt > bluePt) {
	racer1.setPlaces("FINAL SCORE: Red and Gray tie, Blue is third", 100, 600, 20);
	racer1.showText(true);
}
else if (redPt > grayPt && redPt == bluePt && bluePt > grayPt) {
	racer1.setPlaces("FINAL SCORE: Red and Blue tie, Gray is third", 100, 600, 20);
	racer1.showText(true);
}
else if (redPt > grayPt && redPt > bluePt && bluePt > grayPt) {
	racer1.setPlaces("FINAL SCORE: Red wins, Blue is second, Gray is third", 100, 600, 20);
	racer1.showText(true);
}
else if (grayPt > redPt && grayPt > bluePt && redPt > bluePt) {
	racer1.setPlaces("FINAL SCORE: Gray wins, Red is second, Blue is third", 100, 600, 20);
	racer1.showText(true);
}
else if (grayPt > redPt && grayPt == bluePt && bluePt > redPt) {
	racer1.setPlaces("FINAL SCORE: Gray and Blue tie, Red is third", 100, 600, 20);
	racer1.showText(true);
}
else if (bluePt > redPt && bluePt > grayPt && redPt > grayPt) {
	racer1.setPlaces("FINAL SCORE: Blue wins, Red is second, Gray is third", 100, 600, 20);
	racer1.showText(true);
}
}
}
}