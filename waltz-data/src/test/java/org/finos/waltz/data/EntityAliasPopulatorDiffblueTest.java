package org.finos.waltz.data;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOrderByStep;
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
class EntityAliasPopulatorDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private EntityAliasPopulator entityAliasPopulator;

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap() {
    // Arrange
    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap3() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.PERSON, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap4() {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record2<Object, Object>>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.PERSON, new HashSet<>()));
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), isA(SelectField.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap5() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record2<Object, Object>> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record2<Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.PERSON, new HashSet<>()));
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), isA(SelectField.class));
    verify(selectOrderByStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep, atLeast(1)).union(Mockito.<Select<Record2<Object, Object>>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); given DSLContext select(SelectField, SelectField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_givenDSLContextSelectThrowIllegalArgumentException() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectField, SelectField)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); given DSLContext select(SelectField, SelectField) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_givenDSLContextSelectThrowIllegalArgumentException2() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.PERSON, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchSet(RecordMapper)}
   *       return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); given SelectConditionStep fetchSet(RecordMapper) return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_givenSelectConditionStepFetchSetReturnHashSet()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, Long> actualFetchEntityIdLookupMapResult =
        entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.APPLICATION, new HashSet<>());

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchEntityIdLookupMapResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); given SelectJoinStep where(Condition) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_givenSelectJoinStepWhereThrowIllegalArgumentException() {
    // Arrange
    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@link SelectOrderByStep} {@link SelectOrderByStep#fetchSet(RecordMapper)} return
   *       {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); given SelectOrderByStep fetchSet(RecordMapper) return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_givenSelectOrderByStepFetchSetReturnHashSet()
      throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record2<Object, Object>> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record2<Object, Object>>>any()))
        .thenReturn(selectOrderByStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, Long> actualFetchEntityIdLookupMapResult =
        entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.PERSON, new HashSet<>());

    // Assert
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), isA(SelectField.class));
    verify(selectOrderByStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2, atLeast(1)).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectConditionStep, atLeast(1)).union(Mockito.<Select<Record2<Object, Object>>>any());
    verify(selectJoinStep, atLeast(1)).where(Mockito.<Condition>any());
    assertTrue(actualFetchEntityIdLookupMapResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityIdLookupMap(EntityKind, Set); when 'ALL'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_whenAll_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.ALL, new HashSet<>()));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_whenChangeInitiative() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityIdLookupMap(
                EntityKind.CHANGE_INITIATIVE, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set); when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_whenChangeInitiative2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, Long> actualFetchEntityIdLookupMapResult =
        entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.CHANGE_INITIATIVE, new HashSet<>());

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchEntityIdLookupMapResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code LEGAL_ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set); when 'LEGAL_ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_whenLegalEntity() {
    // Arrange
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.LEGAL_ENTITY, new HashSet<>()));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code LEGAL_ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityIdLookupMap(EntityKind, Set)}
   */
  @Test
  @DisplayName("Test fetchEntityIdLookupMap(EntityKind, Set); when 'LEGAL_ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityIdLookupMap(EntityKind, Set)"})
  void testFetchEntityIdLookupMap_whenLegalEntity2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, Long> actualFetchEntityIdLookupMapResult =
        entityAliasPopulator.fetchEntityIdLookupMap(EntityKind.LEGAL_ENTITY, new HashSet<>());

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchEntityIdLookupMapResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap() {
    // Arrange
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityReferenceLookupMap(
                EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap2() {
    // Arrange
    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new IllegalArgumentException());
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityReferenceLookupMap(
                EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap3() {
    // Arrange
    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenThrow(new IllegalArgumentException());

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityReferenceLookupMap(
                EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap4() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenThrow(new IllegalArgumentException());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            entityAliasPopulator.fetchEntityReferenceLookupMap(
                EntityKind.APPLICATION, new HashSet<>()));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap5() {
    // Arrange
    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("Cannot find lookup map for entity reference for entity kind: %s");
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, identifiers));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Given {@code entityKind cannot be null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityReferenceLookupMap(EntityKind, Set); given 'entityKind cannot be null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap_givenEntityKindCannotBeNull() {
    // Arrange
    HashSet<String> identifiers = new HashSet<>();
    identifiers.add("entityKind cannot be null");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, identifiers));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName("Test fetchEntityReferenceLookupMap(EntityKind, Set); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, EntityReference> actualFetchEntityReferenceLookupMapResult =
        entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.APPLICATION, new HashSet<>());

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchEntityReferenceLookupMapResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code ALL}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityReferenceLookupMap(EntityKind, Set); when 'ALL'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap_whenAll_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> entityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind.ALL, new HashSet<>()));
  }

  /**
   * Test {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind, Set)}.
   *
   * <ul>
   *   <li>When {@code LEGAL_ENTITY}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasPopulator#fetchEntityReferenceLookupMap(EntityKind,
   * Set)}
   */
  @Test
  @DisplayName(
      "Test fetchEntityReferenceLookupMap(EntityKind, Set); when 'LEGAL_ENTITY'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityAliasPopulator.fetchEntityReferenceLookupMap(EntityKind, Set)"})
  void testFetchEntityReferenceLookupMap_whenLegalEntity_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Map<String, EntityReference> actualFetchEntityReferenceLookupMapResult =
        entityAliasPopulator.fetchEntityReferenceLookupMap(
            EntityKind.LEGAL_ENTITY, new HashSet<>());

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFetchEntityReferenceLookupMapResult.isEmpty());
  }
}
