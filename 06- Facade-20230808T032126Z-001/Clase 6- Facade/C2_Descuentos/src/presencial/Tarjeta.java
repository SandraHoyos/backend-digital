package presencial;

public class Tarjeta {
    private Integer numero;
    private  String bancoEmisor;

    public Tarjeta(Integer numero, String bancoEmisor) {
        this.numero = numero;
        this.bancoEmisor = bancoEmisor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }
}
