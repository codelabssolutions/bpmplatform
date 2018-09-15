package com.bpmplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bpmplatform.model.NotificationDetails;
import com.bpmplatform.model.User;
/**
 * @author Dhiraj
 *
 */
@Repository("notifcationRepository")
public interface NotifcationRepository extends JpaRepository<NotificationDetails, Long> {

	  @Query("SELECT nd FROM NotificationDetails nd WHERE nd.userXnotification.notificationOwner = ?1 ")
	  List<NotificationDetails>  findNotificationDetailsByUser(User user);
}
