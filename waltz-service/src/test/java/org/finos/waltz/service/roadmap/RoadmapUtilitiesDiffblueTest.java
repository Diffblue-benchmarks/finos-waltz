package org.finos.waltz.service.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RoadmapUtilitiesDiffblueTest {
  /**
   * Test {@link RoadmapUtilities#mkBasicLogEntry(long, String, String)}.
   *
   * <p>Method under test: {@link RoadmapUtilities#mkBasicLogEntry(long, String, String)}
   */
  @Test
  @DisplayName("Test mkBasicLogEntry(long, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ChangeLog RoadmapUtilities.mkBasicLogEntry(long, String, String)"})
  void testMkBasicLogEntry() {
    // Arrange and Act
    ChangeLog actualMkBasicLogEntryResult =
        RoadmapUtilities.mkBasicLogEntry(1L, "Not all who wander are lost", "42");

    // Assert
    EntityReference parentReferenceResult = actualMkBasicLogEntryResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualMkBasicLogEntryResult instanceof ImmutableChangeLog);
    assertEquals("42", actualMkBasicLogEntryResult.userId());
    assertEquals("Not all who wander are lost", actualMkBasicLogEntryResult.message());
    assertNull(parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ROADMAP, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(Operation.UPDATE, actualMkBasicLogEntryResult.operation());
    assertEquals(Severity.INFORMATION, actualMkBasicLogEntryResult.severity());
  }
}
