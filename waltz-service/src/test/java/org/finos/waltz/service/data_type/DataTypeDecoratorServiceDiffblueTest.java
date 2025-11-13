package org.finos.waltz.service.data_type;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDaoSelectorFactory;
import org.finos.waltz.data.datatype_decorator.LogicalFlowDecoratorDao;
import org.finos.waltz.data.datatype_decorator.PhysicalSpecDecoratorDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableAssessmentsView;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeDecorator;
import org.finos.waltz.model.datatype.DataTypeDecoratorRatingCharacteristics;
import org.finos.waltz.model.datatype.DataTypeUsageCharacteristics;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecorator;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.finos.waltz.model.flow_classification.ImmutableFlowClassification;
import org.finos.waltz.model.logical_flow.DataTypeDecoratorView;
import org.finos.waltz.model.logical_flow.ImmutableDataTypeDecoratorView;
import org.finos.waltz.model.logical_flow.ImmutableFlowClassificationRulesView;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow.Builder;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
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
class DataTypeDecoratorServiceDiffblueTest {
  @Mock private AssessmentDefinitionService assessmentDefinitionService;

  @Mock private AssessmentRatingService assessmentRatingService;

  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeDecoratorDaoSelectorFactory dataTypeDecoratorDaoSelectorFactory;

  @InjectMocks private DataTypeDecoratorService dataTypeDecoratorService;

  @Mock private DataTypeService dataTypeService;

  @Mock private DataTypeUsageService dataTypeUsageService;

  @Mock private FlowClassificationRuleService flowClassificationRuleService;

  @Mock private FlowClassificationService flowClassificationService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private LogicalFlowDecoratorRatingsCalculator logicalFlowDecoratorRatingsCalculator;

