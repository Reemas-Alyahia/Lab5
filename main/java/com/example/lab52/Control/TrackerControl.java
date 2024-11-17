package com.example.lab52.Control;

import com.example.lab52.ApiResponse.ApiResponse;
import com.example.lab52.Model.Tracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerControl {
    ArrayList<Tracker> trackers=new ArrayList<>();

    @PostMapping("/addT")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
        trackers.add(tracker);
   return new ApiResponse("Successfully added tracker");
    }
    @GetMapping("/get")
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index,@RequestBody Tracker tracker) {
        trackers.set(index, tracker);
   return new ApiResponse("Successfully updated tracker");
    }

    @DeleteMapping("/delet/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
        trackers.remove(index);
   return new ApiResponse("Successfully deleted tracker"); }


////Change the project status as done or not done
@PutMapping("/change/{index}")
public ApiResponse changStatus(@PathVariable int index ,@RequestParam String status ) {
    if(index<trackers.size()&&trackers.get(index).getStatus().equals("not done")) {
        trackers.get(index).setStatus("done");
    }
        return new ApiResponse("Successfully changed tracker");
    }


//Search for a project by given title
    @GetMapping("/search")
    public Tracker search (@RequestParam String title){
        for(Tracker t:trackers){
            if(t.getTitle().toLowerCase().contains(title.toLowerCase())){
                  return t;
            }
            }
            return null; }

    //Display All project for one company by companyName
    @GetMapping("/company")
    public ArrayList<Tracker> getcompany(@RequestParam String company) {
        ArrayList<Tracker> search=new ArrayList<>();
        for(Tracker t:trackers){
            if(t.getCompanyName().toLowerCase().contains(company.toLowerCase())){
                search.add(t);
            }
        }
   return search; }
}
