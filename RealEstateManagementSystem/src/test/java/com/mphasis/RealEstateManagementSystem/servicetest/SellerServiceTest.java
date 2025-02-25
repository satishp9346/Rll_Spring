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

import com.mphasis.RealEstateManagementSystem.entity.Seller;
import com.mphasis.RealEstateManagementSystem.repository.SellerRepository;
import com.mphasis.RealEstateManagementSystem.service.SellerService;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    
    @Mock
    private SellerRepository sellerRepo;
    
    @InjectMocks
    private SellerService sellerService;
    
    private Seller seller1, seller2;
    
    @BeforeEach
    void setUp() {
        seller1 = new Seller();
        seller1.setSellerId(1);
        
        seller2 = new Seller();
        seller2.setSellerId(2);
    }
    
    @Test
    void testGetAllSellers() {
        when(sellerRepo.findAll()).thenReturn(Arrays.asList(seller1, seller2));
        List<Seller> sellers = sellerService.getAllSeller();
        assertEquals(2, sellers.size());
        verify(sellerRepo, times(1)).findAll();
    }
    
    @Test
    void testGetSellerByIdExists() {
        when(sellerRepo.existsById(1)).thenReturn(true);
        when(sellerRepo.findById(1)).thenReturn(Optional.of(seller1));
        Seller foundSeller = sellerService.getSeller(1);
        assertNotNull(foundSeller);
        assertEquals(1, foundSeller.getSellerId());
    }
    
    @Test
    void testGetSellerByIdNotExists() {
        when(sellerRepo.existsById(3)).thenReturn(false);
        Seller foundSeller = sellerService.getSeller(3);
        assertNull(foundSeller);
    }
    
    @Test
    void testAddSeller() {
        when(sellerRepo.save(seller1)).thenReturn(seller1);
        Seller savedSeller = sellerService.addSeller(seller1);
        assertNotNull(savedSeller);
        assertEquals(1, savedSeller.getSellerId());
    }
    
    @Test
    void testUpdateSellerExists() {
        when(sellerRepo.existsById(1)).thenReturn(true);
        when(sellerRepo.save(seller1)).thenReturn(seller1);
        Seller updatedSeller = sellerService.updateSeller(seller1);
        assertNotNull(updatedSeller);
        assertEquals(1, updatedSeller.getSellerId());
    }
    
    @Test
    void testUpdateSellerNotExists() {
        when(sellerRepo.existsById(1)).thenReturn(false);
        Seller updatedSeller = sellerService.updateSeller(seller1);
        assertNull(updatedSeller);
    }
    
    @Test
    void testDeleteSellerExists() {
        when(sellerRepo.existsById(1)).thenReturn(true);
        when(sellerRepo.findById(1)).thenReturn(Optional.of(seller1));
        doNothing().when(sellerRepo).deleteById(1);
        
        Seller deletedSeller = sellerService.deleteSeller(1);
        assertNotNull(deletedSeller);
        assertEquals(1, deletedSeller.getSellerId());
        verify(sellerRepo, times(1)).deleteById(1);
    }
    
    @Test
    void testDeleteSellerNotExists() {
        when(sellerRepo.existsById(1)).thenReturn(false);
        Seller deletedSeller = sellerService.deleteSeller(1);
        assertNull(deletedSeller);
    }
}