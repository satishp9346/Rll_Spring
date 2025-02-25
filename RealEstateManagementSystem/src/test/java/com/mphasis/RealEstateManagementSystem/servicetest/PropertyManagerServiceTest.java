package com.mphasis.RealEstateManagementSystem.servicetest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mphasis.RealEstateManagementSystem.entity.PropertyManager;
import com.mphasis.RealEstateManagementSystem.repository.PropertyManagerRepository;
import com.mphasis.RealEstateManagementSystem.service.PropertyManagerService;

@ExtendWith(MockitoExtension.class)
public class PropertyManagerServiceTest {

    @Mock
    private PropertyManagerRepository propertyManagerRepository;

    @InjectMocks
    private PropertyManagerService propertyManagerService;

    private PropertyManager propertyManager;

    @BeforeEach
    void setUp() {
        propertyManager = new PropertyManager();
        propertyManager.setPropManagerid(1);
    }

    @Test
    void testGetAllPropertyManager() {
        when(propertyManagerRepository.findAll()).thenReturn(Arrays.asList(propertyManager));
        assertEquals(1, propertyManagerService.getAllPropertyManager().size());
    }

    @Test
    void testGetPropertyManager() {
        when(propertyManagerRepository.existsById(1)).thenReturn(true);
        when(propertyManagerRepository.findById(1)).thenReturn(Optional.of(propertyManager));
        assertNotNull(propertyManagerService.getPropertyManager(1));
    }

    @Test
    void testAddPropertyManager() {
        when(propertyManagerRepository.save(propertyManager)).thenReturn(propertyManager);
        assertEquals(propertyManager, propertyManagerService.addPropertyManager(propertyManager));
    }

    @Test
    void testUpdatePropertyManager() {
        when(propertyManagerRepository.existsById(1)).thenReturn(true);
        when(propertyManagerRepository.save(propertyManager)).thenReturn(propertyManager);
        assertEquals(propertyManager, propertyManagerService.updatePropertyManager(propertyManager));
    }

    @Test
    void testDeletePropertyManager() {
        when(propertyManagerRepository.existsById(1)).thenReturn(true);
        when(propertyManagerRepository.findById(1)).thenReturn(Optional.of(propertyManager));
        doNothing().when(propertyManagerRepository).deleteById(1);
        assertEquals(propertyManager, propertyManagerService.deletePropertyManager(1));
    }
}
