package com.example.notify.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.notify.Entity.ApiDataResponse;

import com.example.notify.Entity.User;
import com.example.notify.Service.emailServices;
import com.example.notify.Service.serpapiservices;
import com.example.notify.Service.userService;


@Controller
public class controller {
    @Autowired
    private serpapiservices serpApiService;

    @Autowired
    private  ApiDataResponse apiDataResponse;

    @Autowired
    private emailServices emailServices;

    private String Email;
    private String subject="Hey You're Favourite Artist  is Performing!!!!";



    @Autowired 
    private userService Userservice;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("userdata", new User());
        return "home";
        
    }
    @PostMapping("/submitrequest")
    public String savedata(@ModelAttribute("userdata") User user,Model model){
        Userservice.savedata(user);
         serpApiService.Artist=Userservice.finduserbyId(Userservice.User_id).getArtistName();
         serpApiService.City=Userservice.finduserbyId(Userservice.User_id).getCity();
         Email=Userservice.finduserbyId(Userservice.User_id).getEmail();

         apiDataResponse =serpApiService.searchEvents();
         if(apiDataResponse.getEvents_results()!=null){
         ApiDataResponse.EventsResult eventResult = apiDataResponse.getEvents_results().get(0);
            
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
        model.addAttribute("showSuccess", true);



         return "home";
    }














    

 
  

    
}

  

