package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Billet;
import ma.emsi.aeroproject.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/billets")
public class BilletController {

    @Autowired
    private BilletService billetService;

    @GetMapping
    public String getAllBillets(Model model) {
        List<Billet> billets = billetService.getAllBillets();
        model.addAttribute("billets", billets);
        return "billets";
    }
}
