package com.example.demo.repository;

import com.example.demo.entity.NhanVien;
import com.example.demo.model.request.FindNhanVienRequest;
import com.example.demo.model.response.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author thangncph26123
 */
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query(value = """
            SELECT a.id as id_nhan_vien, a.ten as ten_nhan_vien, b.ten as ten_cua_hang FROM NhanVien a Join CuaHang b ON a.idCH = b.id
            """, nativeQuery = true)
    List<NhanVienResponse> getAllNhanVien();

    // 0: sai
    // 1: đúng

    // toán tử &
    // 1 & 0 = 0
    // 0 & 0 = 0
    // 1 & 1 = 1

    // toán tử hoặc
    // 1 || 0 || 0 = 1
    // 1 || 1 = 1

    @Query(value = """
            SELECT a.id as id_nhan_vien, a.ten as ten_nhan_vien, 
            b.ten as ten_cua_hang FROM 
            NhanVien a Join CuaHang b ON a.idCH = b.id
            WHERE 
            (a.ma like %:#{#req.ma}% OR :#{#req.ma} IS NULL OR :#{#req.ma} LIKE '')
            AND
            (a.ten LIKE %:#{#req.ten}% OR :#{#req.ten} IS NULL OR :#{#req.ten} LIKE '')
            AND
            (a.sdt LIKE %:#{#req.sdt}% OR :#{#req.sdt} IS NULL OR :#{#req.sdt} LIKE '')
            """, nativeQuery = true)
    Page<NhanVienResponse> search(@Param("req") FindNhanVienRequest req, Pageable pageable);
}
