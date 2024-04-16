package ma.emsi.aeroproject;

import ma.emsi.aeroproject.dao.entities.*;
import ma.emsi.aeroproject.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class AeroProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AeroProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AeroportManager aeroportManager, ClientManager clientManager,
                                  VolManager volManager, BilletManager billetManager,
                                  BagageManager bagageManager, ReservationManager reservationManager) {
        return (args) -> {

            Aeroport aeroport1 = new Aeroport();
            aeroport1.setNom("Aéroport International Mohammed V");
            aeroport1.setVille("Casablanca");
            aeroportManager.addAeroport(aeroport1);

            Client c1 = new Client();
            c1.setNomComp("Yasmine Oubnaali");
            c1.setEmail("yasmineOub@gmail.com");
            c1.setAdress("rue 11 nr 03");
            clientManager.addClient(c1);

            Vol vol = new Vol();
            vol.setDateDepart(new Date());
            vol.setDateArriver(new Date());
            vol.setVilleArriver("Casablanca");
            vol.setVilleDestination("Bali");
            volManager.addVol(vol);

            Billet billet = new Billet();
            billet.setNumeroSiege("A12");
            billet.setClasseSiege("Economique");
            billet.setNomPassager("Elhamdaoui");
            billet.setPrenomPassager("Taha");
            billet.setNumeroPasseport("AB123456");
            billet.setPrix(2500.0);
            billetManager.addBillet(billet);

            Bagage bagage = new Bagage();
            bagage.setPoids(20.5);
            bagage.setEtiquette("ABC123");
            bagage.setDescription("Valise noire");
            bagage.setClient(c1);
            bagageManager.addBagage(bagage);

            Reservation reservation = new Reservation();
            reservation.setNomPassager("Yasmine");
            reservation.setPrenomPassager("Oubnaali");
            reservation.setNumeroPasseport("CD456789");
            reservation.setDateReservation(new Date());
            reservation.setNombrePlaces(1);
            reservation.setStatut("En attente");
            reservation.setPrixTotal(150.0);
            reservation.setTypeSiege("Fenêtre");
            reservationManager.addReservation(reservation);
        };
    }

}
