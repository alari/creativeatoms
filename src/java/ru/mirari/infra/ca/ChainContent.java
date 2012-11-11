package ru.mirari.infra.ca;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author alari
 * @since 10/28/12 12:22 AM
 */
public class ChainContent {
    public List<Molecule> molecules;

    static final private ObjectMapper mapper = new ObjectMapper();

    public String toJson() throws IOException {
        return mapper.writeValueAsString(this);
    }

    static public ChainContent forJson(String json) throws IOException {
        return mapper.readValue(json, ChainContent.class);
    }
}
