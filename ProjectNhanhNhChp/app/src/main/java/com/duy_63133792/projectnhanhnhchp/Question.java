package com.duy_63133792.projectnhanhnhchp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String question;
    private List<String> options;
    private String answer;

    public Question() {
        this.id = id;
        this.question = question;
        this.options = (options != null) ? options : new ArrayList<>();
        this.answer = answer;
    }
    public Question(String q, List<String> options, String ans) {

        question = q;
        this.options =options;
        answer = ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
