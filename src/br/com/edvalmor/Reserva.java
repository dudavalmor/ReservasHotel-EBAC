package br.com.edvalmor;

public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int qntDias;
    private double totalDiaria;

    public Reserva(String nomeHospede, String tipoQuarto, int qntDias) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        setQntDias(qntDias);
        this.totalDiaria = definirValorDiaria(tipoQuarto);
    }

    private double definirValorDiaria(String tipoQuarto){
        switch (tipoQuarto.toLowerCase()){
            case "standard":
                return 100.0;
            case "luxo":
                return 150.0;
            case "presidencial":
                return 250.0;
            default:
                throw new IllegalArgumentException("Tipo de quarto inválido: " + tipoQuarto);
        }
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
        this.totalDiaria = definirValorDiaria(tipoQuarto);
    }

    public int getQntDias() {
        return qntDias;
    }

    public void setQntDias(int qntDias) {
        if (qntDias < 1) {
            throw new IllegalArgumentException("Número de dias não pode ser menor do que 1.");
        }
        this.qntDias = qntDias;
    }

    public double getTotalDiaria() {
        return totalDiaria;
    }

    public double calcularValorTotal() {
        double total = totalDiaria * qntDias;
        return total;
    }

    @Override
    public String toString() {
        return "Reserva\n{" +
                "Nome: '" + nomeHospede + '\'' +
                ", Tipo do quarto: " + tipoQuarto +
                ", Dias: " + qntDias +
                ", Valor da diária: " + totalDiaria +
                ", Valor total: " + calcularValorTotal() +
                '}';
    }
}
