package dao.impl;

import commom.DBUtiliy;
import dao.CategoryDAO;
import entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CategoryDaoImpl implements CategoryDAO {
    @Override
    public boolean addCategory(Category category) {
        boolean result = false;
        // tao doi tuong
        Connection conn = null;
        // tao doi tuong de thuc thi voi SQL
        PreparedStatement pstmt = null;
        try{
            //ket noi voi DB
            conn = DBUtiliy.getConnection();
            // tao cau lenh them du lieu vao bang
            String sql = "insert into Category(cate_id,cate_name,status) valus (?,?,?)";
            // tao pre
            pstmt = conn.prepareStatement(sql);

            // gan dau ?
            pstmt.setString(1, category.getCate_id());
            pstmt.setString(2, category.getCate_name());
            pstmt.setBoolean(3,category.isStatus());

            // thuc thi lenh them
            int row = pstmt.executeUpdate();
            if(row>0){
                result = true;
            }else {
                result = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtiliy.close(conn , null , pstmt);
        }
        return result;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }
    @Override
    public boolean deleteCategory(String category_id) {
        return false;
    }
}
