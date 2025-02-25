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
import com.mphasis.RealEstateManagementSystem.entity.Admin;
import com.mphasis.RealEstateManagementSystem.repository.AdminRepository;
import com.mphasis.RealEstateManagementSystem.service.AdminService;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {
    
    @Mock
    private AdminRepository adminRepo;
    
    @InjectMocks
    private AdminService adminService;
    
    private Admin admin1;
    private Admin admin2;
    
    @BeforeEach
    void setUp() {
        admin1 = new Admin();
        admin1.setAdminId(1);
        
        admin2 = new Admin();
        admin2.setAdminId(2);
    }
    
    @Test
    void testGetAllAdmin() {
        List<Admin> adminList = Arrays.asList(admin1, admin2);
        when(adminRepo.findAll()).thenReturn(adminList);
        
        List<Admin> result = adminService.getAllAdmin();
        
        assertEquals(2, result.size());
        verify(adminRepo, times(1)).findAll();
    }
    
    @Test
    void testGetAdmin_WhenAdminExists() {
        when(adminRepo.existsById(1)).thenReturn(true);
        when(adminRepo.findById(1)).thenReturn(Optional.of(admin1));
        
        Admin result = adminService.getAdmin(1);
        
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        verify(adminRepo, times(1)).existsById(1);
        verify(adminRepo, times(1)).findById(1);
    }
    
    @Test
    void testGetAdmin_WhenAdminDoesNotExist() {
        when(adminRepo.existsById(3)).thenReturn(false);
        
        Admin result = adminService.getAdmin(3);
        
        assertNull(result);
        verify(adminRepo, times(1)).existsById(3);
    }
    
    @Test
    void testAddAdmin() {
        when(adminRepo.save(admin1)).thenReturn(admin1);
        
        Admin result = adminService.addAdmin(admin1);
        
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        verify(adminRepo, times(1)).save(admin1);
    }
    
    @Test
    void testUpdateAdmin_WhenAdminExists() {
        when(adminRepo.existsById(1)).thenReturn(true);
        when(adminRepo.save(admin1)).thenReturn(admin1);
        
        Admin result = adminService.updateAdmin(admin1);
        
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        verify(adminRepo, times(1)).existsById(1);
        verify(adminRepo, times(1)).save(admin1);
    }
    
    @Test
    void testUpdateAdmin_WhenAdminDoesNotExist() {
        when(adminRepo.existsById(3)).thenReturn(false);
        
        Admin result = adminService.updateAdmin(admin1);
        
        assertNull(result);
        verify(adminRepo, times(1)).existsById(1);
    }
    
    @Test
    void testDeleteAdmin_WhenAdminExists() {
        when(adminRepo.existsById(1)).thenReturn(true);
        when(adminRepo.findById(1)).thenReturn(Optional.of(admin1));
        doNothing().when(adminRepo).deleteById(1);
        
        Admin result = adminService.deleteAdmin(1);
        
        assertNotNull(result);
        assertEquals(1, result.getAdminId());
        verify(adminRepo, times(1)).existsById(1);
        verify(adminRepo, times(1)).findById(1);
        verify(adminRepo, times(1)).deleteById(1);
    }
    
    @Test
    void testDeleteAdmin_WhenAdminDoesNotExist() {
        when(adminRepo.existsById(3)).thenReturn(false);
        
        Admin result = adminService.deleteAdmin(3);
        
        assertNull(result);
        verify(adminRepo, times(1)).existsById(3);
    }
}
