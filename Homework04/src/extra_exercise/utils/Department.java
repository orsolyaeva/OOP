package extra_exercise.utils;

import java.util.ArrayList;
import java.util.Locale;

public class Department {
    private final String name;
    private static final ArrayList<Department> departments = new ArrayList<>();

    public static Department create(String name){
        return new Department(name.toUpperCase());
    }

    public static void addList(String[] name) {
        for (String str : name) {
            new Department(str);
        }
    }

    private Department(String name) {
        this.name = name;
        for(Department deg: departments){
            if(deg.name.equals(name)){
//                System.out.println("The department you tried to add (" + name + ") already exists! ");
                return;
            }
        }
        departments.add(this);
    }


    public static ArrayList<Department> values(){
        ArrayList<Department> result = new ArrayList<>();
        result.addAll(departments);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}