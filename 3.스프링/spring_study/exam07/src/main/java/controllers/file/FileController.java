package controllers.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/upload")
    public String upload() {

        return "file/upload";
    }

    @PostMapping("/upload")
    public String uploadPs(@RequestParam("file")MultipartFile[] files) {
        // @RequestParam("file") : upload.html의 name="file" - 이름이 동일해야한다.
        for (MultipartFile file : files) { // 파일 여러개 받기 위해 배열로

            File uploadPath = new File("C:/uploads/" + file.getOriginalFilename());
            // getOriginalFilename() : 클라이언트 파일 시스템의 원래 파일 이름을 반환합니다.

            try {
                file.transferTo(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "file/upload";
    }

}
