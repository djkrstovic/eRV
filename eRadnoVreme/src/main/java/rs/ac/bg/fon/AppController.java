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
 // KOEFICIJENT

    @Autowired
    private KoeficijentDao daoKo;

    @RequestMapping("/koeficijent")
    public String viewHomePageKoeficijent(Model modelKo){

        List<Koeficijent> listKoeficijent = daoKo.list();
        modelKo.addAttribute("listKoeficijent", listKoeficijent);

        return "/koeficijent";

    }

    @RequestMapping("/newKoeficijent")
    public String showNewFormKo(Model modelKo){
        Koeficijent koeficijent = new Koeficijent();
        modelKo.addAttribute("koeficijent", koeficijent);
        return "new_koeficijent";

    }

    @RequestMapping(value="/saveKoeficijent", method = RequestMethod.POST)
    public String saveKo(@ModelAttribute("koeficijent") Koeficijent koeficijent){
        daoKo.saveKo(koeficijent);

        return "redirect:/koeficijent";
    }

    @RequestMapping("/editKoeficijent/{ID_KOEFICIJENT}")
    public ModelAndView showEditFormKo(@PathVariable(name = "ID_KOEFICIJENT") long ID_KOEFICIJENT){
        ModelAndView mavKo = new ModelAndView("edit_koeficijent");
        Koeficijent koeficijent = daoKo.getKo(ID_KOEFICIJENT);
        mavKo.addObject("koeficijent", koeficijent);

        return mavKo;
    }


    @RequestMapping(value="/updateKoeficijent", method = RequestMethod.POST)
    public String updateKo(@ModelAttribute("koeficijent") Koeficijent koeficijent) {
        daoKo.updateKo(koeficijent);
        return "redirect:/koeficijent";
    }

    @RequestMapping("/deleteKoeficijent/{ID_KOEFICIJENT}")
    public String deleteKo(@PathVariable(name = "ID_KOEFICIJENT") long ID_KOEFICIJENT) {
        daoKo.deleteKo(ID_KOEFICIJENT);
        return "redirect:/koeficijent";
    }

