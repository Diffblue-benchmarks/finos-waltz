package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ContextPopulatorDiffblueTest {
  /**
   * Test {@link ContextPopulator#populateContext(Set, GenericSelector)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  @DisplayName("Test populateContext(Set, GenericSelector); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ContextPopulator.populateContext(Set, GenericSelector)"})
  void testPopulateContext_whenHashSet_thenReturnEmpty() {
    // Arrange
    ContextPopulator contextPopulator = new ContextPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(contextPopulator.populateContext(new HashSet<>(), null).isEmpty());
  }
}
