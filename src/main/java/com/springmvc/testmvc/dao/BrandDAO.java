package com.springmvc.testmvc.dao;

import com.springmvc.testmvc.mapper.BrandMapper;
import com.springmvc.testmvc.model.BrandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BrandDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<BrandModel> findAll() {
        String sql = "select * from brand";
        return jdbcTemplate.query(sql, new BrandMapper());
    }

    public BrandModel findById(int id) {
        String sql = "select * from brand where id = ?";
        return jdbcTemplate.queryForObject(sql, new BrandMapper(), id);
    }

    public int addBrand(final BrandModel brandModel) {
        String sql = "insert into brand(nameBrand) values (?)";
        try {
            jdbcTemplate.update(sql, brandModel.getNameBrand());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public void update(BrandModel brandModel) {
        String sql = "update brand set nameBrand = ? where id =?";
        jdbcTemplate.update(sql, brandModel.getNameBrand(), brandModel.getId());
    }
}
