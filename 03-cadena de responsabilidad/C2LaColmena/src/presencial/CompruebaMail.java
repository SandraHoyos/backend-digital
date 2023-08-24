package presencial;

public class CompruebaMail {
    private Manejador inicializar;

    public CompruebaMail() {
        //acá hemos dado vida a la cadena, instanciamos en un constructor los objetos intervinientes.
        inicializar= new ManejadorComercial();
        Manejador tecnico= new ManejadorTecnico();
        Manejador gerencial= new ManejadorGerencial();
        Manejador spam= new ManejadorSpam();
        //ahora deberemos definir como se unen los eslabones de esa cadena que acabmos de crear
        inicializar.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(gerencial);
        gerencial.setSiguienteManejador(spam);
        //termino la cadena
    }
    //ahora necesito un metodo que me permita manejar esa cadena
    public String compruebaCadena(Mail mail){
        return inicializar.comprobar(mail);
    }

    public Manejador getInicializar() {
        return inicializar;
    }

    public void setInicializar(Manejador inicializar) {
        this.inicializar = inicializar;
    }
}
