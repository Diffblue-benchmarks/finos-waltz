package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.change_initiative.ChangeInitiativeDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.client_cache_key.ClientCacheKeyDao;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.entity_hierarchy.EntityHierarchyDao;
import org.finos.waltz.data.entity_statistic.EntityStatisticDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_category.MeasurableCategoryDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.orgunit.OrganisationalUnitDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.taxonomy_management.TaxonomyChangeDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.taxonomy_management.ImmutableTaxonomyChangePreview;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeLifecycleStatus;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangePreview;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.client_cache_key.ClientCacheKeyService;
import org.finos.waltz.service.entity_hierarchy.EntityHierarchyService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.measurable_category.MeasurableCategoryService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.taxonomy_management.processors.AddMeasurableCommandProcessor;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaxonomyChangeServiceDiffblueTest {
  /**
   * Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  void testPreviewById() {
    // Arrange
    TaxonomyChangeCommand taxonomyChangeCommand = mock(TaxonomyChangeCommand.class);
    when(taxonomyChangeCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.getDraftCommandById(anyLong())).thenReturn(taxonomyChangeCommand);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    UserRoleService userRoleService = mock(UserRoleService.class);

    // Act
    TaxonomyChangePreview actualPreviewByIdResult = (new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class))).previewById(1L);

    // Assert
    verify(taxonomyChangeDao).getDraftCommandById(eq(1L));
    verify(taxonomyChangeCommand, atLeast(1)).changeType();
    assertTrue(actualPreviewByIdResult instanceof ImmutableTaxonomyChangePreview);
    assertEquals("Cannot find processor for type: ADD_PEER", actualPreviewByIdResult.errorMessage());
    assertTrue(actualPreviewByIdResult.impacts().isEmpty());
  }

  /**
   * Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  void testPreviewById2() {
    // Arrange
    TaxonomyChangeCommand taxonomyChangeCommand = mock(TaxonomyChangeCommand.class);
    when(taxonomyChangeCommand.changeDomain()).thenReturn(null);
    doNothing().when(taxonomyChangeCommand).validate();
    when(taxonomyChangeCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.getDraftCommandById(anyLong())).thenReturn(taxonomyChangeCommand);

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    processors
        .add(new AddMeasurableCommandProcessor(new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))));

    // Act
    TaxonomyChangePreview actualPreviewByIdResult = (new TaxonomyChangeService(taxonomyChangeDao,
        mock(ClientCacheKeyService.class), mock(MeasurableCategoryService.class), mock(UserRoleService.class),
        processors, mock(MeasurableService.class), mock(EntityHierarchyService.class))).previewById(1L);

    // Assert
    verify(taxonomyChangeDao).getDraftCommandById(eq(1L));
    verify(taxonomyChangeCommand).changeDomain();
    verify(taxonomyChangeCommand, atLeast(1)).changeType();
    verify(taxonomyChangeCommand).validate();
    assertTrue(actualPreviewByIdResult instanceof ImmutableTaxonomyChangePreview);
    assertNull(actualPreviewByIdResult.errorMessage());
    assertTrue(actualPreviewByIdResult.impacts().isEmpty());
  }

  /**
   * Method under test: {@link TaxonomyChangeService#previewById(long)}
   */
  @Test
  void testPreviewById3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    TaxonomyChangeCommand taxonomyChangeCommand = mock(TaxonomyChangeCommand.class);
    when(taxonomyChangeCommand.changeDomain()).thenReturn(entityReference);
    doNothing().when(taxonomyChangeCommand).validate();
    when(taxonomyChangeCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.getDraftCommandById(anyLong())).thenReturn(taxonomyChangeCommand);

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    processors
        .add(new AddMeasurableCommandProcessor(new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))));

    // Act
    TaxonomyChangePreview actualPreviewByIdResult = (new TaxonomyChangeService(taxonomyChangeDao,
        mock(ClientCacheKeyService.class), mock(MeasurableCategoryService.class), mock(UserRoleService.class),
        processors, mock(MeasurableService.class), mock(EntityHierarchyService.class))).previewById(1L);

    // Assert
    verify(taxonomyChangeDao).getDraftCommandById(eq(1L));
    verify(entityReference, atLeast(1)).kind();
    verify(taxonomyChangeCommand, atLeast(1)).changeDomain();
    verify(taxonomyChangeCommand, atLeast(1)).changeType();
    verify(taxonomyChangeCommand).validate();
    assertTrue(actualPreviewByIdResult instanceof ImmutableTaxonomyChangePreview);
    assertEquals("Incorrect domain, expected [MEASURABLE_CATEGORY] got [ALL]", actualPreviewByIdResult.errorMessage());
    assertTrue(actualPreviewByIdResult.impacts().isEmpty());
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}
   */
  @Test
  void testSubmitDraftChange() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any())).thenReturn(null);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    TaxonomyChangeService taxonomyChangeService = new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(new HashMap<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(draftCommand.id()).thenReturn(ofResult);
    when(draftCommand.primaryReference()).thenReturn(mock(EntityReference.class));
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain()).thenReturn(entityReference);

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult = taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(entityReference).kind();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertNull(actualSubmitDraftChangeResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}
   */
  @Test
  void testSubmitDraftChange2() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any())).thenReturn(null);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    TaxonomyChangeService taxonomyChangeService = new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("Command must be DRAFT", "Command must be DRAFT");
    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(stringStringMap);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(draftCommand.id()).thenReturn(ofResult);
    when(draftCommand.primaryReference()).thenReturn(mock(EntityReference.class));
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain()).thenReturn(entityReference);

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult = taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(entityReference).kind();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertNull(actualSubmitDraftChangeResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}
   */
  @Test
  void testSubmitDraftChange3() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any())).thenReturn(null);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    TaxonomyChangeService taxonomyChangeService = new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("instance", "instance");
    stringStringMap.put("Command must be DRAFT", "Command must be DRAFT");
    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(stringStringMap);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(draftCommand.id()).thenReturn(ofResult);
    when(draftCommand.primaryReference()).thenReturn(mock(EntityReference.class));
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain()).thenReturn(entityReference);

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult = taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(entityReference).kind();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertNull(actualSubmitDraftChangeResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}
   */
  @Test
  void testSubmitDraftChange4() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any())).thenReturn(null);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    TaxonomyChangeService taxonomyChangeService = new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(new HashMap<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(draftCommand.id()).thenReturn(ofResult);
    when(draftCommand.primaryReference()).thenReturn(mock(EntityReference.class));
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("42");
    when(draftCommand.lastUpdatedBy()).thenReturn("2020-03-01");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain()).thenReturn(entityReference);

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult = taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(entityReference).kind();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertNull(actualSubmitDraftChangeResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#submitDraftChange(TaxonomyChangeCommand, String)}
   */
  @Test
  void testSubmitDraftChange5() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.createCommand(Mockito.<TaxonomyChangeCommand>any())).thenReturn(null);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = mock(ClientCacheKeyService.class);
    MeasurableCategoryService measurableCategoryService = mock(MeasurableCategoryService.class);
    TaxonomyChangeService taxonomyChangeService = new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, new ArrayList<>(), mock(MeasurableService.class),
        mock(EntityHierarchyService.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    TaxonomyChangeCommand draftCommand = mock(TaxonomyChangeCommand.class);
    when(draftCommand.params()).thenReturn(new HashMap<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(draftCommand.id()).thenReturn(ofResult);
    when(draftCommand.primaryReference()).thenReturn(mock(EntityReference.class));
    when(draftCommand.changeType()).thenReturn(TaxonomyChangeType.ADD_PEER);
    when(draftCommand.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.createdBy()).thenReturn("Jan 1, 2020 8:00am GMT+0100");
    when(draftCommand.lastUpdatedBy()).thenReturn("42");
    when(draftCommand.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(draftCommand.status()).thenReturn(TaxonomyChangeLifecycleStatus.DRAFT);
    when(draftCommand.changeDomain()).thenReturn(entityReference);

    // Act
    TaxonomyChangeCommand actualSubmitDraftChangeResult = taxonomyChangeService.submitDraftChange(draftCommand, "42");

    // Assert
    verify(taxonomyChangeDao).createCommand(isA(TaxonomyChangeCommand.class));
    verify(draftCommand).createdAt();
    verify(draftCommand).createdBy();
    verify(entityReference).kind();
    verify(draftCommand).id();
    verify(draftCommand).lastUpdatedAt();
    verify(draftCommand).lastUpdatedBy();
    verify(draftCommand, atLeast(1)).changeDomain();
    verify(draftCommand).changeType();
    verify(draftCommand).params();
    verify(draftCommand).primaryReference();
    verify(draftCommand, atLeast(1)).status();
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertNull(actualSubmitDraftChangeResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#findDraftChangesByDomain(EntityReference)}
   */
  @Test
  void testFindDraftChangesByDomain() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    ArrayList<TaxonomyChangeCommand> taxonomyChangeCommandList = new ArrayList<>();
    when(taxonomyChangeDao.findChangesByDomainAndStatus(Mockito.<EntityReference>any(),
        Mockito.<TaxonomyChangeLifecycleStatus>any())).thenReturn(taxonomyChangeCommandList);
    ClientCacheKeyService clientCacheKeyService = new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao3 = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao2, roleDao2, personDao2, changeLogService3,
        personService2, new SettingsService(settingsDao3, new ArrayList<>()));

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);

    // Act
    Collection<TaxonomyChangeCommand> actualFindDraftChangesByDomainResult = (new TaxonomyChangeService(
        taxonomyChangeDao, clientCacheKeyService, measurableCategoryService, userRoleService2, processors,
        measurableService2,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao3, organisationalUnitDao,
            new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class))))
                .findDraftChangesByDomain(null);

    // Assert
    verify(taxonomyChangeDao).findChangesByDomainAndStatus(isNull(), eq(TaxonomyChangeLifecycleStatus.DRAFT));
    assertTrue(actualFindDraftChangesByDomainResult instanceof List);
    assertTrue(actualFindDraftChangesByDomainResult.isEmpty());
    assertSame(taxonomyChangeCommandList, actualFindDraftChangesByDomainResult);
  }

  /**
   * Method under test:
   * {@link TaxonomyChangeService#findAllChangesByDomain(EntityReference)}
   */
  @Test
  void testFindAllChangesByDomain() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    ArrayList<TaxonomyChangeCommand> taxonomyChangeCommandList = new ArrayList<>();
    when(taxonomyChangeDao.findChangesByDomain(Mockito.<EntityReference>any())).thenReturn(taxonomyChangeCommandList);
    ClientCacheKeyService clientCacheKeyService = new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    UserRoleDao userRoleDao2 = mock(UserRoleDao.class);
    RoleDao roleDao2 = mock(RoleDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    ChangeLogService changeLogService3 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService2 = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao3 = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao2, roleDao2, personDao2, changeLogService3,
        personService2, new SettingsService(settingsDao3, new ArrayList<>()));

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao3 = mock(PersonDao.class);

    // Act
    Collection<TaxonomyChangeCommand> actualFindAllChangesByDomainResult = (new TaxonomyChangeService(taxonomyChangeDao,
        clientCacheKeyService, measurableCategoryService, userRoleService2, processors, measurableService2,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao3, organisationalUnitDao,
            new PersonHierarchyService(personDao3, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class))))
                .findAllChangesByDomain(null);

    // Assert
    verify(taxonomyChangeDao).findChangesByDomain(isNull());
    assertTrue(actualFindAllChangesByDomainResult instanceof List);
    assertTrue(actualFindAllChangesByDomainResult.isEmpty());
    assertSame(taxonomyChangeCommandList, actualFindAllChangesByDomainResult);
  }

  /**
   * Method under test: {@link TaxonomyChangeService#removeById(long, String)}
   */
  @Test
  void testRemoveById() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.removeById(anyLong(), Mockito.<String>any())).thenReturn(true);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService2, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);

    // Act
    boolean actualRemoveByIdResult = (new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, processors, measurableService2,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao3, organisationalUnitDao,
            new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class))))
                .removeById(1L, "42");

    // Assert
    verify(taxonomyChangeDao).removeById(eq(1L), eq("42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Method under test: {@link TaxonomyChangeService#removeById(long, String)}
   */
  @Test
  void testRemoveById2() {
    // Arrange
    TaxonomyChangeDao taxonomyChangeDao = mock(TaxonomyChangeDao.class);
    when(taxonomyChangeDao.removeById(anyLong(), Mockito.<String>any())).thenReturn(false);
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    ClientCacheKeyService clientCacheKeyService = new ClientCacheKeyService(mock(ClientCacheKeyDao.class));
    MeasurableCategoryDao measurableCategoryDao = mock(MeasurableCategoryDao.class);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService2 = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService = new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    SettingsDao settingsDao2 = mock(SettingsDao.class);
    MeasurableCategoryService measurableCategoryService = new MeasurableCategoryService(measurableCategoryDao,
        userRoleService2, changeLogService2, measurableService, new SettingsService(settingsDao2, new ArrayList<>()));

    ArrayList<TaxonomyCommandProcessor> processors = new ArrayList<>();
    MeasurableDao measurableDao2 = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao2 = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver2 = mock(EntityReferenceNameResolver.class);
    MeasurableService measurableService2 = new MeasurableService(measurableDao2, measurableSearchDao2, nameResolver2,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));

    DefaultDSLContext dsl = new DefaultDSLContext(SQLDialect.SQL99);
    ChangeInitiativeDao changeInitiativeDao = mock(ChangeInitiativeDao.class);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    EntityHierarchyDao entityHierarchyDao = mock(EntityHierarchyDao.class);
    EntityStatisticDao entityStatisticDao = mock(EntityStatisticDao.class);
    MeasurableDao measurableDao3 = mock(MeasurableDao.class);
    OrganisationalUnitDao organisationalUnitDao = mock(OrganisationalUnitDao.class);
    PersonDao personDao2 = mock(PersonDao.class);

    // Act
    boolean actualRemoveByIdResult = (new TaxonomyChangeService(taxonomyChangeDao, clientCacheKeyService,
        measurableCategoryService, userRoleService, processors, measurableService2,
        new EntityHierarchyService(dsl, changeInitiativeDao, dataTypeDao, entityHierarchyDao, entityStatisticDao,
            measurableDao3, organisationalUnitDao,
            new PersonHierarchyService(personDao2, new DefaultDSLContext(SQLDialect.SQL99)), mock(PersonDao.class))))
                .removeById(1L, "42");

    // Assert
    verify(taxonomyChangeDao).removeById(eq(1L), eq("42"));
    verify(userRoleService).hasRole(eq("42"), (String[]) any());
    assertFalse(actualRemoveByIdResult);
  }
}
