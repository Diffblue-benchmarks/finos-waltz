package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlUtilitiesDiffblueTest {
  /**
   * Test {@link XmlUtilities#stream(NodeList)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return limit five collect toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  @DisplayName(
      "Test stream(NodeList); given IIOMetadataNode(); then return limit five collect toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream XmlUtilities.stream(NodeList)"})
  void testStream_givenIIOMetadataNode_thenReturnLimitFiveCollectToListSizeIsOne() {
    // Arrange
    IIOMetadataNode nodeList = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    nodeList.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act
    Stream<Node> actualStreamResult = XmlUtilities.stream(nodeList);

    // Assert
    List<Node> collectResult = actualStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertNull(collectResult.get(0));
  }

  /**
   * Test {@link XmlUtilities#stream(NodeList)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link XmlUtilities#stream(NodeList)}
   */
  @Test
  @DisplayName(
      "Test stream(NodeList); when IIOMetadataNode(); then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream XmlUtilities.stream(NodeList)"})
  void testStream_whenIIOMetadataNode_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Node> actualStreamResult = XmlUtilities.stream(new IIOMetadataNode());

    // Assert
    assertTrue(actualStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, OutputStream, boolean)} with {@code doc},
   * {@code out}, {@code prettyPrint}.
   *
   * <p>Method under test: {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test printDocument(Document, OutputStream, boolean) with 'doc', 'out', 'prettyPrint'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmlUtilities.printDocument(Document, OutputStream, boolean)"})
  void testPrintDocumentWithDocOutPrettyPrint()
      throws UnsupportedEncodingException, TransformerException {
    // Arrange
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    XmlUtilities.printDocument(null, out, true);

    // Assert
    byte[] expectedToByteArrayResult =
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, OutputStream, boolean)} with {@code doc},
   * {@code out}, {@code prettyPrint}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link XmlUtilities#printDocument(Document, OutputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test printDocument(Document, OutputStream, boolean) with 'doc', 'out', 'prettyPrint'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XmlUtilities.printDocument(Document, OutputStream, boolean)"})
  void testPrintDocumentWithDocOutPrettyPrint_whenFalse()
      throws UnsupportedEncodingException, TransformerException {
    // Arrange
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Act
    XmlUtilities.printDocument(null, out, false);

    // Assert
    byte[] expectedToByteArrayResult =
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, boolean)} with {@code doc}, {@code
   * prettyPrint}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, boolean) with 'doc', 'prettyPrint'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XmlUtilities.printDocument(Document, boolean)"})
  void testPrintDocumentWithDocPrettyPrint_whenFalse() throws TransformerException {
    // Arrange, Act and Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>",
        XmlUtilities.printDocument(null, false));
  }

  /**
   * Test {@link XmlUtilities#printDocument(Document, boolean)} with {@code doc}, {@code
   * prettyPrint}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link XmlUtilities#printDocument(Document, boolean)}
   */
  @Test
  @DisplayName("Test printDocument(Document, boolean) with 'doc', 'prettyPrint'; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XmlUtilities.printDocument(Document, boolean)"})
  void testPrintDocumentWithDocPrettyPrint_whenTrue() throws TransformerException {
    // Arrange, Act and Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n\n",
        XmlUtilities.printDocument(null, true));
  }

  /**
   * Test {@link XmlUtilities#createNonValidatingDocumentBuilderFactory()}.
   *
   * <p>Method under test: {@link XmlUtilities#createNonValidatingDocumentBuilderFactory()}
   */
  @Test
  @DisplayName("Test createNonValidatingDocumentBuilderFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DocumentBuilderFactory XmlUtilities.createNonValidatingDocumentBuilderFactory()"
  })
  void testCreateNonValidatingDocumentBuilderFactory() throws ParserConfigurationException {
    // Arrange and Act
    DocumentBuilderFactory actualCreateNonValidatingDocumentBuilderFactoryResult =
        XmlUtilities.createNonValidatingDocumentBuilderFactory();

    // Assert
    assertNull(actualCreateNonValidatingDocumentBuilderFactoryResult.getSchema());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isCoalescing());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isIgnoringComments());
    assertFalse(
        actualCreateNonValidatingDocumentBuilderFactoryResult.isIgnoringElementContentWhitespace());
    assertFalse(actualCreateNonValidatingDocumentBuilderFactoryResult.isValidating());
    assertTrue(actualCreateNonValidatingDocumentBuilderFactoryResult.isExpandEntityReferences());
    assertTrue(actualCreateNonValidatingDocumentBuilderFactoryResult.isNamespaceAware());
  }
}
