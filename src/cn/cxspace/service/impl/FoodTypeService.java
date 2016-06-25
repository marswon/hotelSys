package cn.cxspace.service.impl;


import cn.cxspace.dao.IFoodTypeDao;
import cn.cxspace.dao.impl.FoodTypeDao;
import cn.cxspace.entity.FoodType;
import cn.cxspace.factory.BeanFactory;
import cn.cxspace.service.IFoodTypeService;

import java.util.List;

/**
 * Created by cxspace on 16-6-25.
 */
public class FoodTypeService implements IFoodTypeService {

    //调用dao,有维护全局变量就是单例，没有全局变量，多例
   // private IFoodTypeDao foodTypeDao = new FoodTypeDao();  //对象创建，不写死，工厂模式

    private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodtypeDao" , IFoodTypeDao.class);

    @Override
    public void save(FoodType foodType) {
        try {
            foodTypeDao.save(foodType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(FoodType foodType) {
        try {
            foodTypeDao.update(foodType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
       try {
           foodTypeDao.delete(id);
       }catch (Exception e)
       {
           throw new RuntimeException(e);
       }

    }

    @Override
    public List<FoodType> getAll() {
        try {
            return foodTypeDao.getAll();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FoodType> getAll(String typeName) {

          try {
              return foodTypeDao.getAll(typeName);
          }catch (Exception e)
          {
              throw new RuntimeException(e);
          }

    }

    @Override
    public FoodType findById(int id) {
        try {
            return foodTypeDao.findById(id);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
