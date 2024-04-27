package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Billet;
import ma.emsi.aeroproject.dao.entities.Reservation;
import ma.emsi.aeroproject.service.ReservationManager;
import ma.emsi.aeroproject.service.ReservationService;
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
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public String getAllReservations(Model model) {
        List<Reservation> reservations = reservationManager.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservations";
    }

    @GetMapping("ajouterReservation")
    public String showAddReservationForm(Model model) {
        model.addAttribute("reservations", new Reservation());
        return "ajouterReservation";
    }

    @PostMapping("ajouterReservation")
    public String addReservation(@ModelAttribute("reservations") Reservation reservation) {
        reservationManager.addReservation(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/editReservation")
    public String editReservation(Model model, @RequestParam(name = "id") Integer id) {
        Reservation reservation = reservationManager.getReservationById(id);
        if (reservation != null) {
            model.addAttribute("reservationToBeUpdated", reservation);
            return "editReservation";
        } else {
            return "error";
        }
    }
    @PostMapping("/editReservation")
    public String updateReservation(Model model,@RequestParam(name = "id") Integer id,

                               @RequestParam(name = "nomPassager") String nomPassager,
                               @RequestParam(name = "prenomPassager") String prenomPassager,
                               @RequestParam(name = "numeroPasseport") String numeroPasseport,
                               @RequestParam(name = "dateReservation") Date dateReservation,
                               @RequestParam(name = "nombrePlaces") Integer nombrePlaces,
                               @RequestParam(name = "statut") String statut,
                               @RequestParam(name = "prixTotal") Double prixTotal,
                               @RequestParam(name = "typeSiege") String typeSiege){

        Reservation reservation=new Reservation(id,nomPassager,prenomPassager,numeroPasseport,dateReservation,nombrePlaces,statut,prixTotal,typeSiege);
        reservationManager.updateReservation(reservation);
        return "redirect:reservations";
    }
    @GetMapping("deleteReservation")
    public String deleteReservation(@RequestParam(name = "id") Integer id) {
        reservationManager.deleteReservationByID(id);
        return "redirect:reservations";

    }
}
