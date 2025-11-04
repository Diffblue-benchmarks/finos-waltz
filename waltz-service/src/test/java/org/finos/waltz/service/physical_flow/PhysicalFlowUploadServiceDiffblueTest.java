package org.finos.waltz.service.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.finos.waltz.common.Aliases;
import org.finos.waltz.data.actor.ActorDao;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDaoSelectorFactory;
import org.finos.waltz.data.enum_value.EnumValueAliasDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.actor.Actor;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.enum_value.EnumValueKind;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowUploadCommandResponse;
import org.finos.waltz.model.physical_flow.PhysicalFlowParsed;
import org.finos.waltz.model.physical_flow.PhysicalFlowUploadCommand;
import org.finos.waltz.model.physical_flow.PhysicalFlowUploadCommandResponse;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorService;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.enum_value.EnumValueAliasService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowUploadServiceDiffblueTest {
  /**
   * Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  void testValidate() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult = physicalFlowUploadService
        .validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  void testValidate2() {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenReturn("Name");

    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(actor);
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(actorList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult = physicalFlowUploadService
        .validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(actor).name();
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  void testValidate3() {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenReturn("Name");
    Actor actor2 = mock(Actor.class);
    when(actor2.name()).thenReturn("Name");

    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(actor2);
    actorList.add(actor);
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(actorList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult = physicalFlowUploadService
        .validate(new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(actor2).name();
    verify(actor).name();
    assertTrue(actualValidateResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  void testValidate4() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);
    PhysicalFlowUploadCommand physicalFlowUploadCommand = mock(PhysicalFlowUploadCommand.class);
    when(physicalFlowUploadCommand.externalId()).thenReturn("42");
    when(physicalFlowUploadCommand.description()).thenReturn("The characteristics of someone or something");
    when(physicalFlowUploadCommand.specDescription()).thenReturn("Spec Description");
    when(physicalFlowUploadCommand.specExternalId()).thenReturn("42");
    when(physicalFlowUploadCommand.basisOffset()).thenReturn("Basis Offset");
    when(physicalFlowUploadCommand.name()).thenReturn("Name");
    when(physicalFlowUploadCommand.criticality()).thenReturn("Criticality");
    when(physicalFlowUploadCommand.frequency()).thenReturn("Frequency");
    when(physicalFlowUploadCommand.transport()).thenReturn("Transport");
    when(physicalFlowUploadCommand.format()).thenReturn("Format");
    when(physicalFlowUploadCommand.dataType()).thenReturn("Data Type");
    when(physicalFlowUploadCommand.owner()).thenReturn("Owner");
    when(physicalFlowUploadCommand.target()).thenReturn("Target");
    when(physicalFlowUploadCommand.source()).thenReturn("Source");

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(physicalFlowUploadCommand);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualValidateResult = physicalFlowUploadService.validate(cmds);

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(physicalFlowUploadCommand, atLeast(1)).basisOffset();
    verify(physicalFlowUploadCommand, atLeast(1)).criticality();
    verify(physicalFlowUploadCommand, atLeast(1)).dataType();
    verify(physicalFlowUploadCommand).description();
    verify(physicalFlowUploadCommand).externalId();
    verify(physicalFlowUploadCommand, atLeast(1)).format();
    verify(physicalFlowUploadCommand, atLeast(1)).frequency();
    verify(physicalFlowUploadCommand, atLeast(1)).name();
    verify(physicalFlowUploadCommand, atLeast(1)).owner();
    verify(physicalFlowUploadCommand, atLeast(1)).source();
    verify(physicalFlowUploadCommand).specDescription();
    verify(physicalFlowUploadCommand).specExternalId();
    verify(physicalFlowUploadCommand, atLeast(1)).target();
    verify(physicalFlowUploadCommand, atLeast(1)).transport();
    assertEquals(1, actualValidateResult.size());
    PhysicalFlowUploadCommandResponse getResult = actualValidateResult.get(0);
    PhysicalFlowParsed parsedFlowResult = getResult.parsedFlow();
    assertTrue(parsedFlowResult instanceof ImmutablePhysicalFlowParsed);
    assertTrue(getResult instanceof ImmutablePhysicalFlowUploadCommandResponse);
    assertEquals("42", parsedFlowResult.externalId());
    assertEquals("42", parsedFlowResult.specExternalId());
    Map<String, String> errorsResult = getResult.errors();
    assertEquals(9, errorsResult.size());
    assertEquals("Basis Offset is not a recognised value, expect this to be a number", errorsResult.get("basisOffset"));
    assertEquals("Data Type not found", errorsResult.get("dataType"));
    assertEquals("Format is not a recognised value", errorsResult.get("format"));
    assertEquals("Name", parsedFlowResult.name());
    assertEquals("Owner not found", errorsResult.get("owner"));
    assertEquals("Spec Description", parsedFlowResult.specDescription());
    assertEquals("The characteristics of someone or something", parsedFlowResult.description());
    assertNull(parsedFlowResult.basisOffset());
    assertNull(parsedFlowResult.dataType());
    assertNull(parsedFlowResult.owner());
    assertNull(parsedFlowResult.source());
    assertNull(parsedFlowResult.target());
    assertNull(getResult.entityReference());
    assertNull(parsedFlowResult.criticality());
    assertNull(parsedFlowResult.frequency());
    assertNull(parsedFlowResult.transport());
    assertNull(parsedFlowResult.format());
    assertEquals(CommandOutcome.FAILURE, getResult.outcome());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#validate(List)}
   */
  @Test
  void testValidate5() {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);
    PhysicalFlowUploadCommand physicalFlowUploadCommand = mock(PhysicalFlowUploadCommand.class);
    when(physicalFlowUploadCommand.externalId()).thenThrow(new IllegalArgumentException(" "));
    when(physicalFlowUploadCommand.description()).thenReturn("The characteristics of someone or something");
    when(physicalFlowUploadCommand.specDescription()).thenReturn("Spec Description");
    when(physicalFlowUploadCommand.specExternalId()).thenReturn("42");
    when(physicalFlowUploadCommand.basisOffset()).thenReturn("Basis Offset");
    when(physicalFlowUploadCommand.name()).thenReturn("Name");
    when(physicalFlowUploadCommand.criticality()).thenReturn("Criticality");
    when(physicalFlowUploadCommand.frequency()).thenReturn("Frequency");
    when(physicalFlowUploadCommand.transport()).thenReturn("Transport");
    when(physicalFlowUploadCommand.format()).thenReturn("Format");
    when(physicalFlowUploadCommand.dataType()).thenReturn("Data Type");
    when(physicalFlowUploadCommand.owner()).thenReturn("Owner");
    when(physicalFlowUploadCommand.target()).thenReturn("Target");
    when(physicalFlowUploadCommand.source()).thenReturn("Source");

    ArrayList<PhysicalFlowUploadCommand> cmds = new ArrayList<>();
    cmds.add(physicalFlowUploadCommand);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> physicalFlowUploadService.validate(cmds));
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(physicalFlowUploadCommand, atLeast(1)).basisOffset();
    verify(physicalFlowUploadCommand, atLeast(1)).criticality();
    verify(physicalFlowUploadCommand, atLeast(1)).dataType();
    verify(physicalFlowUploadCommand).description();
    verify(physicalFlowUploadCommand).externalId();
    verify(physicalFlowUploadCommand, atLeast(1)).format();
    verify(physicalFlowUploadCommand, atLeast(1)).frequency();
    verify(physicalFlowUploadCommand, atLeast(1)).name();
    verify(physicalFlowUploadCommand, atLeast(1)).owner();
    verify(physicalFlowUploadCommand, atLeast(1)).source();
    verify(physicalFlowUploadCommand).specDescription();
    verify(physicalFlowUploadCommand).specExternalId();
    verify(physicalFlowUploadCommand, atLeast(1)).target();
    verify(physicalFlowUploadCommand, atLeast(1)).transport();
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  void testUpload() throws Exception {
    // Arrange
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(new ArrayList<>());
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult = physicalFlowUploadService.upload("janedoe",
        new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  void testUpload2() throws Exception {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenReturn("Name");

    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(actor);
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(actorList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult = physicalFlowUploadService.upload("janedoe",
        new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(actor).name();
    assertTrue(actualUploadResult.isEmpty());
  }

  /**
   * Method under test: {@link PhysicalFlowUploadService#upload(String, List)}
   */
  @Test
  void testUpload3() throws Exception {
    // Arrange
    Actor actor = mock(Actor.class);
    when(actor.name()).thenReturn("Name");
    Actor actor2 = mock(Actor.class);
    when(actor2.name()).thenReturn("Name");

    ArrayList<Actor> actorList = new ArrayList<>();
    actorList.add(actor2);
    actorList.add(actor);
    ActorDao actorDao = mock(ActorDao.class);
    when(actorDao.findAll()).thenReturn(actorList);
    ApplicationDao applicationDao = mock(ApplicationDao.class);
    when(applicationDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(new Aliases<>());
    EnumValueAliasService enumValueAliasService = new EnumValueAliasService(enumValueAliasDao);
    LogicalFlowDao logicalFlowDao = mock(LogicalFlowDao.class);
    PhysicalFlowUploadService physicalFlowUploadService = new PhysicalFlowUploadService(actorDao, applicationDao,
        dataTypeDao, logicalFlowDao,
        new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
            mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class), mock(LogicalFlowService.class),
            mock(LogicalFlowDecoratorRatingsCalculator.class), mock(DataTypeUsageService.class),
            mock(DataTypeService.class), mock(PhysicalSpecificationDao.class), mock(PhysicalSpecificationService.class),
            mock(AssessmentRatingService.class), mock(AssessmentDefinitionService.class),
            mock(RatingSchemeService.class), mock(FlowClassificationService.class),
            mock(FlowClassificationRuleService.class)),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), enumValueAliasService);

    // Act
    List<PhysicalFlowUploadCommandResponse> actualUploadResult = physicalFlowUploadService.upload("janedoe",
        new ArrayList<>());

    // Assert
    verify(actorDao).findAll();
    verify(applicationDao).findAll();
    verify(dataTypeDao).findAll();
    verify(enumValueAliasDao, atLeast(1)).mkAliases(Mockito.<EnumValueKind>any(),
        Mockito.<Function<String, Object>>any());
    verify(actor2).name();
    verify(actor).name();
    assertTrue(actualUploadResult.isEmpty());
  }
}
