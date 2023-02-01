package com.accday18.PagenFilter.v1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PnfRepo extends JpaRepository<PnfModel, Integer>
{

	List<PnfModel> findByStatus(String s);

}
