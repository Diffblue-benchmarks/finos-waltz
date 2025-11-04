package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.GenericSelector;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;

class ContextPopulatorDiffblueTest {
  /**
   * Method under test:
   * {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  void testPopulateContext() {
    // Arrange
    ContextPopulator contextPopulator = new ContextPopulator(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(contextPopulator.populateContext(new HashSet<>(), null).isEmpty());
  }

  /**
   * Method under test:
   * {@link ContextPopulator#populateContext(Set, GenericSelector)}
   */
  @Test
  void testPopulateContext2() {
    // Arrange
    ContextPopulator contextPopulator = new ContextPopulator(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertTrue(contextPopulator.populateContext(new HashSet<>(), null).isEmpty());
  }
}
