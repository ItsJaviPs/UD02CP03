public class Main {
    public static void main(String[] args) throws InterruptedException {
        VariableCompartida variable = new VariableCompartida();

        Escritora escritora = new Escritora(variable);
        Lectora lectora = new Lectora(variable);

        escritora.start();
        lectora.start();

        escritora.join();
        lectora.join();
    }
}