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

import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.repository.BuyerRepository;
import com.mphasis.RealEstateManagementSystem.service.BuyerService;

@ExtendWith(MockitoExtension.class)
class BuyerServiceTest {

    @Mock
    private BuyerRepository buyerRepo;

    @InjectMocks
    private BuyerService buyerService;

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
        buyer.setBuyerId(1);
    }

    @Test
    void testGetAllBuyer() {
        List<Buyer> buyers = Arrays.asList(buyer);
        when(buyerRepo.findAll()).thenReturn(buyers);
        
        List<Buyer> result = buyerService.getAllBuyer();
        
        assertEquals(1, result.size());
        verify(buyerRepo, times(1)).findAll();
    }

    @Test
    void testGetBuyer_WhenExists() {
        when(buyerRepo.existsById(1)).thenReturn(true);
        when(buyerRepo.findById(1)).thenReturn(Optional.of(buyer));
        
        Buyer result = buyerService.getBuyer(1);
        
        assertNotNull(result);
        assertEquals(1, result.getBuyerId());
        verify(buyerRepo, times(1)).findById(1);
    }

    @Test
    void testGetBuyer_WhenNotExists() {
        when(buyerRepo.existsById(1)).thenReturn(false);
        
        Buyer result = buyerService.getBuyer(1);
        
        assertNull(result);
    }

    @Test
    void testAddBuyer() {
        when(buyerRepo.save(buyer)).thenReturn(buyer);
        
        Buyer result = buyerService.addBuyer(buyer);
        
        assertNotNull(result);
        assertEquals(1, result.getBuyerId());
        verify(buyerRepo, times(1)).save(buyer);
    }

    @Test
    void testUpdateBuyer_WhenExists() {
        when(buyerRepo.existsById(1)).thenReturn(true);
        when(buyerRepo.save(buyer)).thenReturn(buyer);
        
        Buyer result = buyerService.updateBuyer(buyer);
        
        assertNotNull(result);
        verify(buyerRepo, times(1)).save(buyer);
    }

    @Test
    void testUpdateBuyer_WhenNotExists() {
        when(buyerRepo.existsById(1)).thenReturn(false);
        
        Buyer result = buyerService.updateBuyer(buyer);
        
        assertNull(result);
    }

    @Test
    void testDeleteBuyer_WhenExists() {
        when(buyerRepo.existsById(1)).thenReturn(true);
        when(buyerRepo.findById(1)).thenReturn(Optional.of(buyer));
        
        Buyer result = buyerService.deleteBuyer(1);
        
        assertNotNull(result);
        verify(buyerRepo, times(1)).deleteById(1);
    }

    @Test
    void testDeleteBuyer_WhenNotExists() {
        when(buyerRepo.existsById(1)).thenReturn(false);
        
        Buyer result = buyerService.deleteBuyer(1);
        
        assertNull(result);
        verify(buyerRepo, never()).deleteById(1);
    }
}
