package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;

class EntityReferenceNameResolverDiffblueTest {
  /**
   * Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  void testResolve() {
    // Arrange
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(
        new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertTrue(entityReferenceNameResolver.resolve(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  void testResolve2() {
    // Arrange
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(
        new DefaultDSLContext(SQLDialect.DEFAULT));

    // Act and Assert
    assertTrue(entityReferenceNameResolver.resolve(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link EntityReferenceNameResolver#resolve(List)}
   */
  @Test
  void testResolve3() {
    // Arrange
    EntityReferenceNameResolver entityReferenceNameResolver = new EntityReferenceNameResolver(
        new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertTrue(entityReferenceNameResolver.resolve(new ArrayList<>()).isEmpty());
  }
}
