package pl.bykowski.springbootcaffe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileApi {

    @Value("${server.port}")
    private int port;

    @Value("${profile.type}")
    private String profile;


    @GetMapping("/profile")
    public String get() {
        return "Active profil is " + profile + ", on port: " + port;
    }

}
