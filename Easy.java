
public class Easy implements QuestionsInterface {
	
	String question;
	String answer;
	
	public Easy(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
}
