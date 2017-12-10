package Kuzmenko_RB_141.RGR.Service;

import Kuzmenko_RB_141.RGR.Model.InvatersModel;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class searchForInvaters {
    public List<Map<String,String>> search(InvatersModel data){

        int x, y, count = 0;
        int InvaterNum = 1;
        List<Map<String,String>> res = new ArrayList<>();

        String[] map = data.getMap().split("\n");

        List<String[]> invatersBody = new ArrayList<>();
        for (int i = 0; i<3; i++){
            invatersBody.add(data.getInvaters().get(i).get("map").split("\n"));
        }


        for( String[] invater : invatersBody ){
            for( y = 0; y < map.length-invater.length-1; y++){
                for(x = 0; x<map[y].length()-invater[0].length()-1; x++){
                    for(int i = 0; i<invater.length; i++){
                        for(int j = 0; j<invater[i].length();j++){
                            if(map[i+y].charAt(j+x) == invater[i].charAt(j)){
                                count ++;
                            }
                        }
                    }
                    int acceptablePointsCount = Integer.parseInt(data.getInvaters().get(InvaterNum-1).get("acceptablePointsCount"));
                    if(count >= (data.getInvaters().get(InvaterNum-1).get("map").length()- acceptablePointsCount) ){
                        Map<String,String> OneInvater = new HashMap<>();
                        OneInvater.put("name","INVADER_" + InvaterNum);
                        OneInvater.put("x", ""+x);
                        OneInvater.put("y", ""+y);
                        res.add(OneInvater);

                        count = 0;
                    }else { count = 0;}
                }

            }
            InvaterNum++;
        }



        return res;
    }
}
