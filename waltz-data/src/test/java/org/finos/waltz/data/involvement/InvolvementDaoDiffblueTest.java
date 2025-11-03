package org.finos.waltz.data.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.involvement.Involvement;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InvolvementDaoDiffblueTest {
  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   * <p>
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(mock(DefaultDSLContext.class));
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenThrow(new UnsupportedOperationException("foo"));

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkStoreInvolvements(involvements));
    verify(involvement).entityReference();
  }

  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   * <p>
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements2() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(mock(DefaultDSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenThrow(new UnsupportedOperationException("foo"));
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement = mock(Involvement.class);
    when(involvement.entityReference()).thenReturn(entityReference);

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkStoreInvolvements(involvements));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(involvement, atLeast(1)).entityReference();
  }

  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   * <p>
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements3() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(mock(DefaultDSLContext.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement = mock(Involvement.class);
    when(involvement.employeeId()).thenReturn("42");
    when(involvement.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    Involvement involvement2 = mock(Involvement.class);
    when(involvement2.employeeId()).thenThrow(new UnsupportedOperationException("foo"));
    when(involvement2.entityReference()).thenReturn(entityReference2);

    HashSet<Involvement> involvements = new HashSet<>();
    involvements.add(involvement2);
    involvements.add(involvement);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> involvementDao.bulkStoreInvolvements(involvements));
    verify(entityReference2).id();
    verify(entityReference2).kind();
    verify(involvement2).employeeId();
    verify(involvement2, atLeast(1)).entityReference();
  }

  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code SQL99}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements_givenDefaultDSLContextWithDialectIsSql99_whenHashSet() {
    // Arrange
    InvolvementDao involvementDao = new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, involvementDao.bulkStoreInvolvements(new HashSet<>()));
  }

  /**
   * Test {@link InvolvementDao#bulkStoreInvolvements(Set)}.
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code SQL99}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InvolvementDao#bulkStoreInvolvements(Set)}
   */
  @Test
  @DisplayName("Test bulkStoreInvolvements(Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int InvolvementDao.bulkStoreInvolvements(Set)"})
  void testBulkStoreInvolvements_givenDefaultDSLContextWithDialectIsSql99_whenNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new InvolvementDao(new DefaultDSLContext(SQLDialect.SQL99))).bulkStoreInvolvements(null));
  }
}
