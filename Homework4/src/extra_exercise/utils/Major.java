package extra_exercise.utils;

import java.util.ArrayList;

public class Major {
    private final String name;
    private static final ArrayList<Major> majors = new ArrayList<>();

    public static Major create(String name){
        return new Major(name.toUpperCase());
    }

    public static void addList(String[] name) {
        for (String str : name) {
            new Major(str);
        }
    }

    private Major(String name) {
        this.name = name;
        for(Major deg: majors){
            if(deg.name.equals(name)){
//                System.out.println("The major you tried to add (" + name + ") already exists! ");
                return;
            }
        }
        majors.add(this);
    }

    public static Major valueOf(String major){
        for(Major maj : majors){
            if(maj.name.equals(major)){
                return maj;
            }
        }
        return null;
    }

    public String getName(){
        return this.name;
    }

    public static ArrayList<Major> values(){
        ArrayList<Major> result = new ArrayList<>();
        result.addAll(majors);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}