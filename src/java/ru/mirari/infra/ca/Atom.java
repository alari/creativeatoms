package ru.mirari.infra.ca;

import java.io.File;
import java.util.Map;

/**
 * @author alari
 * @since 10/28/12 12:22 AM
 */
public class Atom {
    public String title;
    public String id;
    public String type;

    public String text;
    public String externalId;

    public Map<String, String> sounds;
    public Map<String, String> images;

    public static class Push extends Atom {
        public File file;
        public String originalFilename;
        public String externalUrl;
    }
}
