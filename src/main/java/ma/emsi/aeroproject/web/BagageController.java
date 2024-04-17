package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Bagage;
import ma.emsi.aeroproject.service.BagageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bagages")
public class BagageController {

    @Autowired
    private BagageService bagageService;

    @GetMapping
    public String getAllBagages(Model model) {
        List<Bagage> bagages = bagageService.getAllBagages();
        model.addAttribute("bagages", bagages);
        return "bagages";
    }
}
