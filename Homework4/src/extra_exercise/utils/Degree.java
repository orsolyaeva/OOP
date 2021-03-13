package extra_exercise.utils;

import java.util.ArrayList;

public class Degree {
    private final String name;
    private static final ArrayList<Degree> degrees = new ArrayList<>();

    public static Degree create(String name){
        return new Degree(name.toUpperCase());
    }

    public static void addList(String[] name) {
        for (String str : name) {
            new Degree(str);
        }
    }

    private Degree(String name) {
        this.name = name;
        for(Degree deg: degrees){
            if(deg.name.equals(name)){
//                System.out.println("The degree you tried to add (" + name + ") already exists! ");
                return;
            }
        }
        degrees.add(this);
    }


    public static ArrayList<Degree> values(){
        ArrayList<Degree> result = new ArrayList<>();
        result.addAll(degrees);
        return result;
    }

    public String getName(){
        return this.name;
    }

    public static Degree valueOf(String degree){
        for(Degree deg : degrees){
            if(deg.name.equals(degree)){
                return deg;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}