import dao.BD;
import dao.MedicamentosDAOH2;
import model.Medicamento;
import service.MedicamentoService;

public class Cliente {
    public static void main(String[] args) {
        //que necesitamos para hacer funcionar esto?
        BD.CrearTablas();
        Medicamento medicamento= new Medicamento(1,"Ibuprofeno","bayer",100,10.0,1010111);
        Medicamento medicamento2 = new Medicamento(2, "dipírona","pfizer",10,100.0,44444);
        MedicamentoService medicamentoService= new MedicamentoService(new MedicamentosDAOH2());
        medicamentoService.guardarMedicamento(medicamento);
        medicamentoService.buscarPorId(medicamento2);
    }

}
