package org.finos.waltz.data.changelog;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChangeLogDaoDiffblueTest {
  /**
   * Test {@link ChangeLogDao#mkUnattestedChangesQuery(EntityReference)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.</li>
   *   <li>Then calls {@link EntityReference#id()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeLogDao#mkUnattestedChangesQuery(EntityReference)}
   */
  @Test
  @DisplayName("Test mkUnattestedChangesQuery(EntityReference); given one; when EntityReference id() return one; then calls id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.jooq.SelectConditionStep ChangeLogDao.mkUnattestedChangesQuery(EntityReference)"})
  void testMkUnattestedChangesQuery_givenOne_whenEntityReferenceIdReturnOne_thenCallsId() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    ChangeLogDao.mkUnattestedChangesQuery(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
  }
}
