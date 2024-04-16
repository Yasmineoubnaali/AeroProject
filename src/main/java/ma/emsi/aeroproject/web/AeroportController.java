package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Aeroport;
import ma.emsi.aeroproject.service.AeroportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AeroportController {

    @Autowired
    private AeroportManager aeroportManager;

    @PostMapping("/ajouterAeroport")
    public String ajouterAeroport(Model model,
                                  @RequestParam(name = "nom") String nom,
                                  @RequestParam(name = "ville") String ville) {
        Aeroport aeroport = new Aeroport();
        aeroport.setNom(nom);
        aeroport.setVille(ville);
        aeroportManager.addAeroport(aeroport);
        return "redirect:/index";
    }

    @GetMapping("/ajouterAeroportPage")
    public String ajouterAeroport(Model model) {
        model.addAttribute("aeroport", new Aeroport());
        return "ajouterAeroport";
    }

    @GetMapping("/index")
    public String listAeroports(Model model) {
        List<Aeroport> aeroports = aeroportManager.getAllAeroports();
        model.addAttribute("listAeroports", aeroports);
        return "index";
    }

    @GetMapping("/deleteAeroport")
    public String deleteAeroport(Model model, @RequestParam(name = "id") Integer id) {
        if (aeroportManager.deleteAeroportByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editAeroport")
    public String editAeroport(Model model, @RequestParam(name = "id") Integer id) {
        Aeroport aeroport = aeroportManager.getAeroportById(id);
        if (aeroport != null) {
            model.addAttribute("aeroportToBeUpdated", aeroport);
            return "updateAeroport";
        } else {
            return "error";
        }
    }
}
