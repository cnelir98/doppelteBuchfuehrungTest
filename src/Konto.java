import java.util.ArrayList;

public class Konto {
    String name;
    double saldo;
    double sollSum = 0;
    double habenSum = 0;

    String typ;
    ArrayList<Buchung> sollList = new ArrayList<Buchung>();
    ArrayList<Buchung> habenList = new ArrayList<Buchung>();

    public Konto(String name, String typ) {
        this.name = name;
        this.typ = typ;
    }

    public void Bilanz(Konto konto) {

        this.sollHabenSum();

        if(this.habenSum > this.sollSum){
            this.saldo = this.habenSum - this.sollSum;
            Buchung EB = new Buchung(this.saldo);
            this.addSollBuchung(EB);
            konto.addHabenBuchung(EB);
        } else if (this.sollSum > this.habenSum){
            this.saldo = this.sollSum - this.habenSum;
            Buchung EB = new Buchung(this.saldo);
            this.addHabenBuchung(EB);
            konto.addSollBuchung(EB);

        } else if(this.sollSum == this.habenSum){
            this.saldo = 0;
        }
    }

    private void sollHabenSum(){
        this.saldo = 0;
        this.sollSum = 0;
        this.habenSum = 0;

        for (Buchung sollElement: this.sollList) {
            this.sollSum = this.sollSum + sollElement.getBetrag();
        }

        for (Buchung habenElement: this.habenList) {
            this.habenSum = this.habenSum + habenElement.getBetrag();
        }
    }

    public void addSollBuchung(Buchung buchung){
        this.sollList.add(buchung);
    }

    public void addHabenBuchung(Buchung buchung){
        this.habenList.add(buchung);
    }

    public double getSaldo(){
        this.sollHabenSum();
        if(this.habenSum > this.sollSum){
            this.saldo = this.habenSum - this.sollSum;
        } else if (this.sollSum > this.habenSum){
            this.saldo = this.sollSum - this.habenSum;
        }
        return this.saldo;
    }

    public String getName() {
        return name;
    }

    public String BilanzToString(){
        String sollAusgabe = "Soll: ";
        String habenAusgabe = "Haben: ";
        for (Buchung sollElement: this.sollList) {
            String betrag = sollElement.getBetrag() + "";
            sollAusgabe = sollAusgabe + " " + betrag;
        }

        for (Buchung habenElement: this.habenList) {
            String betrag = habenElement.getBetrag() + "";
            habenAusgabe = habenAusgabe + " " + betrag;
        }

        return sollAusgabe + " " + habenAusgabe;
    }


}
