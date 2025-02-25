package com.mphasis.RealEstateManagementSystem.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.mphasis.RealEstateManagementSystem.entity.Address;
import com.mphasis.RealEstateManagementSystem.repository.AddressRepository;
import com.mphasis.RealEstateManagementSystem.service.AddressService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    private Address address1, address2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        address1 = new Address(1, "123", "Main St", "New York", "NY District", "10001", "New York", "USA");
        address2 = new Address(2, "456", "Second St", "Los Angeles", "LA District", "90001", "California", "USA");
    }

    @Test
    void testGetAllAddress() {
        when(addressRepository.findAll()).thenReturn(Arrays.asList(address1, address2));

        List<Address> addresses = addressService.getAllAddress();

        assertNotNull(addresses);
        assertEquals(2, addresses.size());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void testGetAddress_Found() {
        when(addressRepository.existsById(1)).thenReturn(true);
        when(addressRepository.findById(1)).thenReturn(Optional.of(address1));

        Address result = addressService.getAddress(1);

        assertNotNull(result);
        assertEquals(1, result.getAddressId());
        assertEquals("New York", result.getCity());
        verify(addressRepository, times(1)).existsById(1);
        verify(addressRepository, times(1)).findById(1);
    }

    @Test
    void testGetAddress_NotFound() {
        when(addressRepository.existsById(3)).thenReturn(false);

        Address result = addressService.getAddress(3);

        assertNull(result);
        verify(addressRepository, times(1)).existsById(3);
        verify(addressRepository, never()).findById(3);
    }

    @Test
    void testAddAddress() {
        when(addressRepository.save(address1)).thenReturn(address1);

        Address result = addressService.addAddress(address1);

        assertNotNull(result);
        assertEquals("New York", result.getCity());
        verify(addressRepository, times(1)).save(address1);
    }

    @Test
    void testUpdateAddress_Success() {
        when(addressRepository.existsById(1)).thenReturn(true);
        when(addressRepository.save(address1)).thenReturn(address1);

        Address result = addressService.updateAddress(address1);

        assertNotNull(result);
        assertEquals("New York", result.getCity());
        verify(addressRepository, times(1)).existsById(1);
        verify(addressRepository, times(1)).save(address1);
    }

    @Test
    void testUpdateAddress_NotFound() {
        when(addressRepository.existsById(3)).thenReturn(false);

        Address result = addressService.updateAddress(address1);

        assertNull(result);
        verify(addressRepository, times(1)).existsById(1);
        verify(addressRepository, never()).save(address1);
    }

    @Test
    void testDeleteAddress_Success() {
        when(addressRepository.existsById(1)).thenReturn(true);
        when(addressRepository.findById(1)).thenReturn(Optional.of(address1));

        Address result = addressService.deleteAddress(1);

        assertNotNull(result);
        assertEquals("New York", result.getCity());
        verify(addressRepository, times(1)).existsById(1);
        verify(addressRepository, times(1)).findById(1);
        verify(addressRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteAddress_NotFound() {
        when(addressRepository.existsById(3)).thenReturn(false);

        Address result = addressService.deleteAddress(3);

        assertNull(result);
        verify(addressRepository, times(1)).existsById(3);
        verify(addressRepository, never()).deleteById(3);
    }
}
