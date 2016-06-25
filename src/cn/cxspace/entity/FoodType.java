package cn.cxspace.entity;

/**
 * Created by cxspace on 16-6-25.
 *
 * 菜系模块，实体类设计
 *
 */
public class FoodType {
    private int id;
    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
