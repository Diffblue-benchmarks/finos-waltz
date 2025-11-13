package org.finos.waltz.service.bulk_upload.assessment_strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.BulkChangeStatistics;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableBulkChangeStatistics;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition.Builder;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AddOnlyMultiValuedDefinitionStrategyDiffblueTest {
  /**
   * Test {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext, AssessmentDefinition, Set,
   * Set, String)}.
   *
   * <ul>
   *   <li>Given {@link Tuple3#Tuple3(Object, Object, Object)} with v1 is zero and v2 is one and v3
   *       is {@code xs cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext,
   * AssessmentDefinition, Set, Set, String)}
   */
  @Test
  @DisplayName(
      "Test apply(DSLContext, AssessmentDefinition, Set, Set, String); given Tuple3(Object, Object, Object) with v1 is zero and v2 is one and v3 is 'xs cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkChangeStatistics AddOnlyMultiValuedDefinitionStrategy.apply(DSLContext, AssessmentDefinition, Set, Set, String)"
  })
  void testApply_givenTuple3WithV1IsZeroAndV2IsOneAndV3IsXsCannotBeNull() throws SQLException {
    // Arrange
    AddOnlyMultiValuedDefinitionStrategy addOnlyMultiValuedDefinitionStrategy =
        new AddOnlyMultiValuedDefinitionStrategy();

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition definition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    HashSet<Tuple3<Long, Long, String>> requiredRatings = new HashSet<>();
    requiredRatings.add(new Tuple3<>(0L, 1L, "xs cannot be null"));

    HashSet<Tuple3<Long, Long, String>> existingRatings = new HashSet<>();
    existingRatings.add(new Tuple3<>(1L, 1L, "xs cannot be null"));

    // Act
    BulkChangeStatistics actualApplyResult =
        addOnlyMultiValuedDefinitionStrategy.apply(
            tx, definition, requiredRatings, existingRatings, "janedoe");

    // Assert
    verify(connection).createStatement();
    verify(connection)
        .prepareStatement(
            "insert into \"assessment_rating\" (\"entity_id\", \"entity_kind\", \"assessment_definition_id\", \"rating_id\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"is_readonly\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).addBatch();
    verify(preparedStatement).setBoolean(9, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(statement).close();
    verify(preparedStatement).executeBatch();
    verify(statement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertTrue(actualApplyResult instanceof ImmutableBulkChangeStatistics);
    assertEquals(0, actualApplyResult.addedCount());
    assertEquals(0, actualApplyResult.removedCount());
    assertEquals(0, actualApplyResult.updatedCount());
  }

  /**
   * Test {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext, AssessmentDefinition, Set,
   * Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext,
   * AssessmentDefinition, Set, Set, String)}
   */
  @Test
  @DisplayName(
      "Test apply(DSLContext, AssessmentDefinition, Set, Set, String); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkChangeStatistics AddOnlyMultiValuedDefinitionStrategy.apply(DSLContext, AssessmentDefinition, Set, Set, String)"
  })
  void testApply_thenCallsCreateStatement() throws SQLException {
    // Arrange
    AddOnlyMultiValuedDefinitionStrategy addOnlyMultiValuedDefinitionStrategy =
        new AddOnlyMultiValuedDefinitionStrategy();

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition definition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();
    HashSet<Tuple3<Long, Long, String>> requiredRatings = new HashSet<>();

    // Act
    BulkChangeStatistics actualApplyResult =
        addOnlyMultiValuedDefinitionStrategy.apply(
            tx, definition, requiredRatings, new HashSet<>(), "janedoe");

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

  /**
   * Test {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext, AssessmentDefinition, Set,
   * Set, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AddOnlyMultiValuedDefinitionStrategy#apply(DSLContext,
   * AssessmentDefinition, Set, Set, String)}
   */
  @Test
  @DisplayName(
      "Test apply(DSLContext, AssessmentDefinition, Set, Set, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkChangeStatistics AddOnlyMultiValuedDefinitionStrategy.apply(DSLContext, AssessmentDefinition, Set, Set, String)"
  })
  void testApply_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    AddOnlyMultiValuedDefinitionStrategy addOnlyMultiValuedDefinitionStrategy =
        new AddOnlyMultiValuedDefinitionStrategy();

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    Builder provenanceResult =
        ImmutableAssessmentDefinition.builder()
            .cardinality(Cardinality.ZERO_ONE)
            .definitionGroup("Definition Group")
            .description("The characteristics of someone or something")
            .entityKind(EntityKind.ALL)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .permittedRole("Permitted Role")
            .provenance("Provenance");
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierReference = Optional.of(immutableEntityReference);
    ImmutableAssessmentDefinition definition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    HashSet<Tuple3<Long, Long, String>> requiredRatings = new HashSet<>();
    requiredRatings.add(new Tuple3<>(1L, 1L, "xs cannot be null"));

    // Act
    BulkChangeStatistics actualApplyResult =
        addOnlyMultiValuedDefinitionStrategy.apply(
            tx, definition, requiredRatings, new HashSet<>(), "janedoe");

    // Assert
    verify(connection).createStatement();
    verify(connection)
        .prepareStatement(
            "insert into \"assessment_rating\" (\"entity_id\", \"entity_kind\", \"assessment_definition_id\", \"rating_id\", \"description\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"is_readonly\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).addBatch();
    verify(preparedStatement).setBoolean(9, false);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(6), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(statement).close();
    verify(preparedStatement).executeBatch();
    verify(statement).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(statement).getWarnings();
    assertTrue(actualApplyResult instanceof ImmutableBulkChangeStatistics);
    assertEquals(0, actualApplyResult.addedCount());
    assertEquals(0, actualApplyResult.removedCount());
    assertEquals(0, actualApplyResult.updatedCount());
  }
}
