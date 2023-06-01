package com.example.demo.repository;

import com.example.demo.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author thangncph26123
 */
@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
