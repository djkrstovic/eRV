package rs.ac.bg.fon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private RadnikDao dao;
// RADNIK
    @RequestMapping("/")
    public String viewHomePage(Model model){

        List<Radnik> listRadnik = dao.list();
        model.addAttribute("listRadnik", listRadnik);

        return "index";

    }

    @RequestMapping("/new")
    public String showNewForm(Model model){
        Radnik radnik = new Radnik();
        model.addAttribute("radnik", radnik);
        return "new_radnik";

    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("radnik") Radnik radnik){
        dao.save(radnik);

        return "redirect:/";
    }

    @RequestMapping("/edit/{ID_RADNIK}")
    public ModelAndView showEditForm(@PathVariable(name = "ID_RADNIK") long ID_RADNIK){
        ModelAndView mav = new ModelAndView("edit_radnik");
        Radnik radnik = dao.get(ID_RADNIK);
        mav.addObject("radnik", radnik);

        return mav;
    }

    /**/

    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("radnik") Radnik radnik) {
        try {
            dao.update(radnik);
            return "redirect:/";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_uik.html";
        }
    }

    @RequestMapping("/delete/{ID_RADNIK}")
    public String delete(@PathVariable(name = "ID_RADNIK") int ID_RADNIK) {
        try {
            dao.delete(ID_RADNIK);
            return "redirect:/";
        }catch(DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_delR.html";
        }

    }
// KLASFIKACIJA


    @Autowired
    private KlasifikacijaDao daoK;

    @RequestMapping("/klasifikacija")
    public String viewHomePageKlasifikacije(Model modelK){

        List<Klasifikacija> listKlasifikacija = daoK.list();
        modelK.addAttribute("listKlasifikacija", listKlasifikacija);

        return "/klasifikacija";

    }

    @RequestMapping("/newKlasifikacija")
    public String showNewFormK(Model modelK){
        Klasifikacija klasifikacija = new Klasifikacija();
        modelK.addAttribute("klasifikacija", klasifikacija);
        return "new_klasifikacija";

    }

    @RequestMapping(value="/saveKlasifikacija", method = RequestMethod.POST)
    public String saveK(@ModelAttribute("klasifikacija") Klasifikacija klasifikacija){
        daoK.saveK(klasifikacija);

        return "redirect:/klasifikacija";
    }

    @RequestMapping("/editKlasfikacija/{ID_KLASIFIKACIJA_CASOVA}")
    public ModelAndView showEditFormK(@PathVariable(name = "ID_KLASIFIKACIJA_CASOVA") long ID_KLASIFIKACIJA_CASOVA){
        ModelAndView mavK = new ModelAndView("edit_klasifikacija");
        Klasifikacija klasifikacija = daoK.getK(ID_KLASIFIKACIJA_CASOVA);
        mavK.addObject("klasifikacija", klasifikacija);

        return mavK;
    }

    /**/

    @RequestMapping(value="/updateKlasifikacija", method = RequestMethod.POST)
    public String updateK(@ModelAttribute("klasifikacija") Klasifikacija klasifikacija) {
            daoK.updateK(klasifikacija);
            return "redirect:/klasifikacija";
    }

    @RequestMapping("/deleteKlasfikacija/{ID_KLASIFIKACIJA_CASOVA}")
    public String deleteK(@PathVariable(name = "ID_KLASIFIKACIJA_CASOVA") long ID_KLASIFIKACIJA_CASOVA) {
        daoK.deleteK(ID_KLASIFIKACIJA_CASOVA);
        return "redirect:/klasifikacija";
    }
// VRSTA PRIMANJA

    @Autowired
    private VrstaPrimanjaDao daoVP;

    @RequestMapping("/vrstaPrimanja")
    public String viewHomePagevrstaPrimanja(Model modelVP){

        List<VrstaPrimanja> listVrstaPrimanja = daoVP.list();
        modelVP.addAttribute("listVrstaPrimanja", listVrstaPrimanja);

        return "/vrstaPrimanja";

    }

    @RequestMapping("/newVrstaPrimanja")
    public String showNewFormVP(Model modelVP){
        VrstaPrimanja vrstaPrimanja = new VrstaPrimanja();
        modelVP.addAttribute("vrstaPrimanja", vrstaPrimanja);
        return "new_VrstaPrimanja";

    }

    @RequestMapping(value="/saveVrstaPrimanja", method = RequestMethod.POST)
    public String saveVP(@ModelAttribute("vrstaPrimanja") VrstaPrimanja vrstaPrimanja){
        daoVP.saveVP(vrstaPrimanja);

        return "redirect:/vrstaPrimanja";
    }

    @RequestMapping("/editVrstaPrimanja/{ID_VRSTA_PRIMANJA}")
    public ModelAndView showEditFormVP(@PathVariable(name = "ID_VRSTA_PRIMANJA") long ID_VRSTA_PRIMANJA){
        ModelAndView mavVP = new ModelAndView("edit_vrstaPrimanja");
        VrstaPrimanja vrstaPrimanja = daoVP.getVP(ID_VRSTA_PRIMANJA);
        mavVP.addObject("vrstaPrimanja", vrstaPrimanja);

        return mavVP;
    }

    /**/

    @RequestMapping(value="/updateVrstaPrimanja", method = RequestMethod.POST)
    public String updateVP(@ModelAttribute("vrstaPrimanja") VrstaPrimanja vrstaPrimanja) {
        try {
            daoVP.updateVP(vrstaPrimanja);
            return "redirect:/vrstaPrimanja";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_uik.html";
        }
    }

    @RequestMapping("/deleteVrstaPrimanja/{ID_VRSTA_PRIMANJA}")
    public String deleteVP(@PathVariable(name = "ID_VRSTA_PRIMANJA") long ID_VRSTA_PRIMANJA) {
        daoVP.deleteVP(ID_VRSTA_PRIMANJA);
        return "redirect:/vrstaPrimanja";
    }
}
