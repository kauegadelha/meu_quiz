public class Question {
    private int id;
    private String text;
    private boolean response;

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

    public boolean isResponse() {
        return response;
    }
}