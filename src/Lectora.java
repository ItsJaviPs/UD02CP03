public class Lectora extends Thread {
    private final VariableCompartida variable;

    public Lectora(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Leído: " + variable.get());
        }
    }
}