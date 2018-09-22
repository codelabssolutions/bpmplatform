package com.bpmplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bpmplatform.model.NotificationDetails;
/**
 * @author Dhiraj
 *
 */
@Repository("notifcationRepository")
public interface NotifcationRepository extends JpaRepository<NotificationDetails, Long> {
}
