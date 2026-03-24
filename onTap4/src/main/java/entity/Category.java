package entity;

public class Category {
    private String cate_id;
    private String cate_name;
    private boolean status;

    public Category() {}

    public Category(String cate_id, String cate_name, boolean status) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.status = false;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cate_id='" + cate_id + '\'' +
                ", cate_name='" + cate_name + '\'' +
                ", status=" + status +
                '}';
    }
}
