package extra_exercise;

public class Main {
    public static void main(String[] args) {
        // read the circuit's components from file
        Circuit circuit = new Circuit("Homework10/circuit.txt");
        Circuit circuit2 = new Circuit("Homework10/circuit.txt");

        System.out.println("\nCircuit equals circuit2 before the operations: " + circuit.equals(circuit2));

        System.out.println("\nThe circuit:\n" + circuit + "\n");

        Condenser condenser = new Condenser(54.22, 11);
        Resistance resistance = new Resistance(59.22, 31);

        // add new component to the circuit
        circuit.addNewComponent(condenser);
        System.out.println("Circuit after adding a new component:\n" + circuit + "\n");

        // remove a component
        circuit.removeComponent(condenser);
        System.out.println("Circuit after removing a given component:\n" + circuit + "\n");

        // remove component with given index
        circuit.removeComponentByIndex(2);
        System.out.println("Circuit after removing component with index 2:\n" + circuit + "\n");

        System.out.println("Number components: " + circuit.getNumberComponents());
        System.out.println("Overall price: " + circuit.getComponentsPrice());

        // find a given component
        System.out.println("Given component is part of the circuit: " + circuit.findComponent(resistance));

        // check if a circuit contains only resistances
        System.out.println("Only resistance: " + circuit.onlyResistance());

        System.out.println("Resultant resistance: " + circuit.resultantResistance());

        System.out.println("\nCircuit equals circuit2 after the operations: " + circuit.equals(circuit2));
    }
}
