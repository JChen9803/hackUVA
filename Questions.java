import java.util.ArrayList;
import java.util.Random;

public class Questions implements QuestionsInterface{
	
	String difficulty;
	String question;
	String answer;
	
	Random random = new Random();

	Easy[] easyList = {new Easy("5 x 3 =", "15"), new Easy("7 + 3 + 10 =", "20"), new Easy("17 - 7 =", "10"), new Easy("4 / 2 =", "2"), new Easy("10 - 2 =", "8")};
	Medium[] mediumList = {new Medium("8 + 6 + 9 =", "23"), new Medium("9 x 12 =", "108"), new Medium("63 - 56 =", "7"), new Medium("56 / 8 =", "7"), new Medium("17 + 26 =", "43")};
	Hard[] hardList = {new Hard("23 + 74 + 13 =", "110"), new Hard("16 x 3 x 3 =", "144"), new Hard("(132 / 11) / 2 =", "6"), new Hard("232 - 74 - 55 + 4 =", "107"), new Hard("(12 x 6) + (8 x 4)  =", "104")};
	
	public Questions(String difficulty) {
		this.difficulty = difficulty;
		
		if (difficulty.toLowerCase() == "easy") {
			this.question = randomEasy().getQuestion();
			this.answer = randomEasy().getAnswer();
		}
		else if (difficulty.toLowerCase() == "medium") {
			this.question = randomMedium().getQuestion();
			this.answer = randomMedium().getAnswer();
		}
		else if (difficulty.toLowerCase() == "hard") {
			this.question = randomHard().getQuestion();
			this.answer = randomHard().getAnswer();
		}
	}
	
	public Easy randomEasy() {
		 return easyList[random.nextInt(easyList.length - 1)];
	}
	
	public Medium randomMedium() {
		return mediumList[random.nextInt(mediumList.length - 1)];
		
	}
	
	public Hard randomHard() {
		return hardList[random.nextInt(hardList.length - 1)];
	}

	public String getQuestion() {
		return this.question;
	}

	public String getAnswer() {
		return this.answer;
	}
	
}
