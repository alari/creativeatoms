package ru.mirari.infra.ca;

import java.util.List;

/**
 * @author alari
 * @since 10/28/12 12:22 AM
 */
public class Molecule {
    private String style;
    private String type;
    private List<Atom> atoms;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Atom> getAtoms() {
        return atoms;
    }

    public void setAtoms(List<Atom> atoms) {
        this.atoms = atoms;
    }
}
