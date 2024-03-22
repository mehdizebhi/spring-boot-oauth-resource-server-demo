package dev.mehdizebhi.resourceserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class MainController {

    @GetMapping("/v1/me")
    public ResponseEntity<Map<String, Object>> getProfileData(Authentication authentication) {
        Map<String, Object> profile = new HashMap<>();
        profile.put("details", authentication.getPrincipal());
        log.info("logged in user details: {}", authentication.getPrincipal());
        return ResponseEntity.ok(profile);
    }
}
