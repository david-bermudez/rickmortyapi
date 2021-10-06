package com.rickmorty.api.controller;

import org.springframework.web.bind.annotation.*;

import com.rickmorty.api.model.format.CalculateSumResponse;
import com.rickmorty.api.model.format.HappyNumberRequest;
import com.rickmorty.api.model.format.HappyNumberResponse;
import com.rickmorty.api.utils.Utils;


@RestController
public class UtilsController {

	private Utils utils = new Utils();
    //private RickMortyRepository rickMortyRepository;

    /*@Autowired
    public UtilsController(RickMortyRepository bookingRepository){
        this.rickMortyRepository = bookingRepository;
    }*/

    @RequestMapping(value = "/utils/happynumbers", method = RequestMethod.POST)
    public HappyNumberResponse happyNumbers(@RequestBody HappyNumberRequest happyNumberRequest){
        return utils.getHappyNumbers(happyNumberRequest);
    }
    
    @RequestMapping(value = "/utils/calculateSum/{number}", method = RequestMethod.POST)
    public CalculateSumResponse calculateSum(@PathVariable Integer number){    	
        return utils.calculateSum(number);
    }
}