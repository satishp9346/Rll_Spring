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

import com.mphasis.RealEstateManagementSystem.dto.VillaDTO;
import com.mphasis.RealEstateManagementSystem.entity.Villa;
import com.mphasis.RealEstateManagementSystem.repository.VillaRepository;
import com.mphasis.RealEstateManagementSystem.service.VillaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@ExtendWith(MockitoExtension.class)
class VillaServiceTest {

    @Mock
    private VillaRepository villaRepo;

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private VillaService villaService;

    private Villa villa;

    @BeforeEach
    void setUp() {
        villa = new Villa();
        villa.setIdividualId(1);
        villa.setType("Luxury Villa");
    }

    @Test
    void testGetAllIndividualHouse() {
        when(villaRepo.findAll()).thenReturn(Arrays.asList(villa));
        List<Villa> result = villaService.getAllIndividualHouse();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testGetIndividualHouse_Exists() {
        when(villaRepo.existsById(1)).thenReturn(true);
        when(villaRepo.findById(1)).thenReturn(Optional.of(villa));
        Villa result = villaService.getIndividualHouse(1);
        assertNotNull(result);
        assertEquals("Luxury Villa", result.getType());
    }

    @Test
    void testGetIndividualHouse_NotExists() {
        when(villaRepo.existsById(1)).thenReturn(false);
        Villa result = villaService.getIndividualHouse(1);
        assertNull(result);
    }

    @Test
    void testAddBuyerToFavFor() {
        when(villaRepo.findById(1)).thenReturn(Optional.of(villa));
        villaService.addBuyerToFavFor(1, 101);
        assertTrue(villa.getFavFor().contains(101));
        verify(villaRepo).save(villa);
    }

    @Test
    void testAddBuyerToViewedBy() {
        when(villaRepo.findById(1)).thenReturn(Optional.of(villa));
        villaService.addBuyerToViewedBy(1, 102);
        assertTrue(villa.getViwedBy().contains(102));
        verify(villaRepo).save(villa);
    }

    @Test
    void testGetVillaByBuyerIdInFavFor() {
        when(villaRepo.getVillaByBuyerIdInFavFor(101)).thenReturn(Arrays.asList(villa));
        List<Villa> result = villaService.getVillaByBuyerIdInFavFor(101);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testGetVillaByBuyerIdInViewedBy() {
        when(villaRepo.getVillaByBuyerIdInViewedBy(102)).thenReturn(Arrays.asList(villa));
        List<Villa> result = villaService.getVillaByBuyerIdInViewedBy(102);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testGetUnsoldVillas() {
        when(villaRepo.getUnsoldVillas()).thenReturn(Arrays.asList(villa));
        List<Villa> result = villaService.getUnsoldVillas();
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void testGetSoldVillas() {
        when(villaRepo.getSoldVillas(201)).thenReturn(Arrays.asList(villa));
        List<Villa> result = villaService.getSoldVillas(201);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}