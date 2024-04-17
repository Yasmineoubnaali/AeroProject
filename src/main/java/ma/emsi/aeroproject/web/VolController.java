package ma.emsi.aeroproject.web;

import ma.emsi.aeroproject.dao.entities.Vol;
import ma.emsi.aeroproject.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vols")
public class VolController {

    @Autowired
    private VolService volService;

    @GetMapping
    public String getAllVols(Model model) {
        List<Vol> vols = volService.getAllVols();
        model.addAttribute("vols", vols);
        return "vols";
    }
}
