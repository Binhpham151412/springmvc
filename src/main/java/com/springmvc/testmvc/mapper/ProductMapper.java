package com.springmvc.testmvc.mapper;

import com.springmvc.testmvc.model.BrandModel;
import com.springmvc.testmvc.model.ProductModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper
    implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(final ResultSet rs, final int rowNum)
        throws SQLException {
        return ProductModel.builder()
                           .id(rs.getInt("pid"))
                           .nameProduct(rs.getString("nameProduct"))
                           .brandModel(BrandModel.builder()
                                                 .id(rs.getInt("bid"))
                                                 .build())
                           .createDate(rs.getString("createdate"))
                           .image(rs.getString("image"))
                           .build();
    }
}
