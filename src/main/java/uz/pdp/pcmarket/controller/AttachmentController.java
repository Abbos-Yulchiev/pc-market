package uz.pdp.pcmarket.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.payload.Result;
import uz.pdp.pcmarket.service.AttachmentService;

@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

    final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(MultipartHttpServletRequest request) {

        Result result = attachmentService.uploadFile(request);
        return ResponseEntity.status(result.getStatus() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAttachmentList(@RequestParam Integer page) {

        Page<Attachment> attachmentList = attachmentService.getAttachmentList(page);
        return ResponseEntity.ok(attachmentList);
    }

    @GetMapping(value = "/get/{attachmentId}")
    public ResponseEntity<?> getOneAttachment(@PathVariable Integer attachmentId) {

        Attachment oneAttachment = attachmentService.getOneAttachment(attachmentId);
        return ResponseEntity.ok(oneAttachment);
    }

    @DeleteMapping(value = "/delete/{attachmentId}")
    public ResponseEntity<?> deleteAttachment(@PathVariable Integer attachmentId) {

        Result result = attachmentService.deleteAttachment(attachmentId);
        return ResponseEntity.status(result.getStatus() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(result);
    }
}
