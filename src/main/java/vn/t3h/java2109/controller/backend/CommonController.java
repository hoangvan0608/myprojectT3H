package vn.t3h.java2109.controller.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import vn.t3h.java2109.dto.common.ResponseDTO;
import vn.t3h.java2109.utils.FileUtils;


@Controller
@RequestMapping("/api/image")
public class CommonController {

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    @ResponseBody
    // trả về 1 nếu thàng công, 0 nếu lỗi
    public String save(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = FileUtils.saveFile(file);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
