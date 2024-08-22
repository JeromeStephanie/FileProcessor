package com.file.processor.Controller;

import com.file.processor.Service.ProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FileProcessController {

    private final ProcessorService textProcessor;

    @GetMapping("/process")
    public String fileUpload() {
        return "index"; // This returns a view named "index", typically an HTML file
    }

    @PostMapping("/process-file")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        // Read file contents and process the text
        String contents = new String(file.getBytes());
        String processedText = textProcessor.processText(contents);

        // Return the processed text in the response
        return ResponseEntity.ok().body(processedText);
    }
}
