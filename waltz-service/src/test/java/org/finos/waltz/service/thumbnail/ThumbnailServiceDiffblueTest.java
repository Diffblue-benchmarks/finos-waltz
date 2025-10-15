package org.finos.waltz.service.thumbnail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.thumbnail.ThumbnailDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail;
import org.finos.waltz.model.thumbnail.ImmutableThumbnail.Builder;
import org.finos.waltz.model.thumbnail.ImmutableThumbnailSaveCommand;
import org.finos.waltz.model.thumbnail.Thumbnail;
import org.finos.waltz.model.thumbnail.ThumbnailSaveCommand;
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
class ThumbnailServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private ThumbnailDao thumbnailDao;

  @InjectMocks private ThumbnailService thumbnailService;

  /**
   * Test {@link ThumbnailService#getByReference(EntityReference)}.
   *
   * <p>Method under test: {@link ThumbnailService#getByReference(EntityReference)}
   */
  @Test
  @DisplayName("Test getByReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Thumbnail ThumbnailService.getByReference(EntityReference)"})
  void testGetByReference() throws UnsupportedEncodingException {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any()))
        .thenReturn(
            mimeTypeResult
                .parentEntityReference(
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

    // Act
    Thumbnail actualByReference = thumbnailService.getByReference(null);

    // Assert
    verify(thumbnailDao).getByReference(isNull());
    EntityReference parentEntityReferenceResult = actualByReference.parentEntityReference();
    assertTrue(parentEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualByReference instanceof ImmutableThumbnail);
    LocalDateTime lastUpdatedAtResult = actualByReference.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualByReference.lastUpdatedBy());
    assertEquals("Provenance", actualByReference.provenance());
    assertEquals(
        "The characteristics of someone or something", parentEntityReferenceResult.description());
    assertEquals("text/plain", actualByReference.mimeType());
    assertEquals(1L, parentEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, parentEntityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentEntityReferenceResult.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ThumbnailService#save(ThumbnailSaveCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailService#save(ThumbnailSaveCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(ThumbnailSaveCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailService.save(ThumbnailSaveCommand, String)"})
  void testSave_givenChangeLogDaoWriteReturn19088743_thenCallsWrite()
      throws UnsupportedEncodingException {
    // Arrange
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

    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.create(Mockito.<Thumbnail>any())).thenReturn(1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any()))
        .thenReturn(
            mimeTypeResult
                .parentEntityReference(
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

    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);

    ImmutableThumbnailSaveCommand.Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    thumbnailService.save(
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(thumbnailDao).create(isA(Thumbnail.class));
    verify(thumbnailDao).getByReference(isA(EntityReference.class));
  }

  /**
   * Test {@link ThumbnailService#save(ThumbnailSaveCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailService#save(ThumbnailSaveCommand, String)}
   */
  @Test
  @DisplayName(
      "Test save(ThumbnailSaveCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThumbnailService.save(ThumbnailSaveCommand, String)"})
  void testSave_givenChangeLogServiceWriteReturn19088743_thenCallsWrite()
      throws UnsupportedEncodingException {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(thumbnailDao.create(Mockito.<Thumbnail>any())).thenReturn(1);

    Builder mimeTypeResult =
        ImmutableThumbnail.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .externalId("42")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any()))
        .thenReturn(
            mimeTypeResult
                .parentEntityReference(
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

    ImmutableThumbnailSaveCommand.Builder mimeTypeResult2 =
        ImmutableThumbnailSaveCommand.builder()
            .blob("AXAXAXAX".getBytes("UTF-8"))
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .mimeType("text/plain");

    // Act
    thumbnailService.save(
        mimeTypeResult2
            .parentEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "janedoe");

    // Assert
    verify(thumbnailDao).create(isA(Thumbnail.class));
    verify(thumbnailDao).getByReference(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link ThumbnailService#deleteByReference(EntityReference, String)}.
   *
   * <p>Method under test: {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  @DisplayName("Test deleteByReference(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailService.deleteByReference(EntityReference, String)"})
  void testDeleteByReference() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);

    // Act
    boolean actualDeleteByReferenceResult =
        thumbnailService.deleteByReference(
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
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByReferenceResult);
  }

  /**
   * Test {@link ThumbnailService#deleteByReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test deleteByReference(EntityReference, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailService.deleteByReference(EntityReference, String)"})
  void testDeleteByReference_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
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

    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);

    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);

    // Act
    boolean actualDeleteByReferenceResult =
        thumbnailService.deleteByReference(
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
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    assertTrue(actualDeleteByReferenceResult);
  }

  /**
   * Test {@link ThumbnailService#deleteByReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test deleteByReference(EntityReference, String); given ChangeLogService write(ChangeLog) return '19088743'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailService.deleteByReference(EntityReference, String)"})
  void testDeleteByReference_givenChangeLogServiceWriteReturn19088743_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);

    // Act
    boolean actualDeleteByReferenceResult =
        thumbnailService.deleteByReference(
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
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByReferenceResult);
  }

  /**
   * Test {@link ThumbnailService#deleteByReference(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  @DisplayName("Test deleteByReference(EntityReference, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ThumbnailService.deleteByReference(EntityReference, String)"})
  void testDeleteByReference_thenReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(15);

    // Act
    boolean actualDeleteByReferenceResult =
        thumbnailService.deleteByReference(
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
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteByReferenceResult);
  }
}
