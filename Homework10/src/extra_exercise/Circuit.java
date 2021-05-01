package extra_exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Circuit {
    private ArrayList<Components> components = new ArrayList<>();

    public Circuit(String filename) {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("An error occurred whilst reading the file!");
            System.exit(1);
        }

        StringTokenizer tokens;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            tokens = new StringTokenizer(line, ", ");

            int component = Integer.parseInt(tokens.nextToken());

            switch (component){
                case 0 -> this.components.add(new Resistance(Double.parseDouble(tokens.nextToken()), Double.parseDouble(tokens.nextToken())));
                case 1 -> this.components.add(new Condenser(Double.parseDouble(tokens.nextToken()), Double.parseDouble(tokens.nextToken())));
                case 2 -> this.components.add(new Transistor(Double.parseDouble(tokens.nextToken()), tokens.nextToken()));
                default -> { System.out.println("The component does not exist: " + line); continue; }
            }
        }
    }

    public void addNewComponent(Components component){
        if(component == null){
            return;
        }
        this.components.add(component);
    }

    public void removeComponent(Components component){
        if(component == null){
            return;
        }
        this.components.remove(component);
    }

    public void removeComponentByIndex(int index){
        if(!(index >= 0 && index <= components.size() - 1)){
            return;
        }
        this.components.remove(index);
    }

    public int getNumberComponents(){
       return this.components.size();
    }

    public double getComponentsPrice(){
        double price = 0;
        for(Components component : components){
            price += component.getPrice();
        }

        return price;
    }

    public boolean findComponent(Components component){
        return components.contains(component);
    }

    public boolean onlyResistance(){
        for(Components component : components){
            if(!(component instanceof Resistance)){
                return false;
            }
        }

        return true;
    }

    public double resultantResistance(){
        if(!onlyResistance()){
            return -1;
        }

        double resultant = 0;
        for(Components  component : components){
           resultant += ((Resistance) component).getValue();
        }

        return resultant;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        for(Components component : components){
            stringBuffer.append(component.toString()).append("\n");
        }

        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circuit circuit = (Circuit) o;

        for(Components component : circuit.components){
            if(!findComponent(component)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }
}
