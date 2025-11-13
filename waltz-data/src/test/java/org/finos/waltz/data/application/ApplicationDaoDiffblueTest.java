package org.finos.waltz.data.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.application.AppRegistrationRequest;
import org.finos.waltz.model.application.AppRegistrationResponse;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableAppRegistrationRequest;
import org.finos.waltz.model.application.ImmutableAppRegistrationResponse;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.ImmutableApplication.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.ApplicationRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.GroupField;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TableRecord;
import org.jooq.exception.DataAccessException;
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
class ApplicationDaoDiffblueTest {
  @InjectMocks private ApplicationDao applicationDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link ApplicationDao#getById(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationDao.getById(long)"})
  void testGetById() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> new ApplicationDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#getById(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationDao.getById(long)"})
  void testGetById2() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> new ApplicationDao(dsl).getById(1L));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#getById(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationDao.getById(long)"})
  void testGetById3() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#getById(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationDao.getById(long)"})
  void testGetById4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.getById(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableApplication}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableApplication")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Application ApplicationDao.getById(long)"})
  void testGetById_thenReturnImmutableApplication() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

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
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Application actualById = new ApplicationDao(dsl).getById(1L);

    // Assert
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualById instanceof ImmutableApplication);
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.organisationalUnitId().longValue());
    assertEquals(Criticality.LOW, actualById.businessCriticality());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(ApplicationKind.IN_HOUSE, actualById.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualById.lifecyclePhase());
    assertEquals(RagRating.R, actualById.overallRating());
    assertFalse(actualById.isRemoved());
  }

  /**
   * Test {@link ApplicationDao#findAll()}.
   *
   * <p>Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findAll()"})
  void testFindAll() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#findAll()}.
   *
   * <p>Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findAll()"})
  void testFindAll2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findAll()}.
   *
   * <p>Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findAll()"})
  void testFindAll3() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findAll());
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetch(RecordMapper)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SelectJoinStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findAll()"})
  void testFindAll_givenSelectJoinStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Application> actualFindAllResult = applicationDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findByIds(new ArrayList<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findByIds(new ArrayList<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findByIds(new ArrayList<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findByIds(new ArrayList<>()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName("Test findByIds(Collection); given one; when ArrayList() add one; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds_givenOne_whenArrayListAddOne_thenReturnEmpty() throws DataAccessException {
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
    List<Application> actualFindByIdsResult = applicationDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByIds(Collection); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
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

    // Act
    List<Application> actualFindByIdsResult = applicationDao.findByIds(new ArrayList<>());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#findByIds(Collection)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findByIds(Collection)}
   */
  @Test
  @DisplayName(
      "Test findByIds(Collection); given zero; when ArrayList() add zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByIds(Collection)"})
  void testFindByIds_givenZero_whenArrayListAddZero_thenReturnEmpty() throws DataAccessException {
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
    List<Application> actualFindByIdsResult = applicationDao.findByIds(ids);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#countByOrganisationalUnit()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#countByOrganisationalUnit()}
   */
  @Test
  @DisplayName("Test countByOrganisationalUnit(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.countByOrganisationalUnit()"})
  void testCountByOrganisationalUnit_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<Long>> actualCountByOrganisationalUnitResult =
        applicationDao.countByOrganisationalUnit();

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualCountByOrganisationalUnitResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId4() {
    // Arrange
    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.or(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId6() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.or(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnConditionStep).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId7() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.or(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).or(isA(Condition.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnConditionStep).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId8() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).or(isA(Condition.class));
    verify(selectOnConditionStep3).or(isA(Condition.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId9() {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).or(isA(Condition.class));
    verify(selectOnConditionStep3).or(isA(Condition.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId10() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.findRelatedByApplicationId(1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).or(isA(Condition.class));
    verify(selectOnConditionStep3).or(isA(Condition.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findRelatedByApplicationId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findRelatedByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findRelatedByApplicationId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findRelatedByApplicationId(long)"})
  void testFindRelatedByApplicationId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.or(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Application> actualFindRelatedByApplicationIdResult =
        applicationDao.findRelatedByApplicationId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).or(isA(Condition.class));
    verify(selectOnConditionStep3).or(isA(Condition.class));
    verify(selectOnConditionStep2).or(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindRelatedByApplicationIdResult.isEmpty());
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenThrow(new DataAccessException("An error occurred"));
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ApplicationDao applicationDao = new ApplicationDao(dsl);
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult = applicationDao.registerApp(request);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertFalse(actualRegisterAppResult.registered());
    assertSame(request, actualRegisterAppResult.originalRequest());
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp2() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataAccessException.class,
        () ->
            applicationDao.registerApp(
                ImmutableAppRegistrationRequest.builder()
                    .applicationKind(ApplicationKind.IN_HOUSE)
                    .assetCode("Asset Code")
                    .businessCriticality(Criticality.LOW)
                    .description("The characteristics of someone or something")
                    .lifecyclePhase(LifecyclePhase.PRODUCTION)
                    .name("Name")
                    .organisationalUnitId(1L)
                    .overallRating(RagRating.R)
                    .parentAssetCode("Parent Asset Code")
                    .provenance("Provenance")
                    .build()));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp3() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.description()).thenThrow(new DataAccessException("An error occurred"));
    when(request.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.registerApp(request));
    verify(request).description();
    verify(request, atLeast(1)).name();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp4() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.lifecyclePhase()).thenThrow(new DataAccessException("An error occurred"));
    when(request.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("42");
    when(request.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(request.parentAssetCode()).thenReturn(ofResult2);
    when(request.organisationalUnitId()).thenReturn(1L);
    when(request.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(request.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.registerApp(request));
    verify(request).description();
    verify(request, atLeast(1)).name();
    verify(request).applicationKind();
    verify(request).assetCode();
    verify(request).lifecyclePhase();
    verify(request).organisationalUnitId();
    verify(request).parentAssetCode();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp5() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.overallRating()).thenThrow(new DataAccessException("An error occurred"));
    when(request.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(request.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("42");
    when(request.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(request.parentAssetCode()).thenReturn(ofResult2);
    when(request.organisationalUnitId()).thenReturn(1L);
    when(request.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(request.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.registerApp(request));
    verify(request).description();
    verify(request, atLeast(1)).name();
    verify(request).applicationKind();
    verify(request).assetCode();
    verify(request).lifecyclePhase();
    verify(request).organisationalUnitId();
    verify(request).overallRating();
    verify(request).parentAssetCode();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp6() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    AppRegistrationRequest request = mock(AppRegistrationRequest.class);
    when(request.businessCriticality()).thenThrow(new DataAccessException("An error occurred"));
    when(request.overallRating()).thenReturn(RagRating.R);
    when(request.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(request.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("42");
    when(request.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(request.parentAssetCode()).thenReturn(ofResult2);
    when(request.organisationalUnitId()).thenReturn(1L);
    when(request.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(request.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.registerApp(request));
    verify(request).description();
    verify(request, atLeast(1)).name();
    verify(request).applicationKind();
    verify(request).assetCode();
    verify(request).businessCriticality();
    verify(request).lifecyclePhase();
    verify(request).organisationalUnitId();
    verify(request).overallRating();
    verify(request).parentAssetCode();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then return not registered.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName(
      "Test registerApp(AppRegistrationRequest); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then return not registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp_givenDefaultDSLContextWithDialectIsSql99_thenReturnNotRegistered() {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(SQLDialect.SQL99));
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult = applicationDao.registerApp(request);

    // Assert
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertFalse(actualRegisterAppResult.registered());
    assertSame(request, actualRegisterAppResult.originalRequest());
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName(
      "Test registerApp(AppRegistrationRequest); then calls prepareStatement(String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getWarnings()).thenThrow(new DataAccessException("An error occurred"));
    doThrow(new DataAccessException("An error occurred"))
        .when(preparedStatement)
        .setString(anyInt(), Mockito.<String>any());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ApplicationDao applicationDao = new ApplicationDao(dsl);
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult = applicationDao.registerApp(request);

    // Assert
    verify(connection)
        .prepareStatement(
            eq(
                "insert into \"application\" (\"name\", \"description\", \"asset_code\", \"updated_at\", \"organisational_unit_id\", \"kind\", \"lifecycle_phase\", \"parent_asset_code\", \"overall_rating\", \"provenance\", \"business_criticality\") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
            isA(String[].class));
    verify(preparedStatement).setString(1, "Name");
    verify(preparedStatement).getWarnings();
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertFalse(actualRegisterAppResult.registered());
    assertSame(request, actualRegisterAppResult.originalRequest());
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then return not registered.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest); then return not registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp_thenReturnNotRegistered() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult = applicationDao.registerApp(request);

    // Assert
    verify(dSLContext).newRecord(isA(Table.class));
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertFalse(actualRegisterAppResult.registered());
    assertSame(request, actualRegisterAppResult.originalRequest());
  }

  /**
   * Test {@link ApplicationDao#registerApp(AppRegistrationRequest)}.
   *
   * <ul>
   *   <li>Then return registered.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#registerApp(AppRegistrationRequest)}
   */
  @Test
  @DisplayName("Test registerApp(AppRegistrationRequest); then return registered")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AppRegistrationResponse ApplicationDao.registerApp(AppRegistrationRequest)"})
  void testRegisterApp_thenReturnRegistered() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.executeUpdate()).thenReturn(1);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    ApplicationDao applicationDao = new ApplicationDao(dsl);
    ImmutableAppRegistrationRequest request =
        ImmutableAppRegistrationRequest.builder()
            .applicationKind(ApplicationKind.IN_HOUSE)
            .assetCode("Asset Code")
            .businessCriticality(Criticality.LOW)
            .description("The characteristics of someone or something")
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R)
            .parentAssetCode("Parent Asset Code")
            .provenance("Provenance")
            .build();

    // Act
    AppRegistrationResponse actualRegisterAppResult = applicationDao.registerApp(request);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement).execute();
    verify(preparedStatement).executeUpdate();
    verify(preparedStatement).setLong(5, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    assertTrue(actualRegisterAppResult instanceof ImmutableAppRegistrationResponse);
    assertTrue(actualRegisterAppResult.registered());
    assertSame(request, actualRegisterAppResult.originalRequest());
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate() {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(SQLDialect.SQL99));

    Application application = mock(Application.class);
    when(application.name()).thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(application));
    verify(application).name();
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate2() {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(SQLDialect.SQL99));

    Application application = mock(Application.class);
    when(application.applicationKind()).thenThrow(new DataAccessException("An error occurred"));
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).lifecyclePhase();
    verify(application).parentAssetCode();
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate3() {
    // Arrange
    ApplicationDao applicationDao = new ApplicationDao(new DefaultDSLContext(SQLDialect.SQL99));

    Application application = mock(Application.class);
    when(application.overallRating()).thenThrow(new DataAccessException("An error occurred"));
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate4() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(mock(Application.class)));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate5() {
    // Arrange
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    Application application = mock(Application.class);
    when(application.description()).thenThrow(new DataAccessException("An error occurred"));
    when(application.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).name();
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate6() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<TableRecord<?>>any(), Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(application.id()).thenReturn(ofResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult2);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult3);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(application.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataAccessException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    verify(dSLContext).executeUpdate(isA(TableRecord.class), isA(Condition.class));
    verify(dSLContext).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate7() throws DataAccessException {
    // Arrange
    when(dSLContext.executeUpdate(Mockito.<TableRecord<?>>any(), Mockito.<Condition>any()))
        .thenReturn(1);
    when(dSLContext.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());

    Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.empty();

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

    // Act
    int actualUpdateResult =
        applicationDao.update(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).executeUpdate(isA(TableRecord.class), isA(Condition.class));
    verify(dSLContext).newRecord(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationDao#ApplicationDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application); given ApplicationDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate_givenApplicationDaoWithDslIsDSLContext() throws DataAccessException {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.executeUpdate(Mockito.<TableRecord<?>>any(), Mockito.<Condition>any())).thenReturn(1);
    when(dsl.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());
    ApplicationDao applicationDao = new ApplicationDao(dsl);

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

    // Act
    int actualUpdateResult =
        applicationDao.update(
            overallRatingResult
                .parentAssetCode(parentAssetCode)
                .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
                .provenance("Provenance")
                .build());

    // Assert
    verify(dsl).executeUpdate(isA(TableRecord.class), isA(Condition.class));
    verify(dsl).newRecord(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <ul>
   *   <li>Given {@link ApplicationRecord} {@link ApplicationRecord#setAssetCode(String)} does
   *       nothing.
   *   <li>Then calls {@link ApplicationRecord#setAssetCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName(
      "Test update(Application); given ApplicationRecord setAssetCode(String) does nothing; then calls setAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate_givenApplicationRecordSetAssetCodeDoesNothing_thenCallsSetAssetCode() {
    // Arrange
    ApplicationRecord applicationRecord = mock(ApplicationRecord.class);
    doNothing().when(applicationRecord).setAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setBusinessCriticality(Mockito.<String>any());
    doNothing().when(applicationRecord).setDescription(Mockito.<String>any());
    doNothing().when(applicationRecord).setIsRemoved(Mockito.<Boolean>any());
    doNothing().when(applicationRecord).setKind(Mockito.<String>any());
    doNothing().when(applicationRecord).setLifecyclePhase(Mockito.<String>any());
    doNothing().when(applicationRecord).setName(Mockito.<String>any());
    doNothing().when(applicationRecord).setOrganisationalUnitId(Mockito.<Long>any());
    doNothing().when(applicationRecord).setOverallRating(Mockito.<String>any());
    doNothing().when(applicationRecord).setParentAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setProvenance(Mockito.<String>any());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.executeUpdate(Mockito.<TableRecord<?>>any(), Mockito.<Condition>any())).thenReturn(1);
    when(dsl.newRecord(Mockito.<Table<ApplicationRecord>>any())).thenReturn(applicationRecord);
    ApplicationDao applicationDao = new ApplicationDao(dsl);

    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(application.id()).thenReturn(ofResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult2);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult3);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act
    int actualUpdateResult = applicationDao.update(application);

    // Assert
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    verify(applicationRecord).setAssetCode("42");
    verify(applicationRecord).setBusinessCriticality("LOW");
    verify(applicationRecord).setDescription("The characteristics of someone or something");
    verify(applicationRecord).setIsRemoved(true);
    verify(applicationRecord).setKind("IN_HOUSE");
    verify(applicationRecord).setLifecyclePhase("PRODUCTION");
    verify(applicationRecord).setName("Name");
    verify(applicationRecord).setOrganisationalUnitId(1L);
    verify(applicationRecord).setOverallRating("R");
    verify(applicationRecord).setParentAssetCode("42");
    verify(applicationRecord).setProvenance("Provenance");
    verify(dsl).executeUpdate(isA(TableRecord.class), isA(Condition.class));
    verify(dsl).newRecord(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#newRecord(Table)} return {@link
   *       ApplicationRecord#ApplicationRecord()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName(
      "Test update(Application); given DefaultDSLContext newRecord(Table) return ApplicationRecord()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate_givenDefaultDSLContextNewRecordReturnApplicationRecord() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.executeUpdate(Mockito.<TableRecord<?>>any(), Mockito.<Condition>any())).thenReturn(1);
    when(dsl.newRecord(Mockito.<Table<ApplicationRecord>>any()))
        .thenReturn(new ApplicationRecord());
    ApplicationDao applicationDao = new ApplicationDao(dsl);

    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(application.id()).thenReturn(ofResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult2);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult3);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act
    int actualUpdateResult = applicationDao.update(application);

    // Assert
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    verify(dsl).executeUpdate(isA(TableRecord.class), isA(Condition.class));
    verify(dsl).newRecord(isA(Table.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName("Test update(Application); given empty; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate_givenEmpty_thenThrowIllegalArgumentException() {
    // Arrange
    ApplicationRecord applicationRecord = mock(ApplicationRecord.class);
    doNothing().when(applicationRecord).setAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setBusinessCriticality(Mockito.<String>any());
    doNothing().when(applicationRecord).setDescription(Mockito.<String>any());
    doNothing().when(applicationRecord).setIsRemoved(Mockito.<Boolean>any());
    doNothing().when(applicationRecord).setKind(Mockito.<String>any());
    doNothing().when(applicationRecord).setLifecyclePhase(Mockito.<String>any());
    doNothing().when(applicationRecord).setName(Mockito.<String>any());
    doNothing().when(applicationRecord).setOrganisationalUnitId(Mockito.<Long>any());
    doNothing().when(applicationRecord).setOverallRating(Mockito.<String>any());
    doNothing().when(applicationRecord).setParentAssetCode(Mockito.<String>any());
    doNothing().when(applicationRecord).setProvenance(Mockito.<String>any());

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.newRecord(Mockito.<Table<ApplicationRecord>>any())).thenReturn(applicationRecord);
    ApplicationDao applicationDao = new ApplicationDao(dsl);

    Application application = mock(Application.class);
    Optional<Long> emptyResult = Optional.empty();
    when(application.id()).thenReturn(emptyResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult);
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult2);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> applicationDao.update(application));
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    verify(applicationRecord).setAssetCode("42");
    verify(applicationRecord).setBusinessCriticality("LOW");
    verify(applicationRecord).setDescription("The characteristics of someone or something");
    verify(applicationRecord).setIsRemoved(true);
    verify(applicationRecord).setKind("IN_HOUSE");
    verify(applicationRecord).setLifecyclePhase("PRODUCTION");
    verify(applicationRecord).setName("Name");
    verify(applicationRecord).setOrganisationalUnitId(1L);
    verify(applicationRecord).setOverallRating("R");
    verify(applicationRecord).setParentAssetCode("42");
    verify(applicationRecord).setProvenance("Provenance");
    verify(dsl).newRecord(isA(Table.class));
  }

  /**
   * Test {@link ApplicationDao#update(Application)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#update(Application)}
   */
  @Test
  @DisplayName(
      "Test update(Application); given PreparedStatement execute() return 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ApplicationDao.update(Application)"})
  void testUpdate_givenPreparedStatementExecuteReturnTrue_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ApplicationDao applicationDao = new ApplicationDao(dsl);

    Application application = mock(Application.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(application.id()).thenReturn(ofResult);
    when(application.isRemoved()).thenReturn(true);
    when(application.provenance()).thenReturn("Provenance");
    when(application.businessCriticality()).thenReturn(Criticality.LOW);
    when(application.overallRating()).thenReturn(RagRating.R);
    when(application.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(application.organisationalUnitId()).thenReturn(1L);
    when(application.description()).thenReturn("The characteristics of someone or something");
    when(application.name()).thenReturn("Name");
    Optional<ExternalIdValue> ofResult2 = Optional.of(ExternalIdValue.of("42"));
    when(application.assetCode()).thenReturn(ofResult2);
    Optional<ExternalIdValue> ofResult3 = Optional.of(ExternalIdValue.of("42"));
    when(application.parentAssetCode()).thenReturn(ofResult3);
    when(application.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);

    // Act
    int actualUpdateResult = applicationDao.update(application);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"application\" set \"application\".\"name\" = ?, \"application\".\"description\" = ?, \"application\".\"asset_code\" = ?, \"application\".\"organisational_unit_id\" = ?, \"application\".\"kind\" = ?, \"application\".\"lifecycle_phase\" = ?, \"application\".\"parent_asset_code\" = ?, \"application\".\"overall_rating\" = ?, \"application\".\"provenance\" = ?, \"application\".\"business_criticality\" = ?, \"application\".\"is_removed\" = ? where \"application\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(11, true);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(application).description();
    verify(application).id();
    verify(application).isRemoved();
    verify(application).name();
    verify(application).organisationalUnitId();
    verify(application).applicationKind();
    verify(application).assetCode();
    verify(application).businessCriticality();
    verify(application).lifecyclePhase();
    verify(application).overallRating();
    verify(application).parentAssetCode();
    verify(application).provenance();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode() {
    // Arrange
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new DataAccessException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode2() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode3() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode4() {
    // Arrange
    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode5() {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test findByAssetCode(ExternalIdValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode6() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new DataAccessException("An error occurred"));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        DataAccessException.class, () -> applicationDao.findByAssetCode(ExternalIdValue.of("42")));
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
  }

  /**
   * Test {@link ApplicationDao#findByAssetCode(ExternalIdValue)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ApplicationDao#findByAssetCode(ExternalIdValue)}
   */
  @Test
  @DisplayName(
      "Test findByAssetCode(ExternalIdValue); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ApplicationDao.findByAssetCode(ExternalIdValue)"})
  void testFindByAssetCode_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Application> actualFindByAssetCodeResult =
        applicationDao.findByAssetCode(ExternalIdValue.of("42"));

    // Assert
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByAssetCodeResult.isEmpty());
  }
}
