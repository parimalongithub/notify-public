package com.example.notify.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.notify.Entity.ApiDataResponse;

@Component
public class Sceduled_task {

    @Autowired
    private userService  Userservice;

    @Autowired 
    private serpapiservices serpapiservices;

    @Autowired
    private emailServices emailServices;

    private String subject="Hey You're Favourite Artist  is Performing!!!!";

    private String Email;

    




    @Scheduled(fixedDelay = 15 * 24 * 60 * 60 * 1000) 
    public void myScheduledMethod() {

        List <String > listArtist= Userservice.getArtist();
        List <String > listcity= Userservice.getCity();
        List <String > listEmail= Userservice.getEmail();


        for (int i = 0; i < listArtist.size(); i++){
            serpapiservices.Artist=listArtist.get(i);
            serpapiservices.City=listcity.get(i);
            Email=listEmail.get(i);
            ApiDataResponse apidataresponse=serpapiservices.searchEvents();
            if(apidataresponse.getEvents_results()!=null){
                ApiDataResponse.EventsResult eventResult = apidataresponse.getEvents_results().get(0);
                try {
                    String emailBody = "<html><body>" +
                           "<h2>Event Details:</h2>" +
                           "<h3><strong>Title:</strong> " + eventResult.getTitle() + "</h3>" +
                           "<h3><strong>Date:</strong> " + eventResult.getDate().toString() + "</h3>" +
                           "<h3><strong>Address:</strong> " + String.join(", ", eventResult.getAddress().toString()) + "</h3>" +
                           "<h3><strong>Link:</strong> <a href='" + eventResult.getLink() + "'>" + eventResult.getLink() + "</a></h3>" +
                           "</body></html>";
                   emailServices.sendEmail(Email, subject ,emailBody, eventResult.getThumbnail());
                      } catch (Exception e) {
                                  System.out.println(e);
                  }










            
            }

        }
      


            

            



        }





        

       
    }



    

