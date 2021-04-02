package uz.pdp.pcmarket.service;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.repository.AttachmentRepository;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

@Service
public class AttachmentService {

    final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public String uploadFile(MultipartHttpServletRequest request) throws IOException {
        final Iterator<String> fileNames = request.getFileNames();
        final MultipartFile file = request.getFile(fileNames.next());
        if (file != null) {
            final String originalFilename = file.getOriginalFilename();
            final long size = file.getSize();
            final String contentType = file.getContentType();
            final byte[] bytes = file.getBytes();
            Attachment attachment = new Attachment();
            attachment.setExtension(contentType);
            attachment.setName(originalFilename);
            attachment.setSize(size);
            attachment.setBytes(bytes);
            final Attachment save = attachmentRepository.save(attachment);
            return "File saved! File id: " + save.getId();

        }
        return "File not saved";
    }

    public void getFile(Integer id, HttpServletResponse response) throws IOException {
        final Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            final Attachment attachment = optionalAttachment.get();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + attachment.getName() + "\"");
            response.setContentType(attachment.getExtension());
            FileCopyUtils.copy(attachment.getBytes(), response.getOutputStream());
        }
    }
}
