package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.rel.RelationshipKindDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipValidationResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.relationship_kind.RelationshipKindService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BulkUploadRelationshipServiceDiffblueTest {
  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  void testBulkPreview() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.getById(anyLong())).thenReturn(null);
    RelationshipKindService relationshipKindService = new RelationshipKindService(relationshipKindDao);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
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

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult = (new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99)))
            .bulkPreview("Input", 1L);

    // Assert
    verify(relationshipKindDao).getById(eq(1L));
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult
        .parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  void testBulkPreview2() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong())).thenReturn(null);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
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

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult = (new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99)))
            .bulkPreview("Input", 1L);

    // Assert
    verify(relationshipKindService).getById(eq(1L));
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult
        .parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  void testBulkPreview3() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong())).thenReturn(null);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
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

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult = (new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99)))
            .bulkPreview("(\n|\r|\r\n)", 1L);

    // Assert
    verify(relationshipKindService).getById(eq(1L));
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult
        .parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
        + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
        + " are not set [sourceExternalId, targetExternalId]\n" + " at [Source: (StringReader); line: 2, column: 1]",
        parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  void testBulkPreview4() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong())).thenReturn(null);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
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

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult = (new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99)))
            .bulkPreview("\n", 1L);

    // Assert
    verify(relationshipKindService).getById(eq(1L));
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult
        .parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertEquals(0, parseErrorResult.column().intValue());
    assertEquals(0, parseErrorResult.line().intValue());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  void testBulkPreview5() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong())).thenReturn(null);
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
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

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult = (new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99)))
            .bulkPreview("#", 1L);

    // Assert
    verify(relationshipKindService).getById(eq(1L));
    BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult
        .parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  void testBulkApply() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
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

    RelationshipKindService relationshipKindService = new RelationshipKindService(mock(RelationshipKindDao.class));
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> (new BulkUploadRelationshipService(relationshipKindService, entityRelationshipService, userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99))).bulkApply(mock(BulkUploadRelationshipValidationResult.class), 1L,
                "User"));
    verify(userRoleDao).getUserRoles(eq("User"));
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  void testBulkApply2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    RelationshipKindService relationshipKindService = new RelationshipKindService(mock(RelationshipKindDao.class));
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
    BulkUploadRelationshipService bulkUploadRelationshipService = new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99));
    BulkUploadRelationshipValidationResult preview = mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError())
        .thenReturn(mock(BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(userRoleService).hasRole(eq("User"), (String[]) any());
  }

  /**
   * Method under test:
   * {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  void testBulkApply3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) any())).thenReturn(true);
    RelationshipKindService relationshipKindService = new RelationshipKindService(mock(RelationshipKindDao.class));
    EntityRelationshipService entityRelationshipService = new EntityRelationshipService(
        mock(EntityRelationshipDao.class));
    BulkUploadRelationshipService bulkUploadRelationshipService = new BulkUploadRelationshipService(
        relationshipKindService, entityRelationshipService, userRoleService, new DefaultDSLContext(SQLDialect.SQL99));
    BulkUploadRelationshipValidationResult preview = mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenThrow(new NotAuthorizedException("An error occurred"));

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(userRoleService).hasRole(eq("User"), (String[]) any());
  }
}
