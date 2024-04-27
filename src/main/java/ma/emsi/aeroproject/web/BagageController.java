package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Aeroport;
import ma.emsi.aeroproject.dao.entities.Bagage;
import ma.emsi.aeroproject.dao.entities.Client;
import ma.emsi.aeroproject.service.BagageService;
import ma.emsi.aeroproject.service.BagageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BagageController {

    @Autowired
    private BagageManager bagageManager;

    @GetMapping("/bagages")
    public String getAllBagages(Model model) {
        List<Bagage> bagage = bagageManager.getAllBagages();
        model.addAttribute("bagages", bagage);
        return "bagages";
    }

    @GetMapping("/ajouterBagage")
    public String showAddBagageForm(Model model) {
        model.addAttribute("bagages", new Bagage());
        return "ajouterBagage";
    }

    @PostMapping("/ajouterBagage")
    public String addBagage(@ModelAttribute("bagages") Bagage bagage) {
       bagageManager.addBagage(bagage);
        return "redirect:/bagages";
    }

    @GetMapping("/editBagage")
    public String editBagage(Model model, @RequestParam(name = "id") Integer id) {
        Bagage bagage = bagageManager.getBagageById(id);
        if (bagage != null) {
            model.addAttribute("bagageToBeUpdated", bagage);
            return "editBagage";
        } else {
            return "error";
        }
    }
    @PostMapping("/editBagage")
    public String updateBagage(Model model,@RequestParam(name = "poids") double poids,
                                 @RequestParam(name = "id") Integer id,

                                 @RequestParam(name = "description") String description,
                                    @RequestParam(name = "etiquette") String etiquette) {

        Bagage bagage=new Bagage(id,poids,description,etiquette,null);
        bagageManager.updateBagage(bagage);
        return "redirect:bagages";
    }
    @GetMapping("deleteBagage")
    public String deleteBagage(@RequestParam(name = "id") Integer id) {
        bagageManager.deleteBagageByID(id);
        return "redirect:bagages";

    }
}
