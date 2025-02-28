package com.mphasis.RealEstateManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.dto.PlotDTO;
import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.service.PlotsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/plots")
public class PlotsController {
	@Autowired
	PlotsService plotServ;

//    @PostMapping("/add")
//    public ResponseEntity<?> addPlots(@RequestPart("plot") PlotDTO plotDTO, 
//                                      @RequestPart("commonPropertyDetails.images") List<MultipartFile> imageFiles) {
//        plotDTO.getCommonPropertyDetails().setImages(imageFiles);
//        Plots newPlot = plotServ.addPlots(plotDTO);
//        if (newPlot != null) {
//            return new ResponseEntity<Plots>(newPlot, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>("Sorry, Plot could not be added.", HttpStatus.NOT_FOUND);
//        }
//    }
	@PutMapping("/addToFav")
    public String addToFav(@RequestParam int plotId, @RequestParam int buyerId) {
        plotServ.addBuyerToFavFor(plotId, buyerId);
        return "Buyer added to favorites successfully.";
    }
	@GetMapping("/favFor/{buyerId}")
    public List<Plots> getVillaByBuyerIdInFavFor(@PathVariable int buyerId) {
        return plotServ.getVillaByBuyerIdInFavFor(buyerId);
    }
	@GetMapping("/viewed/{buyerId}")
    public List<Plots> getPlotsByBuyerIdInViewedBy(@PathVariable int buyerId) {
        return plotServ.getPlotsByBuyerIdInViewedBy(buyerId);
    }

    @PutMapping("/addToViewed")
    public String addToViewedBy(@RequestParam int plotId, @RequestParam int buyerId) {
        plotServ.addBuyerToViewedBy(plotId, buyerId);
        return "Buyer added to viewed list successfully.";
    }
	@PostMapping("/add")
	public ResponseEntity<?> addPlots(@RequestBody PlotDTO plot) {
		if(plotServ.addPlots(plot)!=null)
			return new ResponseEntity<PlotDTO>(plot,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Plots Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/search_by_city")
	public ResponseEntity<?> searchPropertyByCity(String city) {
		List<Plots>	plotList=plotServ.searchPropertyByCity(city);
		if(!plotList.isEmpty())
			return new ResponseEntity<List<Plots>>(plotList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Plots Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatePlots(@PathVariable("id") int plotId, @RequestBody Plots plot) {
		if(plotServ.getPlots(plotId).getPlotId()==plotId) {
			plotServ.updatePlots(plot);
			return new ResponseEntity<Plots>(plot,HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Sorry Plots does not Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("")
	public ResponseEntity<?> getAllPlots() {
		List<Plots> plotList=plotServ.getAllPlots();
		if(!plotList.isEmpty())
			return new ResponseEntity<List<Plots>>(plotList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Plotss Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/unsold")
	public ResponseEntity<?> getUnsoldPlots() {
		List<Plots> plotList=plotServ.getUnsoldPlots();
		if(!plotList.isEmpty())
			return new ResponseEntity<List<Plots>>(plotList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Plotss Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/sold")
	public ResponseEntity<?> getSoldPlots(@RequestParam("buyerId") int buyerId) {
		List<Plots> plotList=plotServ.getSoldPlots(buyerId);
		if(!plotList.isEmpty())
			return new ResponseEntity<List<Plots>>(plotList,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry No Plotss Exists.",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPlots(@PathVariable("id") int plotId) {
		Plots plot=plotServ.getPlots(plotId);
		if(plot!=null)
			return new ResponseEntity<Plots>(plot,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Plots does not Exists.",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePlots(@PathVariable("id") int plotId) {
		Plots plot=plotServ.deletePlots(plotId);
		if(plot!=null)
			return new ResponseEntity<Plots>(plot,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry Plots does not Exists.",HttpStatus.NOT_FOUND);
	}
}
