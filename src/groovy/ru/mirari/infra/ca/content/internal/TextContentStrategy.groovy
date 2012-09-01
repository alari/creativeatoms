package ru.mirari.infra.ca.content.internal

import ru.mirari.infra.text.TextProcessUtil

import ru.mirari.infra.file.FileInfo
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.CreativeAtomRawContentRepo
import org.springframework.beans.factory.annotation.Autowired
import ru.mirari.infra.ca.face.CreativeAtomContentRepo

/**
 * @author alari
 * @since 1/6/12 5:41 PM
 */
@Component
class TextContentStrategy extends InternalContentStrategy {
    @Autowired private CreativeAtomRawContentRepo creativeAtomRawContentRepo
    @Autowired private CreativeAtomContentRepo creativeAtomContentRepo

    @Override
    void setContentFile(CreativeAtom atom, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        if(!atom.rawContent) {
            atom.rawContent = creativeAtomRawContentRepo.create()
        }
        if (!atom.content) {
            atom.content = creativeAtomContentRepo.create()
        }

        atom.title = fileInfo.title

        if (fileInfo.extension.equalsIgnoreCase("txt")) {
            atom.rawContent.text = fileInfo.file.getText()
        } else if (fileInfo.extension in ["htm", "html"]) {
            atom.rawContent.text = TextProcessUtil.htmlToMarkdown(fileInfo.file.getText())
        }
        atom.content.text = TextProcessUtil.markdownToHtml(atom.rawContent.text)
    }

    @Override
    boolean isEmpty(CreativeAtom atom) {
        (!atom?.content || !atom.content?.text)
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        type.extension in ["txt", "htm", "html"]
    }
}
