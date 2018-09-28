package com.sheremet.foxminded.gof.momento;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class DocumentMementoTest {
    private final DocumentCaretaker documentCaretaker = new DocumentCaretaker.DocumentCaretakerImpl();
    private final DocumentOriginator documentOriginator = new DocumentOriginator();

    @Test
    public void testDocumentMemento() {
        documentOriginator.setDocument("version1");
        assertThat(documentCaretaker.save(documentOriginator.getDocumentMemento()), is(1));

        documentOriginator.setDocument("version2");
        assertThat(documentCaretaker.save(documentOriginator.getDocumentMemento()), is(2));

        documentOriginator.setDocument("version3");
        assertThat(documentCaretaker.save(documentOriginator.getDocumentMemento()), is(3));

        assertThat(documentOriginator.restore(documentCaretaker.getByIndex(1)), is("version2"));
        assertThat(documentOriginator.restore(documentCaretaker.getByIndex(0)), is("version1"));
    }
}
