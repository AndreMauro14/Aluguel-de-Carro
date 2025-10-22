package application;

import model.entities.Aluguel;
import model.entities.Veiculo;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do Aluguel");
        System.out.print("Modelo do carro : ");
        String carModel = sc.nextLine();
        System.out.print("Retirada (dd/mm/yyyy HH:mm) : ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
        System.out.print("Retorno (dd/mm/yyyy HH:mm) : ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);

        Aluguel cr = new Aluguel(start,finish, new Veiculo(carModel));

        System.out.print("Digite o preço por dia :");
        Double pricePerDay = sc.nextDouble();
        System.out.print("Digite o preço por hora :");
        Double pricePerHour = sc.nextDouble();


        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println();
        System.out.println("FATURA");
        System.out.println("Pagamento basico :"+cr.getFatura().getBasicPayment());
        System.out.println("Imposto : "+cr.getFatura().getTax());
        System.out.println("Pagamento Total : "+cr.getFatura().getTotalPayment());
    }

}