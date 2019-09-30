

public class Cliente implements Observer {
    private Tuberia inicio;
    private Tuberia fin;

    public Tuberia getInicio() {
        return inicio;
    }

    public Tuberia getFin() {
        return fin;
    }

    public Cliente(Tuberia inicio, Tuberia fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void update(Object arg) {
        System.out.println(arg.toString());
    }

    public static void main(String[] args){

        Tuberia tuberia5 = new Tuberia(new Output(null));
        Tuberia tuberia4 = new Tuberia(new Ordenar(tuberia5));
        Tuberia tuberia3 = new Tuberia(new Mezclar(tuberia4));
        Tuberia tuberia2= new Tuberia(new Partir(tuberia3));
        Tuberia tuberia1= new Tuberia(new Input(tuberia2));
        Cliente cliente= new Cliente(tuberia1, tuberia5);
        ((Output) cliente.getFin().getSigFiltro()).addObserver(cliente);

        cliente.inicio.setStream(null);




    }
}