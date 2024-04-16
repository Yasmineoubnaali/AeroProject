package ma.emsi.aeroproject.web;
import ma.emsi.aeroproject.dao.entities.Client;
import ma.emsi.aeroproject.service.ClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientManager clientManager;

    @PostMapping("/ajouterClient")
    public String ajouterClient(Model model,
                                @RequestParam(name = "nomComp") String nomComp,
                                @RequestParam(name = "email") String email,
                                @RequestParam(name = "adress") String adress) {
        Client client = new Client();
        client.setNomComp(nomComp);
        client.setEmail(email);
        client.setAdress(adress);
        clientManager.addClient(client);
        return "redirect:/index";
    }

    @GetMapping("/ajouterClientPage")
    public String ajouterClient(Model model) {
        model.addAttribute("client", new Client());
        return "ajouterClient";
    }

    @GetMapping("/client")
    public String listClients(Model model) {
        List<Client> clients = clientManager.getAllClients();
        model.addAttribute("listClients", clients);
        return "index";
    }

    @GetMapping("/deleteClient")
    public String deleteClient(Model model, @RequestParam(name = "id") Integer id) {
        if (clientManager.deleteClientByID(id)) {
            return "redirect:/index";
        } else {
            return "error";
        }
    }

    @GetMapping("/editClient")
    public String editClient(Model model, @RequestParam(name = "id") Integer id) {
        Client client = clientManager.getClientById(id);
        if (client != null) {
            model.addAttribute("clientToBeUpdated", client);
            return "updateClient";
        } else {
            return "error";
        }
    }
}
