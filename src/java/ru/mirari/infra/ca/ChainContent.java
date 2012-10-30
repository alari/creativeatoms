package ru.mirari.infra.ca;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author alari
 * @since 10/28/12 12:22 AM
 */
public class ChainContent {
    private List<Molecule> molecules;

    static final private ObjectMapper mapper = new ObjectMapper();

    public String toJson() throws IOException {
        return mapper.writeValueAsString(this);
    }

    static public ChainContent forJson(String json) throws IOException {
        return mapper.readValue(json, ChainContent.class);
    }

    /*
    void addAtom(Atom atom) {
        Molecule last = molecules.get(molecules.size()-1);
        if(last != null && last.type.equals(atom.type)) {
            last.atoms.add(atom);
            return;
        }
        Molecule molecule = new Molecule();
        molecule.atoms = new LinkedList<Atom>();
        molecule.atoms.add(atom);
        molecule.type = atom.type;
        molecules.add(molecule);
    }

    void moveAtom(String id, int index) {
        Molecule oldMolecule = null;
        int oldIndex = 0;
        for(Molecule m : molecules) {
            if(null != oldMolecule) break;
            for(Atom a : m.atoms) {
                if(a.id.equals(id)) {
                    oldMolecule = m;
                    break;
                }
                oldIndex++;
            }
        }
        if(oldIndex == index) return;
        int newIndex = 0;
        for(Molecule m : molecules) {
            for(Atom a : m.atoms) {
                newIndex ++;
                if(newIndex == index) {
                    if(m == oldMolecule) {

                    }
                }
            }
        }
    } */

    public List<Molecule> getMolecules() {
        return molecules;
    }

    public void setMolecules(List<Molecule> molecules) {
        this.molecules = molecules;
    }
}
