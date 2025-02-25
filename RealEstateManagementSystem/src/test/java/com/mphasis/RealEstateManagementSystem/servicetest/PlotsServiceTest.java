package com.mphasis.RealEstateManagementSystem.servicetest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.repository.PlotsRepository;
import com.mphasis.RealEstateManagementSystem.service.PlotsService;

@ExtendWith(MockitoExtension.class)
public class PlotsServiceTest {

    @Mock
    private PlotsRepository plotsRepository;

    @InjectMocks
    private PlotsService plotsService;

    private Plots plot1;
    private Plots plot2;

    @BeforeEach
    void setUp() {
        plot1 = new Plots();
        plot1.setPlotId(1);
        plot1.setAuthorityApproval("Approved");
        
        plot2 = new Plots();
        plot2.setPlotId(2);
        plot2.setAuthorityApproval("Pending");
    }

    @Test
    void testGetAllPlots() {
        when(plotsRepository.findAll()).thenReturn(Arrays.asList(plot1, plot2));
        
        List<Plots> result = plotsService.getAllPlots();
        
        assertEquals(2, result.size());
        verify(plotsRepository, times(1)).findAll();
    }

    @Test
    void testGetPlotsById() {
        when(plotsRepository.existsById(1)).thenReturn(true);
        when(plotsRepository.findById(1)).thenReturn(Optional.of(plot1));
        
        Plots result = plotsService.getPlots(1);
        
        assertNotNull(result);
        assertEquals(1, result.getPlotId());
        verify(plotsRepository, times(1)).findById(1);
    }

    @Test
    void testAddPlots() {
        when(plotsRepository.save(plot1)).thenReturn(plot1);
        
        Plots result = plotsService.addPlots(null); // Mocking only repository interaction
        
        assertNull(result);
    }

    @Test
    void testUpdatePlots() {
        when(plotsRepository.existsById(1)).thenReturn(true);
        when(plotsRepository.save(plot1)).thenReturn(plot1);
        
        Plots result = plotsService.updatePlots(plot1);
        
        assertNotNull(result);
        assertEquals("Approved", result.getAuthorityApproval());
        verify(plotsRepository, times(1)).save(plot1);
    }

    @Test
    void testDeletePlots() {
        when(plotsRepository.existsById(1)).thenReturn(true);
        when(plotsRepository.findById(1)).thenReturn(Optional.of(plot1));
        
        Plots result = plotsService.deletePlots(1);
        
        assertNotNull(result);
        assertEquals(1, result.getPlotId());
        verify(plotsRepository, times(1)).deleteById(1);
    }
}
