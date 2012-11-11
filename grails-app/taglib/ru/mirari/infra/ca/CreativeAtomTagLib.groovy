package ru.mirari.infra.ca


class CreativeAtomTagLib {
    static namespace = "ca"

    def render = {attrs, body ->
        def atom = attrs.atom
        g.render template: "/ca-render/atom", model: [atom: atom.contentDTO]
    }
}
