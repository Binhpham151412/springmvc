package com.springmvc.testmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {
    private int id;
    private String nameProduct;
    private BrandModel brandModel;
    private String createDate;
}
