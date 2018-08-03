package root.structures;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LinkedList {

    private Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int data) {
        Link newLink = new Link(data);
        newLink.next = first;
        first = newLink;
    }

    private static class Link {
        int data;
        public Link next;

        public Link(int data) {
            this.data = data;
        }

        public void displayLink() {
            System.out.println("{" + data + "}");
        }
    }

    public static void main(String[] args) throws DocumentException {
        com.itextpdf.text.pdf.PdfWriter pdfWriter = null;
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4);
        try {
            pdfWriter = com.itextpdf.text.pdf.PdfWriter.getInstance(document, new FileOutputStream("/file.pdf"));
        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
        document.open();
        document.addAuthor("");
        document.addCreator("");
        document.addSubject("Накладная");
        document.addCreationDate();
        document.addTitle("Please read this");
        String pdf1 = "123456";
        document.add(new Paragraph("SLA: " + pdf1));
        PdfPTable pdfPTable = new PdfPTable(new float[]{1.0F, 1.0F, 1.0F, 1.0F});
        pdfPTable.addCell("123");
        pdfPTable.addCell("234");
        pdfPTable.addCell("234");
        pdfPTable.addCell("234");
        pdfPTable.addCell("234");
        document.add(pdfPTable);
        document.close();



        System.exit(0);
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(1);
        linkedList.insertFirst(12);
        linkedList.insertFirst(514);
        linkedList.insertFirst(1234);
        linkedList.insertFirst(1);
        linkedList.insertFirst(1);
        Link first = linkedList.first;
        first.displayLink();
        while (first.next != null) {
            first.next.displayLink();
            first = first.next;
        }
    }
}
