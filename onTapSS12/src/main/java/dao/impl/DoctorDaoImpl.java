package dao.impl; // package chứa class cài đặt DAO

import comom.DBUtility; // class hỗ trợ mở và đóng kết nối database
import dao.DoctorDAO; // interface định nghĩa các phương thức CRUD
import entity.Doctor; // entity đại diện cho bảng doctors

import java.sql.*; // thư viện JDBC
import java.util.ArrayList; // dùng để tạo danh sách
import java.util.List; // interface danh sách

// class cài đặt các phương thức trong DoctorDAO
public class DoctorDaoImpl implements DoctorDAO {

    // ================= CREATE =================
    // phương thức thêm bác sĩ vào database
    @Override
    public boolean createDoctor(Doctor doctor) {

        boolean result = false; // biến lưu kết quả thêm thành công hay không

        Connection conn = null; // đối tượng kết nối database
        PreparedStatement pst = null; // đối tượng thực thi câu SQL có tham số

        try {

            // mở kết nối đến database
            conn = DBUtility.getConnection();

            // câu lệnh SQL thêm dữ liệu vào bảng doctors
            String sql = "INSERT INTO doctors(doctor_name,gender,birthday,specialty,year_work_in) VALUES(?,?,?,?,?)";

            // tạo PreparedStatement từ câu SQL
            pst = conn.prepareStatement(sql);

            // gán giá trị vào dấu ? trong câu SQL
            pst.setString(1, doctor.getDoctorName()); // tham số 1 = tên bác sĩ
            pst.setBoolean(2, doctor.getGender()); // tham số 2 = giới tính
            pst.setDate(3, new java.sql.Date(doctor.getBirthday().getTime())); // tham số 3 = ngày sinh
            pst.setString(4, doctor.getSpecialty()); // tham số 4 = chuyên khoa
            pst.setInt(5, doctor.getYearWorkIn()); // tham số 5 = năm làm việc

            // thực thi câu lệnh INSERT
            int row = pst.executeUpdate();

            // nếu có ít nhất 1 dòng bị ảnh hưởng thì thêm thành công
            if (row > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace(); // in lỗi ra console
        } finally {
            // đóng kết nối và giải phóng tài nguyên
            DBUtility.close(conn, pst, null);
        }

        return result; // trả về kết quả
    }


    // ================= READ =================
    // phương thức lấy danh sách bác sĩ
    @Override
    public List<Doctor> getDoctors() {

        List<Doctor> list = new ArrayList<>(); // tạo danh sách chứa doctor

        Connection conn = null; // kết nối database
        PreparedStatement pst = null; // thực thi câu SQL
        ResultSet rs = null; // chứa kết quả truy vấn

        try {

            // mở kết nối
            conn = DBUtility.getConnection();

            // câu SQL lấy toàn bộ dữ liệu
            String sql = "SELECT * FROM doctors";

            // chuẩn bị câu lệnh SQL
            pst = conn.prepareStatement(sql);

            // thực thi truy vấn
            rs = pst.executeQuery();

            // duyệt từng dòng dữ liệu trong ResultSet
            while (rs.next()) {

                Doctor d = new Doctor(); // tạo object doctor

                // lấy dữ liệu từ database gán vào object
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setDoctorName(rs.getString("doctor_name"));
                d.setGender(rs.getBoolean("gender"));
                d.setBirthday(rs.getDate("birthday"));
                d.setSpecialty(rs.getString("specialty"));
                d.setYearWorkIn(rs.getInt("year_work_in"));

                // thêm object doctor vào danh sách
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace(); // in lỗi
        } finally {
            // đóng kết nối
            DBUtility.close(conn, pst, rs);
        }

        return list; // trả về danh sách bác sĩ
    }


    // ================= UPDATE =================
    // phương thức cập nhật thông tin bác sĩ
    @Override
    public boolean updateDoctor(Doctor doctor) {

        boolean result = false; // kết quả cập nhật

        Connection conn = null; // kết nối database
        PreparedStatement pst = null; // thực thi SQL

        try {

            // mở kết nối
            conn = DBUtility.getConnection();

            // câu SQL cập nhật tên và chuyên khoa theo id
            String sql = "UPDATE doctors SET doctor_name=?, specialty=? WHERE doctor_id=?";

            // tạo PreparedStatement
            pst = conn.prepareStatement(sql);

            // gán giá trị vào ?
            pst.setString(1, doctor.getDoctorName()); // tên bác sĩ
            pst.setString(2, doctor.getSpecialty()); // chuyên khoa
            pst.setInt(3, doctor.getDoctorId()); // id bác sĩ

            // thực thi update
            int row = pst.executeUpdate();

            // nếu update thành công
            if (row > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết nối
            DBUtility.close(conn, pst, null);
        }

        return result; // trả kết quả
    }


    // ================= DELETE =================
    // phương thức xóa bác sĩ theo id
    @Override
    public boolean deleteDoctor(int id) {

        boolean result = false; // kết quả xóa

        Connection conn = null; // kết nối database
        PreparedStatement pst = null; // thực thi SQL

        try {

            // mở kết nối
            conn = DBUtility.getConnection();

            // câu SQL xóa
            String sql = "DELETE FROM doctors WHERE doctor_id=?";

            // tạo PreparedStatement
            pst = conn.prepareStatement(sql);

            // gán id vào ?
            pst.setInt(1, id);

            // thực thi câu lệnh DELETE
            int row = pst.executeUpdate();

            // nếu xóa thành công
            if (row > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết nối
            DBUtility.close(conn, pst, null);
        }

        return result; // trả kết quả
    }
}