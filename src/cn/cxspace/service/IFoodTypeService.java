package cn.cxspace.service;

import cn.cxspace.entity.FoodType;

import java.util.List;

/**
 * Created by cxspace on 16-6-25.
 */
public interface IFoodTypeService {

         /*
         添加
       */

    void save(FoodType foodType);

    /*
        更新
     */

    void  update(FoodType foodType);

    /*
      删除
     */

    void delete(int id);
    /*
      查询全部
     */

    List<FoodType> getAll();

    /*
     根据菜系名称查询
     */

    List<FoodType> getAll(String typeName);

    /*
      根据主键查询
     */

    FoodType findById(int id);
}
