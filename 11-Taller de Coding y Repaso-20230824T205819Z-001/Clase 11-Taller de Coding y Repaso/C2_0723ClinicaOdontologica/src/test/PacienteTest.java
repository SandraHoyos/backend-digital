package test;

import dao.BD;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.util.List;

public class PacienteTest {
    @Test
    public void buscarTodos(){
        //DADO
        BD.crearTablas();
        PacienteService pacienteService= new PacienteService();

        //CUANDO
        List<Paciente> pacientes= pacienteService.buscarTodos();
        //ENTONCES
        Assertions.assertEquals(2,pacientes.size());
    }
}
