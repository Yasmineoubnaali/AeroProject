package ma.emsi.aeroproject.web;
import ma.emsi.aeroproject.dao.entities.Bagage;
import ma.emsi.aeroproject.dao.entities.Client;
import ma.emsi.aeroproject.service.BagageManager;
import ma.emsi.aeroproject.service.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BagageController {

    @Autowired
    private BagageManager bagageManager;

    @Autowired
    private ClientManager clientManager;

    @PostMapping("/ajouterBagage")
    public String ajouterBagage(Model model,
                                @RequestParam(name = "poids") double poids,
                                @RequestParam(name = "etiquette") String etiquette,
                                @RequestParam(name = "description") String description,
                                @RequestParam(name = "clientId") Integer clientId) {
        Bagage bagage = new Bagage();
        bagage.setPoids(poids);
        bagage.setEtiquette(etiquette);
        bagage.setDescription(description);
        Client client = clientManager.getClientById(clientId);
        if (client != null) {
            bagage.setClient(client);
            bagageManager.addBagage(bagage);
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/ajouterBagagePage")
    public String ajouterBagage(Model model) {
        List<Client> clients = clientManager.getAllClients();
        model.addAttribute("clients", clients);
        return "ajouterBagage";
    }

    @GetMapping("/bagage")
    public String listBagages(Model model) {
        List<Bagage> bagages = bagageManager.getAllBagages();
        model.addAttribute("listBagages", bagages);
        return "index";
    }

    @GetMapping("/deleteBagage")
    public String deleteBagage(Model model, @RequestParam(name = "id") Integer id) {
        if (bagageManager.deleteBagageByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editBagage")
    public String editBagage(Model model, @RequestParam(name = "id") Integer id) {
        Bagage bagage = bagageManager.getBagageById(id);
        if (bagage != null) {
            List<Client> clients = clientManager.getAllClients();
            model.addAttribute("bagageToBeUpdated", bagage);
            model.addAttribute("clients", clients);
            return "updateBagage";
        } else {
            return "error";
        }
    }
}
