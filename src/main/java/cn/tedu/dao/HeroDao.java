package cn.tedu.dao;

import cn.tedu.entity.Hero;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDao {


    public List<Hero> findAll() {
        ArrayList<Hero>list = new ArrayList<Hero>();
        try (Connection conn= DBUtils.getConn()
        ){
            String sql="select id,name,type,money from hero";
            Statement s=conn.createStatement();
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()) {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String type = rs.getString(3);
                int money=rs.getInt(4);
                list.add(new Hero(id,name,type,money));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
