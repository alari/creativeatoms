package ru.mirari.infra.ca.strategy.internal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.Atom
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.text.TextProcessUtil

/**
 * @author alari
 * @since 1/6/12 5:41 PM
 */
@Component
class TextStrategy extends InternalStrategy {
    @Autowired private TextProcessUtil textProcessUtil

    @Override
    void setContentFile(Atom atom, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;

        atom.title = fileInfo.title

        if (fileInfo.extension.equalsIgnoreCase("txt")) {
            atom.text = fileInfo.file.getText()
        } else if (fileInfo.extension in ["htm", "html"]) {
            atom.text = textProcessUtil.htmlToMarkdown(fileInfo.file.getText())
        }
    }

    @Override
    boolean setContent(Atom atom, Atom.Push dto) {
        if (super.setContent(atom, dto)) return true;
        if (dto.text) {
            atom.text = dto.text
            return true
        }
        return false
    }

    @Override
    boolean isEmpty(Atom atom) {
        (!atom?.text)
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        type.extension in ["txt", "htm", "html"]
    }

    @Override
    Atom getForRender(Atom atom) {
        atom.text = textProcessUtil.markdownToHtml atom.text
        atom
    }
}
