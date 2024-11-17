package com.example.lab53.Control;

import com.example.lab53.ApiResponse.ApiResponse;
import com.example.lab53.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventControl {
    ArrayList<Event> events = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
   return new ApiResponse("Event added"); }

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {

        return events;
    }
    @PutMapping("/update")
    public ApiResponse updateEvent(@PathVariable int index,@RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Event updated");
    }
    @DeleteMapping("/delet")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted");
    }
    //Change capacity
    @PutMapping("/chnageC/{index}")
    public ApiResponse changCapacity(@PathVariable int index,@RequestParam int capacity) {
       if(index<events.size()) {
           events.get(index).setCapacity(capacity);
       }

        return new ApiResponse("Event changed");
    }
    //Search for a event by given id
    @GetMapping("/search")
    public Event search(@RequestParam int id){
        for (Event event : events) {
            if(event.getId()==id){
                return event;
            }
            }
        return null;
    }



}
