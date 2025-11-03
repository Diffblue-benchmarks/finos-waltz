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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlUtilitiesDiffblueTest {
  /**
   * Test {@link XmlUtilities#stream(NodeList)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  @DisplayName("Test stream(NodeList); given IIOMetadataNode(String) with 'foo'; then return limit five collect toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream XmlUtilities.stream(NodeList)"})
  void testStream_givenIIOMetadataNodeWithFoo_thenReturnLimitFiveCollectToListSizeIsOne() {
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
   * Test {@link XmlUtilities#stream(NodeList)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code foo}.</li>
   *   <li>Then return limit five collect toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  @DisplayName("Test stream(NodeList); when IIOMetadataNode(String) with 'foo'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream XmlUtilities.stream(NodeList)"})
  void testStream_whenIIOMetadataNodeWithFoo_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Node> actualStreamResult = XmlUtilities.stream(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(actualStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, OutputStream, boolean)} with {@code doc}, {@code out}, {@code prettyPrint}.
   * <ul>
   *   <li>Then array length is one hundred thirty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, OutputStream, boolean) with 'doc', 'out', 'prettyPrint'; then array length is one hundred thirty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmlUtilities.printDocument(Document, OutputStream, boolean)"})
  void testPrintDocumentWithDocOutPrettyPrint_thenArrayLengthIsOneHundredThirtyTwo() throws TransformerException {
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

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    assertEquals(132, out.toByteArray().length);
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, OutputStream, boolean)} with {@code doc}, {@code out}, {@code prettyPrint}.
   * <ul>
   *   <li>Then array length is one hundred twenty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, OutputStream, boolean) with 'doc', 'out', 'prettyPrint'; then array length is one hundred twenty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void XmlUtilities.printDocument(Document, OutputStream, boolean)"})
  void testPrintDocumentWithDocOutPrettyPrint_thenArrayLengthIsOneHundredTwentyFive() throws TransformerException {
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

    // Assert
    verify(namedNodeMap).getLength();
    verify(namedNodeMap, atLeast(1)).item(anyInt());
    verify(doc).getAttributes();
    verify(doc).getFirstChild();
    verify(doc).getLocalName();
    verify(doc).getNamespaceURI();
    verify(doc).getNodeName();
    verify(doc, atLeast(1)).getNodeType();
    assertEquals(125, out.toByteArray().length);
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, boolean)} with {@code doc}, {@code prettyPrint}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, boolean) with 'doc', 'prettyPrint'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String XmlUtilities.printDocument(Document, boolean)"})
  void testPrintDocumentWithDocPrettyPrint_thenReturnAString() throws TransformerException {
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
   * Test {@link XmlUtilities#printDocument(Document, boolean)} with {@code doc}, {@code prettyPrint}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, boolean) with 'doc', 'prettyPrint'; when 'false'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String XmlUtilities.printDocument(Document, boolean)"})
  void testPrintDocumentWithDocPrettyPrint_whenFalse_thenReturnAString() throws TransformerException {
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
   * Test {@link XmlUtilities#createNonValidatingDocumentBuilderFactory()}.
   * <p>
   * Method under test: {@link XmlUtilities#createNonValidatingDocumentBuilderFactory()}
   */
  @Test
  @DisplayName("Test createNonValidatingDocumentBuilderFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DocumentBuilderFactory XmlUtilities.createNonValidatingDocumentBuilderFactory()"})
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
