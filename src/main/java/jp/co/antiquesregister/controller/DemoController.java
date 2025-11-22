package jp.co.antiquesregister.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class DemoController {

    @PostMapping("/text")
    public String text(@RequestBody String text) {
        return "api test [text = " + text + "]";
    }

    @PostMapping("/json")
    public DemoResponse json(@RequestBody DemoRequest request) {
        return new DemoResponse("param1 = " + request.param1(), "param2 =  " + request.param2());
    }
    public record DemoRequest(String param1, String param2) {}
    public record DemoResponse(String param1, String param2) {}
}
