package com.example.bengkel.repository;

import com.example.bengkel.model.KegiatanBengkel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KegiatanBengkelRepository extends JpaRepository<KegiatanBengkel, Long> {
}