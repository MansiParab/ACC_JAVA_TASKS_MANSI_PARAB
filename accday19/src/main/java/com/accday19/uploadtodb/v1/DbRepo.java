package com.accday19.uploadtodb.v1;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DbRepo extends JpaRepository<DbModel, Integer> {

	Optional<DbModel> findById(String fileId);

}
