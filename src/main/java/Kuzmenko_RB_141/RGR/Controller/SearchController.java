package Kuzmenko_RB_141.RGR.Controller;

import Kuzmenko_RB_141.RGR.Model.InvatersModel;
import Kuzmenko_RB_141.RGR.Service.searchForInvaters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    searchForInvaters searchForInvaters;

    @PostMapping(value = "/api/searchForInvaters", produces="application/json")
    public  List<Map<String,String>> searchForInvaters(@RequestBody InvatersModel data){
        return searchForInvaters.search(data);
    }
}
