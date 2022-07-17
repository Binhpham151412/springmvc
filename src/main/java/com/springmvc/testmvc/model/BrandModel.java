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
public class BrandModel {
    private int id;
    private String nameBrand;

}
// có 1 vài video có dùng @Entity  (@Column(name = "tên của cột trong bàng", @Table )
// hắn có cài thư viện chi mà có sẵn extend CrudRepository để extend vô luôn  40:04
// https://www.youtube.com/watch?v=CX6Z12GwuTM  phút 36:52
