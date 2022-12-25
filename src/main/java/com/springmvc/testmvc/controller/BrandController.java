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
    public String getEditBrandId(@PathVariable("id") int id, Model model) {
        model.addAttribute("findByBrand", brandDAO.findById(id));
        return "brand/editBrand";
    }

    @PostMapping("/brand/edit/{id}")
    public String editBrand(@RequestParam(value = "nameBrand") String nameBrand, @PathVariable("id") int id) {
        brandDAO.update(BrandModel.builder()
                .id(id)
                .nameBrand(nameBrand)
                .build());
        return "redirect:/brand/list";//-> chạy đến phương thức get của brang/list
        // sai: return "brand/listBrand" -> trả về giao diện. những mình khống truyền lên object-> thiếu object dòng 32

        // chỗ này đang bị lỗi. là vì mình trả về trang brand/listBrand-> giống như nó chỉ gọi lại cái giao diện của list Brand
        // chứ không truyền tham số lên. nên bên kia không đọc dc-> không có giá trị
    }

}
