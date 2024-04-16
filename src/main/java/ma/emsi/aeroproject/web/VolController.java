package ma.emsi.aeroproject.web;
import ma.emsi.aeroproject.dao.entities.Vol;
import ma.emsi.aeroproject.service.VolManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class VolController {

    @Autowired
    private VolManager volManager;

    @PostMapping("/ajouterVol")
    public String ajouterVol(Model model,
                             @RequestParam(name = "dateDepart") Date dateDepart,
                             @RequestParam(name = "dateArriver") Date dateArriver,
                             @RequestParam(name = "villeArriver") String villeArriver,
                             @RequestParam(name = "villeDestination") String villeDestination,
                             @RequestParam(name = "classe") String classe,
                             @RequestParam(name = "nbrPersonne") Integer nbrPersonne) {
        Vol vol = new Vol();
        vol.setDateDepart(dateDepart);
        vol.setDateArriver(dateArriver);
        vol.setVilleArriver(villeArriver);
        vol.setVilleDestination(villeDestination);
        vol.setClasse(classe);
        vol.setNbrPersonne(nbrPersonne);
        volManager.addVol(vol);
        return "redirect:/index";
    }

    @GetMapping("/ajouterVolPage")
    public String ajouterVol(Model model) {
        model.addAttribute("vol", new Vol());
        return "ajouterVol";
    }

    @GetMapping("/vol")
    public String listVols(Model model) {
        List<Vol> vols = volManager.getAllVols();
        model.addAttribute("listVols", vols);
        return "index";
    }

    @GetMapping("/deleteVol")
    public String deleteVol(Model model, @RequestParam(name = "id") Integer id) {
        if (volManager.deleteVolByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editVol")
    public String editVol(Model model, @RequestParam(name = "id") Integer id) {
        Vol vol = volManager.getVolById(id);
        if (vol != null) {
            model.addAttribute("volToBeUpdated", vol);
            return "updateVol";
        } else {
            return "error";
        }
    }
}
