package com.mphasis.RealEstateManagementSystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mphasis.RealEstateManagementSystem.entity.Apartment;
import com.mphasis.RealEstateManagementSystem.entity.Plots;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.ApartmentRepository;
import com.mphasis.RealEstateManagementSystem.repository.PlotsRepository;
import com.mphasis.RealEstateManagementSystem.repository.PropertyRepository;
import com.mphasis.RealEstateManagementSystem.repository.VillaRepository;
import com.mphasis.RealEstateManagementSystem.service.PropertyService;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private PropertyRepository propertyRepository;
    
    @Mock
    private ApartmentRepository apartmentRepository;
    
    @Mock
    private PlotsRepository plotsRepository;
    
    @Mock
    private VillaRepository villaRepository;
    
    @InjectMocks
    private PropertyService propertyService;
    
    private List<Apartment> apartments;
    private List<Plots> plots;
    private List<Villa> villas;
    
    @BeforeEach
    void setUp() {
        apartments = Arrays.asList(new Apartment());
        plots = Arrays.asList(new Plots());
        villas = Arrays.asList(new Villa());
    }

    @Test
    void testGetPropertyDetailsForApartment() {
        when(apartmentRepository.findApartmentsByStatus()).thenReturn(apartments);
        List<?> result = propertyService.getPropertyDetails("apartment");
        assertEquals(apartments, result);
        verify(apartmentRepository, times(1)).findApartmentsByStatus();
    }
    
    @Test
    void testGetPropertyDetailsForPlot() {
        when(plotsRepository.findPlotsByStatus()).thenReturn(plots);
        List<?> result = propertyService.getPropertyDetails("plot");
        assertEquals(plots, result);
        verify(plotsRepository, times(1)).findPlotsByStatus();
    }
    
    @Test
    void testGetPropertyDetailsForVilla() {
        when(villaRepository.findVillaByStatus()).thenReturn(villas);
        List<?> result = propertyService.getPropertyDetails("villa");
        assertEquals(villas, result);
        verify(villaRepository, times(1)).findVillaByStatus();
    }
    
    @Test
    void testGetPropertyDetailsForInvalidType() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            propertyService.getPropertyDetails("invalid");
        });
        assertEquals("Invalid property type: invalid", exception.getMessage());
    }
}
