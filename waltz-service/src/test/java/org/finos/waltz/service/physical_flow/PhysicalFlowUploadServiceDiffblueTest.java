package org.finos.waltz.service.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.finos.waltz.common.Aliases;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.enum_value.EnumValueKind;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommand;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowUploadCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowUploadCommandResponse;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.enum_value.EnumValueAliasService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalFlowUploadServiceDiffblueTest {
  @Mock private ActorDao actorDao;

  @Mock private ApplicationDao applicationDao;

  @Mock private DataTypeDao dataTypeDao;

  @Mock private DataTypeDecoratorService dataTypeDecoratorService;

  @Mock private EnumValueAliasService enumValueAliasService;

  @Mock private LogicalFlowDao logicalFlowDao;

  @Mock private PhysicalFlowDao physicalFlowDao;

  @InjectMocks private PhysicalFlowUploadService physicalFlowUploadService;

  @Mock private PhysicalSpecificationDao physicalSpecificationDao;

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate() {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    when(actorDao.findAll()).thenReturn(actorList);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate2() {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    when(actorDao.findAll()).thenReturn(actorList);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate3() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findAll()).thenReturn(applicationList);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate4() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate5() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Given {@link ActorDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName(
      "Test validate(List); given ActorDao; when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_givenActorDao_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange
    when(applicationDao.findAll()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowUploadService.validate(new ArrayList<>()));
    verify(applicationDao).findAll();
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Given {@link Aliases} {@link Aliases#lookup(String)} return empty.
   *   <li>Then calls {@link Aliases#lookup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName(
      "Test validate(List); given Aliases lookup(String) return empty; then calls lookup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_givenAliasesLookupReturnEmpty_thenCallsLookup() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

    Aliases<Object> aliases = mock(Aliases.class);
    Optional<Object> emptyResult = Optional.empty();
    when(aliases.lookup(Mockito.<String>any())).thenReturn(emptyResult);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(cmds);

    // Assert
    verify(aliases, atLeast(1)).lookup(Mockito.<String>any());
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertEquals(1, actualValidateResult.size());
    PhysicalFlowUploadCommandResponse getResult = actualValidateResult.get(0);
    assertTrue(getResult.parsedFlow() instanceof ImmutablePhysicalFlowParsed);
    assertTrue(getResult.originalCommand() instanceof ImmutablePhysicalFlowUploadCommand);
    assertTrue(getResult instanceof ImmutablePhysicalFlowUploadCommandResponse);
    assertNull(getResult.entityReference());
    Map<String, String> errorsResult = getResult.errors();
    assertEquals(9, errorsResult.size());
    assertEquals(CommandOutcome.FAILURE, getResult.outcome());
    assertTrue(errorsResult.containsKey("basisOffset"));
    assertTrue(errorsResult.containsKey("dataType"));
    assertTrue(errorsResult.containsKey("format"));
    assertTrue(errorsResult.containsKey("owner"));
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Given {@link EnumValueAliasService} {@link EnumValueAliasService#mkAliases(EnumValueKind,
   *       Function)} return {@link Aliases} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName(
      "Test validate(List); given EnumValueAliasService mkAliases(EnumValueKind, Function) return Aliases (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_givenEnumValueAliasServiceMkAliasesReturnAliases_thenReturnEmpty() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Given {@link EnumValueAliasService} {@link EnumValueAliasService#mkAliases(EnumValueKind,
   *       Function)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName(
      "Test validate(List); given EnumValueAliasService mkAliases(EnumValueKind, Function) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_givenEnumValueAliasServiceMkAliasesThrowIllegalArgumentException() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowUploadService.validate(new ArrayList<>()));
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_thenReturnSizeIsOne() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(cmds);

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertEquals(1, actualValidateResult.size());
    PhysicalFlowUploadCommandResponse getResult = actualValidateResult.get(0);
    assertTrue(getResult.parsedFlow() instanceof ImmutablePhysicalFlowParsed);
    assertTrue(getResult.originalCommand() instanceof ImmutablePhysicalFlowUploadCommand);
    assertTrue(getResult instanceof ImmutablePhysicalFlowUploadCommandResponse);
    assertNull(getResult.entityReference());
    Map<String, String> errorsResult = getResult.errors();
    assertEquals(9, errorsResult.size());
    assertEquals(CommandOutcome.FAILURE, getResult.outcome());
    assertTrue(errorsResult.containsKey("basisOffset"));
    assertTrue(errorsResult.containsKey("dataType"));
    assertTrue(errorsResult.containsKey("format"));
    assertTrue(errorsResult.containsKey("owner"));
  }

  /**
   * Test {@link PhysicalFlowUploadService#validate(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  @DisplayName("Test validate(List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.validate(List)"})
  void testValidate_thenReturnSizeIsTwo() {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult =
        physicalFlowUploadService.validate(cmds);

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertEquals(2, actualValidateResult.size());
    PhysicalFlowUploadCommandResponse getResult = actualValidateResult.get(1);
    assertTrue(getResult instanceof ImmutablePhysicalFlowUploadCommandResponse);
    assertEquals(actualValidateResult.get(0), getResult);
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload() throws Exception {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    when(actorDao.findAll()).thenReturn(actorList);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload2() throws Exception {
    // Arrange
    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    actorList.add(
        ImmutableActor.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isExternal(true)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .build());
    when(actorDao.findAll()).thenReturn(actorList);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload3() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<Application> applicationList = new ArrayList<>();

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    applicationList.add(
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build());
    when(applicationDao.findAll()).thenReturn(applicationList);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload4() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload5() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Given {@link ActorDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName(
      "Test upload(String, List); given ActorDao; when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_givenActorDao_whenArrayList_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(applicationDao.findAll()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowUploadService.upload("janedoe", new ArrayList<>()));
    verify(applicationDao).findAll();
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Given {@link Aliases} {@link Aliases#lookup(String)} return empty.
   *   <li>Then calls {@link Aliases#lookup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName(
      "Test upload(String, List); given Aliases lookup(String) return empty; then calls lookup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_givenAliasesLookupReturnEmpty_thenCallsLookup() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

    Aliases<Object> aliases = mock(Aliases.class);
    Optional<Object> emptyResult = Optional.empty();
    when(aliases.lookup(Mockito.<String>any())).thenReturn(emptyResult);
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowUploadService.upload("janedoe", cmds));
    verify(aliases, atLeast(1)).lookup(Mockito.<String>any());
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Given {@link EnumValueAliasService} {@link EnumValueAliasService#mkAliases(EnumValueKind,
   *       Function)} return {@link Aliases} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName(
      "Test upload(String, List); given EnumValueAliasService mkAliases(EnumValueKind, Function) return Aliases (default constructor); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_givenEnumValueAliasServiceMkAliasesReturnAliases_thenReturnEmpty()
      throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult =
        physicalFlowUploadService.upload("janedoe", new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Given {@link EnumValueAliasService} {@link EnumValueAliasService#mkAliases(EnumValueKind,
   *       Function)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName(
      "Test upload(String, List); given EnumValueAliasService mkAliases(EnumValueKind, Function) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_givenEnumValueAliasServiceMkAliasesThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> physicalFlowUploadService.upload("janedoe", new ArrayList<>()));
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowUploadService.upload("janedoe", cmds));
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
  }

  /**
   * Test {@link PhysicalFlowUploadService#upload(String, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  @DisplayName("Test upload(String, List); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowUploadService.upload(String, List)"})
  void testUpload_thenThrowIllegalArgumentException2() throws Exception {
    // Arrange
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    when(enumValueAliasService.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());
    cmds.add(
        ImmutablePhysicalFlowUploadCommand.builder()
            .basisOffset("Basis Offset")
            .criticality("Criticality")
            .dataType("Data Type")
            .description("The characteristics of someone or something")
            .externalId("42")
            .format("Format")
            .frequency("Frequency")
            .name("Name")
            .owner("Owner")
            .source("Source")
            .specDescription("Spec Description")
            .specExternalId("42")
            .target("Target")
            .transport("Transport")
            .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> physicalFlowUploadService.upload("janedoe", cmds));
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasService, atLeast(1))
        .mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any());
  }
}
