package model;

import java.util.List;

public class Aliment {
    private String name;
    private double kcal;
    private double grasimiSaturate;
    private double grasimiNesaturate;
    private double zahar;
    private double carbohidratiComplecsi;
    private double proteine;
    private double fibre;
    private double cantitate;

    public Aliment() {
        setZeros();
    }

    public Aliment(String name, double kcal, double grasimiSaturate, double grasimiNesaturate, double zahar, double carbohidratiComplecsi, double proteine, double fibre, double cantitate) {
        this.name = name;
        this.kcal = kcal;
        this.grasimiSaturate = grasimiSaturate;
        this.grasimiNesaturate = grasimiNesaturate;
        this.zahar = zahar;
        this.carbohidratiComplecsi = carbohidratiComplecsi;
        this.proteine = proteine;
        this.fibre = fibre;
        this.cantitate = cantitate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public double getGrasimiSaturate() {
        return grasimiSaturate;
    }

    public void setGrasimiSaturate(double grasimiSaturate) {
        this.grasimiSaturate = grasimiSaturate;
    }

    public double getGrasimiNesaturate() {
        return grasimiNesaturate;
    }

    public void setGrasimiNesaturate(double grasimiNesaturate) {
        this.grasimiNesaturate = grasimiNesaturate;
    }

    public double getZahar() {
        return zahar;
    }

    public void setZahar(double zahar) {
        this.zahar = zahar;
    }

    public double getCarbohidratiComplecsi() {
        return carbohidratiComplecsi;
    }

    public void setCarbohidratiComplecsi(double carbohidratiComplecsi) {
        this.carbohidratiComplecsi = carbohidratiComplecsi;
    }

    public double getProteine() {
        return proteine;
    }

    public void setProteine(double proteine) {
        this.proteine = proteine;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }

    private void setZeros()
    {
        this.cantitate = 0;
        this.carbohidratiComplecsi = 0;
        this.fibre = 0;
        this.grasimiNesaturate = 0;
        this.grasimiSaturate = 0;
        this.kcal = 0;
        this.proteine = 0;
        this.zahar = 0;
    }

    public static Aliment calculateMacros(List<Aliment> alimente) {
        Aliment total = new Aliment();
        total.setName("Total");
        total.setZeros();

        double kcal = 0;
        double grasimiSaturate = 0;
        double grasimiNesaturate = 0;
        double zahar = 0;
        double carbohidratiComplecsi = 0;
        double proteine = 0;
        double fibre = 0;
        double cantitate = 0;

        for (Aliment aliment : alimente) {
            kcal = kcal + aliment.getCantitate() / 100 * aliment.getKcal();
            grasimiSaturate = grasimiSaturate + aliment.getCantitate() / 100 * aliment.getGrasimiSaturate();
            grasimiNesaturate = grasimiNesaturate + aliment.getCantitate() / 100 * aliment.getGrasimiNesaturate();
            zahar = zahar + aliment.getCantitate() / 100 * aliment.getZahar();
            carbohidratiComplecsi = carbohidratiComplecsi + aliment.getCantitate() / 100 * aliment.getCarbohidratiComplecsi();
            proteine = proteine + aliment.getCantitate() / 100 * aliment.getProteine();
            fibre = fibre + aliment.getCantitate() / 100 * aliment.getFibre();
            cantitate = cantitate + aliment.getCantitate();
        }

        total.setKcal(kcal);
        total.setGrasimiSaturate(grasimiSaturate);
        total.setGrasimiNesaturate(grasimiNesaturate);
        total.setZahar(zahar);
        total.setCarbohidratiComplecsi(carbohidratiComplecsi);
        total.setProteine(proteine);
        total.setFibre(fibre);
        total.setCantitate(cantitate);

        return total;
    }
}
