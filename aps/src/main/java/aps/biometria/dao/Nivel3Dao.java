package aps.biometria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aps.biometria.entities.Nivel3;

@Repository
public interface Nivel3Dao extends JpaRepository<Nivel3, Integer> {

}