package com.example.bengkel.controller;

import com.example.bengkel.model.KegiatanBengkel;
import com.example.bengkel.repository.KegiatanBengkelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kegiatan")
public class KegiatanBengkelController {

    @Autowired
    private KegiatanBengkelRepository repository;

    @GetMapping
    public List<KegiatanBengkel> getAllKegiatan() {
        return repository.findAll();
    }

    @PostMapping
    public KegiatanBengkel createKegiatan(@RequestBody KegiatanBengkel kegiatan) {
        return repository.save(kegiatan);
    }

    @GetMapping("/{id}")
    public KegiatanBengkel getKegiatanById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public KegiatanBengkel updateKegiatan(@PathVariable Long id, @RequestBody KegiatanBengkel kegiatanDetails) {
        KegiatanBengkel kegiatan = repository.findById(id).orElse(null);
        if (kegiatan != null) {
            kegiatan.setNamaKegiatan(kegiatanDetails.getNamaKegiatan());
            kegiatan.setDeskripsi(kegiatanDetails.getDeskripsi());
            kegiatan.setTanggal(kegiatanDetails.getTanggal());
            return repository.save(kegiatan);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteKegiatan(@PathVariable Long id) {
        repository.deleteById(id);
    }
}