package jp.co.antiquesregister.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class DemoController {

    @PostMapping("/text")
    public String text(@RequestBody String text) {
        return "text = " + text;
    }

    @PostMapping("/password_encode")
    public String encodePassword(@RequestBody String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @PostMapping("/json")
    public DemoResponse json(@RequestBody DemoRequest request) {
        return new DemoResponse("param1 = " + request.param1(), "param2 =  " + request.param2());
    }
    public record DemoRequest(String param1, String param2) {}
    public record DemoResponse(String param1, String param2) {}
}
