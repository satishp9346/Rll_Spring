package com.mphasis.RealEstateManagementSystem.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.RealEstateManagementSystem.entity.TempImages;
import com.mphasis.RealEstateManagementSystem.repository.TempImageRepository;
//@Service
public class TempImageService {

    @Autowired
    private TempImageRepository tempImagesRepository;

    // Save image
    public TempImages saveImage(TempImages tempImages) {
        return tempImagesRepository.save(tempImages);
    }

    // Get image by ID
    public TempImages getImage(int id) {
        return tempImagesRepository.findById(id).orElse(null);
    }

    // Get all images
    public List<TempImages> getAllImages() {
        return tempImagesRepository.findAll();
    }

    // Remove image by ID
    public void removeImage(int id) {
        tempImagesRepository.deleteById(id);
    }

    // Update image
//    public TempImages updateImage(int id, Blob imgBlob) {
//        TempImages tempImages = tempImagesRepository.findById(id).orElse(null);
//        if (tempImages != null) {
//            tempImages.s(imgBlob);
//            return tempImagesRepository.save(tempImages);
//        }
//        return null;
//    }
}
