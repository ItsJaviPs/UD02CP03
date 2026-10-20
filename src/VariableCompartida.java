public class VariableCompartida {
    private int v;
    private boolean disponible = false; // true = hay un valor nuevo sin leer

    public synchronized void set(int v) {
        while (disponible) {            // el anterior no se ha leído: esperar
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        this.v = v;
        disponible = true;
        notifyAll();                    // avisar a la lectora
    }

    public synchronized int get() {
        while (!disponible) {           // no hay valor nuevo: esperar
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return -1;
            }
        }
        disponible = false;
        notifyAll();                    // avisar a la escritora
        return v;
    }

    public synchronized void inc() {    // el del CP02, se queda igual
        v++;
    }
}