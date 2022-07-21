package com.springmvc.testmvc.controller;

import com.springmvc.testmvc.dao.BrandDAO;
import com.springmvc.testmvc.dao.ProductDAO;
import com.springmvc.testmvc.model.BrandModel;
import com.springmvc.testmvc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private BrandDAO brandDAO;

    @ModelAttribute
    public void common(Model model) {
        model.addAttribute("listBrand", brandDAO.findAll());
    }

    @GetMapping(value = "/product/list")
    public ModelAndView getListProduct() {
        ModelAndView modelAndView = new ModelAndView("product/listProduct");
        modelAndView.addObject("listProduct", productDAO.findAll());
        return modelAndView;
    }

    @GetMapping("/product/update")
    public ModelAndView getUpdateProduct(@RequestParam(value = "id") int idProduct) {
        ModelAndView modelAndView = new ModelAndView("product/updateProduct");
        modelAndView.addObject("findOneProduct", productDAO.findById(idProduct));
        return modelAndView;
    }

    @PostMapping("/product/update")
    public String updateProduct(@RequestParam(value = "newName") String nameProduct,
                                @RequestParam(value = "newCreateDate") String dateProduct,
                                @RequestParam(value = "newBrand") int brandId,
                                @RequestParam(value = "id") int id,
                                @RequestParam(value = "image") MultipartFile multipartFile,
                                HttpServletRequest request) { //request
        String getFileName = null;
        if (!(multipartFile.isEmpty())) { // check thử có tải file lên ko?
            String fileName = multipartFile.getOriginalFilename(); // lấy lại tên gốc của file
            getFileName = productDAO.getFileNameServer(fileName); // đặt lại cái tên
            File fileRoot = productDAO.pathFile(getFileName, "template/img", request); // tạo đường dẫn để lưu file
            try {
                multipartFile.transferTo(fileRoot); // cho phép lưu ảnh dô server
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        productDAO.updateProduct(ProductModel.builder()
                                             .id(id)
                                             .brandModel(BrandModel.builder()
                                                                   .id(brandId)
                                                                   .build())
                                             .createDate(dateProduct)
                                             .image(getFileName)
                                             .nameProduct(nameProduct)
                                             .build());
        return "redirect:/product/list";
    }

    @GetMapping("/product/add")
    public ModelAndView getAddProduct() {
        ModelAndView modelAndView = new ModelAndView("product/addProduct");
        return modelAndView;
    }

    @PostMapping("/product/add")
    public String postAddProduct(@RequestParam(value = "name") String nameProduct,
                                 @RequestParam(value = "date") String dateProduct,
                                 @RequestParam(value = "brand_id") int idProduct,
                                 @RequestParam(value = "image") MultipartFile multipartFile,
                                 HttpServletRequest request) {
        String getFile = null;
        if (!(multipartFile.isEmpty())) { // check thử có tải file lên ko?
            String fileName = multipartFile.getOriginalFilename(); // lấy lại tên gốc của file
            getFile = productDAO.getFileNameServer(fileName); // đặt lại c ái tên
            File fileRoot = productDAO.pathFile(getFile, "template/img", request); // tạo đường dẫn để lưu file
            try {
                multipartFile.transferTo(fileRoot); // cho phép lưu ảnh dô server
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        productDAO.addProduct(ProductModel.builder()
                                          .nameProduct(nameProduct)
                                          .brandModel(BrandModel.builder().id(idProduct).build())
                                          .createDate(dateProduct)
                                          .image(getFile)
                                          .build());
        return "redirect:/product/list";
    }


}
