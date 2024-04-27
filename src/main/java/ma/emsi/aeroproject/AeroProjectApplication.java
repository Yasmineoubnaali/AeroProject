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

            Aeroport aeroport2 = new Aeroport();
            aeroport2.setNom("Aéroport International de Luxembourg");
            aeroport2.setVille("Luxembourg");
            aeroportManager.addAeroport(aeroport2);

            Aeroport aeroport3 = new Aeroport();
            aeroport3.setNom("Aéroport International Menara");
            aeroport3.setVille("Marakech");
            aeroportManager.addAeroport(aeroport3);

            Aeroport aeroport4 = new Aeroport();
            aeroport4.setNom("Aéroport de Londre");
            aeroport4.setVille("London");
            aeroportManager.addAeroport(aeroport4);

            Aeroport aeroport5 = new Aeroport();
            aeroport5.setNom("Aéroport International de Madrid");
            aeroport5.setVille("Madrid");
            aeroportManager.addAeroport(aeroport5);

            Aeroport aeroport6 = new Aeroport();
            aeroport6.setNom("Aéroport de Rabat");
            aeroport6.setVille("Rabat");
            aeroportManager.addAeroport(aeroport6);

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

            Bagage bagage1 = new Bagage();
            bagage1.setPoids(28.00);
            bagage1.setEtiquette("ABC225");
            bagage1.setDescription("Valise turquoise");
            bagage1.setClient(c1);
            bagageManager.addBagage(bagage1);

            Bagage bagage2 = new Bagage();
            bagage2.setPoids(12.99);
            bagage2.setEtiquette("GHT857");
            bagage2.setDescription("Valise blanche");
            bagage2.setClient(c1);
            bagageManager.addBagage(bagage2);

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
