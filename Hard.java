
public class Hard implements QuestionsInterface {
	
	String question;
	String answer;
	
	public Hard(String question, String answer) {
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
