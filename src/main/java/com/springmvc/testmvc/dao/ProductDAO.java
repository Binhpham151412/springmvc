package com.springmvc.testmvc.dao;

import com.mysql.cj.util.StringUtils;
import com.springmvc.testmvc.mapper.ListProductMapper;
import com.springmvc.testmvc.model.ProductModel;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.List;

@Repository
@Transactional
public class ProductDAO {
    @Autowired

    private JdbcTemplate jdbcTemplate;

    public List<ProductModel> findAll() {
        String sql = "select product.id as pid,product.image, product.nameProduct as pname, brand.nameBrand as bname"
            + ", brand.id as bid, product.createdate "
            + "from product "
            + " inner join brand on product.brand_id = brand.id ";
        return jdbcTemplate.query(sql, new ListProductMapper());
    }

    public ProductModel findById(int id) {
        String sql = "select product.id as pid,product.image, product.nameProduct as pname, brand.nameBrand as bname,"
            + " brand.id as bid, product.createdate "
            + " from product "
            + " inner join brand on product.brand_id = brand.id "
            + " where product.id = ?";
        return jdbcTemplate.queryForObject(sql, new ListProductMapper(), id);
    }

    public void addProduct(ProductModel productModel) {
        String sql = "insert into product (nameProduct, createdate, brand_id, image) values (?,?,?,?)";
        jdbcTemplate.update(sql, productModel.getNameProduct(),
                            productModel.getCreateDate(),
                            productModel.getBrandModel().getId(),
                            productModel.getImage());
    }

    public void updateProduct(ProductModel productModel) {
        String sql = "update product set nameProduct = ?, createdate = ?, brand_id = ?, image = ? where id = ? ";
        jdbcTemplate.update(sql, productModel.getNameProduct(), productModel.getCreateDate(),
                            productModel.getBrandModel().getId(),productModel.getImage(), productModel.getId());
    }

    public String getFileNameServer(String fileName) {
        String nameFile;
        if (!StringUtils.isNullOrEmpty(fileName)) {
            String extension = FilenameUtils.getExtension(fileName);
            String baseName = FilenameUtils.getBaseName(fileName);
            nameFile = baseName + "-" + System.nanoTime() + extension;
            return nameFile;

//            StringBuilder builder = new StringBuilder();
//            builder.append(baseName).append("_").append(System.nanoTime()).append(".").append(extension);
//            return builder.toString();
        }
        return null;
    }
//
    public File pathFile(String fileName, String folder, HttpServletRequest request) {
        String rootPath = request.getServletContext().getRealPath(""); // trả về đường dẫn tuyệt đối của web (target)
        File diary = new File(rootPath + folder); // đường dẫn folder
        if (!diary.exists()) {
            diary.mkdirs();
        }
        return new File(rootPath + folder + "/" + fileName);
    }

}
