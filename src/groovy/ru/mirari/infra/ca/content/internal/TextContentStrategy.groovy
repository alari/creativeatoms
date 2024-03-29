package ru.mirari.infra.ca.content.internal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.mirari.infra.ca.face.CreativeAtom
import ru.mirari.infra.ca.face.dto.CreativeAtomContentDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomPushDTO
import ru.mirari.infra.ca.face.dto.CreativeAtomUpdateDTO
import ru.mirari.infra.file.FileInfo
import ru.mirari.infra.text.TextProcessUtil
import ru.mirari.infra.ca.face.CreativeAtomRepo

/**
 * @author alari
 * @since 1/6/12 5:41 PM
 */
@Component
class TextContentStrategy extends InternalContentStrategy {
    @Autowired private TextProcessUtil textProcessUtil
    @Autowired private CreativeAtomRepo creativeAtomRepo

    private void initiateContent(CreativeAtom atom) {
        if (!atom.rawContent) {
            atom.rawContent = creativeAtomRepo.createRawContent()
        }
        if (!atom.content) {
            atom.content = creativeAtomRepo.createContent()
        }
    }

    @Override
    void setContentFile(CreativeAtom atom, FileInfo fileInfo) {
        if (!isContentFileSupported(fileInfo)) return;
        initiateContent(atom)

        atom.title = fileInfo.title

        if (fileInfo.extension.equalsIgnoreCase("txt")) {
            atom.rawContent.text = fileInfo.file.getText()
        } else if (fileInfo.extension in ["htm", "html"]) {
            atom.rawContent.text = textProcessUtil.htmlToMarkdown(fileInfo.file.getText())
        }
        atom.content.text = textProcessUtil.markdownToHtml(atom.rawContent.text)
    }

    @Override
    boolean setContent(CreativeAtom atom, CreativeAtomPushDTO dto) {
        if (super.setContent(atom, dto)) return true;
        if (dto.text) {
            initiateContent(atom)
            atom.rawContent.text = dto.text
            atom.content.text = textProcessUtil.markdownToHtml(atom.rawContent.text)
            return true
        }
        return false
    }

    @Override
    boolean isEmpty(CreativeAtom atom) {
        (!atom?.content || !atom.content?.text)
    }

    @Override
    boolean isContentFileSupported(FileInfo type) {
        type.extension in ["txt", "htm", "html"]
    }

    @Override
    CreativeAtomContentDTO getContentDTO(CreativeAtom atom, CreativeAtomContentDTO dto = null) {
        dto = super.getContentDTO(atom, dto)
        dto.text = atom.content.text
        dto
    }

    @Override
    CreativeAtomUpdateDTO getUpdateDTO(CreativeAtom atom, CreativeAtomUpdateDTO dto = null) {
        dto = super.getBaseUpdateDTO(atom, dto)
        dto.text = atom.rawContent.text
        dto
    }
}
