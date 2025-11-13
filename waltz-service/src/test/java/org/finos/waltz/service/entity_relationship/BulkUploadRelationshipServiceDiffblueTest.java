package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipValidationResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult.Builder;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.rel.ImmutableRelationshipKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.relationship_kind.RelationshipKindService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.SQLDialect;
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
class BulkUploadRelationshipServiceDiffblueTest {
  @InjectMocks private BulkUploadRelationshipService bulkUploadRelationshipService;

  @Mock private UserRoleService userRoleService;

  /**
   * Test {@link BulkUploadRelationshipService#bulkPreview(String, Long)}.
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName("Test bulkPreview(String, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult =
        bulkUploadRelationshipService.bulkPreview("#", 1L);

    // Assert
    verify(relationshipKindService).getById(1L);
    BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals(
        "Empty header line: can not bind data\n at [Source: (StringReader); line: UNKNOWN, column: UNKNOWN]",
        parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkPreview(String, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationshipKindDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName("Test bulkPreview(String, Long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview_thenCallsGetById() {
    // Arrange
    RelationshipKindDao relationshipKindDao = mock(RelationshipKindDao.class);
    when(relationshipKindDao.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());
    RelationshipKindService relationshipKindService =
        new RelationshipKindService(relationshipKindDao);
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult =
        bulkUploadRelationshipService.bulkPreview("Input", 1L);

    // Assert
    verify(relationshipKindDao).getById(1L);
    BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkPreview(String, Long)}.
   *
   * <ul>
   *   <li>Then return parseError message is a string.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName("Test bulkPreview(String, Long); then return parseError message is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview_thenReturnParseErrorMessageIsAString() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult =
        bulkUploadRelationshipService.bulkPreview("(\n|\r|\r\n)", 1L);

    // Assert
    verify(relationshipKindService).getById(1L);
    BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals(
        "Cannot construct instance of `org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUpl"
            + "oadRelationshipItem`, problem: Cannot build BulkUploadRelationshipItem, some of required attributes"
            + " are not set [sourceExternalId, targetExternalId]\n"
            + " at [Source: (StringReader); line: 2, column: 1]",
        parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkPreview(String, Long)}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return parseError message is {@code Cannot parse input.}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(String, Long); when 'Input'; then return parseError message is 'Cannot parse input.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview_whenInput_thenReturnParseErrorMessageIsCannotParseInput() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult =
        bulkUploadRelationshipService.bulkPreview("Input", 1L);

    // Assert
    verify(relationshipKindService).getById(1L);
    BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertNull(parseErrorResult.column());
    assertNull(parseErrorResult.line());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkPreview(String, Long)}.
   *
   * <ul>
   *   <li>When lf.
   *   <li>Then return parseError column intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName(
      "Test bulkPreview(String, Long); when lf; then return parseError column intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview_whenLf_thenReturnParseErrorColumnIntValueIsZero() {
    // Arrange
    RelationshipKindService relationshipKindService = mock(RelationshipKindService.class);
    when(relationshipKindService.getById(anyLong()))
        .thenReturn(
            ImmutableRelationshipKind.builder()
                .categoryA(1L)
                .categoryB(1L)
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kindA(EntityKind.ALL)
                .kindB(EntityKind.ALL)
                .name("Name")
                .position(1)
                .reverseName("Reverse Name")
                .build());
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act
    BulkUploadRelationshipValidationResult actualBulkPreviewResult =
        bulkUploadRelationshipService.bulkPreview("\n", 1L);

    // Assert
    verify(relationshipKindService).getById(1L);
    BulkUploadRelationshipParseError parseErrorResult = actualBulkPreviewResult.parseError();
    assertTrue(parseErrorResult instanceof ImmutableBulkUploadRelationshipParseError);
    assertTrue(actualBulkPreviewResult instanceof ImmutableBulkUploadRelationshipValidationResult);
    assertEquals("Cannot parse input.", parseErrorResult.message());
    assertEquals(0, parseErrorResult.column().intValue());
    assertEquals(0, parseErrorResult.line().intValue());
    assertTrue(actualBulkPreviewResult.validatedItems().isEmpty());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName("Test bulkApply(BulkUploadRelationshipValidationResult, Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    RelationshipKindService relationshipKindService =
        new RelationshipKindService(mock(RelationshipKindDao.class));
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError())
        .thenReturn(
            ImmutableBulkUploadRelationshipParseError.builder()
                .column(1)
                .line(2)
                .message("Not all who wander are lost")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName("Test bulkApply(BulkUploadRelationshipValidationResult, Long, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply2() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    Builder builderResult = ImmutableBulkUploadRelationshipValidationResult.builder();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadRelationshipService.bulkApply(
                builderResult
                    .parseError(
                        ImmutableBulkUploadRelationshipParseError.builder()
                            .column(1)
                            .line(2)
                            .message("Not all who wander are lost")
                            .build())
                    .build(),
                1L,
                "User"));
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenIllegalStateException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); then throw NotAuthorizedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);
    RelationshipKindService relationshipKindService =
        new RelationshipKindService(mock(RelationshipKindDao.class));
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService,
            entityRelationshipService,
            userRoleService,
            new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            bulkUploadRelationshipService.bulkApply(
                mock(BulkUploadRelationshipValidationResult.class), 1L, "User"));
    verify(userRoleDao).getUserRoles("User");
  }
}
