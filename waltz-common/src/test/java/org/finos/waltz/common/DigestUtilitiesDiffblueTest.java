package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Test;

class DigestUtilitiesDiffblueTest {
  /**
   * Method under test: {@link DigestUtilities#digest(byte[])}
   */
  @Test
  void testDigest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals("ZmNW5JBX2XLWUhRoj3DEAwVL+TM=", DigestUtilities.digest("AXAXAXAX".getBytes("UTF-8")));
  }
}
