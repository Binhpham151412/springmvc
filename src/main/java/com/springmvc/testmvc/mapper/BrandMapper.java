package com.springmvc.testmvc.mapper;

import com.springmvc.testmvc.model.BrandModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapper
    implements RowMapper<BrandModel> {
    @Override
    public BrandModel mapRow(final ResultSet rs, final int rowNum)
        throws SQLException {
        return BrandModel.builder()
                         .id(rs.getInt("id"))
                         .nameBrand(rs.getString("nameBrand"))
                         .build();
    }
}
