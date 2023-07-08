package lihuibear;

public class Student {
    private String name;
    private int score_java;
    private int score_python;

    public Student(){

    }

    public Student(String name, int score_java, int score_python) {
        this.name = name;
        this.score_java = score_java;
        this.score_python = score_python;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore_java() {
        return score_java;
    }

    public void setScore_java(int score_java) {
        this.score_java = score_java;
    }

    public int getScore_python() {
        return score_python;
    }

    public void setScore_python(int score_python) {
        this.score_python = score_python;
    }
}
