package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IOUtilitiesDiffblueTest {
  /**
   * Test {@link IOUtilities#readLines(InputStream)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtilities#readLines(InputStream)}
   */
  @Test
  @DisplayName("Test readLines(InputStream); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List IOUtilities.readLines(InputStream)"})
  void testReadLines_thenReturnSizeIsOne() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    List<String> actualReadLinesResult = IOUtilities.readLines(stream);

    // Assert
    assertEquals(1, actualReadLinesResult.size());
    assertEquals("AXAXAXAX", actualReadLinesResult.get(0));
    int actualReadResult = stream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link IOUtilities#streamLines(InputStream)}.
   *
   * <ul>
   *   <li>Then return limit five collect toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtilities#streamLines(InputStream)}
   */
  @Test
  @DisplayName("Test streamLines(InputStream); then return limit five collect toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream IOUtilities.streamLines(InputStream)"})
  void testStreamLines_thenReturnLimitFiveCollectToListSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange and Act
    Stream<String> actualStreamLinesResult =
        IOUtilities.streamLines(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    List<String> collectResult = actualStreamLinesResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("AXAXAXAX", collectResult.get(0));
  }

  /**
   * Test {@link IOUtilities#copyStream(InputStream, OutputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link IOUtilities#copyStream(InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test copyStream(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IOUtilities.copyStream(InputStream, OutputStream)"})
  void testCopyStream_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    IOUtilities.copyStream(input, output);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link IOUtilities#readAsString(InputStream)}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link IOUtilities#readAsString(InputStream)}
   */
  @Test
  @DisplayName("Test readAsString(InputStream); then return 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IOUtilities.readAsString(InputStream)"})
  void testReadAsString_thenReturnAxaxaxax() throws IOException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals("AXAXAXAX", IOUtilities.readAsString(stream));
    int actualReadResult = stream.read(new byte[] {});
    assertEquals(-1, actualReadResult);
  }
}
