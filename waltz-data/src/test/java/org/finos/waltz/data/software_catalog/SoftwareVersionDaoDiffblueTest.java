package org.finos.waltz.data.software_catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareVersion;
import org.finos.waltz.model.software_catalog.ImmutableSoftwareVersion.Builder;
import org.finos.waltz.model.software_catalog.SoftwareVersion;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SoftwareVersionDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SoftwareVersionDao softwareVersionDao;

  /**
   * Test {@link SoftwareVersionDao#findBySoftwarePackageId(long)}.
   *
   * <p>Method under test: {@link SoftwareVersionDao#findBySoftwarePackageId(long)}
   */
  @Test
  @DisplayName("Test findBySoftwarePackageId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareVersionDao.findBySoftwarePackageId(long)"})
  void testFindBySoftwarePackageId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwareVersion> actualFindBySoftwarePackageIdResult =
        new SoftwareVersionDao(dsl).findBySoftwarePackageId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySoftwarePackageIdResult.isEmpty());
  }

  /**
   * Test {@link SoftwareVersionDao#getByVersionId(long)}.
   *
   * <p>Method under test: {@link SoftwareVersionDao#getByVersionId(long)}
   */
  @Test
  @DisplayName("Test getByVersionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SoftwareVersion SoftwareVersionDao.getByVersionId(long)"})
  void testGetByVersionId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder builderResult = ImmutableSoftwareVersion.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);
    LocalDate releaseDate = LocalDate.of(1970, 1, 1);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            builderResult
                .created(created)
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .releaseDate(releaseDate)
                .softwarePackageId(1L)
                .version("1.0.2")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    SoftwareVersion actualByVersionId = new SoftwareVersionDao(dsl).getByVersionId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByVersionId instanceof ImmutableSoftwareVersion);
    assertEquals("1.0.2", actualByVersionId.version());
    LocalDate releaseDateResult = actualByVersionId.releaseDate();
    assertEquals("1970-01-01", releaseDateResult.toString());
    assertEquals("Name", actualByVersionId.name());
    assertEquals("Provenance", actualByVersionId.provenance());
    assertEquals("The characteristics of someone or something", actualByVersionId.description());
    assertEquals(1L, actualByVersionId.softwarePackageId());
    assertEquals(EntityKind.ALL, actualByVersionId.kind());
    assertSame(releaseDate, releaseDateResult);
  }

  /**
   * Test {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link SoftwareVersionDao#SoftwareVersionDao(DSLContext)} with dsl is {@link
   *       DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findBySoftwarePackageIds(Collection); given SoftwareVersionDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareVersionDao.findBySoftwarePackageIds(Collection)"})
  void testFindBySoftwarePackageIds_givenSoftwareVersionDaoWithDslIsDSLContext()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    SoftwareVersionDao softwareVersionDao = new SoftwareVersionDao(dsl);

    // Act
    List<SoftwareVersion> actualFindBySoftwarePackageIdsResult =
        softwareVersionDao.findBySoftwarePackageIds(new ArrayList<>());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySoftwarePackageIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link SoftwareVersionDao}.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findBySoftwarePackageIds(Collection); given SoftwareVersionDao; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareVersionDao.findBySoftwarePackageIds(Collection)"})
  void testFindBySoftwarePackageIds_givenSoftwareVersionDao_whenArrayListAddOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    List<SoftwareVersion> actualFindBySoftwarePackageIdsResult =
        softwareVersionDao.findBySoftwarePackageIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySoftwarePackageIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link SoftwareVersionDao#findBySoftwarePackageIds(Collection)}
   */
  @Test
  @DisplayName("Test findBySoftwarePackageIds(Collection); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareVersionDao.findBySoftwarePackageIds(Collection)"})
  void testFindBySoftwarePackageIds_givenZero_whenArrayListAddZero() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act
    List<SoftwareVersion> actualFindBySoftwarePackageIdsResult =
        softwareVersionDao.findBySoftwarePackageIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySoftwarePackageIdsResult.isEmpty());
  }

  /**
   * Test {@link SoftwareVersionDao#findByLicenceId(long)}.
   *
   * <p>Method under test: {@link SoftwareVersionDao#findByLicenceId(long)}
   */
  @Test
  @DisplayName("Test findByLicenceId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SoftwareVersionDao.findByLicenceId(long)"})
  void testFindByLicenceId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<SoftwareVersion> actualFindByLicenceIdResult =
        new SoftwareVersionDao(dsl).findByLicenceId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByLicenceIdResult.isEmpty());
  }
}
