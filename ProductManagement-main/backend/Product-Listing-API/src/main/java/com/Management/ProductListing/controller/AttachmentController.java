package com.Management.ProductListing.controller;

import com.Management.ProductListing.model.Attachment;
import com.Management.ProductListing.model.ResponseData;
import com.Management.ProductListing.service.AttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("api/vI/")
public class AttachmentController {

    private AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
    private static final Logger logger= LoggerFactory.getLogger(AttachmentController.class);

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            Attachment attachment = null;
            String downloadURl = "";
            attachment = attachmentService.saveAttachment(file);
            attachment.setDownloadURL(downloadURl);
            attachment.setFileSize(file.getSize());
            ResponseEntity.ok();
            ResponseData responseData= new ResponseData(attachment.getId(),attachment.getFileName(),
                    downloadURl,
                    file.getContentType(),
                    file.getSize());
            return new ResponseEntity<>(responseData, HttpStatus.OK);

        }catch (Exception e){
            logger.debug("Failed in saving file {}" ,e);
            throw new Exception("Exception occur in File upload {}" ,e);
        }
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = null;
        attachment = attachmentService.getAttachment(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + attachment.getFileName()
                                + "\"")
                .body(new ByteArrayResource(attachment.getData()));
    }
    @GetMapping("/attachment/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        byte[] imageData = new byte[0];
        try {
            imageData = attachmentService.getAttachment(id).getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // Set the appropriate content type

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

}
