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
@RequestMapping("/aeroports")
public class AeroportController {

    @Autowired
    private AeroportService aeroportService;

    @GetMapping
    public String getAllAeroports(Model model) {
        List<Aeroport> aeroports = aeroportService.getAllAeroports();
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
        aeroportService.addAeroport(aeroport);
        return "redirect:/aeroports";
    }

    @GetMapping("/edit/{id}")
    public String showEditAeroportForm(@PathVariable Integer id, Model model) {
        Aeroport aeroport = aeroportService.getAeroportById(id);
        model.addAttribute("aeroport", aeroport);
        return "editer";
    }


    @PostMapping("/edit/{id}")
    public String editAeroport(@PathVariable Integer id, @ModelAttribute("aeroport") Aeroport aeroport) {
        aeroport.setId(id);
        aeroportService.updateAeroport(aeroport);
        return "aeroports";
    }






}
