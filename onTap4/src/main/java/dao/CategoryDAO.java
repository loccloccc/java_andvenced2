package dao;

import entity.Category;

import java.util.List;

public interface CategoryDAO {
    // them danh muc
    boolean addCategory(Category category);
    // lay danh sach danh muc
    List<Category> getAllCategories();
    // cap nhat danh muc
    boolean updateCategory(Category category);
    // xoa danh muc
    boolean deleteCategory(String cate_id);
}