//Radno mesto

    @Autowired
    private RadnoMestoDao daoRM;

    @RequestMapping("/radnoMesto")
    public String viewHomePageRadnoMesto(Model modelRM){

        List<RadnoMesto> listRadnoMesto = daoRM.list();
        modelRM.addAttribute("listRadnoMesto", listRadnoMesto);

        return "/radnoMesto";

    }

    @RequestMapping("/newRadnoMesto")
    public String showNewFormRM(Model modelRM){
        RadnoMesto radnoMesto = new RadnoMesto();
        modelRM.addAttribute("radnoMesto", radnoMesto);
        return "new_radnoMesto";

    }

    @RequestMapping(value="/saveRadnoMesto", method = RequestMethod.POST)
    public String saveRM(@ModelAttribute("radnoMesto") RadnoMesto radnoMesto){
        daoRM.saveRM(radnoMesto);

        return "redirect:/radnoMesto";
    }

    @RequestMapping("/editRadnoMesto/{ID_RADNO_MESTO}")
    public ModelAndView showEditFormRM(@PathVariable(name = "ID_RADNO_MESTO") long ID_RADNO_MESTO){
        ModelAndView mavRM = new ModelAndView("edit_radnoMesto");
        RadnoMesto radnoMesto = daoRM.getRM(ID_RADNO_MESTO);
        mavRM.addObject("radnoMesto", radnoMesto);

        return mavRM;
    }


    @RequestMapping(value="/updateRadnoMesto", method = RequestMethod.POST)
    public String updateRM(@ModelAttribute("radnoMesto") RadnoMesto radnoMesto) {
        daoRM.updateRM(radnoMesto);
        return "redirect:/radnoMesto";
    }

    @RequestMapping("/deleteRadnoMesto/{ID_RADNO_MESTO}")
    public String deleteRM(@PathVariable(name = "ID_RADNO_MESTO") long ID_RADNO_MESTO) {
        try {
            daoRM.deleteRM(ID_RADNO_MESTO);
            return "redirect:/radnoMesto";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_delRM.html";
        }
    }

    // MESECNA EVIDENCIJA
    @Autowired
    private MesecnaEvidencijaDao daoME;

    @RequestMapping("/mesecnaEvidencija")
    public String viewHomePageMesecnaEvidencija(Model modelME){

        List<MesecnaEvidencija> listMesecnaEvidencija = daoME.list();
        modelME.addAttribute("listMesecnaEvidencija", listMesecnaEvidencija);

        return "/mesecnaEvidencija";

    }

    @RequestMapping("/newMesecnaEvidencija")
    public String showNewFormME(Model modelME){
        MesecnaEvidencija mesecnaEvidencija = new MesecnaEvidencija();
        modelME.addAttribute("mesecnaEvidencija", mesecnaEvidencija);
        return "new_mesecnaEvidencija";

    }

    @RequestMapping(value="/saveMesecnaEvidencija", method = RequestMethod.POST)
    public String saveME(@ModelAttribute("mesecnaEvidencija") MesecnaEvidencija mesecnaEvidencija){
        daoME.saveME(mesecnaEvidencija);

        return "redirect:/mesecnaEvidencija";
    }

    @RequestMapping("/editMesecnaEvidencija/{ID_MESECNA_EVIDENCIJA}")
    public ModelAndView showEditFormME(@PathVariable(name = "ID_MESECNA_EVIDENCIJA") long ID_MESECNA_EVIDENCIJA){
        ModelAndView mavME = new ModelAndView("edit_mesecnaEvidencija");
        MesecnaEvidencija mesecnaEvidencija = daoME.getME(ID_MESECNA_EVIDENCIJA);
        mavME.addObject("mesecnaEvidencija", mesecnaEvidencija);

        return mavME;
    }


    @RequestMapping(value="/updateMesecnaEvidencija", method = RequestMethod.POST)
    public String updateME(@ModelAttribute("mesecnaEvidencija") MesecnaEvidencija mesecnaEvidencija) {
        daoME.updateME(mesecnaEvidencija);
        return "redirect:/mesecnaEvidencija";
    }

    @RequestMapping("/deleteMesecnaEvidencija/{ID_MESECNA_EVIDENCIJA}")
    public String deleteME(@PathVariable(name = "ID_MESECNA_EVIDENCIJA") long ID_MESECNA_EVIDENCIJA) {
        try {
            daoME.deleteME(ID_MESECNA_EVIDENCIJA);
            return "redirect:/mesecnaEvidencija";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_delME.html";
        }
    }

    // OSTVARENI CASOVI
    @Autowired
    private OstvareniCasoviDao daoOC;

    @RequestMapping("/ostvareniCasovi")
    public String viewHomePageOstvareniCasovi(Model modelOC){

        List<OstvareniCasovi> listOstvareniCasovi = daoOC.list();
        modelOC.addAttribute("listOstvareniCasovi", listOstvareniCasovi);

        return "/ostvareniCasovi";

    }

    @RequestMapping("/newOstvareniCasovi")
    public String showNewFormOC(Model modelOC){
        OstvareniCasovi ostvareniCasovi = new OstvareniCasovi();
        modelOC.addAttribute("ostvareniCasovi", ostvareniCasovi);
        return "new_ostvareniCasovi";

    }

    @RequestMapping(value="/saveOstvareniCasovi", method = RequestMethod.POST)
    public String saveOC(@ModelAttribute("ostvareniCasovi") OstvareniCasovi ostvareniCasovi){
        try{
            daoOC.saveOC(ostvareniCasovi);
            return "redirect:/ostvareniCasovi";
        }catch(DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_OCP.html";
        }

    }

    @RequestMapping("/editOstvareniCasovi/{ID_OSTVARENI_CASOVI}")
    public ModelAndView showEditFormOC(@PathVariable(name = "ID_OSTVARENI_CASOVI") long ID_OSTVARENI_CASOVI){
        ModelAndView mavOC = new ModelAndView("edit_ostvareniCasovi");
        OstvareniCasovi ostvareniCasovi = daoOC.getOC(ID_OSTVARENI_CASOVI);
        mavOC.addObject("ostvareniCasovi", ostvareniCasovi);

        return mavOC;
    }


    @RequestMapping(value="/updateOstvareniCasovi", method = RequestMethod.POST)
    public String updateOC(@ModelAttribute("ostvareniCasovi") OstvareniCasovi ostvareniCasovi) {
        try {
            daoOC.updateOC(ostvareniCasovi);
            return "redirect:/ostvareniCasovi";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_UMN_OC.html";
        }
    }

    @RequestMapping("/deleteOstvareniCasovi/{ID_OSTVARENI_CASOVI}")
    public String deleteOC(@PathVariable(name = "ID_OSTVARENI_CASOVI") long ID_OSTVARENI_CASOVI) {
        try {
            daoOC.deleteOC(ID_OSTVARENI_CASOVI);
            return "redirect:/ostvareniCasovi";
        }catch (DataAccessException da){
            System.out.println("Greska: " + da.getCause());
            return "../error/error_delOC.html";
        }
    }

}
