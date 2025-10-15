package org.finos.waltz.data.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ImmutableApplicationIdSelectionOptions;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_definition.AssessmentRipplerJobConfiguration;
import org.finos.waltz.model.assessment_definition.AssessmentRipplerJobStep;
import org.finos.waltz.model.assessment_definition.AssessmentVisibility;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentDefinition;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobStep;
import org.finos.waltz.schema.tables.records.AssessmentDefinitionRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectWhereStep;
import org.jooq.Table;
import org.jooq.TransactionalCallable;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AssessmentRatingRipplerDiffblueTest {
  @InjectMocks private AssessmentRatingRippler assessmentRatingRippler;

  @Mock private DSLContext dSLContext;

  @Mock private SettingsDao settingsDao;

  /**
   * Test {@link AssessmentRatingRippler#parseConfig(String, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@link ImmutableAssessmentRipplerJobConfiguration}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#parseConfig(String, String)}
   */
  @Test
  @DisplayName(
      "Test parseConfig(String, String); when 'Name'; then return ImmutableAssessmentRipplerJobConfiguration")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssessmentRipplerJobConfiguration AssessmentRatingRippler.parseConfig(String, String)"
  })
  void testParseConfig_whenName_thenReturnImmutableAssessmentRipplerJobConfiguration()
      throws JsonProcessingException {
    // Arrange
    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    ImmutableAssessmentRipplerJobStep immutableAssessmentRipplerJobStep =
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build();
    String value =
        jsonMapper.writeValueAsString(
            new AssessmentRipplerJobStep[] {immutableAssessmentRipplerJobStep});

    // Act
    AssessmentRipplerJobConfiguration actualParseConfigResult =
        AssessmentRatingRippler.parseConfig("Name", value);

    // Assert
    assertTrue(actualParseConfigResult instanceof ImmutableAssessmentRipplerJobConfiguration);
    List<AssessmentRipplerJobStep> stepsResult = actualParseConfigResult.steps();
    assertEquals(1, stepsResult.size());
    AssessmentRipplerJobStep getResult = stepsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRipplerJobStep);
    assertEquals("Name", actualParseConfigResult.name());
    assertEquals("To Def", getResult.toDef());
    assertEquals("jane.doe@example.org", getResult.fromDef());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments()}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  @DisplayName("Test rippleAssessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingRippler.rippleAssessments()"})
  void testRippleAssessments() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> assessmentRatingRippler.rippleAssessments());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments()}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  @DisplayName("Test rippleAssessments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingRippler.rippleAssessments()"})
  void testRippleAssessments2() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    AssessmentRatingRippler assessmentRatingRippler = new AssessmentRatingRippler(dsl, settingsDao);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> assessmentRatingRippler.rippleAssessments());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)} with {@code assessmentDefinition}, {@code scope}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessments(AssessmentDefinition, IdSelectionOptions) with 'assessmentDefinition', 'scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long AssessmentRatingRippler.rippleAssessments(AssessmentDefinition, IdSelectionOptions)"
  })
  void testRippleAssessmentsWithAssessmentDefinitionScope() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            assessmentRatingRippler.rippleAssessments(
                assessmentDefinition,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)} with {@code assessmentDefinition}, {@code scope}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessments(AssessmentDefinition, IdSelectionOptions) with 'assessmentDefinition', 'scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long AssessmentRatingRippler.rippleAssessments(AssessmentDefinition, IdSelectionOptions)"
  })
  void testRippleAssessmentsWithAssessmentDefinitionScope2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("Assessment not related to kind: %s", "Assessment not related to kind: %s");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Long actualRippleAssessmentsResult =
        assessmentRatingRippler.rippleAssessments(
            assessmentDefinition,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)} with {@code assessmentDefinition}, {@code scope}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessments(AssessmentDefinition, IdSelectionOptions) with 'assessmentDefinition', 'scope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long AssessmentRatingRippler.rippleAssessments(AssessmentDefinition, IdSelectionOptions)"
  })
  void testRippleAssessmentsWithAssessmentDefinitionScope3() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    ImmutableApplicationIdSelectionOptions.Builder builderResult =
        ImmutableApplicationIdSelectionOptions.builder();

    ImmutableApplicationIdSelectionOptions.Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    ImmutableApplicationIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Long actualRippleAssessmentsResult =
        assessmentRatingRippler.rippleAssessments(
            assessmentDefinition,
            joiningEntityKindResult
                .addAllApplicationKinds(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)} with {@code assessmentDefinition}, {@code scope}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments(AssessmentDefinition,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessments(AssessmentDefinition, IdSelectionOptions) with 'assessmentDefinition', 'scope'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long AssessmentRatingRippler.rippleAssessments(AssessmentDefinition, IdSelectionOptions)"
  })
  void testRippleAssessmentsWithAssessmentDefinitionScope_thenReturnLongValueIsZero() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    ImmutableAssessmentDefinition.Builder provenanceResult =
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
    ImmutableAssessmentDefinition assessmentDefinition =
        provenanceResult
            .qualifierReference(qualifierReference)
            .ratingSchemeId(1L)
            .visibility(AssessmentVisibility.PRIMARY)
            .build();

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    Long actualRippleAssessmentsResult =
        assessmentRatingRippler.rippleAssessments(
            assessmentDefinition,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code job.RIPPLE_ASSESSMENTS.} is {@code
   *       job.RIPPLE_ASSESSMENTS.}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  @DisplayName(
      "Test rippleAssessments(); given HashMap() 'job.RIPPLE_ASSESSMENTS.' is 'job.RIPPLE_ASSESSMENTS.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingRippler.rippleAssessments()"})
  void testRippleAssessments_givenHashMapJobRippleAssessmentsIsJobRippleAssessments()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    AssessmentRatingRippler assessmentRatingRippler = new AssessmentRatingRippler(dsl, settingsDao);

    // Act
    Long actualRippleAssessmentsResult = assessmentRatingRippler.rippleAssessments();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments()}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  @DisplayName("Test rippleAssessments(); then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingRippler.rippleAssessments()"})
  void testRippleAssessments_thenReturnLongValueIsZero() throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    doNothing().when(connection).commit();
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    AssessmentRatingRippler assessmentRatingRippler = new AssessmentRatingRippler(dsl, settingsDao);

    // Act
    Long actualRippleAssessmentsResult = assessmentRatingRippler.rippleAssessments();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertEquals(0L, actualRippleAssessmentsResult.longValue());
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessments()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessments()}
   */
  @Test
  @DisplayName("Test rippleAssessments(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long AssessmentRatingRippler.rippleAssessments()"})
  void testRippleAssessments_thenThrowIllegalArgumentException() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("42", "42");

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    AssessmentRatingRippler assessmentRatingRippler = new AssessmentRatingRippler(dsl, settingsDao);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assessmentRatingRippler.rippleAssessments());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String, String, String,
   * String, Optional)} with {@code DSLContext}, {@code String}, {@code String}, {@code String},
   * {@code String}, {@code Optional}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String,
   * String, String, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessment(DSLContext, String, String, String, String, Optional) with 'DSLContext', 'String', 'String', 'String', 'String', 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssessmentRatingRippler.rippleAssessment(DSLContext, String, String, String, String, Optional)"
  })
  void testRippleAssessmentWithDSLContextStringStringStringStringOptional() {
    // Arrange
    when(dSLContext.selectFrom(Mockito.<Table<AssessmentDefinitionRecord>>any()))
        .thenThrow(new UnsupportedOperationException());

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<IdSelectionOptions> scope = Optional.of(immutableIdSelectionOptions);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            AssessmentRatingRippler.rippleAssessment(
                dSLContext,
                "42",
                "Provenance",
                "jane.doe@example.org",
                "alice.liddell@example.org",
                scope));
    verify(dSLContext).selectFrom(isA(Table.class));
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String, String, String,
   * String, Optional)} with {@code DSLContext}, {@code String}, {@code String}, {@code String},
   * {@code String}, {@code Optional}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String,
   * String, String, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessment(DSLContext, String, String, String, String, Optional) with 'DSLContext', 'String', 'String', 'String', 'String', 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssessmentRatingRippler.rippleAssessment(DSLContext, String, String, String, String, Optional)"
  })
  void testRippleAssessmentWithDSLContextStringStringStringStringOptional2() {
    // Arrange
    SelectWhereStep<AssessmentDefinitionRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dSLContext.selectFrom(Mockito.<Table<AssessmentDefinitionRecord>>any()))
        .thenReturn(selectWhereStep);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<IdSelectionOptions> scope = Optional.of(immutableIdSelectionOptions);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            AssessmentRatingRippler.rippleAssessment(
                dSLContext,
                "42",
                "Provenance",
                "jane.doe@example.org",
                "alice.liddell@example.org",
                scope));
    verify(dSLContext).selectFrom(isA(Table.class));
    verify(selectWhereStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String, String, String,
   * String, Optional)} with {@code DSLContext}, {@code String}, {@code String}, {@code String},
   * {@code String}, {@code Optional}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#rippleAssessment(DSLContext, String,
   * String, String, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test rippleAssessment(DSLContext, String, String, String, String, Optional) with 'DSLContext', 'String', 'String', 'String', 'String', 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssessmentRatingRippler.rippleAssessment(DSLContext, String, String, String, String, Optional)"
  })
  void testRippleAssessmentWithDSLContextStringStringStringStringOptional3()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<AssessmentDefinitionRecord> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchMap(
            Mockito.<RecordMapper<AssessmentDefinitionRecord, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectWhereStep<AssessmentDefinitionRecord> selectWhereStep = mock(SelectWhereStep.class);
    when(selectWhereStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);
    when(dSLContext.selectFrom(Mockito.<Table<AssessmentDefinitionRecord>>any()))
        .thenReturn(selectWhereStep);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    ImmutableIdSelectionOptions immutableIdSelectionOptions =
        joiningEntityKindResult
            .addAllEntityLifecycleStatuses(new ArrayList<>())
            .scope(HierarchyQueryScope.EXACT)
            .build();
    Optional<IdSelectionOptions> scope = Optional.of(immutableIdSelectionOptions);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            AssessmentRatingRippler.rippleAssessment(
                dSLContext,
                "42",
                "Provenance",
                "jane.doe@example.org",
                "alice.liddell@example.org",
                scope));
    verify(dSLContext).selectFrom(isA(Table.class));
    verify(selectConditionStep).fetchMap(isA(RecordMapper.class));
    verify(selectWhereStep).where(isA(Condition.class));
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig2() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIs42() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "42");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIs422() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "42");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} IfAbsent {@code job.RIPPLE_ASSESSMENTS.} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() IfAbsent 'job.RIPPLE_ASSESSMENTS.' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapIfAbsentJobRippleAssessmentsIsEmptyString() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code job.RIPPLE_ASSESSMENTS.} is {@code
   *       job.RIPPLE_ASSESSMENTS.}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() 'job.RIPPLE_ASSESSMENTS.' is 'job.RIPPLE_ASSESSMENTS.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapJobRippleAssessmentsIsJobRippleAssessments() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code jobxRIPPLE_ASSESSMENTSx} is {@code
   *       jobxRIPPLE_ASSESSMENTSx}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given HashMap() 'jobxRIPPLE_ASSESSMENTSx' is 'jobxRIPPLE_ASSESSMENTSx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenHashMapJobxRIPPLEASSESSMENTSxIsJobxRIPPLEASSESSMENTSx() {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("jobxRIPPLE_ASSESSMENTSx", "jobxRIPPLE_ASSESSMENTSx");
    stringStringMap.put("^job.RIPPLE_ASSESSMENTS.", "^job.RIPPLE_ASSESSMENTS.");
    stringStringMap.putIfAbsent("job.RIPPLE_ASSESSMENTS.", "job.RIPPLE_ASSESSMENTS.");
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(stringStringMap);

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Given {@link SettingsDao} {@link SettingsDao#indexByPrefix(String)} return {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName(
      "Test findRippleConfig(); given SettingsDao indexByPrefix(String) return HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_givenSettingsDaoIndexByPrefixReturnHashMap_thenReturnEmpty() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    Set<AssessmentRipplerJobConfiguration> actualFindRippleConfigResult =
        assessmentRatingRippler.findRippleConfig();

    // Assert
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
    assertTrue(actualFindRippleConfigResult.isEmpty());
  }

  /**
   * Test {@link AssessmentRatingRippler#findRippleConfig()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentRatingRippler#findRippleConfig()}
   */
  @Test
  @DisplayName("Test findRippleConfig(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AssessmentRatingRippler.findRippleConfig()"})
  void testFindRippleConfig_thenThrowUnsupportedOperationException() {
    // Arrange
    when(settingsDao.indexByPrefix(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> assessmentRatingRippler.findRippleConfig());
    verify(settingsDao).indexByPrefix("job.RIPPLE_ASSESSMENTS.");
  }
}
