package service;

import dao.iDao;
import model.Medicamento;
import org.apache.log4j.Logger;

public class MedicamentoService {
    private static final Logger logger=Logger.getLogger(MedicamentoService.class);
    //relacion de asociacion
    private iDao<Medicamento> medicamentoiDao;

    public MedicamentoService(iDao<Medicamento> medicamentoiDao) {
        this.medicamentoiDao = medicamentoiDao;
    }
    public Medicamento guardarMedicamento(Medicamento medicamento){
        logger.info("llamo al idao medicamentos para darle el objeto a guardar");
        //service lo que hace unicamente es llamar a la clase correspondiente a hacer ese trabajo
        return medicamentoiDao.guardar(medicamento);
    }
    public Medicamento buscarPorId(Medicamento medicamento){
        return medicamentoiDao.buscar(medicamento);
    }
}
