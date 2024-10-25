package aps.biometria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aps.biometria.entities.Nivel2;

@Repository
public interface Nivel2Dao extends JpaRepository<Nivel2, Integer> {

}