package org.finos.waltz.service.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.junit.jupiter.api.Test;

class RoadmapUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link RoadmapUtilities#mkBasicLogEntry(long, String, String)}
   */
  @Test
  void testMkBasicLogEntry() {
    // Arrange and Act
    ChangeLog actualMkBasicLogEntryResult = RoadmapUtilities.mkBasicLogEntry(1L, "Not all who wander are lost", "42");

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
