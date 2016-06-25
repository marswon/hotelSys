package cn.cxspace.servlet;

import cn.cxspace.entity.FoodType;
import cn.cxspace.factory.BeanFactory;
import cn.cxspace.service.IFoodTypeService;
import cn.cxspace.service.impl.FoodTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

/**
 * Created by cxspace on 16-6-25.
 *
 * 1.添加菜系
 * 2.菜系列表展示
 *
 */

public class FoodTypeServlet extends HttpServlet {

    private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);

    private Object uri;

    RequestDispatcher dispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取操作类型
         String method = request.getParameter("method");

         if ("addFoodType".equals(method)){
               addFoodType(request,response);
         }

         else if("list".equals(method)) {
             list(request, response);
         }

        else if ("viewUpdate".equals(method))
         {
             viewUpdate(request,response);
         }

         else if ("delete".equals(method)){
             delete(request,response);
         }

         else if ("update".equals(method))
         {
             update(request,response);
         }
    }

    //添加菜系
    public void addFoodType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //1.获取请求数据封装
            String foodTypeName = request.getParameter("foodTypeName");

            FoodType ft = new FoodType();
            ft.setTypeName(foodTypeName);

            //2.调用service处理业务逻辑
            foodTypeService.save(ft);

            //3.跳转uri
            uri = request.getRequestDispatcher("/FoodType?method=list");

        }catch (Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }

        goTo(request,response,uri);


    }

    //菜系列表展示
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //调用service查询所有类别
            List<FoodType> list = foodTypeService.getAll();

            request.setAttribute("listFoodType", list);

            //跳到菜系列表页面
            uri = request.getRequestDispatcher("/sys/type/foodtype_list.jsp");

        }catch (Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);
    }

    public void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            //获取请求id
            String id = request.getParameter("id");
            //根据id查询对象
            FoodType ft = foodTypeService.findById(Integer.parseInt(id));
            //保存
            request.setAttribute("foodType", ft);
            //跳转
            uri = request.getRequestDispatcher("/sys/type/foodtype_update.jsp");
        }catch (Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
        }
        goTo(request,response,uri);

 }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

             String id = request.getParameter("id");

             foodTypeService.delete(Integer.parseInt(id));

             uri = "/FoodType?method=list";
         }catch (Exception e){
             e.printStackTrace();
             uri="/error/error.jsp";
         }

        goTo(request,response,uri);

    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("foodTypeName");
            FoodType foodType = new FoodType();
            foodType.setId(id);
            foodType.setTypeName(name);

            foodTypeService.update(foodType);

            uri = "/FoodType?method=list";

           } catch (Exception e){
            e.printStackTrace();
            uri="/error/error.jsp";
          }

         goTo(request,response,uri);

    }

     private void goTo(HttpServletRequest request, HttpServletResponse response , Object uri) throws ServletException, IOException {

         if (uri instanceof RequestDispatcher){
             ((RequestDispatcher)uri).forward(request,response);
         }else if (uri instanceof String){
             response.sendRedirect(request.getContextPath()+uri);
         }
     }
}
