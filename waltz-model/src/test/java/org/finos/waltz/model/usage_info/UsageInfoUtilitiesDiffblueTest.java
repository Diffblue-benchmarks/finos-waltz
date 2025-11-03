package org.finos.waltz.model.usage_info;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.system.ImmutableSystemChangeSet;
import org.finos.waltz.model.system.SystemChangeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UsageInfoUtilitiesDiffblueTest {
  /**
   * Test {@link UsageInfoUtilities#mkChangeSet(Set, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link ImmutableSystemChangeSet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UsageInfoUtilities#mkChangeSet(Set, Set)}
   */
  @Test
  @DisplayName("Test mkChangeSet(Set, Set); when HashSet(); then return ImmutableSystemChangeSet")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SystemChangeSet UsageInfoUtilities.mkChangeSet(Set, Set)"})
  void testMkChangeSet_whenHashSet_thenReturnImmutableSystemChangeSet() {
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
