package com.accday16.crud.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface crudoprepo extends JpaRepository<crudopmodel, Integer>{

}
