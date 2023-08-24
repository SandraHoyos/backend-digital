package presencial;

public class centroVacunatorio implements vacunatorioInterface {
    @Override
    public String vacunar(Persona persona) {
        //trabajar con el desarrollo si no tuviese filtros, osea sin proxy
        System.out.println("verificando la documentación correspondiente");
        System.out.println("Paciente: "+persona.getNombre());
        for (int i=0; i<10;i++){
            System.out.println("****************");
        }
         System.out.println("Vacunación exitosa");
                return "El paciente :"+persona.getNombre()+" "+persona.getApellido()+" fue vacunado con exito";
    }
}
