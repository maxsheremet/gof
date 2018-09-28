package com.sheremet.foxminded.gof.momento;

import java.util.ArrayList;
import java.util.List;

public interface DocumentCaretaker {
    int save(DocumentMemento documentMemento);

    DocumentMemento getByIndex(int index);

    final class DocumentCaretakerImpl implements DocumentCaretaker {

        private final List<DocumentMemento> documents = new ArrayList<>();

        public int save(DocumentMemento documentMemento) {
            this.documents.add(documentMemento);
            return this.documents.size();
        }

        public DocumentMemento getByIndex(int index) {
            return documents.get(index % documents.size());
        }
    }
}
