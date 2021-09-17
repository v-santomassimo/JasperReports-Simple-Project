package com.vsan.jasper.app.repository;

import org.springframework.stereotype.Repository;

import com.vsan.jasper.app.model.AnagraficaBean;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnagraficaRepository extends JpaRepository<AnagraficaBean,Integer> {

}
