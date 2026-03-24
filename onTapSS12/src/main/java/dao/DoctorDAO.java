package dao;

import entity.Doctor;
import java.util.List;

public interface DoctorDAO {

    // thêm bác sĩ
    boolean createDoctor(Doctor doctor);

    // lấy danh sách bác sĩ
    List<Doctor> getDoctors();

    // cập nhật bác sĩ
    boolean updateDoctor(Doctor doctor);

    // xóa bác sĩ
    boolean deleteDoctor(int id);
}