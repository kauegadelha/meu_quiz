public class Question {
    int id;
    String text;
    boolean response;

    public Question(int id, String text, boolean response){
        this.id = id;
        this.text = text;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean getResponse() {
        return response;
    }
}