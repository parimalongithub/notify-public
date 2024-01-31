package com.example.notify.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notify.Entity.User;
import com.example.notify.Repository.userrpository;


@Service
public class userService {

    @Autowired
    private userrpository Userrpository;

    public Long User_id;


   

    public void savedata(User user){
        if(user!=null){
            Userrpository.save(user);
             User_id = user.getId();

        }

    }

    public List<String> getArtist(){
        List<User> data=(List<User>) Userrpository.findAll();
        List<String > List_Of_All_Artist=new ArrayList<>();
        for(User Data:data){
            String artist =Data.getArtistName();
            List_Of_All_Artist.add(artist);

        } 
        return List_Of_All_Artist;
    }

    public List<String> getCity(){
        List<User> data=(List<User>) Userrpository.findAll();
        List<String > List_Of_All_City=new ArrayList<>();
        for(User Data:data){
            String city =Data.getCity();
            List_Of_All_City.add(city);
        } 
        return List_Of_All_City;
    }
    public List<String> getEmail(){
        List<User> data=(List<User>) Userrpository.findAll();
        List<String > List_Of_All_Email=new ArrayList<>();

        for(User Data:data){
            String Email =Data.getEmail();
            List_Of_All_Email.add(Email);
    
        } 
        return List_Of_All_Email;
    }
    
    public User finduserbyId(Long id){
        User user=Userrpository.findById(id).get();
        return user;
    }
}









    

