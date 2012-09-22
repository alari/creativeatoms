package ru.mirari.infra.ca

import ru.mirari.infra.ca.face.CreativeAtom

class CreativeAtomTagLib {
    static namespace = "ca"

    def render = {attrs, body->
        CreativeAtom atom = attrs.atom
        g.render template: "/ca-render/atom", model: [atom: atom.contentDTO]
    }
}
