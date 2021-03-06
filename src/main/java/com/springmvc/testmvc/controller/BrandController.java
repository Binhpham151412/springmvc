package com.springmvc.testmvc.controller;

import com.springmvc.testmvc.dao.BrandDAO;
import com.springmvc.testmvc.model.BrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BrandController {

//    @ModelAttribute
//    public void common(final Model model) {
//        model.addAttribute("listBrand", brandDAO.findAll());
//    }

    @Autowired
    BrandDAO brandDAO;

    @GetMapping("/brand/list")
    public ModelAndView listBrand() {
        ModelAndView modelAndView = new ModelAndView("brand/listBrand");
        modelAndView.addObject("listBrand", brandDAO.findAll());
        return modelAndView;
    }

    @GetMapping("/brand/add")
    public String getAddBrand(Model model) {
//        model.addAttribute("brand", new BrandModel());
        return "brand/addBrand";
    }

    //localhost:8000/springmvc/brand/add?nameBrand=huan -> parametter
    //localhost:8000/springmvc/brand/add/huan ->localhost:8000/springmvc/brand/add/{nameBrand}
    @PostMapping("/brand/add")
    public String postAddBrand(@RequestParam(value = "nameBrand") String name) {
        int check = brandDAO.addBrand(BrandModel.builder()
                                                .nameBrand(name)
                                                .build());
        if (check > 0) {
            return "redirect:/brand/list";
        } else {
            return "redirect:/brand/add?err=1";
        }
    }

    @GetMapping("/brand/edit/{id}")
    public String getEditBrandId(@PathVariable int id, Model model) {
        model.addAttribute("findByBrand", brandDAO.findById(id));
        return "brand/editBrand";
    }

    @PostMapping("/brand/edit/{id}")
    public String editBrand(@RequestParam(value = "nameBrand") String nameBrand, @PathVariable int id) {
        brandDAO.update(BrandModel.builder()
                                  .id(id)
                                  .nameBrand(nameBrand)
                                  .build());
        return "redirect:/brand/list";//-> ch???y ?????n ph????ng th???c get c???a brang/list
        // sai: return "brand/listBrand" -> tr??? v??? giao di???n. nh???ng m??nh kh???ng truy???n l??n object-> thi???u object d??ng 32

        // ch??? n??y ??ang b??? l???i. l?? v?? m??nh tr??? v??? trang brand/listBrand-> gi???ng nh?? n?? ch??? g???i l???i c??i giao di???n c???a list Brand
        // ch??? kh??ng truy???n tham s??? l??n. n??n b??n kia kh??ng ?????c dc-> kh??ng c?? gi?? tr???
    }

}
