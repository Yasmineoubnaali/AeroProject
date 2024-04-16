package ma.emsi.aeroproject.web;
import ma.emsi.aeroproject.dao.entities.Reservation;
import ma.emsi.aeroproject.service.ReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationManager reservationManager;

    @PostMapping("/ajouterReservation")
    public String ajouterReservation(Model model,
                                     @RequestParam(name = "nomPassager") String nomPassager,
                                     @RequestParam(name = "prenomPassager") String prenomPassager,
                                     @RequestParam(name = "numeroPasseport") String numeroPasseport,
                                     @RequestParam(name = "dateReservation") Date dateReservation,
                                     @RequestParam(name = "nombrePlaces") Integer nombrePlaces,
                                     @RequestParam(name = "statut") String statut,
                                     @RequestParam(name = "prixTotal") Double prixTotal,
                                     @RequestParam(name = "typeSiege") String typeSiege) {
        Reservation reservation = new Reservation();
        reservation.setNomPassager(nomPassager);
        reservation.setPrenomPassager(prenomPassager);
        reservation.setNumeroPasseport(numeroPasseport);
        reservation.setDateReservation(dateReservation);
        reservation.setNombrePlaces(nombrePlaces);
        reservation.setStatut(statut);
        reservation.setPrixTotal(prixTotal);
        reservation.setTypeSiege(typeSiege);
        reservationManager.addReservation(reservation);
        return "redirect:/index";
    }

    @GetMapping("/ajouterReservationPage")
    public String ajouterReservation(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "ajouterReservation";
    }

    @GetMapping("/reservation")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationManager.getAllReservations();
        model.addAttribute("listReservations", reservations);
        return "index";
    }

    @GetMapping("/deleteReservation")
    public String deleteReservation(Model model, @RequestParam(name = "id") Integer id) {
        if (reservationManager.deleteReservationByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editReservation")
    public String editReservation(Model model, @RequestParam(name = "id") Integer id) {
        Reservation reservation = reservationManager.getReservationById(id);
        if (reservation != null) {
            model.addAttribute("reservationToBeUpdated", reservation);
            return "updateReservation";
        } else {
            return "error";
        }
    }
}
