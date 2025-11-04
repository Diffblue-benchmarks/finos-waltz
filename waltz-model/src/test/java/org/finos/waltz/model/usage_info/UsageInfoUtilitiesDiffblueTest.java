package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.system.ImmutableSystemChangeSet;
import org.finos.waltz.model.system.SystemChangeSet;
import org.junit.jupiter.api.Test;

class UsageInfoUtilitiesDiffblueTest {
  /**
   * Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  void testMkChangeSet() {
    // Arrange
    HashSet<UsageInfo> base = new HashSet<>();

    // Act
    SystemChangeSet<UsageInfo, UsageKind> actualMkChangeSetResult = UsageInfoUtilities.mkChangeSet(base,
        new HashSet<>());

    // Assert
    assertTrue(actualMkChangeSetResult instanceof ImmutableSystemChangeSet);
    List<UsageKind> deletesResult = actualMkChangeSetResult.deletes();
    assertTrue(deletesResult.isEmpty());
    assertSame(deletesResult, actualMkChangeSetResult.inserts());
    assertSame(deletesResult, actualMkChangeSetResult.updates());
  }
}
