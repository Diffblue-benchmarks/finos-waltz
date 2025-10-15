package org.finos.waltz.service.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.external_identifier.ExternalIdentifierDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier;
import org.finos.waltz.model.external_identifier.ImmutableExternalIdentifier.Builder;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExternalIdentifierServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private ExternalIdentifierDao externalIdentifierDao;

  @InjectMocks private ExternalIdentifierService externalIdentifierService;

  /**
   * Test {@link ExternalIdentifierService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ExternalIdentifierService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<ExternalIdentifier> actualFindByEntityReferenceResult =
        externalIdentifierService.findByEntityReference(null);

    // Assert
    verify(externalIdentifierDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link ExternalIdentifierService#findByKind(EntityKind, String)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#findByKind(EntityKind, String)}
   */
  @Test
  @DisplayName("Test findByKind(EntityKind, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ExternalIdentifierService.findByKind(EntityKind, String)"})
  void testFindByKind() {
    // Arrange
    when(externalIdentifierDao.findByKind(Mockito.<EntityKind>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<ExternalIdentifier> actualFindByKindResult =
        externalIdentifierService.findByKind(EntityKind.ALL, "42");

    // Assert
    verify(externalIdentifierDao).findByKind(EntityKind.ALL, "42");
    assertTrue(actualFindByKindResult.isEmpty());
  }

  /**
   * Test {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test merge(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.merge(EntityReference, EntityReference)"})
  void testMerge() {
    // Arrange
    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();

    Builder builderResult = ImmutableExternalIdentifier.builder();
    externalIdentifierSet.add(
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
            .externalId("42")
            .system("System")
            .build());
    when(externalIdentifierDao.create(Mockito.<Set<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.delete(Mockito.<Collection<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(externalIdentifierSet);
    ImmutableEntityReference fromRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualMergeResult =
        externalIdentifierService.merge(
            fromRef,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(externalIdentifierDao).create(isA(Set.class));
    verify(externalIdentifierDao).delete(isA(Collection.class));
    verify(externalIdentifierDao, atLeast(1)).findByEntityReference(isA(EntityReference.class));
    assertEquals(0, actualMergeResult);
  }

  /**
   * Test {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test merge(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.merge(EntityReference, EntityReference)"})
  void testMerge2() {
    // Arrange
    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();

    Builder builderResult = ImmutableExternalIdentifier.builder();
    externalIdentifierSet.add(
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
            .externalId("42")
            .system("System")
            .build());
    when(externalIdentifierDao.create(Mockito.<Set<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.delete(Mockito.<Collection<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(externalIdentifierSet);
    ImmutableEntityReference fromRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualMergeResult =
        externalIdentifierService.merge(
            fromRef,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(-2L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(externalIdentifierDao).create(isA(Set.class));
    verify(externalIdentifierDao).delete(isA(Collection.class));
    verify(externalIdentifierDao, atLeast(1)).findByEntityReference(Mockito.<EntityReference>any());
    assertEquals(0, actualMergeResult);
  }

  /**
   * Test {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test merge(EntityReference, EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.merge(EntityReference, EntityReference)"})
  void testMerge3() {
    // Arrange
    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();

    Builder builderResult = ImmutableExternalIdentifier.builder();
    externalIdentifierSet.add(
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
            .externalId("42")
            .system("System")
            .build());
    when(externalIdentifierDao.create(Mockito.<Set<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.delete(Mockito.<Collection<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(externalIdentifierSet);

    // Act
    int actualMergeResult =
        externalIdentifierService.merge(
            null,
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(externalIdentifierDao).create(isA(Set.class));
    verify(externalIdentifierDao).delete(isA(Collection.class));
    verify(externalIdentifierDao, atLeast(1)).findByEntityReference(Mockito.<EntityReference>any());
    assertEquals(0, actualMergeResult);
  }

  /**
   * Test {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}
   */
  @Test
  @DisplayName("Test merge(EntityReference, EntityReference); when 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.merge(EntityReference, EntityReference)"})
  void testMerge_whenNull_thenReturnZero() {
    // Arrange
    when(externalIdentifierDao.create(Mockito.<Set<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.delete(Mockito.<Collection<ExternalIdentifier>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    int actualMergeResult = externalIdentifierService.merge(null, null);

    // Assert
    verify(externalIdentifierDao).create(isA(Set.class));
    verify(externalIdentifierDao).delete(isA(Collection.class));
    verify(externalIdentifierDao, atLeast(1)).findByEntityReference(isNull());
    assertEquals(0, actualMergeResult);
  }

  /**
   * Test {@link ExternalIdentifierService#delete(EntityReference)} with {@code entityRef}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#delete(EntityReference)}
   */
  @Test
  @DisplayName("Test delete(EntityReference) with 'entityRef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.delete(EntityReference)"})
  void testDeleteWithEntityRef() {
    // Arrange
    when(externalIdentifierDao.delete(Mockito.<EntityReference>any())).thenReturn(1);

    // Act
    int actualDeleteResult = externalIdentifierService.delete(null);

    // Assert
    verify(externalIdentifierDao).delete((EntityReference) isNull());
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierService#delete(EntityReference, String, String, String)} with
   * {@code entityRef}, {@code externalId}, {@code provenance}, {@code username}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#delete(EntityReference, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference, String, String, String) with 'entityRef', 'externalId', 'provenance', 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ExternalIdentifierService.delete(EntityReference, String, String, String)"
  })
  void testDeleteWithEntityRefExternalIdProvenanceUsername() {
    // Arrange
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int actualDeleteResult =
        externalIdentifierService.delete(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build(),
            "42",
            "Provenance",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierService#delete(EntityReference, String, String, String)} with
   * {@code entityRef}, {@code externalId}, {@code provenance}, {@code username}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#delete(EntityReference, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference, String, String, String) with 'entityRef', 'externalId', 'provenance', 'username'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ExternalIdentifierService.delete(EntityReference, String, String, String)"
  })
  void testDeleteWithEntityRefExternalIdProvenanceUsername_thenCallsWrite() {
    // Arrange
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int actualDeleteResult =
        externalIdentifierService.delete(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "Provenance",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierService#delete(EntityReference, String, String, String)} with
   * {@code entityRef}, {@code externalId}, {@code provenance}, {@code username}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#delete(EntityReference, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference, String, String, String) with 'entityRef', 'externalId', 'provenance', 'username'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ExternalIdentifierService.delete(EntityReference, String, String, String)"
  })
  void testDeleteWithEntityRefExternalIdProvenanceUsername_thenCallsWrite2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(1);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ExternalIdentifierService externalIdentifierService =
        new ExternalIdentifierService(externalIdentifierDao, changeLogService);

    // Act
    int actualDeleteResult =
        externalIdentifierService.delete(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "Provenance",
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierService#delete(EntityReference, String, String, String)} with
   * {@code entityRef}, {@code externalId}, {@code provenance}, {@code username}.
   *
   * <ul>
   *   <li>Then return minus five.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#delete(EntityReference, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test delete(EntityReference, String, String, String) with 'entityRef', 'externalId', 'provenance', 'username'; then return minus five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ExternalIdentifierService.delete(EntityReference, String, String, String)"
  })
  void testDeleteWithEntityRefExternalIdProvenanceUsername_thenReturnMinusFive() {
    // Arrange
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(-5);

    // Act
    int actualDeleteResult =
        externalIdentifierService.delete(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "Provenance",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    assertEquals(-5, actualDeleteResult);
  }

  /**
   * Test {@link ExternalIdentifierService#create(EntityReference, String, String)}.
   *
   * <p>Method under test: {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  @DisplayName("Test create(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.create(EntityReference, String, String)"})
  void testCreate() {
    // Arrange
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int actualCreateResult =
        externalIdentifierService.create(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build(),
            "42",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierService#create(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(EntityReference, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.create(EntityReference, String, String)"})
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ExternalIdentifierService externalIdentifierService =
        new ExternalIdentifierService(externalIdentifierDao, changeLogService);

    // Act
    int actualCreateResult =
        externalIdentifierService.create(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierService#create(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(EntityReference, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.create(EntityReference, String, String)"})
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    int actualCreateResult =
        externalIdentifierService.create(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCreateResult);
  }

  /**
   * Test {@link ExternalIdentifierService#create(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ExternalIdentifierDao} {@link
   *       ExternalIdentifierDao#create(ExternalIdentifier)} return minus five.
   *   <li>Then return minus five.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(EntityReference, String, String); given ExternalIdentifierDao create(ExternalIdentifier) return minus five; then return minus five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdentifierService.create(EntityReference, String, String)"})
  void testCreate_givenExternalIdentifierDaoCreateReturnMinusFive_thenReturnMinusFive() {
    // Arrange
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(-5);

    // Act
    int actualCreateResult =
        externalIdentifierService.create(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "janedoe");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(-5, actualCreateResult);
  }
}
