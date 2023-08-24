package presencial;

public class ManejadorComercial extends Manejador{
    @Override
    public String comprobar(Mail mail) {
        if(mail.getTema().equals("Comercial")||mail.getDestino().equals("comercial@colmena.com")){
            System.out.println("En unos instantes lo atenderemos ");
            System.out.println("Aguarde unos minutos.");
            return "Gracias, Comercial.";
        }else{
            System.out.println("Lamentamos no poder atenderlo, en Comercial lo comunicaremos con el siguiente departamento");
            return getSiguienteManejador().comprobar(mail);
        }
            }
}
