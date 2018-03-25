import java.util.ArrayList;
import java.util.Random;

public class Questions implements QuestionsInterface{

	String difficulty;
	String question;
	String answer;

	Random random = new Random();

	Easy[] easyList = {new Easy("5 x 3 =", "15"), new Easy("7 + 3 + 10 =", "20"), new Easy("17 - 7 =", "10"), new Easy("4 / 2 =", "2"), new Easy("10 - 2 =", "8")};
	Easy[] easyList2 = {new Easy("15-5 =", "10"), new Easy("8 + 9 =","17"), new Easy("2 x 3 =","6"), new Easy("3 / 1 =","3"), new Easy("7 - 3 =", "4"), new Easy("1 + 1 =","2")};

	Medium[] mediumList = {new Medium("8 + 6 + 9 =", "23"), new Medium("9 x 10 =", "90"), new Medium("5 / 1 * 1 =", "5"), new Medium("56 - 6 =", "50"), new Medium("17 + 10 =", "27")};
	Medium[] mediumList2 = {new Medium("2 + 2 + 2 =", "6"), new Medium("9 x 2 =", "18"), new Medium("63 - 60 =", "3"), new Medium("50 / 2 =", "25"), new Medium("3 x 4 =", "12")};

	Hard[] hardList = {new Hard("20 + 20 + 3 =", "43"), new Hard("10 + 10 + 10 =", "30"), new Hard("20 + 5 + 4 =", "29"), new Hard("2 x 2 / 2 =", "2"), new Hard("10 + 7 + 3 =", "20")};
	Hard[] hardList2 = {new Hard("23 + 17 =", "40"), new Hard("(15 x 2) + 1 =", "31"), new Hard("(30 / 3) + 2 =", "12"), new Hard("(40 / 10) - 1 =", "3"), new Hard("(12 + 6) - 2  =", "16")};

	public Questions(String difficulty, int list) {
		this.difficulty = difficulty;

		if (list == 1) {
			if (difficulty.toLowerCase() == "easy") {
				Easy question1 = randomEasy();
				this.question = question1.getQuestion();
				this.answer = question1.getAnswer();
			}
			else if (difficulty.toLowerCase() == "medium") {
				Medium question2 = randomMedium();
				this.question = question2.getQuestion();
				this.answer = question2.getAnswer();
			}
			else if (difficulty.toLowerCase() == "hard") {
				Hard question3 = randomHard();
				this.question = question3.getQuestion();
				this.answer = question3.getAnswer();
			}
		}
		else {
			if (difficulty.toLowerCase() == "easy") {
				Easy question1 = randomEasy2();
				this.question = question1.getQuestion();
				this.answer = question1.getAnswer();
			}
			else if (difficulty.toLowerCase() == "medium") {
				Medium question2 = randomMedium2();
				this.question = question2.getQuestion();
				this.answer = question2.getAnswer();
			}
			else if (difficulty.toLowerCase() == "hard") {
				Hard question3 = randomHard2();
				this.question = question3.getQuestion();
				this.answer = question3.getAnswer();
			}
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

	public Easy randomEasy2() {
		return easyList2[random.nextInt(easyList.length - 1)];
	}

	public Medium randomMedium2() {
		return mediumList2[random.nextInt(mediumList.length - 1)];

	}

	public Hard randomHard2() {
		return hardList2[random.nextInt(hardList.length - 1)];
	}


	public String getQuestion() {
		return this.question;
	}

	public String getAnswer() {
		return this.answer;
	}

}
