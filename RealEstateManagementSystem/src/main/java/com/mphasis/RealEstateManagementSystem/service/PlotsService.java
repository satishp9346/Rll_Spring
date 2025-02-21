package com.mphasis.RealEstateManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.dto.PlotDTO;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.PlotsRepository;

@Service
public class PlotsService {
	@Autowired
	PlotsRepository plotsRepo;
	public List<Plots> getAllPlots(){
		return plotsRepo.findAll();
	}
	public Plots getPlots(int plotId) {
		if(plotsRepo.existsById(plotId)) 
			return plotsRepo.findById(plotId).get();
		return null;
	}
	public Plots addPlots(PlotDTO plot) {
		Plots plots=new Plots();
		plots.setAuthorityApproval(plot.getAuthorityApproval());
		plots.setFloorsAllowed(plot.getFloorsAllowed());
		plots.setNoOfOpenSides(plot.getNoOfOpenSides());
		plots.setBoundaryWalls(plot.getBoundaryWalls());
		plots.setCommPropDetails(plot.getCommonPropertyDetails());
		plots.setSeller(plot.getSeller());
		if(plotsRepo.save(plots)!=null)
			return plots;
		return null;
	}
	public Plots updatePlots(Plots plot) {
		if(plotsRepo.existsById(plot.getPlotId()))
			return plotsRepo.save(plot);
		return null;
	}
	public Plots deletePlots(int plotId) {
		if(plotsRepo.existsById(plotId)){
			Plots plot=plotsRepo.findById(plotId).get();
			plotsRepo.deleteById(plotId);
			return plot;
		}
		return null;
	}
	public List<Plots> searchPropertyByCity(String city){
		return plotsRepo.searchPropertyByCity(city);
	}
}
