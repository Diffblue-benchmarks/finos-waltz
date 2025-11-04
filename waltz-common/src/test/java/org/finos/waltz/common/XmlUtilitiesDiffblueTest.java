package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlUtilitiesDiffblueTest {
  /**
   * Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  void testStream() {
    // Arrange and Act
    Stream<Node> actualStreamResult = XmlUtilities.stream(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(actualStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  void testStream2() {
    // Arrange
    IIOMetadataNode nodeList = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    nodeList.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act
    Stream<Node> actualStreamResult = XmlUtilities.stream(nodeList);

    // Assert
    List<Node> collectResult = actualStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertNull(collectResult.get(0));
  }

  /**
   * Method under test:
   * {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  void testPrintDocument() throws TransformerException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("omit-xml-declaration");
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.item(anyInt())).thenReturn(iioMetadataNode);
    when(namedNodeMap.getLength()).thenReturn(3);
    Document doc = mock(Document.class);
    when(doc.getLocalName()).thenReturn("Local Name");
    when(doc.getNamespaceURI()).thenReturn("Namespace URI");
    when(doc.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(doc.getAttributes()).thenReturn(namedNodeMap);
    when(doc.getNodeName()).thenReturn("Node Name");
    when(doc.getNodeType()).thenReturn((short) 1);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    XmlUtilities.printDocument(doc, out, true);

    // Assert that nothing has changed
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(132, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[107]);
    assertEquals(' ', toByteArrayResult[125]);
    assertEquals(' ', toByteArrayResult[5]);
    assertEquals(' ', toByteArrayResult[Columns.T]);
    assertEquals('.', toByteArrayResult[Columns.Q]);
    assertEquals('/', toByteArrayResult[116]);
    assertEquals('/', toByteArrayResult[120]);
    assertEquals('0', toByteArrayResult[Columns.R]);
    assertEquals('1', toByteArrayResult[Columns.P]);
    assertEquals('<', toByteArrayResult[0]);
    assertEquals('<', toByteArrayResult[119]);
    assertEquals('=', toByteArrayResult[113]);
    assertEquals('=', toByteArrayResult[Columns.N]);
    assertEquals('>', toByteArrayResult[117]);
    assertEquals('>', toByteArrayResult[130]);
    assertEquals('?', toByteArrayResult[1]);
    assertEquals('N', toByteArrayResult[121]);
    assertEquals('N', toByteArrayResult[126]);
    assertEquals('"', toByteArrayResult[114]);
    assertEquals('"', toByteArrayResult[115]);
    assertEquals('"', toByteArrayResult[Columns.O]);
    assertEquals('"', toByteArrayResult[Columns.S]);
    assertEquals('\n', toByteArrayResult[118]);
    assertEquals('\n', toByteArrayResult[131]);
    assertEquals('a', toByteArrayResult[Float.MAX_EXPONENT]);
    assertEquals('c', toByteArrayResult[Columns.W]);
    assertEquals('d', toByteArrayResult[123]);
    assertEquals('d', toByteArrayResult[Columns.Y]);
    assertEquals('e', toByteArrayResult[124]);
    assertEquals('e', toByteArrayResult[129]);
    assertEquals('e', toByteArrayResult[7]);
    assertEquals('e', toByteArrayResult[Columns.U]);
    assertEquals('i', toByteArrayResult[Columns.K]);
    assertEquals('l', toByteArrayResult[110]);
    assertEquals('l', toByteArrayResult[4]);
    assertEquals('m', toByteArrayResult[109]);
    assertEquals('m', toByteArrayResult[128]);
    assertEquals('m', toByteArrayResult[3]);
    assertEquals('n', toByteArrayResult[111]);
    assertEquals('n', toByteArrayResult[Columns.M]);
    assertEquals('n', toByteArrayResult[Columns.V]);
    assertEquals('o', toByteArrayResult[122]);
    assertEquals('o', toByteArrayResult[Columns.L]);
    assertEquals('o', toByteArrayResult[Columns.X]);
    assertEquals('r', toByteArrayResult[8]);
    assertEquals('s', toByteArrayResult[112]);
    assertEquals('s', toByteArrayResult[Columns.J]);
    assertEquals('v', toByteArrayResult[6]);
    assertEquals('x', toByteArrayResult[108]);
    assertEquals('x', toByteArrayResult[2]);
  }

  /**
   * Method under test:
   * {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  void testPrintDocument2() throws TransformerException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("omit-xml-declaration");
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.item(anyInt())).thenReturn(iioMetadataNode);
    when(namedNodeMap.getLength()).thenReturn(3);
    Document doc = mock(Document.class);
    when(doc.getLocalName()).thenReturn("Local Name");
    when(doc.getNamespaceURI()).thenReturn("Namespace URI");
    when(doc.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(doc.getAttributes()).thenReturn(namedNodeMap);
    when(doc.getNodeName()).thenReturn("Node Name");
    when(doc.getNodeType()).thenReturn((short) 1);
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);

    // Act
    XmlUtilities.printDocument(doc, out, false);

    // Assert that nothing has changed
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    byte[] toByteArrayResult = out.toByteArray();
    assertEquals(125, toByteArrayResult.length);
    assertEquals(' ', toByteArrayResult[102]);
    assertEquals(' ', toByteArrayResult[119]);
    assertEquals(' ', toByteArrayResult[5]);
    assertEquals(' ', toByteArrayResult[Columns.T]);
    assertEquals('.', toByteArrayResult[Columns.Q]);
    assertEquals('/', toByteArrayResult[111]);
    assertEquals('/', toByteArrayResult[114]);
    assertEquals('0', toByteArrayResult[Columns.R]);
    assertEquals('1', toByteArrayResult[Columns.P]);
    assertEquals('<', toByteArrayResult[0]);
    assertEquals('<', toByteArrayResult[113]);
    assertEquals('=', toByteArrayResult[108]);
    assertEquals('=', toByteArrayResult[Columns.N]);
    assertEquals('>', toByteArrayResult[112]);
    assertEquals('>', toByteArrayResult[124]);
    assertEquals('?', toByteArrayResult[1]);
    assertEquals('N', toByteArrayResult[115]);
    assertEquals('N', toByteArrayResult[120]);
    assertEquals('"', toByteArrayResult[109]);
    assertEquals('"', toByteArrayResult[110]);
    assertEquals('"', toByteArrayResult[Columns.O]);
    assertEquals('"', toByteArrayResult[Columns.S]);
    assertEquals('a', toByteArrayResult[121]);
    assertEquals('c', toByteArrayResult[Columns.W]);
    assertEquals('d', toByteArrayResult[117]);
    assertEquals('d', toByteArrayResult[Columns.Y]);
    assertEquals('e', toByteArrayResult[118]);
    assertEquals('e', toByteArrayResult[123]);
    assertEquals('e', toByteArrayResult[7]);
    assertEquals('e', toByteArrayResult[Columns.U]);
    assertEquals('i', toByteArrayResult[Columns.K]);
    assertEquals('l', toByteArrayResult[105]);
    assertEquals('l', toByteArrayResult[4]);
    assertEquals('m', toByteArrayResult[104]);
    assertEquals('m', toByteArrayResult[122]);
    assertEquals('m', toByteArrayResult[3]);
    assertEquals('n', toByteArrayResult[106]);
    assertEquals('n', toByteArrayResult[Columns.M]);
    assertEquals('n', toByteArrayResult[Columns.V]);
    assertEquals('o', toByteArrayResult[100]);
    assertEquals('o', toByteArrayResult[101]);
    assertEquals('o', toByteArrayResult[116]);
    assertEquals('o', toByteArrayResult[Columns.L]);
    assertEquals('o', toByteArrayResult[Columns.X]);
    assertEquals('r', toByteArrayResult[8]);
    assertEquals('s', toByteArrayResult[107]);
    assertEquals('s', toByteArrayResult[Columns.J]);
    assertEquals('v', toByteArrayResult[6]);
    assertEquals('x', toByteArrayResult[103]);
    assertEquals('x', toByteArrayResult[2]);
  }

  /**
   * Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  void testPrintDocument3() throws TransformerException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("omit-xml-declaration");
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.item(anyInt())).thenReturn(iioMetadataNode);
    when(namedNodeMap.getLength()).thenReturn(3);
    Document doc = mock(Document.class);
    when(doc.getLocalName()).thenReturn("Local Name");
    when(doc.getNamespaceURI()).thenReturn("Namespace URI");
    when(doc.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(doc.getAttributes()).thenReturn(namedNodeMap);
    when(doc.getNodeName()).thenReturn("Node Name");
    when(doc.getNodeType()).thenReturn((short) 1);

    // Act
    String actualPrintDocumentResult = XmlUtilities.printDocument(doc, true);

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Node Name foo=\"omit-xml-declaration\" xmlns=\"Namespace URI\">\n"
            + "    <foo xmlns=\"\"/>\n" + "</Node Name>\n",
        actualPrintDocumentResult);
  }

  /**
   * Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  void testPrintDocument4() throws TransformerException {
    // Arrange
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    iioMetadataNode.setNodeValue("omit-xml-declaration");
    NamedNodeMap namedNodeMap = mock(NamedNodeMap.class);
    when(namedNodeMap.item(anyInt())).thenReturn(iioMetadataNode);
    when(namedNodeMap.getLength()).thenReturn(3);
    Document doc = mock(Document.class);
    when(doc.getLocalName()).thenReturn("Local Name");
    when(doc.getNamespaceURI()).thenReturn("Namespace URI");
    when(doc.getFirstChild()).thenReturn(new IIOMetadataNode("foo"));
    when(doc.getAttributes()).thenReturn(namedNodeMap);
    when(doc.getNodeName()).thenReturn("Node Name");
    when(doc.getNodeType()).thenReturn((short) 1);

    // Act
    String actualPrintDocumentResult = XmlUtilities.printDocument(doc, false);

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Node Name foo=\"omit-xml-declaration\" xmlns=\"Namespace URI\"><foo"
            + " xmlns=\"\"/></Node Name>",
        actualPrintDocumentResult);
  }

  /**
   * Method under test:
   * {@link XmlUtilities#createNonValidatingDocumentBuilderFactory()}
   */
  @Test
  void testCreateNonValidatingDocumentBuilderFactory() throws ParserConfigurationException {
    // Arrange and Act
    DocumentBuilderFactory actualCreateNonValidatingDocumentBuilderFactoryResult = XmlUtilities
        .createNonValidatingDocumentBuilderFactory();

    // Assert
    assertNull(actualCreateNonValidatingDocumentBuilderFactoryResult.getSchema());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isCoalescing());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isIgnoringComments());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isIgnoringElementContentWhitespace());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isValidating());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isXIncludeAware());
    assertTrue(actualCreateNonValidatingDocumentBuilderFactoryResult.isExpandEntityReferences());
    assertTrue(actualCreateNonValidatingDocumentBuilderFactoryResult.isNamespaceAware());
  }
}
