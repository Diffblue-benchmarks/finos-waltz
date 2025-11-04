package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

class IOUtilitiesDiffblueTest {
  /**
   * Method under test: {@link IOUtilities#readLines(InputStream)}
   */
  @Test
  void testReadLines() throws IOException {
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
   * Method under test: {@link IOUtilities#copyStream(InputStream, OutputStream)}
   */
  @Test
  void testCopyStream() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    IOUtilities.copyStream(input, output);

    // Assert that nothing has changed
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link IOUtilities#readAsString(InputStream)}
   */
  @Test
  void testReadAsString() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", IOUtilities.readAsString(stream));
    assertEquals(-1, stream.read(new byte[]{}));
  }

  /**
   * Method under test: {@link IOUtilities#getFileResource(String)}
   */
  @Test
  void testGetFileResource() throws IOException {
    // Arrange and Act
    Resource actualFileResource = IOUtilities.getFileResource("foo.txt");

    // Assert
    assertTrue(actualFileResource instanceof FileSystemResource);
    File file = actualFileResource.getFile();
    assertEquals("foo.txt", file.getName());
    assertEquals("foo.txt", actualFileResource.getFilename());
    assertFalse(actualFileResource.isOpen());
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
