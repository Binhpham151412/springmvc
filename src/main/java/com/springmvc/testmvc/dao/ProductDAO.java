package com.springmvc.testmvc.dao;

import com.springmvc.testmvc.mapper.ListProductMapper;
import com.springmvc.testmvc.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDAO {
    @Autowired

    private JdbcTemplate jdbcTemplate;

    public List<ProductModel> findAll() {
        String sql = "select product.id as pid, product.nameProduct as pname, brand.nameBrand as bname"
            + ", brand.id as bid, product.createdate "
            + "from product "
            + " inner join brand on product.brand_id = brand.id ";
        return jdbcTemplate.query(sql, new ListProductMapper());
    }

    public ProductModel findById(int id) {
        String sql = "select product.id as pid, product.nameProduct as pname, brand.nameBrand as bname,"
            + " brand.id as bid, product.createdate "
            + " from product "
            + " inner join brand on product.brand_id = brand.id "
            + " where product.id = ?";
        return jdbcTemplate.queryForObject(sql, new ListProductMapper(), id);
    }

    public void addProduct(ProductModel productModel) {
        String sql = "insert into product (nameProduct, createdate, brand_id) values (?,?,?)";
        jdbcTemplate.update(sql, productModel.getNameProduct(), productModel.getCreateDate(), productModel.getBrandModel()
                                                                                                          .getId());
    }

    public void updateProduct(ProductModel productModel) {
        String sql = "update product set nameProduct = ?, createdate = ?, brand_id = ? where id = ? ";
        jdbcTemplate.update(sql, productModel.getNameProduct(), productModel.getCreateDate(),
                            productModel.getBrandModel().getId(), productModel.getId());
    }


}
