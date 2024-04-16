package ma.emsi.aeroproject.web;
import ma.emsi.aeroproject.dao.entities.Billet;
import ma.emsi.aeroproject.service.BilletManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BilletController {

    @Autowired
    private BilletManager billetManager;

    @PostMapping("/ajouterBillet")
    public String ajouterBillet(Model model,
                                @RequestParam(name = "numeroSiege") String numeroSiege,
                                @RequestParam(name = "classeSiege") String classeSiege,
                                @RequestParam(name = "nomPassager") String nomPassager,
                                @RequestParam(name = "prenomPassager") String prenomPassager,
                                @RequestParam(name = "numeroPasseport") String numeroPasseport,
                                @RequestParam(name = "prix") Double prix) {
        Billet billet = new Billet();
        billet.setNumeroSiege(numeroSiege);
        billet.setClasseSiege(classeSiege);
        billet.setNomPassager(nomPassager);
        billet.setPrenomPassager(prenomPassager);
        billet.setNumeroPasseport(numeroPasseport);
        billet.setPrix(prix);
        billetManager.addBillet(billet);
        return "redirect:/index";
    }

    @GetMapping("/ajouterBilletPage")
    public String ajouterBillet(Model model) {
        model.addAttribute("billet", new Billet());
        return "ajouterBillet";
    }

    @GetMapping("/billet")
    public String listBillets(Model model) {
        List<Billet> billets = billetManager.getAllBillets();
        model.addAttribute("listBillets", billets);
        return "index";
    }

    @GetMapping("/deleteBillet")
    public String deleteBillet(Model model, @RequestParam(name = "id") Integer id) {
        if (billetManager.deleteBilletByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editBillet")
    public String editBillet(Model model, @RequestParam(name = "id") Integer id) {
        Billet billet = billetManager.getBilletById(id);
        if (billet != null) {
            model.addAttribute("billetToBeUpdated", billet);
            return "updateBillet";
        } else {
            return "error";
        }
    }
}
