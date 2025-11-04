package org.finos.waltz.service.bulk_upload.column_parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import org.finos.waltz.model.bulk_upload.ResolutionStatus;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.AssessmentHeaderCell;
import org.finos.waltz.model.bulk_upload.legal_entity_relationship.ImmutableAssessmentCell;
import org.junit.jupiter.api.Test;

class AlwaysFailingColumnParserDiffblueTest {
  /**
   * Method under test:
   * {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    AlwaysFailingColumnParser alwaysFailingColumnParser = new AlwaysFailingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("42", new ArrayList<>());

    // Assert
    verify(headerCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("42", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.ratings().size());
    Set<ResolutionStatus> statusesResult = actualApplyResult.statuses();
    assertEquals(1, statusesResult.size());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(statusesResult.contains(ResolutionStatus.ERROR));
  }

  /**
   * Method under test:
   * {@link AlwaysFailingColumnParser#apply(String, Collection)}
   */
  @Test
  void testApply2() {
    // Arrange
    AssessmentHeaderCell headerCell = mock(AssessmentHeaderCell.class);
    when(headerCell.columnId()).thenReturn(1);
    AlwaysFailingColumnParser alwaysFailingColumnParser = new AlwaysFailingColumnParser(headerCell);

    // Act
    AssessmentCell actualApplyResult = alwaysFailingColumnParser.apply("", new ArrayList<>());

    // Assert
    verify(headerCell).columnId();
    assertTrue(actualApplyResult instanceof ImmutableAssessmentCell);
    assertEquals("", actualApplyResult.inputString());
    assertEquals(1, actualApplyResult.columnId());
    assertTrue(actualApplyResult.ratings().isEmpty());
    assertTrue(actualApplyResult.statuses().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlwaysFailingColumnParser#AlwaysFailingColumnParser(AssessmentHeaderCell)}
   *   <li>{@link AlwaysFailingColumnParser#getHeader()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new AlwaysFailingColumnParser(null)).getHeader());
  }
}
