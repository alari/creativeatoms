package ru.mirari.infra.ca.strategy.external

import org.apache.http.client.utils.URLEncodedUtils
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom

/**
 * @author alari
 * @since 1/6/12 7:23 PM
 */
@Component
class YouTubeStrategy extends ExternalStrategy {
    @Override
    void buildContentByUrl(Atom atom, URL url) {
        if (!isUrlSupported(url)) return;
        // TODO: validate characters in external id!
        if (url.host == "youtu.be") {
            // http://youtu.be/zi3AqicZgEk
            atom.externalId = url.path.substring(1)
        } else if (url.host == "www.youtube.com" && url.path == "/watch") {
            // http://www.youtube.com/watch?v=zi3AqicZgEk&feature=g-logo&context=G2e33cabFOAAAAAAABAA
            atom.externalId = URLEncodedUtils.parse(url.toURI(), "UTF-8").find {it.name == "v"}.value
        }
    }

    @Override
    boolean isUrlSupported(URL url) {
        return url.host == "youtu.be" || (url.host == "www.youtube.com" && url.path == "/watch")
    }
}
