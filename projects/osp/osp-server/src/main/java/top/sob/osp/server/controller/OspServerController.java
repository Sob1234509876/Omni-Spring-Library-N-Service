package top.sob.osp.server.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.sob.osp.server.service.OspServerService;

import java.util.Map;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class OspServerController {

    @NonNull
    OspServerService ospServerService;

    @GetMapping("/plugin/{pluginName}")
    public ResponseEntity<Map<String, String>> getPlugin(@PathVariable String pluginName) {
        var bean = ospServerService.getPlugin(pluginName);

        return new ResponseEntity<>(bean, bean == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

}
