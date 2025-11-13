package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CellValueDiffblueTest {
  /**
   * Test {@link CellValue#type()}.
   *
   * <ul>
   *   <li>Given builder comment {@code Comment} name {@code Name} type {@code Type} value {@code
   *       42} build.
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link CellValue#type()}
   */
  @Test
  @DisplayName(
      "Test type(); given builder comment 'Comment' name 'Name' type 'Type' value '42' build; then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String CellValue.type()"})
  void testType_givenBuilderCommentCommentNameNameTypeTypeValue42Build_thenReturnType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type",
        ImmutableCellValue.builder()
            .comment("Comment")
            .name("Name")
            .type("Type")
            .value("42")
            .build()
            .type());
  }
}
