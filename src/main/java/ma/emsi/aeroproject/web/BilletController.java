package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Bagage;
import ma.emsi.aeroproject.dao.entities.Billet;
import ma.emsi.aeroproject.service.BilletManager;
import ma.emsi.aeroproject.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BilletController {

    @Autowired
    private BilletManager billetManager;

    @GetMapping("/billets")
    public String getAllBillets(Model model) {
        List<Billet> billets = billetManager.getAllBillets();
        model.addAttribute("billets", billets);
        return "billets";
    }
    @GetMapping("ajouterBillet")
    public String showAddBilletForm(Model model) {
        model.addAttribute("billets", new Billet());
        return "ajouterBillet";
    }

    @PostMapping("ajouterBillet")
    public String addBillet(@ModelAttribute("billets") Billet billet) {
        billetManager.addBillet(billet);
        return "redirect:/billets";
    }

    @GetMapping("/editBillet")
    public String editBillet(Model model, @RequestParam(name = "id") Integer id) {
        Billet billet = billetManager.getBilletById(id);
        if (billet != null) {
            model.addAttribute("billetToBeUpdated", billet);
            return "editBillet";
        } else {
            return "error";
        }
    }
    @PostMapping("/editBillet")
    public String updateBillet(Model model,@RequestParam(name = "prix") double prix,
                               @RequestParam(name = "id") Integer id,

                               @RequestParam(name = "numeroSiege") String numeroSiege,
                               @RequestParam(name = "classeSiege") String classeSiege,
                               @RequestParam(name = "nomPassager") String nomPassager,
                               @RequestParam(name = "prenomPassager") String prenomPassager,
                               @RequestParam(name = "numeroPasseport") String numeroPasseport) {

        Billet billet=new Billet(id,numeroSiege,classeSiege,nomPassager,prenomPassager,numeroPasseport,prix);
        billetManager.updateBillet(billet);
        return "redirect:billets";
    }
    @GetMapping("deleteBillet")
    public String deleteBagage(@RequestParam(name = "id") Integer id) {
        billetManager.deleteBilletByID(id);
        return "redirect:billets";

    }
}