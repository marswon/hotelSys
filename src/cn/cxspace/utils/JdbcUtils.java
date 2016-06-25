package cn.cxspace.utils;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * Created by cxspace on 16-6-25.
 */
public class JdbcUtils {

    //初始化连接池
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }

    static {
        dataSource = new ComboPooledDataSource();
    }

    /*
     创建DbUtil常用工具类对象
     */

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }



}
