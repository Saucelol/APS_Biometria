package aps.biometria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aps.biometria.entities.Nivel1;

@Repository
public interface Nivel1Dao extends JpaRepository<Nivel1, Integer> {

}