package com.mazznat.quizspeed.Models;


public class Question {

    private String question;
    private int reponse;

    public Question(){};

    public Question(String question,int reponse){
        this.question = question;
        this.reponse = reponse;
    }


    public String getQuestion(){
        return question;
    }

    public int isReponse(){
        return reponse;
    }
}
