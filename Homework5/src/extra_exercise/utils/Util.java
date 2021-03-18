package extra_exercise.utils;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Random;

public class Util {
    public static Random random = new Random();
    public static ArrayList<String> commonWords = new ArrayList<>();
    public static ArrayList<Disease> diseases = new ArrayList<>();

    static class Disease{
       public final  ArrayList<String> treatments = new ArrayList<>();
    }
}

