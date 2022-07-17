package com.springmvc.testmvc.mapper;

import com.springmvc.testmvc.model.BrandModel;
import com.springmvc.testmvc.model.ProductModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListProductMapper
    implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(final ResultSet rs, final int rowNum)
        throws SQLException {
        return ProductModel.builder()
                           .id(rs.getInt("pid"))
                           .nameProduct(rs.getString("pname"))
                           .brandModel(BrandModel.builder()
                                                 .id(rs.getInt("bid"))
                                                 .nameBrand(rs.getString("bname"))
                                                 .build())
                           .createDate(rs.getString("createdate"))
                           .build();
    }
}
