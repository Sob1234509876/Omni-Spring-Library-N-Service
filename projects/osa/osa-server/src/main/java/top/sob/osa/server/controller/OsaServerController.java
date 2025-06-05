package top.sob.osa.server.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sob.osa.server.service.OsaServerService;

import java.util.Map;
import java.util.Optional;

@Controller
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@RequestMapping("/osa")
public class OsaServerController {

    @NonNull
    OsaServerService osaServerService;

    @GetMapping("/register")
    @ResponseBody
    public boolean register(@NonNull String username, @NonNull String password) {
        return osaServerService.register(username, password);
    }

    @GetMapping("/system/save")
    @ResponseBody
    public @NonNull Map.Entry<String, UserDetails> save(@NonNull Map.Entry<String, UserDetails> entity) {
        return osaServerService.save(entity);
    }

    @GetMapping("/public/find-by-id")
    @ResponseBody
    public @NonNull Optional<Map.Entry<String, UserDetails>> findById(@NonNull String s) {
        return osaServerService.findById(s);
    }

    @GetMapping("/public/find-all")
    @ResponseBody
    public @NonNull Iterable<Map.Entry<String, UserDetails>> findAll() {
        return osaServerService.findAll();
    }

    @GetMapping("/system/delete-by-id")
    @ResponseBody
    public void deleteById(@NonNull String s) {
        osaServerService.deleteById(s);
    }

    @GetMapping("/system/delete")
    @ResponseBody
    public void delete(Map.@NonNull Entry<String, UserDetails> entity) {
        osaServerService.delete(entity);
    }

    @GetMapping("/system/delete-all")
    @ResponseBody
    public void deleteAll() {
        osaServerService.deleteAll();
    }

    @GetMapping("/public/count")
    @ResponseBody
    public long count() {
        return osaServerService.count();
    }

    @GetMapping("/system/save-given")
    @ResponseBody
    public @NonNull Iterable<Map.Entry<String, UserDetails>> saveAll(@NonNull Iterable<Map.Entry<String, UserDetails>> entities) {
        return osaServerService.saveAll(entities);
    }

    @GetMapping("/public/exists-by-id")
    @ResponseBody
    public boolean existsById(@NonNull String id) {
        return findById(id).isPresent();
    }

    @GetMapping("/public/find-all-by-id")
    @ResponseBody
    public @NonNull Iterable<Map.Entry<String, UserDetails>> findAllById(@NonNull Iterable<String> ids) {
        return osaServerService.findAllById(ids);
    }

    @GetMapping("/system/delete-all-by-id")
    @ResponseBody
    public void deleteAllById(@NonNull Iterable<? extends String> ids) {
        osaServerService.deleteAllById(ids);
    }

    @GetMapping("/system/delete-given")
    @ResponseBody
    public void deleteAll(@NonNull Iterable<? extends Map.Entry<String, UserDetails>> entities) {
        osaServerService.deleteAll(entities);
    }
}
