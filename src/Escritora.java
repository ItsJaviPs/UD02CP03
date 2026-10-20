public class Escritora extends Thread {
    private final VariableCompartida variable;

    public Escritora(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            variable.set(i);
        }
    }
}