package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsageInfoDiffblueTest {
  /**
   * Test {@link UsageInfo#description()}.
   *
   * <p>Method under test: {@link UsageInfo#description()}
   */
  @Test
  @DisplayName("Test description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UsageInfo.description()"})
  void testDescription() {
    // Arrange, Act and Assert
    assertEquals(
        "The characteristics of someone or something",
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build()
            .description());
  }
}
