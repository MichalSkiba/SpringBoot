package com.ms.SpringBoot.Controller;

import com.ms.SpringBoot.Model.Zamowienia;
import com.ms.SpringBoot.Validator.ZamowieniaValidator;
import com.ms.SpringBoot.service.ZamowieniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.List;

@Controller
public class ControllerZamowienia {

    @Autowired
    ZamowieniaService zamowieniaService;

    @GET
    @RequestMapping(value = "/zamowienia")
    @Secured(value = {"ROLE_ADMIN", "ROLE_SALE"})
    public String pokazZamowienia(Model model) {

        List<Zamowienia> zamowieniaList = null;
        zamowieniaList = zamowieniaService.findAll();
        model.addAttribute("zamowieniaList", zamowieniaList);
        return "zamowienia";
    }

    @GET
    @RequestMapping(value = "/zamowienia/{page}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_SALE" })
    public String showZamowieniaPageable(@PathVariable("page") int page, Model model) {
        int elements = 5;
        Page<Zamowienia> pages = zamowieniaService.findAllPages(new PageRequest(page, elements));
        int totalPages = pages.getTotalPages();
        int currentPage = pages.getNumber();
        List<Zamowienia> zamowieniaList = pages.getContent();
        model.addAttribute("zamowieniaList", zamowieniaList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        return "zamowienia";
    }

    @GET
    @RequestMapping("/nowezam")
    @Secured(value = {"ROLE_ADMIN", "ROLE_SALE"})
    public String noweZamowienie(Model model) {
        Zamowienia zamowienia = new Zamowienia();
        java.sql.Date sql = new java.sql.Date(new java.util.Date().getTime());
        zamowienia.setDataZamowienia(sql);
        zamowienia.setDataPrzyjecia(sql);
        zamowienia.setKompletne("N");
        model.addAttribute("zamowienia", zamowienia);
        return "nowezam";
    }

    @POST
    @RequestMapping("/addzam")
    @Secured(value = {"ROLE_ADMIN", "ROLE_SALE"})
    public String dodajZamowienie(Model model, Zamowienia zamowienia, BindingResult result) {

        String strona = null;

        new ZamowieniaValidator().validate(zamowienia, result);

        if (result.hasErrors()) {
            strona = "nowezam";
            model.addAttribute("zamowienia", zamowienia);
        } else {
            zamowieniaService.saveZamowienia(zamowienia);
            int elements = 5;
            int page = 0;
            Page<Zamowienia> pages = zamowieniaService.findAllPages(new PageRequest(page, elements));
            int totalPages = pages.getTotalPages();
            int currentPage = pages.getNumber();
            List<Zamowienia> zamowieniaList = pages.getContent();
            model.addAttribute("zamowieniaList", zamowieniaList);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", currentPage);
            strona = "zamowienia";
        }
        return strona;
    }
}

