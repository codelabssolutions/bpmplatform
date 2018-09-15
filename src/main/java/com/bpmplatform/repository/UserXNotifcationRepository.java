package com.bpmplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bpmplatform.model.UserXnotification;
/**
 * @author Dhiraj
 *
 */
@Repository("userXnotifcationRepository")
public interface UserXNotifcationRepository extends JpaRepository<UserXnotification, Long> {
	 
}
