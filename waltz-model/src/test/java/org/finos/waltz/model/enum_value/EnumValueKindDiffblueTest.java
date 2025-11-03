package org.finos.waltz.model.enum_value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumValueKindDiffblueTest {
  /**
   * Test {@link EnumValueKind#dbValue()}.
   * <p>
   * Method under test: {@link EnumValueKind#dbValue()}
   */
  @Test
  @DisplayName("Test dbValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EnumValueKind.dbValue()"})
  void testDbValue() {
    // Arrange, Act and Assert
    assertEquals("TransportKind", EnumValueKind.valueOf("TRANSPORT_KIND").dbValue());
  }
}
