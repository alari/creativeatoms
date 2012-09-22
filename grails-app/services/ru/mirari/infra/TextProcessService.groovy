package ru.mirari.infra

import ru.mirari.infra.text.TextProcessUtil
import ru.mirari.infra.text.TextProcessUtilHandler

class TextProcessService implements TextProcessUtil {

    @Override
    String cleanHtml(String unsafe) {
        TextProcessUtilHandler.cleanHtml(unsafe)
    }

    @Override
    String markdownToHtml(String text) {
        TextProcessUtilHandler.markdownToHtml(text)
    }

    @Override
    String htmlToMarkdown(String theHTML) {
        TextProcessUtilHandler.htmlToMarkdown(theHTML)
    }
}
