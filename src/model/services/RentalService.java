package model.services;

import model.entities.Aluguel;
import model.entities.Fatura;

import java.time.Duration;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }
    public void processInvoice(Aluguel aluguel){
        double minutes = Duration.between(aluguel.getStart(),aluguel.getFinish()).toMinutes();
        double hours = minutes/60.0;
        double basicPayment;
        if (hours<=12.0){
            basicPayment = pricePerHour*Math.ceil(hours);
        }
        else {
            basicPayment = pricePerDay*Math.ceil(hours/24.0);
        }
        double tax = taxService.tax(basicPayment);

        aluguel.setFatura(new Fatura(basicPayment,tax));
    }
}
