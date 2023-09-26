package com.obrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.obrs.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	
	@Query("SELECT a FROM Admin a WHERE a.adminName=:adminName")
	Admin findByAdminName(String adminName);
   /* @Query("SELECT a FROM Admin a WHERE a.adminname = :username")
    Admin findByUsername(@Param("username") String username);*/

	//Admin findByAdminName(String adminName);

}

/*import com.obrs.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByUsername(String adminname);
    // Add custom query methods if needed

	//com.obrs.serviceimpl.Admin findByUsername(String adminname);
}
*/
