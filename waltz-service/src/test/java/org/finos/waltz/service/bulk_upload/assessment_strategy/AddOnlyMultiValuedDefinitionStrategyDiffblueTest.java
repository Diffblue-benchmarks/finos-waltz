package org.finos.waltz.service.bulk_upload.assessment_strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.ImmutableBulkChangeStatistics;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AddOnlyMultiValuedDefinitionStrategyDiffblueTest {
  /**
   * Test {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext, AssessmentDefinition, Set, Set, String)}.
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext, AssessmentDefinition, Set, Set, String)}
   */
  @Test
  @DisplayName("Test apply(DSLContext, AssessmentDefinition, Set, Set, String); then calls createStatement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "BulkChangeStatistics AddOnlyMultiValuedDefinitionStrategy.apply(DSLContext, AssessmentDefinition, Set, Set, String)"})
  void testApply_thenCallsCreateStatement() throws SQLException {
    // Arrange
    AddOnlyMultiValuedDefinitionStrategy addOnlyMultiValuedDefinitionStrategy = new AddOnlyMultiValuedDefinitionStrategy();
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[]{1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();
    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<Tuple3<Long, Long, String>> requiredRatings = new HashSet<>();

    // Act
    BulkChangeStatistics actualApplyResult = addOnlyMultiValuedDefinitionStrategy.apply(tx, null, requiredRatings,
        new HashSet<>(), "janedoe");

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertTrue(actualApplyResult instanceof ImmutableBulkChangeStatistics);
    assertEquals(0, actualApplyResult.addedCount());
    assertEquals(0, actualApplyResult.removedCount());
    assertEquals(0, actualApplyResult.updatedCount());
  }
}
