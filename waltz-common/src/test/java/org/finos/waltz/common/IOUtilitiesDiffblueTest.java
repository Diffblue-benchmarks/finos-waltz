package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

class IOUtilitiesDiffblueTest {
  /**
   * Test {@link IOUtilities#readLines(InputStream)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtilities#readLines(InputStream)}
   */
  @Test
  @DisplayName("Test readLines(InputStream); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List IOUtilities.readLines(InputStream)"})
  void testReadLines_thenReturnSizeIsOne() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<String> actualReadLinesResult = IOUtilities.readLines(stream);

    // Assert
    assertEquals(1, actualReadLinesResult.size());
    assertEquals("AXAXAXAX", actualReadLinesResult.get(0));
    assertEquals(-1, stream.read(new byte[]{}));
  }

  /**
   * Test {@link IOUtilities#streamLines(InputStream)}.
   * <ul>
   *   <li>Then return limit five collect toList size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtilities#streamLines(InputStream)}
   */
  @Test
  @DisplayName("Test streamLines(InputStream); then return limit five collect toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream IOUtilities.streamLines(InputStream)"})
  void testStreamLines_thenReturnLimitFiveCollectToListSizeIsOne() throws UnsupportedEncodingException {
    // Arrange and Act
    Stream<String> actualStreamLinesResult = IOUtilities
        .streamLines(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    List<String> collectResult = actualStreamLinesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("AXAXAXAX", collectResult.get(0));
  }

  /**
   * Test {@link IOUtilities#copyStream(InputStream, OutputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtilities#copyStream(InputStream, OutputStream)}
   */
  @Test
  @DisplayName("Test copyStream(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IOUtilities.copyStream(InputStream, OutputStream)"})
  void testCopyStream_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    IOUtilities.copyStream(input, output);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link IOUtilities#readAsString(InputStream)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtilities#readAsString(InputStream)}
   */
  @Test
  @DisplayName("Test readAsString(InputStream); then return 'AXAXAXAX'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String IOUtilities.readAsString(InputStream)"})
  void testReadAsString_thenReturnAxaxaxax() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", IOUtilities.readAsString(stream));
    assertEquals(-1, stream.read(new byte[]{}));
  }

  /**
   * Test {@link IOUtilities#getFileResource(String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@link FileSystemResource}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IOUtilities#getFileResource(String)}
   */
  @Test
  @DisplayName("Test getFileResource(String); when 'foo.txt'; then return FileSystemResource")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Resource IOUtilities.getFileResource(String)"})
  void testGetFileResource_whenFooTxt_thenReturnFileSystemResource() throws IOException {
    // Arrange and Act
    Resource actualFileResource = IOUtilities.getFileResource("foo.txt");

    // Assert
    assertTrue(actualFileResource instanceof FileSystemResource);
    File file = actualFileResource.getFile();
    assertEquals("foo.txt", file.getName());
    assertEquals("foo.txt", actualFileResource.getFilename());
    assertTrue(file.isAbsolute());
    assertTrue(actualFileResource.isFile());
    String expectedPath = Paths.get(System.getProperty("user.home"), ".waltz", "foo.txt").toString();
    assertEquals(expectedPath, ((FileSystemResource) actualFileResource).getPath());
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("user.home"), ".waltz", "foo.txt").toString());
    assertEquals(expectedToStringResult, actualFileResource.getURI().toString());
    String expectedToStringResult2 = String.join("", "file:",
        Paths.get(System.getProperty("user.home"), ".waltz", "foo.txt").toString());
    assertEquals(expectedToStringResult2, actualFileResource.getURL().toString());
    String expectedDescription = String.join("", "file [",
        Paths.get(System.getProperty("user.home"), ".waltz", "foo.txt").toString(), "]");
    assertEquals(expectedDescription, actualFileResource.getDescription());
  }
}
