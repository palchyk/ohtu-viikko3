package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week;
     private int hours;
     private ArrayList<Integer> exercises;
     private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }
    public int getExercisesSum() {
        int apu = 0;
        for (Integer exercise : exercises) {
            apu+=exercise;
        }
        return apu;
    }

    public void setExercises(ArrayList<Integer> exercises) {
        this.exercises = exercises;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getWeek() {
        return week;
    }
    
     public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
   
    

    @Override
    public String toString() {
        String teht =   exercises.toString().substring(1, exercises.toString().length()-1);
        //course+", viikko "+week+" tehtyjä tehtäviä yhteensä "+exercises.size()+
        return " aikaa kului "+hours+" tehdyt tehtävät: "+teht+"\n";
    }
    
}