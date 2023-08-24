package presencial;

public class ManejadorGerencial extends Manejador {

    @Override
    public String comprobar(Mail mail) {
        if(mail.getTema().equals("Gerencial")||mail.getDestino().equals("gerencial@colmena.com")){
            System.out.println("En unos instantes lo atenderemos en la gerencia ");
            System.out.println("Aguarde unos minutos.");
            return "Gracias, Gerencial.";
        }else{
            System.out.println("Lamentamos no poder atenderlo, en Gerencial lo comunicaremos con el siguiente departamento");
            return getSiguienteManejador().comprobar(mail);
        }
    }
}
