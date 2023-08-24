package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if(mail.getTema().equals("tecnico")||mail.getDestino().equals("tecnico@colmena.com")){
            System.out.println("En unos instantes lo atenderemos ");
            System.out.println("Aguarde unos minutos.");
            return "Gracias, Tecnico.";
        }else{
            System.out.println("Lamentamos no poder atenderlo,en Tecnico lo comunicaremos con el siguiente departamento");
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
