package com.bpmplatform.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bpmplatform.domainobj.AjaxResponseBody;
import com.bpmplatform.domainobj.NotificationDetailsResponse;
import com.bpmplatform.domainobj.NotificationRequest;
import com.bpmplatform.model.NotificationDetails;
import com.bpmplatform.model.User;
import com.bpmplatform.model.UserXnotification;
import com.bpmplatform.repository.NotifcationRepository;
import com.bpmplatform.repository.UserXNotifcationRepository;
import com.bpmplatform.service.UserService;
import com.bpmplatform.utility.CommonUtility;

@Controller
public class NotificationController {

	@Autowired
	CommonUtility commonUtility;
	@Autowired 
    NotifcationRepository notifcationRepository;
	@Autowired
	private UserService userService;
	@Autowired 
	UserXNotifcationRepository userXnotifcationRepository;
	
	
    @PostMapping("/create/notification")
    public ResponseEntity<?> createNotificationViaAjax( @Valid @RequestBody NotificationRequest notificationRequest, Errors errors) {
    	User user = commonUtility.getUserByUserName(); //get logged in username
        AjaxResponseBody result = new AjaxResponseBody();
        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        NotificationDetails notificationDetails =new NotificationDetails();
        notificationDetails.setCreatedBy(user);
        notificationDetails.setCreatedDate(new Date());
        notificationDetails.setIsPublish(notificationRequest.getIsPublish());
        notificationDetails.setNotifcationMessage(notificationRequest.getNotifcationMessage());
        notificationDetails.setPublishDate(new Date());
        notificationDetails.setPublishBy(user);
        Random rand = new Random(); 
        // Generate random integers in range 0 to 999 
        int rand_int1 = rand.nextInt(1000); 
        notificationDetails.setNotifcationTitle("#"+rand_int1+":"+notificationRequest.getNotifcationTitle());
        notifcationRepository.save(notificationDetails);
        if(notificationRequest.getIsPublish()==true) {
        	List<User> userlist=userService.findAllUser();
        	for(User notificationOwner:userlist) {
        		UserXnotification userXnotification= new UserXnotification();
        		userXnotification.setNotificationDetails(notificationDetails);
        		userXnotification.setNotificationOwner(notificationOwner);
        		userXnotifcationRepository.save(userXnotification);
        	}
         }
       return ResponseEntity.ok(result);

    }
    @RequestMapping(value = "/admin/addnotification")
  	public String createNotification() {
  		return "/addnotification";
  	}
      
    @RequestMapping(value = "/admin/viewnotification")
   	public ModelAndView viewNotification(ModelAndView modelAndView) {
    	List<NotificationDetailsResponse> notifications = new ArrayList<>(100);
    	User user = commonUtility.getUserByUserName(); //get logged in username
		List <NotificationDetails> notficationList=notifcationRepository.findNotificationDetailsByUser(user);
		for(NotificationDetails notfication1:notficationList) {
			NotificationDetailsResponse notificationDetailsResponse =new NotificationDetailsResponse();
			notificationDetailsResponse.setNotifcationMessage(notfication1.getNotifcationMessage());
			notificationDetailsResponse.setNotifcationTitle(notfication1.getNotifcationTitle());
			notificationDetailsResponse.setNotificationId(notfication1.getId());
			notifications.add(notificationDetailsResponse);
		}
		modelAndView.addObject("notifications", notifications);
	    modelAndView.setViewName("viewnotification");
     	return modelAndView;
   }

}
