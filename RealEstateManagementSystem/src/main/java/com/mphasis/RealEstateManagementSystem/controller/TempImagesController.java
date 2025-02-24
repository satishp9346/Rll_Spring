package com.mphasis.RealEstateManagementSystem.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.imaging.Imaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mphasis.RealEstateManagementSystem.entity.TempImages;
import com.mphasis.RealEstateManagementSystem.repository.TempImageRepository;
import com.mphasis.RealEstateManagementSystem.service.TempImageService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tempImages")
public class TempImagesController {

    @Autowired
    private TempImageRepository tempImagesService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
                }
 
                byte[] imgData = file.getBytes();

                TempImages tempImages = new TempImages();
                tempImages.setImgData(imgData);
                tempImagesService.save(tempImages);
            }

            return ResponseEntity.ok("Images uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
//        TempImages tempImages = tempImagesService.getImage(id);
//        if (tempImages == null || tempImages.getImgData() == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        byte[] imageData = tempImages.getImgData();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        headers.setContentLength(imageData.length);
//
//        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        List<TempImages> allImages = tempImagesService.findAll();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (TempImages tempImages : allImages) {
            Map<String, Object> imageMap = new HashMap<>();
            imageMap.put("id", tempImages.getId());
            imageMap.put("imgData", tempImages.getImgData());
            responseList.add(imageMap);
        }

        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeImage(@PathVariable int id) {
        tempImagesService.deleteById(id);
        return ResponseEntity.ok("Image removed successfully");
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateImage(@PathVariable int id, @RequestParam("image") MultipartFile file) {
//        try {
//            byte[] imgData = file.getBytes();
//
//            TempImages updatedImage = tempImagesService.updateImage(id, imgData);
//            if (updatedImage != null) {
//                return ResponseEntity.ok("Image updated successfully with ID: " + updatedImage.getId());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
//            }
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update image: " + e.getMessage());
//        }
//    }
}
//
//@RestController
//@RequestMapping("/api/tempImages")
//public class TempImagesController {
//
//    @Autowired
//    private TempImageService tempImagesService;
//
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpeg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images");
////        }
////    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
//        TempImages tempImages = tempImagesService.getImage(id);
//        if (tempImages == null || tempImages.getImgBlob() == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        byte[] imageData;
//        try {
//            imageData = tempImages.getImgBlob().getBytes(1, (int) tempImages.getImgBlob().length());
//        } catch (SQLException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        headers.setContentLength(imageData.length);
//
//        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
//    }
//
////    @GetMapping("/all")
////    public ResponseEntity<List<TempImages>> getAllImages() {
////        List<TempImages> allImages = tempImagesService.getAllImages();
////        return ResponseEntity.ok(allImages);
////    }
//    @GetMapping("/all")
//    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
//        List<TempImages> allImages = tempImagesService.getAllImages();
//        List<Map<String, Object>> responseList = new ArrayList<>();
//
//        for (TempImages tempImages : allImages) {
//            Map<String, Object> imageMap = new HashMap<>();
//            imageMap.put("id", tempImages.getId());
//            
//            byte[] imageData = null;
//            try {
//                imageData = tempImages.getImgBlob().getBytes(1, (int) tempImages.getImgBlob().length());
//            } catch (SQLException e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//            }
//            
//            imageMap.put("imgData", imageData);
//            responseList.add(imageMap);
//        }
//
//        return ResponseEntity.ok(responseList);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> removeImage(@PathVariable int id) {
//        tempImagesService.removeImage(id);
//        return ResponseEntity.ok("Image removed successfully");
//    }
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
//        try {
//            for (MultipartFile file : files) {
//                if (file.isEmpty()) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
//                }
//
//                // Check the file type
//                if (!isImageFile(file)) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is not an image");
//                }
//
//                // Log the content type and file name for debugging
//                System.out.println("Uploading file: " + file.getOriginalFilename() + ", Content type: " + file.getContentType());
//                InputStream inputStream = file.getInputStream();
//                System.out.println("InputStream available: " + inputStream.available());
//                // Using Apache Commons Imaging to read the image
//                BufferedImage originalImage = Imaging.getBufferedImage(file.getInputStream());
//                if (originalImage == null) {
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to read image: invalid image file or format not supported");
//                }
//
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
//                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
//
//                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
//
//                TempImages tempImages = new TempImages();
//                tempImages.setImgBlob(imgBlob);
//                tempImagesService.saveImage(tempImages);
//            }
//
//            return ResponseEntity.ok("Images uploaded successfully");
//        } catch (IOException | SQLException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
//        }
//    }
//
//    private boolean isImageFile(MultipartFile file) {
//        String contentType = file.getContentType();
//        return contentType != null && contentType.startsWith("image/");
//    }    
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                if (file.isEmpty()) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
////                }
////
////                // Check the file type
////                if (!isImageFile(file)) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is not an image");
////                }
////
////                // Log the content type and file name for debugging
////                System.out.println("Uploading file: " + file.getOriginalFilename() + ", Content type: " + file.getContentType());
////                System.out.println("Supported formats: " + Arrays.toString(ImageIO.getReaderFormatNames()));
////
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                System.out.println(originalImage);
////                if (originalImage == null) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to read image: invalid image file or format not supported");
////                }
////
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (IOException | SQLException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
////        }
////    }
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                if (file.isEmpty()) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
////                }
////
////                // Check the file type
////                if (!isImageFile(file)) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is not an image");
////                }
////
////                // Log the content type and file name for debugging
////                System.out.println("Uploading file: " + file.getOriginalFilename() + ", Content type: " + file.getContentType());
////
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                if (originalImage == null) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to read image: invalid image file or format not supported");
////                }
////
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (IOException | SQLException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
////        }
////    }
////
////    private boolean isImageFile(MultipartFile file) {
////        String contentType = file.getContentType();
////        return contentType != null && contentType.startsWith("image/");
////    }
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                if (file.isEmpty()) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
////                }
////
////                // Check the file type
////                if (!isImageFile(file)) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is not an image");
////                }
////  
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                if (originalImage == null) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to read image: invalid image file or format not supported");
////                }
////
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (IOException | SQLException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
////        }
////    }
////
////    private boolean isImageFile(MultipartFile file) {
////        String contentType = file.getContentType();
////        return contentType != null && contentType.startsWith("image/");
////    }
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                if (file.isEmpty()) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
////                }
////                
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                if (originalImage == null) {
////                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to read image");
////                }
////
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (IOException | SQLException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
////        }
////    }
////    @PostMapping("/upload")
////    public ResponseEntity<String> uploadImage(@RequestParam("images") MultipartFile[] files) {
////        try {
////            for (MultipartFile file : files) {
////                BufferedImage originalImage = ImageIO.read(file.getInputStream());
////                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////                ImageIO.write(originalImage, "jpg", byteArrayOutputStream);
////                byte[] compressedImageData = byteArrayOutputStream.toByteArray();
////
////                Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
////
////                TempImages tempImages = new TempImages();
////                tempImages.setImgBlob(imgBlob);
////                tempImagesService.saveImage(tempImages);
////            }
////
////            return ResponseEntity.ok("Images uploaded successfully");
////        } catch (IOException | SQLException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload images: " + e.getMessage());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred: " + e.getMessage());
////        }
////    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateImage(@PathVariable int id, @RequestParam("image") MultipartFile file) {
//        try {
//            BufferedImage originalImage = ImageIO.read(file.getInputStream());
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ImageIO.write(originalImage, "jpeg", byteArrayOutputStream);
//            byte[] compressedImageData = byteArrayOutputStream.toByteArray();
//
//            Blob imgBlob = new javax.sql.rowset.serial.SerialBlob(compressedImageData);
//
//            TempImages updatedImage = tempImagesService.updateImage(id, imgBlob);
//            if (updatedImage != null) {
//                return ResponseEntity.ok("Image updated successfully with ID: " + updatedImage.getId());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found");
//            }
//        } catch (IOException | SQLException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update image");
//        }
//    }
//}
