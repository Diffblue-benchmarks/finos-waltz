package org.finos.waltz.service.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ImmutableSetAttributeCommand;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.SetAttributeCommand;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier;
import org.finos.waltz.model.logical_flow.ImmutableLogicalFlow;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FlowAttributes;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutableFlowAttributes;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowCreateCommandResponse;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowCreateCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowDeleteCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowInfo;
import org.finos.waltz.model.physical_flow.PhysicalFlowSpecDefinitionChangeCommand;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalFlowServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private DataTypeDecoratorService dataTypeDecoratorService;

  @Mock private ExternalIdentifierService externalIdentifierService;

  @Mock private FlowPermissionChecker flowPermissionChecker;

  @Mock private LogicalFlowService logicalFlowService;

  @Mock private PhysicalFlowDao physicalFlowDao;

  @InjectMocks private PhysicalFlowService physicalFlowService;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  /**
   * Test {@link PhysicalFlowService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenReturnEmpty() {
    // Arrange
    when(physicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<PhysicalFlow> actualFindByEntityReferenceResult =
        physicalFlowService.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(physicalFlowDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowService#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.findByEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(physicalFlowDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalFlowService#findByProducerEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowService#findByProducerEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByProducerEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByProducerEntityReference(EntityReference)"})
  void testFindByProducerEntityReference_thenReturnEmpty() {
    // Arrange
    when(physicalFlowDao.findByProducer(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<PhysicalFlow> actualFindByProducerEntityReferenceResult =
        physicalFlowService.findByProducerEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(physicalFlowDao).findByProducer(isA(EntityReference.class));
    assertTrue(actualFindByProducerEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowService#findByProducerEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowService#findByProducerEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByProducerEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByProducerEntityReference(EntityReference)"})
  void testFindByProducerEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findByProducer(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.findByProducerEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(physicalFlowDao).findByProducer(isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalFlowService#findByConsumerEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowService#findByConsumerEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByConsumerEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByConsumerEntityReference(EntityReference)"})
  void testFindByConsumerEntityReference_thenReturnEmpty() {
    // Arrange
    when(physicalFlowDao.findByConsumer(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<PhysicalFlow> actualFindByConsumerEntityReferenceResult =
        physicalFlowService.findByConsumerEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(physicalFlowDao).findByConsumer(isA(EntityReference.class));
    assertTrue(actualFindByConsumerEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowService#findByConsumerEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalFlowService#findByConsumerEntityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByConsumerEntityReference(EntityReference); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByConsumerEntityReference(EntityReference)"})
  void testFindByConsumerEntityReference_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findByConsumer(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.findByConsumerEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(physicalFlowDao).findByConsumer(isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalFlowService#findBySpecificationId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySpecificationId(long)}
   */
  @Test
  @DisplayName("Test findBySpecificationId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findBySpecificationId(long)"})
  void testFindBySpecificationId_thenReturnEmpty() {
    // Arrange
    when(physicalFlowDao.findBySpecificationId(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<PhysicalFlow> actualFindBySpecificationIdResult =
        physicalFlowService.findBySpecificationId(1L);

    // Assert
    verify(physicalFlowDao).findBySpecificationId(1L);
    assertTrue(actualFindBySpecificationIdResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowService#findBySpecificationId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySpecificationId(long)}
   */
  @Test
  @DisplayName("Test findBySpecificationId(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findBySpecificationId(long)"})
  void testFindBySpecificationId_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findBySpecificationId(anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.findBySpecificationId(1L));
    verify(physicalFlowDao).findBySpecificationId(1L);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    Collection<PhysicalFlow> actualFindBySelectorResult =
        physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder addOmitApplicationKinds {@code IN_HOUSE}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given builder addOmitApplicationKinds 'IN_HOUSE'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderAddOmitApplicationKindsInHouse_thenCallsFilters() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.filters()).thenReturn(builderResult.build());
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult =
        physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given builder build.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); given builder build; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenBuilderBuild_thenCallsFilters() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult =
        physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code ACTIVE}.
   *   <li>Then calls {@link IdSelectionOptions#filters()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test findBySelector(IdSelectionOptions); given HashSet() add 'ACTIVE'; then calls filters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_givenHashSetAddActive_thenCallsFilters() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.ACTIVE);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.filters()).thenReturn(ImmutableSelectionFilters.builder().build());
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.APP_GROUP)
                .name("Name")
                .build());

    // Act
    Collection<PhysicalFlow> actualFindBySelectorResult =
        physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_thenReturnList() {
    // Arrange
    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(physicalFlowList);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
    Collection<PhysicalFlow> actualFindBySelectorResult =
        physicalFlowService.findBySelector(idSelectionOptions);

    // Assert
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySelectorResult instanceof List);
    assertTrue(actualFindBySelectorResult.isEmpty());
    assertSame(physicalFlowList, actualFindBySelectorResult);
  }

  /**
   * Test {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findBySelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test findBySelector(IdSelectionOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findBySelector(IdSelectionOptions)"})
  void testFindBySelector_thenThrowUnsupportedOperationException() {
    // Arrange
    when(physicalFlowDao.findBySelector(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());

    HashSet<EntityLifecycleStatus> entityLifecycleStatusSet = new HashSet<>();
    entityLifecycleStatusSet.add(EntityLifecycleStatus.REMOVED);

    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(entityLifecycleStatusSet);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference())
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
        () -> physicalFlowService.findBySelector(idSelectionOptions));
    verify(physicalFlowDao).findBySelector(isA(Select.class));
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
  }

  /**
   * Test {@link PhysicalFlowService#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePhysicalFlow}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutablePhysicalFlow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowService.getById(long)"})
  void testGetById_thenReturnImmutablePhysicalFlow() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(transport).build());

    // Act
    PhysicalFlow actualById = physicalFlowService.getById(1L);

    // Assert
    verify(physicalFlowDao).getById(1L);
    assertTrue(actualById instanceof ImmutablePhysicalFlow);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1, actualById.basisOffset());
    assertEquals(1L, actualById.logicalFlowId());
    assertEquals(1L, actualById.specificationId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualById.freshnessIndicator());
    assertFalse(actualById.isRemoved());
    assertFalse(actualById.isReadOnly());
    assertSame(criticality, actualById.criticality());
    assertSame(frequency, actualById.frequency());
    assertSame(transport, actualById.transport());
  }

  /**
   * Test {@link PhysicalFlowService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowService.getById(long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.getById(1L));
    verify(physicalFlowDao).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByExternalId(String)"})
  void testFindByExternalId_thenReturnEmpty() {
    // Arrange
    when(physicalFlowDao.findByExternalId(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<PhysicalFlow> actualFindByExternalIdResult = physicalFlowService.findByExternalId("42");

    // Assert
    verify(physicalFlowDao).findByExternalId("42");
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowService#findByExternalId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowService.findByExternalId(String)"})
  void testFindByExternalId_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findByExternalId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.findByExternalId("42"));
    verify(physicalFlowDao).findByExternalId("42");
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("kind");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Merged physical flow 1 to: 1"),
            eq(Operation.UPDATE));
    verify(externalIdentifierService, atLeast(1))
        .create(isA(EntityReference.class), Mockito.<String>any(), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertTrue(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge2() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Merged physical flow 1 to: 1"),
            eq(Operation.UPDATE));
    verify(externalIdentifierService).create(isA(EntityReference.class), eq("42"), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertTrue(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge3() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Merged physical flow 1 to: 1"),
            eq(Operation.UPDATE));
    verify(externalIdentifierService).create(isA(EntityReference.class), eq("42"), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertTrue(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge4() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();

    ImmutableExternalIdentifier.Builder builderResult3 = ImmutableExternalIdentifier.builder();
    externalIdentifierSet.add(
        builderResult3
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .externalId("42")
            .system("System")
            .build());
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(externalIdentifierSet);

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Merged physical flow 1 to: 1"),
            eq(Operation.UPDATE));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertTrue(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge5() {
    // Arrange
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutablePhysicalSpecification.Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.merge(1L, 1L, "janedoe"));
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(externalIdentifierService).create(isA(EntityReference.class), eq("42"), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link
   *       ChangeLogService#writeChangeLogEntries(EntityReference, String, String, Operation)} does
   *       nothing.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName(
      "Test merge(long, long, String); given ChangeLogService writeChangeLogEntries(EntityReference, String, String, Operation) does nothing; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge_givenChangeLogServiceWriteChangeLogEntriesDoesNothing_thenReturnTrue() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Merged physical flow 1 to: 1"),
            eq(Operation.UPDATE));
    verify(externalIdentifierService).create(isA(EntityReference.class), eq("42"), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertTrue(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName(
      "Test merge(long, long, String); given PhysicalFlowDao; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge_givenPhysicalFlowDao_thenThrowIllegalArgumentException() {
    // Arrange
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.merge(1L, 1L, "janedoe"));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalFlowService#merge(long, long, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#merge(long, long, String)}
   */
  @Test
  @DisplayName("Test merge(long, long, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowService.merge(long, long, String)"})
  void testMerge_thenReturnFalse() {
    // Arrange
    when(physicalFlowDao.updateEntityLifecycleStatus(
            anyLong(), Mockito.<EntityLifecycleStatus>any()))
        .thenReturn(-2);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
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
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(physicalSpecificationService.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(externalIdentifierService.merge(
            Mockito.<EntityReference>any(), Mockito.<EntityReference>any()))
        .thenReturn(1);
    when(externalIdentifierService.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    boolean actualMergeResult = physicalFlowService.merge(1L, 1L, "janedoe");

    // Assert
    verify(physicalFlowDao, atLeast(1)).getById(1L);
    verify(physicalFlowDao).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);
    verify(externalIdentifierService).create(isA(EntityReference.class), eq("42"), eq("janedoe"));
    verify(externalIdentifierService).findByEntityReference(isA(EntityReference.class));
    verify(externalIdentifierService).merge(isA(EntityReference.class), isA(EntityReference.class));
    verify(physicalSpecificationService, atLeast(1)).getById(1L);
    verify(physicalSpecificationService)
        .markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class), eq("janedoe"));
    assertFalse(actualMergeResult);
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ExternalIdentifierService} {@link
   *       ExternalIdentifierService#delete(EntityReference)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); given ExternalIdentifierService delete(EntityReference) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_givenExternalIdentifierServiceDeleteThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.delete(anyLong())).thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(externalIdentifierService.delete(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.delete(
                ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(), "janedoe"));
    verify(physicalFlowDao).delete(1L);
    verify(physicalFlowDao).getByIdAndIsRemoved(1L, false);
    verify(externalIdentifierService).delete(isA(EntityReference.class));
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link PhysicalFlowDeleteCommand#flowId()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); given IllegalArgumentException(); then calls flowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_givenIllegalArgumentException_thenCallsFlowId() {
    // Arrange
    PhysicalFlowDeleteCommand command = mock(PhysicalFlowDeleteCommand.class);
    when(command.flowId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.delete(command, "janedoe"));
    verify(command).flowId();
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao} {@link PhysicalFlowDao#delete(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); given PhysicalFlowDao delete(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_givenPhysicalFlowDaoDeleteThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.delete(anyLong())).thenThrow(new IllegalArgumentException());

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.delete(
                ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(), "janedoe"));
    verify(physicalFlowDao).delete(1L);
    verify(physicalFlowDao).getByIdAndIsRemoved(1L, false);
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao} {@link PhysicalFlowDao#getByIdAndIsRemoved(long, boolean)}
   *       throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); given PhysicalFlowDao getByIdAndIsRemoved(long, boolean) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_givenPhysicalFlowDaoGetByIdAndIsRemovedThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.delete(
                ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(), "janedoe"));
    verify(physicalFlowDao).getByIdAndIsRemoved(1L, false);
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecificationService} {@link
   *       PhysicalSpecificationService#isUsed(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); given PhysicalSpecificationService isUsed(Long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_givenPhysicalSpecificationServiceIsUsedThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.delete(anyLong())).thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(physicalSpecificationService.isUsed(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    when(externalIdentifierService.delete(Mockito.<EntityReference>any())).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.delete(
                ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build(), "janedoe"));
    verify(physicalFlowDao).delete(1L);
    verify(physicalFlowDao).getByIdAndIsRemoved(1L, false);
    verify(externalIdentifierService).delete(isA(EntityReference.class));
    verify(physicalSpecificationService).isUsed(1L);
  }

  /**
   * Test {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#delete(PhysicalFlowDeleteCommand, String)}
   */
  @Test
  @DisplayName(
      "Test delete(PhysicalFlowDeleteCommand, String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowDeleteCommandResponse PhysicalFlowService.delete(PhysicalFlowDeleteCommand, String)"
  })
  void testDelete_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<PhysicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.hasPhysicalFlows(anyLong())).thenReturn(true);
    when(physicalFlowDao.delete(anyLong())).thenReturn(1);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getByIdAndIsRemoved(anyLong(), anyBoolean()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(physicalSpecificationService.isUsed(Mockito.<Long>any())).thenReturn(true);
    when(externalIdentifierService.delete(Mockito.<EntityReference>any())).thenReturn(1);
    ImmutablePhysicalFlowDeleteCommand command =
        ImmutablePhysicalFlowDeleteCommand.builder().flowId(1L).build();

    // Act
    PhysicalFlowDeleteCommandResponse actualDeleteResult =
        physicalFlowService.delete(command, "janedoe");

    // Assert
    verify(physicalFlowDao).delete(1L);
    verify(physicalFlowDao).getByIdAndIsRemoved(1L, false);
    verify(physicalFlowDao).hasPhysicalFlows(1L);
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(PhysicalFlow.class), eq("janedoe"), eq(" removed"), eq(Operation.REMOVE));
    verify(externalIdentifierService).delete(isA(EntityReference.class));
    verify(physicalSpecificationService).isUsed(1L);
    EntityReference entityReferenceResult = actualDeleteResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    PhysicalFlowDeleteCommand originalCommandResult = actualDeleteResult.originalCommand();
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowDeleteCommand);
    assertTrue(actualDeleteResult instanceof ImmutablePhysicalFlowDeleteCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, originalCommandResult.flowId());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualDeleteResult.outcome());
    assertFalse(actualDeleteResult.isLastPhysicalFlow());
    assertFalse(actualDeleteResult.isSpecificationUnused());
    assertSame(command, originalCommandResult);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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
    when(physicalFlowDao.findByAttributesAndSpecification(Mockito.<PhysicalFlow>any()))
        .thenThrow(new IllegalArgumentException());

    ImmutablePhysicalFlowCreateCommand.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.create(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build(),
                "janedoe"));
    verify(physicalFlowDao).findByAttributesAndSpecification(isA(PhysicalFlow.class));
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<PhysicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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
    when(physicalFlowDao.findByAttributesAndSpecification(Mockito.<PhysicalFlow>any()))
        .thenReturn(new ArrayList<>());
    when(physicalFlowDao.create(Mockito.<PhysicalFlow>any())).thenReturn(1L);

    ImmutablePhysicalFlowCreateCommand.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.create(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build(),
                "janedoe"));
    verify(physicalFlowDao).create(isA(PhysicalFlow.class));
    verify(physicalFlowDao).findByAttributesAndSpecification(isA(PhysicalFlow.class));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(PhysicalFlow.class), eq("janedoe"), eq(" created"), eq(Operation.ADD));
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate3() {
    // Arrange
    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.logicalFlowId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(command).logicalFlowId();
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate4() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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

    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.specification()).thenThrow(new IllegalArgumentException());
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(command).logicalFlowId();
    verify(command).specification();
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate5() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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

    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.flowAttributes()).thenThrow(new IllegalArgumentException());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(command.specification())
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(command).flowAttributes();
    verify(command).logicalFlowId();
    verify(command).specification();
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link LogicalFlowService} {@link LogicalFlowService#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalFlowCreateCommand, String); given LogicalFlowService getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate_givenLogicalFlowServiceGetByIdThrowIllegalArgumentException() {
    // Arrange
    when(logicalFlowService.getById(anyLong())).thenThrow(new IllegalArgumentException());

    ImmutablePhysicalFlowCreateCommand.Builder builderResult =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.create(
                addAllDataTypeIdsResult
                    .specification(
                        nameResult2
                            .owningEntity(
                                ImmutableEntityReference.builder()
                                    .description("The characteristics of someone or something")
                                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                    .externalId("42")
                                    .id(1L)
                                    .kind(EntityKind.ALL)
                                    .name("Name")
                                    .build())
                            .provenance("Provenance")
                            .build())
                    .build(),
                "janedoe"));
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PhysicalFlowCreateCommand#dataTypeIds()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName("Test create(PhysicalFlowCreateCommand, String); then calls dataTypeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate_thenCallsDataTypeIds() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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
    when(physicalFlowDao.findByAttributesAndSpecification(Mockito.<PhysicalFlow>any()))
        .thenReturn(new ArrayList<>());
    when(physicalFlowDao.create(Mockito.<PhysicalFlow>any())).thenReturn(1L);

    PhysicalFlowCreateCommand command = mock(PhysicalFlowCreateCommand.class);
    when(command.dataTypeIds()).thenThrow(new IllegalArgumentException());

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");
    when(command.flowAttributes())
        .thenReturn(nameResult.transport(TransportKindValue.of("42")).build());

    ImmutablePhysicalSpecification.Builder builderResult2 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult2
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(command.specification())
        .thenReturn(
            nameResult2
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());
    when(command.logicalFlowId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.create(command, "janedoe"));
    verify(physicalFlowDao).create(isA(PhysicalFlow.class));
    verify(physicalFlowDao).findByAttributesAndSpecification(isA(PhysicalFlow.class));
    verify(command).dataTypeIds();
    verify(command, atLeast(1)).flowAttributes();
    verify(command, atLeast(1)).logicalFlowId();
    verify(command, atLeast(1)).specification();
    verify(logicalFlowService).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalFlowCreateCommand, String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<PhysicalFlow>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());

    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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
    when(physicalFlowDao.findByAttributesAndSpecification(Mockito.<PhysicalFlow>any()))
        .thenReturn(new ArrayList<>());
    when(physicalFlowDao.create(Mockito.<PhysicalFlow>any())).thenReturn(1L);

    ImmutablePhysicalFlowCreateCommand.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult =
        basisOffsetResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    ImmutablePhysicalSpecification.Builder externalIdResult2 =
        builderResult3
            .created(created2)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult2
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    ImmutablePhysicalFlowCreateCommand command =
        addAllDataTypeIdsResult
            .specification(
                nameResult2
                    .owningEntity(
                        ImmutableEntityReference.builder()
                            .description("The characteristics of someone or something")
                            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                            .externalId("42")
                            .id(1L)
                            .kind(EntityKind.ALL)
                            .name("Name")
                            .build())
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    PhysicalFlowCreateCommandResponse actualCreateResult =
        physicalFlowService.create(command, "janedoe");

    // Assert
    verify(physicalFlowDao).create(isA(PhysicalFlow.class));
    verify(physicalFlowDao).findByAttributesAndSpecification(isA(PhysicalFlow.class));
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(PhysicalFlow.class), eq("janedoe"), eq(" created"), eq(Operation.ADD));
    verify(logicalFlowService).getById(1L);
    EntityReference entityReferenceResult = actualCreateResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualCreateResult instanceof ImmutablePhysicalFlowCreateCommandResponse);
    assertNull(entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.PHYSICAL_FLOW, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertEquals(CommandOutcome.SUCCESS, actualCreateResult.outcome());
    assertSame(command, actualCreateResult.originalCommand());
  }

  /**
   * Test {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}.
   *
   * <ul>
   *   <li>Then originalCommand flowAttributes return {@link ImmutableFlowAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#create(PhysicalFlowCreateCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(PhysicalFlowCreateCommand, String); then originalCommand flowAttributes return ImmutableFlowAttributes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PhysicalFlowCreateCommandResponse PhysicalFlowService.create(PhysicalFlowCreateCommand, String)"
  })
  void testCreate_thenOriginalCommandFlowAttributesReturnImmutableFlowAttributes() {
    // Arrange
    ImmutableLogicalFlow.Builder builderResult = ImmutableLogicalFlow.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    ImmutableLogicalFlow.Builder provenanceResult =
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

    ImmutableLogicalFlow.Builder sourceResult =
        provenanceResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(logicalFlowService.getById(anyLong()))
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

    ArrayList<PhysicalFlow> physicalFlowList = new ArrayList<>();

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult = basisOffsetResult.created(created2);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    physicalFlowList.add(specificationIdResult.transport(transport).build());
    when(physicalFlowDao.findByAttributesAndSpecification(Mockito.<PhysicalFlow>any()))
        .thenReturn(physicalFlowList);

    ImmutablePhysicalFlowCreateCommand.Builder builderResult2 =
        ImmutablePhysicalFlowCreateCommand.builder();

    ImmutableFlowAttributes.Builder basisOffsetResult2 =
        ImmutableFlowAttributes.builder().basisOffset(1);

    ImmutableFlowAttributes.Builder externalIdResult2 =
        basisOffsetResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutableFlowAttributes.Builder nameResult =
        externalIdResult2.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowCreateCommand.Builder logicalFlowIdResult =
        builderResult2
            .flowAttributes(nameResult.transport(TransportKindValue.of("42")).build())
            .logicalFlowId(1L);

    ImmutablePhysicalFlowCreateCommand.Builder addAllDataTypeIdsResult =
        logicalFlowIdResult.addAllDataTypeIds(new ArrayList<>());

    ImmutablePhysicalSpecification.Builder builderResult3 =
        ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp3 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created3 = Optional.of(immutableUserTimestamp3);

    ImmutablePhysicalSpecification.Builder externalIdResult3 =
        builderResult3
            .created(created3)
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalSpecification.Builder nameResult2 =
        externalIdResult3
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");

    // Act
    PhysicalFlowCreateCommandResponse actualCreateResult =
        physicalFlowService.create(
            addAllDataTypeIdsResult
                .specification(
                    nameResult2
                        .owningEntity(
                            ImmutableEntityReference.builder()
                                .description("The characteristics of someone or something")
                                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                                .externalId("42")
                                .id(1L)
                                .kind(EntityKind.ALL)
                                .name("Name")
                                .build())
                        .provenance("Provenance")
                        .build())
                .build(),
            "janedoe");

    // Assert
    verify(physicalFlowDao).findByAttributesAndSpecification(isA(PhysicalFlow.class));
    verify(logicalFlowService).getById(1L);
    PhysicalFlowCreateCommand originalCommandResult = actualCreateResult.originalCommand();
    FlowAttributes flowAttributesResult = originalCommandResult.flowAttributes();
    assertTrue(flowAttributesResult instanceof ImmutableFlowAttributes);
    assertTrue(originalCommandResult instanceof ImmutablePhysicalFlowCreateCommand);
    assertTrue(actualCreateResult instanceof ImmutablePhysicalFlowCreateCommandResponse);
    assertEquals(CommandOutcome.FAILURE, actualCreateResult.outcome());
    assertEquals(criticality, flowAttributesResult.criticality());
    assertEquals(frequency, flowAttributesResult.frequency());
    assertEquals(transport, flowAttributesResult.transport());
  }

  /**
   * Test {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowService.updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testUpdateSpecDefinitionId() {
    // Arrange
    when(physicalFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    PhysicalFlowSpecDefinitionChangeCommand command =
        mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command));
    verify(physicalFlowDao).updateSpecDefinition("janedoe", 1L, 1L);
    verify(command).newSpecDefinitionId();
  }

  /**
   * Test {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowService.updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testUpdateSpecDefinitionId2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1);

    PhysicalFlowSpecDefinitionChangeCommand command =
        mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command));
    verify(physicalFlowDao).updateSpecDefinition("janedoe", 1L, 1L);
    verify(command, atLeast(1)).newSpecDefinitionId();
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Physical flow id: 1 specification definition id changed to: 1"),
            eq(Operation.UPDATE));
  }

  /**
   * Test {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowService.updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testUpdateSpecDefinitionId_givenIllegalArgumentException() {
    // Arrange
    PhysicalFlowSpecDefinitionChangeCommand command =
        mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command));
    verify(command).newSpecDefinitionId();
  }

  /**
   * Test {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Then return minus two.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand); then return minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowService.updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testUpdateSpecDefinitionId_thenReturnMinusTwo() {
    // Arrange
    when(physicalFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(-2);

    PhysicalFlowSpecDefinitionChangeCommand command =
        mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act
    int actualUpdateSpecDefinitionIdResult =
        physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command);

    // Assert
    verify(physicalFlowDao).updateSpecDefinition("janedoe", 1L, 1L);
    verify(command).newSpecDefinitionId();
    assertEquals(-2, actualUpdateSpecDefinitionIdResult);
  }

  /**
   * Test {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#updateSpecDefinitionId(String, long,
   * PhysicalFlowSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowService.updateSpecDefinitionId(String, long, PhysicalFlowSpecDefinitionChangeCommand)"
  })
  void testUpdateSpecDefinitionId_thenReturnOne() {
    // Arrange
    doNothing()
        .when(changeLogService)
        .writeChangeLogEntries(
            Mockito.<EntityReference>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Operation>any());
    when(physicalFlowDao.updateSpecDefinition(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1);

    PhysicalFlowSpecDefinitionChangeCommand command =
        mock(PhysicalFlowSpecDefinitionChangeCommand.class);
    when(command.newSpecDefinitionId()).thenReturn(1L);

    // Act
    int actualUpdateSpecDefinitionIdResult =
        physicalFlowService.updateSpecDefinitionId("janedoe", 1L, command);

    // Assert
    verify(physicalFlowDao).updateSpecDefinition("janedoe", 1L, 1L);
    verify(command, atLeast(1)).newSpecDefinitionId();
    verify(changeLogService)
        .writeChangeLogEntries(
            isA(EntityReference.class),
            eq("janedoe"),
            eq("Physical flow id: 1 specification definition id changed to: 1"),
            eq(Operation.UPDATE));
    assertEquals(1, actualUpdateSpecDefinitionIdResult);
  }

  /**
   * Test {@link PhysicalFlowService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao} {@link PhysicalFlowDao#cleanupOrphans()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#cleanupOrphans()}
   */
  @Test
  @DisplayName(
      "Test cleanupOrphans(); given PhysicalFlowDao cleanupOrphans() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowService.cleanupOrphans()"})
  void testCleanupOrphans_givenPhysicalFlowDaoCleanupOrphansReturnOne_thenReturnOne() {
    // Arrange
    when(physicalFlowDao.cleanupOrphans()).thenReturn(1);

    // Act
    int actualCleanupOrphansResult = physicalFlowService.cleanupOrphans();

    // Assert
    verify(physicalFlowDao).cleanupOrphans();
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Test {@link PhysicalFlowService#cleanupOrphans()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowService.cleanupOrphans()"})
  void testCleanupOrphans_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.cleanupOrphans()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowService.cleanupOrphans());
    verify(physicalFlowDao).cleanupOrphans();
  }

  /**
   * Test {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateAttribute(String, SetAttributeCommand); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowService.updateAttribute(String, SetAttributeCommand)"})
  void testUpdateAttribute_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.updateAttribute(
                "janedoe",
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
                    .name("Name")
                    .value("42")
                    .build()));
    verify(physicalFlowDao).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#updateAttribute(String, SetAttributeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateAttribute(String, SetAttributeCommand); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowService.updateAttribute(String, SetAttributeCommand)"})
  void testUpdateAttribute_thenThrowUnsupportedOperationException() {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    ImmutableSetAttributeCommand.Builder builderResult = ImmutableSetAttributeCommand.builder();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            physicalFlowService.updateAttribute(
                "janedoe",
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
                    .name("Name")
                    .value("42")
                    .build()));
    verify(physicalFlowDao).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}.
   *
   * <ul>
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  @DisplayName("Test findUnderlyingPhysicalFlows(Long); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findUnderlyingPhysicalFlows(Long)"})
  void testFindUnderlyingPhysicalFlows_thenReturnSet() {
    // Arrange
    HashSet<PhysicalFlowInfo> physicalFlowInfoSet = new HashSet<>();
    when(physicalFlowDao.findUnderlyingPhysicalFlows(Mockito.<Long>any()))
        .thenReturn(physicalFlowInfoSet);

    // Act
    Collection<PhysicalFlowInfo> actualFindUnderlyingPhysicalFlowsResult =
        physicalFlowService.findUnderlyingPhysicalFlows(1L);

    // Assert
    verify(physicalFlowDao).findUnderlyingPhysicalFlows(1L);
    assertTrue(actualFindUnderlyingPhysicalFlowsResult instanceof Set);
    assertTrue(actualFindUnderlyingPhysicalFlowsResult.isEmpty());
    assertSame(physicalFlowInfoSet, actualFindUnderlyingPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  @DisplayName("Test findUnderlyingPhysicalFlows(Long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection PhysicalFlowService.findUnderlyingPhysicalFlows(Long)"})
  void testFindUnderlyingPhysicalFlows_thenThrowIllegalArgumentException() {
    // Arrange
    when(physicalFlowDao.findUnderlyingPhysicalFlows(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowService.findUnderlyingPhysicalFlows(1L));
    verify(physicalFlowDao).findUnderlyingPhysicalFlows(1L);
  }

  /**
   * Test {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test checkLogicalFlowPermission(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PhysicalFlowService.checkLogicalFlowPermission(EntityReference, String)"
  })
  void testCheckLogicalFlowPermission() throws InsufficientPrivelegeException {
    // Arrange
    doNothing()
        .when(flowPermissionChecker)
        .verifyEditPerms(
            Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    physicalFlowService.checkLogicalFlowPermission(
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build(),
        "janedoe");

    // Assert
    verify(flowPermissionChecker).findPermissionsForFlow(1L, "janedoe");
    verify(flowPermissionChecker)
        .verifyEditPerms(isA(Set.class), eq(EntityKind.PHYSICAL_FLOW), eq("janedoe"));
  }

  /**
   * Test {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link FlowPermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkLogicalFlowPermission(EntityReference, String); then calls verifyEditPerms(Set, EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PhysicalFlowService.checkLogicalFlowPermission(EntityReference, String)"
  })
  void testCheckLogicalFlowPermission_thenCallsVerifyEditPerms()
      throws InsufficientPrivelegeException {
    // Arrange
    doNothing()
        .when(flowPermissionChecker)
        .verifyEditPerms(
            Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    physicalFlowService.checkLogicalFlowPermission(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build(),
        "janedoe");

    // Assert
    verify(flowPermissionChecker).findPermissionsForFlow(1L, "janedoe");
    verify(flowPermissionChecker)
        .verifyEditPerms(isA(Set.class), eq(EntityKind.PHYSICAL_FLOW), eq("janedoe"));
  }

  /**
   * Test {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#checkLogicalFlowPermission(EntityReference,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkLogicalFlowPermission(EntityReference, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PhysicalFlowService.checkLogicalFlowPermission(EntityReference, String)"
  })
  void testCheckLogicalFlowPermission_thenThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            physicalFlowService.checkLogicalFlowPermission(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                "janedoe"));
    verify(flowPermissionChecker).findPermissionsForFlow(1L, "janedoe");
  }

  /**
   * Test {@link PhysicalFlowService#checkHasPermission(long, String)}.
   *
   * <p>Method under test: {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  @DisplayName("Test checkHasPermission(long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowService.checkHasPermission(long, String)"})
  void testCheckHasPermission() throws InsufficientPrivelegeException {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowService.checkHasPermission(1L, "janedoe"));
    verify(physicalFlowDao).getById(1L);
    verify(flowPermissionChecker).findPermissionsForFlow(1L, "janedoe");
  }

  /**
   * Test {@link PhysicalFlowService#checkHasPermission(long, String)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao} {@link PhysicalFlowDao#getById(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  @DisplayName(
      "Test checkHasPermission(long, String); given PhysicalFlowDao getById(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowService.checkHasPermission(long, String)"})
  void testCheckHasPermission_givenPhysicalFlowDaoGetByIdThrowIllegalArgumentException()
      throws InsufficientPrivelegeException {
    // Arrange
    when(physicalFlowDao.getById(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowService.checkHasPermission(1L, "janedoe"));
    verify(physicalFlowDao).getById(1L);
  }

  /**
   * Test {@link PhysicalFlowService#checkHasPermission(long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link FlowPermissionChecker#verifyEditPerms(Set, EntityKind, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowService#checkHasPermission(long, String)}
   */
  @Test
  @DisplayName(
      "Test checkHasPermission(long, String); then calls verifyEditPerms(Set, EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalFlowService.checkHasPermission(long, String)"})
  void testCheckHasPermission_thenCallsVerifyEditPerms() throws InsufficientPrivelegeException {
    // Arrange
    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(physicalFlowDao.getById(anyLong()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());
    doNothing()
        .when(flowPermissionChecker)
        .verifyEditPerms(
            Mockito.<Set<Operation>>any(), Mockito.<EntityKind>any(), Mockito.<String>any());
    when(flowPermissionChecker.findPermissionsForFlow(Mockito.<Long>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    physicalFlowService.checkHasPermission(1L, "janedoe");

    // Assert
    verify(physicalFlowDao).getById(1L);
    verify(flowPermissionChecker).findPermissionsForFlow(1L, "janedoe");
    verify(flowPermissionChecker)
        .verifyEditPerms(isA(Set.class), eq(EntityKind.PHYSICAL_FLOW), eq("janedoe"));
  }
}
