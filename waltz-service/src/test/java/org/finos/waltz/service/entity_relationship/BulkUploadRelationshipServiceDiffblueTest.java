package org.finos.waltz.service.entity_relationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipApplyResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipParsedResult.BulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipValidatedItem;
import org.finos.waltz.model.bulk_upload.entity_relationship.BulkUploadRelationshipValidationResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipApplyResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipItem;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipParseError;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidatedItem.Builder;
import org.finos.waltz.model.bulk_upload.entity_relationship.ImmutableBulkUploadRelationshipValidationResult;
import org.finos.waltz.model.bulk_upload.entity_relationship.UploadOperation;
import org.finos.waltz.model.bulk_upload.entity_relationship.ValidationError;
import org.finos.waltz.model.exceptions.NotAuthorizedException;
import org.finos.waltz.model.rel.ImmutableRelationshipKind;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.relationship_kind.RelationshipKindService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.TransactionalCallable;
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

  @Mock private DSLContext dSLContext;

  @Mock private RelationshipKindService relationshipKindService;

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
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BulkUploadRelationshipService#bulkPreview(String, Long)}
   */
  @Test
  @DisplayName("Test bulkPreview(String, Long); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipValidationResult BulkUploadRelationshipService.bulkPreview(String, Long)"
  })
  void testBulkPreview_thenThrowIllegalStateException() {
    // Arrange
    when(relationshipKindService.getById(anyLong())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> bulkUploadRelationshipService.bulkPreview("Input", 1L));
    verify(relationshipKindService).getById(1L);
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
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    ImmutableBulkUploadRelationshipValidationResult.Builder builderResult =
        ImmutableBulkUploadRelationshipValidationResult.builder();

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
   *   <li>Given builder column one line two message {@code Not all who wander are lost} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given builder column one line two message 'Not all who wander are lost' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenBuilderColumnOneLineTwoMessageNotAllWhoWanderAreLostBuild() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

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
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given DSLContext transactionResult(TransactionalCallable) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenDSLContextTransactionResultReturnNull_thenReturnNull() {
    // Arrange
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
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);
    when(dSLContext.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenReturn(null);

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(new ArrayList<>());

    // Act
    BulkUploadRelationshipApplyResult actualBulkApplyResult =
        bulkUploadRelationshipService.bulkApply(preview, 1L, "User");

    // Assert
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(relationshipKindService).getById(1L);
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    verify(dSLContext).transactionResult(isA(TransactionalCallable.class));
    assertNull(actualBulkApplyResult);
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transactionResult(TransactionalCallable)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given DSLContext transactionResult(TransactionalCallable) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenDSLContextTransactionResultThrowIllegalStateException() {
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

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.transactionResult(Mockito.<TransactionalCallable<Object>>any()))
        .thenThrow(new IllegalStateException());
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService, entityRelationshipService, userRoleService, dsl);

    Builder builderResult = ImmutableBulkUploadRelationshipValidatedItem.builder();
    builderResult.addError(ValidationError.SOURCE_NOT_FOUND);

    Builder descriptionResult =
        builderResult.description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableBulkUploadRelationshipValidatedItem immutableBulkUploadRelationshipValidatedItem =
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build();

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList =
        new ArrayList<>();
    bulkUploadRelationshipValidatedItemList.add(immutableBulkUploadRelationshipValidatedItem);

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(relationshipKindService).getById(1L);
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    verify(dsl).transactionResult(isA(TransactionalCallable.class));
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
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

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService, entityRelationshipService, userRoleService, dsl);

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList =
        new ArrayList<>();

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    bulkUploadRelationshipValidatedItemList.add(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);

    // Act
    BulkUploadRelationshipApplyResult actualBulkApplyResult =
        bulkUploadRelationshipService.bulkApply(preview, 1L, "User");

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement, atLeast(1)).executeBatch();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(relationshipKindDao).getById(1L);
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    assertTrue(actualBulkApplyResult instanceof ImmutableBulkUploadRelationshipApplyResult);
    assertEquals(0L, actualBulkApplyResult.recordsAdded().longValue());
    assertEquals(0L, actualBulkApplyResult.recordsUpdated().longValue());
    assertEquals(0L, actualBulkApplyResult.skippedRows().longValue());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService, entityRelationshipService, userRoleService, dsl);

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(new ArrayList<>());

    // Act
    BulkUploadRelationshipApplyResult actualBulkApplyResult =
        bulkUploadRelationshipService.bulkApply(preview, 1L, "User");

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    verify(relationshipKindDao).getById(1L);
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    assertTrue(actualBulkApplyResult instanceof ImmutableBulkUploadRelationshipApplyResult);
    assertEquals(0L, actualBulkApplyResult.recordsAdded().longValue());
    assertEquals(0L, actualBulkApplyResult.recordsUpdated().longValue());
    assertEquals(0L, actualBulkApplyResult.skippedRows().longValue());
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
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
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
   *   <li>Given {@link RelationshipKindService} {@link RelationshipKindService#getById(long)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given RelationshipKindService getById(long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenRelationshipKindServiceGetByIdThrowIllegalStateException() {
    // Arrange
    when(relationshipKindService.getById(anyLong())).thenThrow(new IllegalStateException());
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> bulkUploadRelationshipService.bulkApply(preview, 1L, "User"));
    verify(preview).parseError();
    verify(relationshipKindService).getById(1L);
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleDao} {@link UserRoleDao#getUserRoles(String)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given UserRoleDao getUserRoles(String) return HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenUserRoleDaoGetUserRolesReturnHashSet_thenCallsGetUserRoles() {
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

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, String[])} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given UserRoleService hasRole(String, String[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenUserRoleServiceHasRoleReturnFalse() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            bulkUploadRelationshipService.bulkApply(
                mock(BulkUploadRelationshipValidationResult.class), 1L, "User"));
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Given {@link UserRoleService} {@link UserRoleService#hasRole(String, String[])} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); given UserRoleService hasRole(String, String[]) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_givenUserRoleServiceHasRoleThrowIllegalStateException() {
    // Arrange
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            bulkUploadRelationshipService.bulkApply(
                mock(BulkUploadRelationshipValidationResult.class), 1L, "User"));
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_thenCallsPrepareStatement() throws SQLException {
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

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService, entityRelationshipService, userRoleService, dsl);

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList =
        new ArrayList<>();

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    bulkUploadRelationshipValidatedItemList.add(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);

    // Act
    BulkUploadRelationshipApplyResult actualBulkApplyResult =
        bulkUploadRelationshipService.bulkApply(preview, 1L, "User");

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement, atLeast(1)).executeBatch();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(relationshipKindDao).getById(1L);
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    assertTrue(actualBulkApplyResult instanceof ImmutableBulkUploadRelationshipApplyResult);
    assertEquals(0L, actualBulkApplyResult.recordsAdded().longValue());
    assertEquals(0L, actualBulkApplyResult.recordsUpdated().longValue());
    assertEquals(0L, actualBulkApplyResult.skippedRows().longValue());
  }

  /**
   * Test {@link BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult,
   * Long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BulkUploadRelationshipService#bulkApply(BulkUploadRelationshipValidationResult, Long, String)}
   */
  @Test
  @DisplayName(
      "Test bulkApply(BulkUploadRelationshipValidationResult, Long, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BulkUploadRelationshipApplyResult BulkUploadRelationshipService.bulkApply(BulkUploadRelationshipValidationResult, Long, String)"
  })
  void testBulkApply_thenCallsPrepareStatement2() throws SQLException {
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

    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), (String[]) Mockito.any())).thenReturn(true);

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    EntityRelationshipService entityRelationshipService =
        new EntityRelationshipService(mock(EntityRelationshipDao.class));

    BulkUploadRelationshipService bulkUploadRelationshipService =
        new BulkUploadRelationshipService(
            relationshipKindService, entityRelationshipService, userRoleService, dsl);

    ArrayList<BulkUploadRelationshipValidatedItem> bulkUploadRelationshipValidatedItemList =
        new ArrayList<>();

    Builder descriptionResult =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult = descriptionResult.addAllError(new ArrayList<>());

    Builder parsedItemResult =
        addAllErrorResult.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult =
        parsedItemResult.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    bulkUploadRelationshipValidatedItemList.add(
        sourceEntityRefResult
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    Builder descriptionResult2 =
        ImmutableBulkUploadRelationshipValidatedItem.builder()
            .description("The characteristics of someone or something");

    Builder addAllErrorResult2 = descriptionResult2.addAllError(new ArrayList<>());

    Builder parsedItemResult2 =
        addAllErrorResult2.parsedItem(
            ImmutableBulkUploadRelationshipItem.builder()
                .description("The characteristics of someone or something")
                .sourceExternalId("42")
                .targetExternalId("42")
                .build());

    Builder sourceEntityRefResult2 =
        parsedItemResult2.sourceEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    bulkUploadRelationshipValidatedItemList.add(
        sourceEntityRefResult2
            .targetEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .uploadOperation(UploadOperation.ADD)
            .build());

    BulkUploadRelationshipValidationResult preview =
        mock(BulkUploadRelationshipValidationResult.class);
    when(preview.parseError()).thenReturn(null);
    when(preview.validatedItems()).thenReturn(bulkUploadRelationshipValidatedItemList);

    // Act
    BulkUploadRelationshipApplyResult actualBulkApplyResult =
        bulkUploadRelationshipService.bulkApply(preview, 1L, "User");

    // Assert
    verify(connection).commit();
    verify(connection).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(anyInt(), isA(Timestamp.class));
    verify(statement).close();
    verify(preparedStatement, atLeast(1)).close();
    verify(statement).executeBatch();
    verify(preparedStatement, atLeast(1)).executeBatch();
    verify(statement).getWarnings();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(relationshipKindDao).getById(1L);
    verify(preview).parseError();
    verify(preview, atLeast(1)).validatedItems();
    verify(userRoleService).hasRole(eq("User"), (String[]) Mockito.any());
    assertTrue(actualBulkApplyResult instanceof ImmutableBulkUploadRelationshipApplyResult);
    assertEquals(0L, actualBulkApplyResult.recordsAdded().longValue());
    assertEquals(0L, actualBulkApplyResult.recordsUpdated().longValue());
    assertEquals(0L, actualBulkApplyResult.skippedRows().longValue());
  }
}
