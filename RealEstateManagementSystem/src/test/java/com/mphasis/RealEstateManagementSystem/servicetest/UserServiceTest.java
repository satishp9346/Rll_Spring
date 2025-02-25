package com.mphasis.RealEstateManagementSystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mphasis.RealEstateManagementSystem.entity.Buyer;
import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;
import com.mphasis.RealEstateManagementSystem.repository.*;
import com.mphasis.RealEstateManagementSystem.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepo;
    
    @Mock
    private AdminRepository adminRepo;
    
    @Mock
    private BuyerRepository buyerRepo;
    
    @Mock
    private SellerRepository sellerRepo;
    
    @Mock
    private PropertyManagerRepository propertyManagerRepo;
    
    @Mock
    private UserCommonDetailsRepository userCommonDetailsRepo;
    
    @InjectMocks
    private UserService userService;
    
    private User user;
    private UserCommonDetails userCommonDetails;
    
    @BeforeEach
    void setUp() {
        user = new User();
        user.setUserId(1);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("BUYER");
        
        userCommonDetails = new UserCommonDetails();
    }
    
    @Test
    void testAddUser() {
        when(buyerRepo.save(any())).thenReturn(null);
        boolean result = userService.addUser(user, userCommonDetails);
        assertTrue(result);
    }
    
    @Test
    void testUpdateUserExists() {
        when(buyerRepo.findByUserId(1)).thenReturn(Optional.of(new Buyer()));
        boolean result = userService.updateUser(user, userCommonDetails);
        assertTrue(result);
    }
    
    @Test
    void testUpdateUserNotExists() {
        when(buyerRepo.findByUserId(1)).thenReturn(Optional.empty());
        boolean result = userService.updateUser(user, userCommonDetails);
        assertFalse(result);
    }
    
    @Test
    void testCheckUserExists() {
        when(userRepo.checkUser("test@example.com", "password")).thenReturn(user);
        when(userCommonDetailsRepo.findByUserId(1)).thenReturn(userCommonDetails);
        assertNotNull(userService.checkUser("test@example.com", "password"));
    }
    
    @Test
    void testCheckUserNotExists() {
        when(userRepo.checkUser("wrong@example.com", "password")).thenReturn(null);
        assertNull(userService.checkUser("wrong@example.com", "password"));
    }
}
