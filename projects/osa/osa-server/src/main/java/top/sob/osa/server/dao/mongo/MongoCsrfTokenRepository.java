package top.sob.osa.server.dao.mongo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;
import top.sob.osl.lib.util.Pair;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Repository
public class MongoCsrfTokenRepository implements CsrfTokenRepository {

    public static final String DEFAULT_CSRF_PARAMETER_NAME = "_csrf";
    public static final String DEFAULT_CSRF_HEADER_NAME = "X-CSRF-TOKEN";
    public static final String DEFAULT_CSRF_ID_HEADER_NAME = "X-CSRF-TOKEN-ID";

    @NonNull
    MongoCsrfTokenDao csrfTokenDao;

    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        return new DefaultCsrfToken(DEFAULT_CSRF_HEADER_NAME, DEFAULT_CSRF_PARAMETER_NAME, UUID.randomUUID().toString());
    }

    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        var id = request.getHeader(DEFAULT_CSRF_ID_HEADER_NAME);

        if (id == null)
            return;

        if (token == null)
            csrfTokenDao.deleteById(id);
        else
            csrfTokenDao.save(new Pair<>(id, token));
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        var id = request.getHeader(DEFAULT_CSRF_ID_HEADER_NAME);
        if (id == null)
            return null;

        var res = csrfTokenDao.findById(id);
        return res.map(Map.Entry::getValue).orElse(null);
    }
}
