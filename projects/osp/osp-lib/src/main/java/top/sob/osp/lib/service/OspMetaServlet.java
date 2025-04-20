package top.sob.osp.lib.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import top.sob.osp.lib.Plugin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class OspMetaServlet {

    Plugin plugin;

}
