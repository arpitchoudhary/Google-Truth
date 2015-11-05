package com.example.arpit.googletruth;


import java.util.ArrayList;
import java.util.List;

public class DataUtility {
    List<String> names;
    public DataUtility() {
    }

    public double getSquareRoot(double number) throws IllegalArgumentException{
        if(number < 0){
            throw new IllegalArgumentException("Invalid Number");
        }
        return Math.sqrt(number);
    }

    public String getReverseName(String name){
        if(name == null && name.isEmpty()){
            throw new IllegalArgumentException("Invalid Name");
        }
        StringBuilder str = new StringBuilder(name);
        return str.reverse().toString();
    }

    public List<String> getListOfNames() {
        names = new ArrayList<String>();
        names.add("Arpit");
        names.add("Kshitiz");
        names.add("Sunil");
        names.add("Atul");
        names.add("Sharad");
        return names;
    }

}
