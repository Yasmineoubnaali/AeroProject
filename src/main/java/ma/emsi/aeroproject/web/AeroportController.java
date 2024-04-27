package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Aeroport;
import ma.emsi.aeroproject.service.AeroportManager;
import ma.emsi.aeroproject.service.AeroportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AeroportController {

    @Autowired
    private AeroportManager aeroportManager;


    @GetMapping("/aeroports")
    public String getAllAeroports(Model model) {
        List<Aeroport> aeroports = aeroportManager.getAllAeroports();
        model.addAttribute("aeroports", aeroports);
        return "aeroports";
    }

    @GetMapping("/ajouter")
    public String showAddAeroportForm(Model model) {
        model.addAttribute("aeroport", new Aeroport());
        return "ajouter";
    }

    @PostMapping("/ajouter")
    public String addAeroport(@ModelAttribute("aeroport") Aeroport aeroport) {
        aeroportManager.addAeroport(aeroport);
        return "redirect:/aeroports";
    }

    @GetMapping("/editAeroport")
    public String editAeroport(Model model, @RequestParam(name = "id") Integer id) {
        Aeroport aeroport = aeroportManager.getAeroportById(id);
        if (aeroport != null) {
            model.addAttribute("aeroportToBeUpdated", aeroport);
            return "editer";
        } else {
            return "error";
        }
    }
    @PostMapping("/edit")
    public String updateAeroport(Model model,@RequestParam(name = "nom") String nom,
                                 @RequestParam(name = "id") Integer id,

                                 @RequestParam(name = "ville") String ville){

        Aeroport aeroport=new Aeroport(id,nom,ville);
        aeroportManager.updateAeroport(aeroport);
        return "redirect:aeroports";
    }
    @GetMapping("/deleteAeroport")
    public String deleteAeroport(@RequestParam(name = "id") Integer id) {
        aeroportManager.deleteAeroportByID(id);
        return "redirect:aeroports";

    }


}