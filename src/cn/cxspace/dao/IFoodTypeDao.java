package cn.cxspace.dao;

import cn.cxspace.entity.FoodType;

import java.util.List;

/**
 * Created by cxspace on 16-6-25.
 * dao接口设计
 * 功能设计
 *
 * 只设计，不实现，就像C语言头文件声明
 *
 */
public interface IFoodTypeDao {

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
