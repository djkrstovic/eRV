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
            return "update";
        }


    }


}
