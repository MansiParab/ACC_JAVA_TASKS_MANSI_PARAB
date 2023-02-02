package com.accday22.AwsFileUd.v1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwsRepo extends JpaRepository<AwsModel, Integer> {

	void deleteByfilename(String fileName);

	AwsModel findByfilename(String fileName);

}
