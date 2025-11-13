package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameHelperDiffblueTest {
  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NameHelper.toName(EntityReference)"})
  void testToName() {
    // Arrange
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals("Name", NameHelper.toName(ref));
  }

  /**
   * Test {@link NameHelper#toName(EntityReference)}.
   *
   * <p>Method under test: {@link NameHelper#toName(EntityReference)}
   */
  @Test
  @DisplayName("Test toName(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NameHelper.toName(EntityReference)"})
  void testToName2() {
    // Arrange
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals("Name", NameHelper.toName(ref));
  }
}
