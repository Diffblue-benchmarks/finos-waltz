package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DigestUtilitiesDiffblueTest {
  /**
   * Test {@link DigestUtilities#digest(byte[])}.
   *
   * <p>Method under test: {@link DigestUtilities#digest(byte[])}
   */
  @Test
  @DisplayName("Test digest(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DigestUtilities.digest(byte[])"})
  void testDigest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
    // Arrange, Act and Assert
    assertEquals(
        "ZmNW5JBX2XLWUhRoj3DEAwVL+TM=", DigestUtilities.digest("AXAXAXAX".getBytes("UTF-8")));
  }
}
