package info_sec.project.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String FirstPage() {
        return "We succeed. we are viewing our first page.";
    }
}
