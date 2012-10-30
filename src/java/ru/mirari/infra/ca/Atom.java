package ru.mirari.infra.ca;

import java.io.File;
import java.util.Map;

/**
 * @author alari
 * @since 10/28/12 12:22 AM
 */
public class Atom {
    String title;
    String id;
    String type;

    String text;
    String externalId;

    Map<String, String> sounds;
    Map<String, String> images;

    public static class Push extends Atom {
        File file;
        String originalFilename;
        String externalUrl;

        public String getExternalUrl() {
            return externalUrl;
        }

        public void setExternalUrl(String externalUrl) {
            this.externalUrl = externalUrl;
        }

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public String getOriginalFilename() {
            return originalFilename;
        }

        public void setOriginalFilename(String originalFilename) {
            this.originalFilename = originalFilename;
        }
    }

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Map<String, String> getSounds() {
        return sounds;
    }

    public void setSounds(Map<String, String> sounds) {
        this.sounds = sounds;
    }
}