  @Mock private LogicalFlowDecoratorService logicalFlowDecoratorService;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  @Mock private RatingSchemeService ratingSchemeService;

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(String, EntityReference, Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityReferenceList);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);
    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(String, EntityReference, Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators2() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityReferenceList);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);
    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(String, EntityReference, Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators3() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenThrow(new UnsupportedOperationException());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(String, EntityReference, Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators4() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenThrow(new UnsupportedOperationException());
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName("Test updateDecorators(String, EntityReference, Set, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators5() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(
            Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    HashSet<Long> dataTypeIdsToRemove = new HashSet<>();
    dataTypeIdsToRemove.add(-2L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, dataTypeIdsToRemove);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory, atLeast(1)).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDecoratorDao)
        .removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link FlowClassificationRuleService}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given FlowClassificationRuleService; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenFlowClassificationRuleService_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);
    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link FlowClassificationRuleService}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given FlowClassificationRuleService; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenFlowClassificationRuleService_whenNull_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, new HashSet<>(), null);

    // Assert
    verify(logicalFlowDao).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowDecoratorDao} {@link
   *       LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)} return one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given LogicalFlowDecoratorDao removeDataTypes(EntityReference, Collection) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenLogicalFlowDecoratorDaoRemoveDataTypesReturnOne() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(
            Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(1);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    HashSet<Long> dataTypeIdsToRemove = new HashSet<>();
    dataTypeIdsToRemove.add(-2L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, dataTypeIdsToRemove);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory, atLeast(1)).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDecoratorDao)
        .removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService, atLeast(1)).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When {@link HashSet#HashSet()} add minus two.
   *   <li>Then calls {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given minus two; when HashSet() add minus two; then calls addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenMinusTwo_whenHashSetAddMinusTwo_thenCallsAddDecorators() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(-2L);
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#getWarnings()} return {@link
   *       SQLWarning#SQLWarning()}.
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given Statement getWarnings() return SQLWarning(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenStatementGetWarningsReturnSQLWarning_thenCallsClose()
      throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#getWarnings()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); given Statement getWarnings() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_givenStatementGetWarningsThrowUnsupportedOperationException()
      throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenThrow(new UnsupportedOperationException());

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#updateDecorators(String, EntityReference, Set, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link LogicalFlowDecoratorDao#addDecorators(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#updateDecorators(String, EntityReference,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecorators(String, EntityReference, Set, Set); then calls addDecorators(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DataTypeDecoratorService.updateDecorators(String, EntityReference, Set, Set)"
  })
  void testUpdateDecorators_thenCallsAddDecorators() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder provenanceResult =
        builderResult
            .created(created)
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");

    Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowDao.getByFlowId(anyLong()))
        .thenReturn(
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());
    when(dataTypeUsageService.recalculateForApplications(
            Mockito.<Collection<EntityReference>>any()))
        .thenReturn(true);
    when(dataTypeService.findByIdSelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    when(flowClassificationRuleService.recalculateFlowRatingsForSelector(
            Mockito.<IdSelectionOptions>any()))
        .thenReturn(1);

    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.LOGICAL_DATA_FLOW);

    HashSet<Long> dataTypeIdsToAdd = new HashSet<>();
    dataTypeIdsToAdd.add(1L);

    // Act
    boolean actualUpdateDecoratorsResult =
        dataTypeDecoratorService.updateDecorators(
            "janedoe", entityReference, dataTypeIdsToAdd, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(logicalFlowDao, atLeast(1)).getByFlowId(1L);
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(dataTypeService, atLeast(1)).findByIdSelector(isA(Select.class));
    verify(flowClassificationRuleService)
        .recalculateFlowRatingsForSelector(isA(IdSelectionOptions.class));
    verify(dataTypeUsageService).recalculateForApplications(isA(Collection.class));
    assertTrue(actualUpdateDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}.
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}
   */
  @Test
  @DisplayName("Test getByEntityRefAndDataTypeId(EntityReference, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator DataTypeDecoratorService.getByEntityRefAndDataTypeId(EntityReference, long)"
  })
  void testGetByEntityRefAndDataTypeId() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    when(logicalFlowDecoratorDao.getByEntityIdAndDataTypeId(anyLong(), anyLong()))
        .thenReturn(ratingResult.targetInboundRating(targetInboundRating).build());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference reference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    DataTypeDecorator actualByEntityRefAndDataTypeId =
        dataTypeDecoratorService.getByEntityRefAndDataTypeId(reference, 1L);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).getByEntityIdAndDataTypeId(1L, 1L);
    EntityReference entityReferenceResult = actualByEntityRefAndDataTypeId.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    EntityReference decoratorEntityResult2 = actualByEntityRefAndDataTypeId.decoratorEntity();
    assertTrue(decoratorEntityResult2 instanceof ImmutableEntityReference);
    assertTrue(actualByEntityRefAndDataTypeId instanceof ImmutableDataTypeDecorator);
    LocalDateTime lastUpdatedAtResult = actualByEntityRefAndDataTypeId.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualByEntityRefAndDataTypeId.lastUpdatedBy());
    assertEquals("Provenance", actualByEntityRefAndDataTypeId.provenance());
    assertEquals(1L, actualByEntityRefAndDataTypeId.dataFlowId());
    assertEquals(1L, actualByEntityRefAndDataTypeId.dataTypeId());
    assertFalse(actualByEntityRefAndDataTypeId.isReadonly());
    assertEquals(reference, entityReferenceResult);
    assertEquals(reference, decoratorEntityResult2);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#getByEntityRefAndDataTypeId(EntityReference, long)}
   */
  @Test
  @DisplayName(
      "Test getByEntityRefAndDataTypeId(EntityReference, long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecorator DataTypeDecoratorService.getByEntityRefAndDataTypeId(EntityReference, long)"
  })
  void testGetByEntityRefAndDataTypeId_thenThrowUnsupportedOperationException() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getByEntityRefAndDataTypeId(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityId(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityId(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityId(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeDecoratorService.findByEntityId(EntityReference)"})
  void testFindByEntityId_thenReturnEmpty() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    // Act
    List<DataTypeDecorator> actualFindByEntityIdResult =
        dataTypeDecoratorService.findByEntityId(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    assertTrue(actualFindByEntityIdResult.isEmpty());
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityId(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityId(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityId(EntityReference); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeDecoratorService.findByEntityId(EntityReference)"})
  void testFindByEntityId_thenThrowUnsupportedOperationException() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findByEntityId(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByEntityIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findByEntityIdSelector(
                EntityKind.ALL,
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByEntityIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector2() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByEntityIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector3() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(mock(LogicalFlowDecoratorDao.class));

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.AGGREGATE_OVERLAY_DIAGRAM)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findByEntityIdSelector(
                EntityKind.LOGICAL_DATA_FLOW, selectionOptions));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(selectionOptions, atLeast(1)).entityReference();
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findByEntityIdSelector(EntityKind, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector4() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findByEntityIdSelector(
                EntityKind.LOGICAL_DATA_FLOW, selectionOptions));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions, atLeast(1)).entityReference();
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_givenBuilderAddOmitApplicationKindsInHouse() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters immutableSelectionFilters = builderResult.build();

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(immutableSelectionFilters);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions, atLeast(1)).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code EXACT}.
   *   <li>Then calls {@link IdSelectionOptions#scope()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); given 'EXACT'; then calls scope()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_givenExact_thenCallsScope() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APPLICATION)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); given HashSet() add 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_givenHashSetAddActive() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); given HashSet() add 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_givenHashSetAddPending() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.PENDING);
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.LOGICAL_DATA_FLOW, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.LOGICAL_DATA_FLOW);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code APPLICATION}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); when 'APPLICATION'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_whenApplication_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(EntityKind.APPLICATION, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.APPLICATION);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); when 'CHANGE_INITIATIVE'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_whenChangeInitiative_thenReturnList() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(
            EntityKind.CHANGE_INITIATIVE, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.CHANGE_INITIATIVE);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind, IdSelectionOptions)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_UNIT}.
   *   <li>Then calls {@link IdSelectionOptions#entityLifecycleStatuses()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByEntityIdSelector(EntityKind,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findByEntityIdSelector(EntityKind, IdSelectionOptions); when 'CHANGE_UNIT'; then calls entityLifecycleStatuses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findByEntityIdSelector(EntityKind, IdSelectionOptions)"
  })
  void testFindByEntityIdSelector_whenChangeUnit_thenCallsEntityLifecycleStatuses() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findByEntityIdSelector(
            Mockito.<Select<Record1<Long>>>any(), Mockito.<Optional<EntityKind>>any()))
        .thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Collection<DataTypeDecorator> actualFindByEntityIdSelectorResult =
        dataTypeDecoratorService.findByEntityIdSelector(EntityKind.CHANGE_UNIT, selectionOptions);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.CHANGE_UNIT);
    verify(logicalFlowDecoratorDao).findByEntityIdSelector(isA(Select.class), isA(Optional.class));
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    assertTrue(actualFindByEntityIdSelectorResult instanceof List);
    assertTrue(actualFindByEntityIdSelectorResult.isEmpty());
    assertSame(dataTypeDecoratorList, actualFindByEntityIdSelectorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators2() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators3() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenThrow(new UnsupportedOperationException());
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators4() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators5() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(dsl).insertInto(isA(Table.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators6() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenThrow(new UnsupportedOperationException());

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetStep).set(isA(Record.class));
    verify(dsl).insertInto(isA(Table.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators7() throws DataAccessException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    InsertOnDuplicateSetStep<LogicalFlowDecoratorRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Record>any()))
        .thenReturn(mock(InsertOnDuplicateSetMoreStep.class));

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(batch).execute();
    verify(insertOnDuplicateSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetStep).set(isA(Record.class));
    verify(dsl).batch((Query[]) Mockito.any());
    verify(dsl).insertInto(isA(Table.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators8() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InsertOnDuplicateSetStep<LogicalFlowDecoratorRecord> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Record>any()))
        .thenThrow(new UnsupportedOperationException());

    InsertSetMoreStep<LogicalFlowDecoratorRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenReturn(insertSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(insertOnDuplicateSetStep).set(isA(Record.class));
    verify(insertSetMoreStep).onDuplicateKeyUpdate();
    verify(insertSetStep).set(isA(Record.class));
    verify(dsl).insertInto(isA(Table.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); given ChangeLogService write(ChangeLog) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_givenChangeLogServiceWriteThrowUnsupportedOperationException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new UnsupportedOperationException());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#batch(Query[])} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); given DefaultDSLContext batch(Query[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_givenDefaultDSLContextBatchThrowUnsupportedOperationException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch((Query[]) Mockito.any())).thenThrow(new UnsupportedOperationException());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(dsl).batch((Query[]) Mockito.any());
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given {@link InsertSetStep} {@link InsertSetStep#set(Record)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); given InsertSetStep set(Record) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_givenInsertSetStepSetThrowUnsupportedOperationException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    InsertSetStep<LogicalFlowDecoratorRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Record>any())).thenThrow(new UnsupportedOperationException());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(insertSetStep);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(15L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(insertSetStep).set(isA(Record.class));
    verify(dsl).insertInto(isA(Table.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given seven.
   *   <li>When {@link HashSet#HashSet()} add seven.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); given seven; when HashSet() add seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_givenSeven_whenHashSetAddSeven() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(7L);
    dataTypeIds.add(1L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#executeBatch()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); given Statement executeBatch() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_givenStatementExecuteBatchThrowUnsupportedOperationException()
      throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenThrow(new UnsupportedOperationException());
    when(statement.getWarnings()).thenThrow(new UnsupportedOperationException());

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertNull(actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Statement#close()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_thenCallsClose() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_thenCallsExecute() throws DataAccessException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch((Query[]) Mockito.any())).thenReturn(batch);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(batch).execute();
    verify(dsl).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_thenReturnArrayOfIntWithTwoAndOne() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with two and one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test addDecorators(String, EntityReference, Set); then return array of int with two and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_thenReturnArrayOfIntWithTwoAndOne2() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.addDecorators(Mockito.<Collection<DataTypeDecorator>>any()))
        .thenReturn(new int[] {2, 1, 2, 1});
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).addDecorators(isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {2, 1, 2, 1}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#addDecorators(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#addDecorators(String, EntityReference,
   * Set)}
   */
  @Test
  @DisplayName("Test addDecorators(String, EntityReference, Set); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeDecoratorService.addDecorators(String, EntityReference, Set)"})
  void testAddDecorators_thenReturnEmptyArrayOfInt() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new PhysicalSpecDecoratorDao(new DefaultDSLContext(SQLDialect.SQL99)));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int[] actualAddDecoratorsResult =
        dataTypeDecoratorService.addDecorators("janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertArrayEquals(new int[] {}, actualAddDecoratorsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName("Test removeDataTypeDecorator(String, EntityReference, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator(
            "janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = cast(? as bigint) and \"logical_flow_decorator\".\"decorator_entity_kind\" = cast(? as varchar) and 1 = 0 and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(0, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); given one; when HashSet() add one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_givenOne_whenHashSetAddOne_thenReturnZero() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" in (?) and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(0, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link HashSet#HashSet()} add two.
   *   <li>Then calls {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); given two; when HashSet() add two; then calls removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_givenTwo_whenHashSetAddTwo_thenCallsRemoveDataTypes() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(
            Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(1);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(2L);
    dataTypeIds.add(1L);

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao)
        .removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link DeleteConditionStep#and(Condition)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); then calls and(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenCallsAnd() throws DataAccessException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep3 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<LogicalFlowDecoratorRecord> deleteConditionStep4 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<LogicalFlowDecoratorRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<LogicalFlowDecoratorRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator(
            "janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); then calls removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenCallsRemoveDataTypes() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(
            Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(1);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator(
            "janedoe", entityReference, new HashSet<>());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao)
        .removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link LogicalFlowDecoratorDao#removeDataTypes(EntityReference, Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); then calls removeDataTypes(EntityReference, Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenCallsRemoveDataTypes2() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.removeDataTypes(
            Mockito.<EntityReference>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(1);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    HashSet<Long> dataTypeIds = new HashSet<>();
    dataTypeIds.add(1L);

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator("janedoe", entityReference, dataTypeIds);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao)
        .removeDataTypes(isA(EntityReference.class), isA(Collection.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName("Test removeDataTypeDecorator(String, EntityReference, Set); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenReturnZero() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator(
            "janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" in () and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(0, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName("Test removeDataTypeDecorator(String, EntityReference, Set); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenReturnZero2() throws SQLException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(new LogicalFlowDecoratorDao(dsl));
    ImmutableAppGroupEntry entityReference =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();

    // Act
    int actualRemoveDataTypeDecoratorResult =
        dataTypeDecoratorService.removeDataTypeDecorator(
            "janedoe", entityReference, new HashSet<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"logical_flow_decorator\" where (\"logical_flow_decorator\".\"logical_flow_id\" = ? and \"logical_flow_decorator\".\"decorator_entity_kind\" = ? and \"logical_flow_decorator\".\"decorator_entity_id\" in () and \"logical_flow_decorator\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).setString(2, "DATA_TYPE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(0, actualRemoveDataTypeDecoratorResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#removeDataTypeDecorator(String, EntityReference, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#removeDataTypeDecorator(String,
   * EntityReference, Set)}
   */
  @Test
  @DisplayName(
      "Test removeDataTypeDecorator(String, EntityReference, Set); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int DataTypeDecoratorService.removeDataTypeDecorator(String, EntityReference, Set)"
  })
  void testRemoveDataTypeDecorator_thenThrowUnsupportedOperationException() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.removeDataTypeDecorator(
                "janedoe", entityReference, new HashSet<>()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then calls {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByFlowIds(Collection, EntityKind); given zero; when ArrayList() add zero; then calls findByFlowIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeDecoratorService.findByFlowIds(Collection, EntityKind)"})
  void testFindByFlowIds_givenZero_whenArrayListAddZero_thenCallsFindByFlowIds() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new HashSet<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult =
        dataTypeDecoratorService.findByFlowIds(ids, EntityKind.ALL);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByFlowIds(isA(Collection.class));
    assertTrue(actualFindByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}.
   *
   * <ul>
   *   <li>Then calls {@link LogicalFlowDecoratorDao#findByFlowIds(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection, EntityKind); then calls findByFlowIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeDecoratorService.findByFlowIds(Collection, EntityKind)"})
  void testFindByFlowIds_thenCallsFindByFlowIds() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByFlowIds(Mockito.<Collection<Long>>any()))
        .thenReturn(new HashSet<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Set<DataTypeDecorator> actualFindByFlowIdsResult =
        dataTypeDecoratorService.findByFlowIds(ids, EntityKind.ALL);

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByFlowIds(isA(Collection.class));
    assertTrue(actualFindByFlowIdsResult.isEmpty());
  }

  /**
   * Test {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test findByFlowIds(Collection, EntityKind); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeDecoratorService.findByFlowIds(Collection, EntityKind)"})
  void testFindByFlowIds_thenThrowUnsupportedOperationException() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeDecoratorService.findByFlowIds(ids, EntityKind.ALL));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection, EntityKind); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeDecoratorService.findByFlowIds(Collection, EntityKind)"})
  void testFindByFlowIds_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(dataTypeDecoratorService.findByFlowIds(new ArrayList<>(), EntityKind.ALL).isEmpty());
  }

  /**
   * Test {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#findByFlowIds(Collection, EntityKind)}
   */
  @Test
  @DisplayName("Test findByFlowIds(Collection, EntityKind); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeDecoratorService.findByFlowIds(Collection, EntityKind)"})
  void testFindByFlowIds_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        dataTypeDecoratorService.findByFlowIds(null, EntityKind.PHYSICAL_SPECIFICATION).isEmpty());
  }

  /**
   * Test {@link DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName("Test findDatatypeUsageCharacteristics(EntityReference); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics_thenReturnList() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    ArrayList<DataTypeUsageCharacteristics> dataTypeUsageCharacteristicsList = new ArrayList<>();
    when(logicalFlowDecoratorDao.findDatatypeUsageCharacteristics(Mockito.<EntityReference>any()))
        .thenReturn(dataTypeUsageCharacteristicsList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    // Act
    Collection<DataTypeUsageCharacteristics> actualFindDatatypeUsageCharacteristicsResult =
        dataTypeDecoratorService.findDatatypeUsageCharacteristics(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findDatatypeUsageCharacteristics(isA(EntityReference.class));
    assertTrue(actualFindDatatypeUsageCharacteristicsResult instanceof List);
    assertTrue(actualFindDatatypeUsageCharacteristicsResult.isEmpty());
    assertSame(dataTypeUsageCharacteristicsList, actualFindDatatypeUsageCharacteristicsResult);
  }

  /**
   * Test {@link DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeUsageCharacteristics(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeUsageCharacteristics(EntityReference); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection DataTypeDecoratorService.findDatatypeUsageCharacteristics(EntityReference)"
  })
  void testFindDatatypeUsageCharacteristics_thenThrowUnsupportedOperationException() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findDatatypeUsageCharacteristics(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView() {
    // Arrange
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getDecoratorView(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView2() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getDecoratorView(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView3() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getDecoratorView(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView4() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getDecoratorView(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView5() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenThrow(new UnsupportedOperationException());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.getDecoratorView(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView6() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());

    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    flowClassificationSet.add(
        ImmutableFlowClassification.builder()
            .code("Code")
            .color("Color")
            .defaultMessage("Default Message")
            .description("The characteristics of someone or something")
            .direction(FlowDirection.INBOUND)
            .id(1L)
            .isCustom(true)
            .kind(EntityKind.ALL)
            .messageSeverity(MessageSeverity.NONE)
            .name("Name")
            .position(1)
            .userSelectable(true)
            .build());
    when(flowClassificationService.findAll()).thenReturn(flowClassificationSet);
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView7() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ACTOR);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <ul>
   *   <li>Then primaryAssessments return {@link ImmutableAssessmentsView}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test getDecoratorView(EntityReference); then primaryAssessments return ImmutableAssessmentsView")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView_thenPrimaryAssessmentsReturnImmutableAssessmentsView() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <ul>
   *   <li>Then return dataTypeDecorators size is one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference); then return dataTypeDecorators size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView_thenReturnDataTypeDecoratorsSizeIsOne() {
    // Arrange
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualDecoratorView.dataTypeDecorators().size());
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <ul>
   *   <li>Then return dataTypeDecorators size is one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference); then return dataTypeDecorators size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView_thenReturnDataTypeDecoratorsSizeIsOne2() {
    // Arrange
    ArrayList<DataTypeDecorator> dataTypeDecoratorList = new ArrayList<>();

    ImmutableDataTypeDecorator.Builder builderResult = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult =
        builderResult.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult =
        decoratorEntityResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult = provenanceResult.rating(rating);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult.targetInboundRating(targetInboundRating).build());

    ImmutableDataTypeDecorator.Builder builderResult2 = ImmutableDataTypeDecorator.builder();

    ImmutableDataTypeDecorator.Builder decoratorEntityResult2 =
        builderResult2.decoratorEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutableDataTypeDecorator.Builder provenanceResult2 =
        decoratorEntityResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .flowClassificationRuleId(1L)
            .id(1L)
            .inboundFlowClassificationRuleId(1L)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .provenance("Provenance");
    Optional<? extends AuthoritativenessRatingValue> rating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));

    ImmutableDataTypeDecorator.Builder ratingResult2 = provenanceResult2.rating(rating2);
    Optional<? extends AuthoritativenessRatingValue> targetInboundRating2 =
        Optional.of(AuthoritativenessRatingValue.of("42"));
    dataTypeDecoratorList.add(ratingResult2.targetInboundRating(targetInboundRating2).build());

    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(dataTypeDecoratorList);
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(new HashSet<>());
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualDecoratorView.dataTypeDecorators().size());
  }

  /**
   * Test {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}.
   *
   * <ul>
   *   <li>Then return dataTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeDecoratorService#getDecoratorView(EntityReference)}
   */
  @Test
  @DisplayName("Test getDecoratorView(EntityReference); then return dataTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataTypeDecoratorView DataTypeDecoratorService.getDecoratorView(EntityReference)"
  })
  void testGetDecoratorView_thenReturnDataTypesSizeIsOne() {
    // Arrange
    LogicalFlowDecoratorDao logicalFlowDecoratorDao = mock(LogicalFlowDecoratorDao.class);
    when(logicalFlowDecoratorDao.findByEntityId(anyLong())).thenReturn(new ArrayList<>());
    when(dataTypeDecoratorDaoSelectorFactory.getDao(Mockito.<EntityKind>any()))
        .thenReturn(logicalFlowDecoratorDao);

    HashSet<DataType> dataTypeSet = new HashSet<>();
    dataTypeSet.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeService.findByIdSelector(Mockito.<IdSelectionOptions>any()))
        .thenReturn(dataTypeSet);
    when(assessmentRatingService.getPrimaryAssessmentsViewForKindAndSelector(
            Mockito.<EntityKind>any(), Mockito.<IdSelectionOptions>any()))
        .thenReturn(ImmutableAssessmentsView.builder().build());
    when(flowClassificationService.findAll()).thenReturn(new HashSet<>());
    when(flowClassificationRuleService.getFlowClassificationsViewForFlow(anyLong()))
        .thenReturn(ImmutableFlowClassificationRulesView.builder().build());

    // Act
    DataTypeDecoratorView actualDecoratorView =
        dataTypeDecoratorService.getDecoratorView(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDecoratorDaoSelectorFactory).getDao(EntityKind.ALL);
    verify(logicalFlowDecoratorDao).findByEntityId(1L);
    verify(assessmentRatingService)
        .getPrimaryAssessmentsViewForKindAndSelector(
            eq(EntityKind.LOGICAL_DATA_FLOW_DATA_TYPE_DECORATOR), isA(IdSelectionOptions.class));
    verify(dataTypeService).findByIdSelector(isA(IdSelectionOptions.class));
    verify(flowClassificationRuleService).getFlowClassificationsViewForFlow(1L);
    verify(flowClassificationService).findAll();
    assertTrue(actualDecoratorView.primaryAssessments() instanceof ImmutableAssessmentsView);
    assertTrue(actualDecoratorView instanceof ImmutableDataTypeDecoratorView);
    assertTrue(
        actualDecoratorView.flowClassificationRules()
            instanceof ImmutableFlowClassificationRulesView);
    assertEquals(1, actualDecoratorView.dataTypes().size());
  }

  /**
   * Test {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference)} with {@code source}, {@code target}.
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference) with 'source', 'target'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set DataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference)"
  })
  void testFindDatatypeRatingCharacteristicsForSourceAndTargetWithSourceTarget() {
    // Arrange
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Optional<Collection<Long>>>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics>
        actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult =
            dataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(
                null, null);

    // Assert
    verify(logicalFlowDecoratorRatingsCalculator)
        .calculate(isNull(), isNull(), isA(Optional.class));
    assertTrue(actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Test {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference)} with {@code source}, {@code target}.
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference) with 'source', 'target'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set DataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference)"
  })
  void testFindDatatypeRatingCharacteristicsForSourceAndTargetWithSourceTarget2() {
    // Arrange
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Optional<Collection<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(
                null, null));
    verify(logicalFlowDecoratorRatingsCalculator)
        .calculate(isNull(), isNull(), isA(Optional.class));
  }

  /**
   * Test {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference, Optional)} with {@code source}, {@code target}, {@code dataTypeIds}.
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference, Optional)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional) with 'source', 'target', 'dataTypeIds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set DataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional)"
  })
  void testFindDatatypeRatingCharacteristicsForSourceAndTargetWithSourceTargetDataTypeIds() {
    // Arrange
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Optional<Collection<Long>>>any()))
        .thenReturn(new HashSet<>());
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act
    Set<DataTypeDecoratorRatingCharacteristics>
        actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult =
            dataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(
                null, null, dataTypeIds);

    // Assert
    verify(logicalFlowDecoratorRatingsCalculator)
        .calculate(isNull(), isNull(), isA(Optional.class));
    assertTrue(actualFindDatatypeRatingCharacteristicsForSourceAndTargetResult.isEmpty());
  }

  /**
   * Test {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference, Optional)} with {@code source}, {@code target}, {@code dataTypeIds}.
   *
   * <p>Method under test: {@link
   * DataTypeDecoratorService#findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference,
   * EntityReference, Optional)}
   */
  @Test
  @DisplayName(
      "Test findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional) with 'source', 'target', 'dataTypeIds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set DataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(EntityReference, EntityReference, Optional)"
  })
  void testFindDatatypeRatingCharacteristicsForSourceAndTargetWithSourceTargetDataTypeIds2() {
    // Arrange
    when(logicalFlowDecoratorRatingsCalculator.calculate(
            Mockito.<EntityReference>any(),
            Mockito.<EntityReference>any(),
            Mockito.<Optional<Collection<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());
    Optional<Collection<Long>> dataTypeIds = Optional.of(new ArrayList<>());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeDecoratorService.findDatatypeRatingCharacteristicsForSourceAndTarget(
                null, null, dataTypeIds));
    verify(logicalFlowDecoratorRatingsCalculator)
        .calculate(isNull(), isNull(), isA(Optional.class));
  }
}
