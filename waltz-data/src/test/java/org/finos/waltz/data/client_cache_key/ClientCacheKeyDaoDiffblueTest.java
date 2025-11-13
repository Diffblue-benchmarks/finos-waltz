package org.finos.waltz.data.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.client_cache_key.ClientCacheKey;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertValuesStep3;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientCacheKeyDaoDiffblueTest {
  /**
   * Test {@link ClientCacheKeyDao#findAll()}.
   *
   * <p>Method under test: {@link ClientCacheKeyDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClientCacheKeyDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<ClientCacheKey> actualFindAllResult = new ClientCacheKeyDao(dsl).findAll();

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link ClientCacheKeyDao#getByKey(String)}.
   *
   * <p>Method under test: {@link ClientCacheKeyDao#getByKey(String)}
   */
  @Test
  @DisplayName("Test getByKey(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClientCacheKey ClientCacheKeyDao.getByKey(String)"})
  void testGetByKey() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            ImmutableClientCacheKey.builder()
                .guid("1234")
                .key("Key")
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .build());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    ClientCacheKey actualByKey = new ClientCacheKeyDao(dsl).getByKey("Key");

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualByKey instanceof ImmutableClientCacheKey);
    assertEquals("1234", actualByKey.guid());
    assertEquals("Key", actualByKey.key());
  }

  /**
   * Test {@link ClientCacheKeyDao#createOrUpdate(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClientCacheKeyDao#createOrUpdate(String, String)}
   */
  @Test
  @DisplayName("Test createOrUpdate(String, String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClientCacheKeyDao.createOrUpdate(String, String)"})
  void testCreateOrUpdate_thenReturnFalse() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(0);

    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep2 =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);

    InsertOnDuplicateSetStep<Record> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep2);

    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep3 =
        mock(InsertValuesStep3.class);
    when(insertValuesStep3.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep32 =
        mock(InsertValuesStep3.class);
    when(insertValuesStep32.values(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(insertValuesStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = new ClientCacheKeyDao(dsl).createOrUpdate("Key", "1234");

    // Assert
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    verify(dsl).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    assertFalse(actualCreateOrUpdateResult);
  }

  /**
   * Test {@link ClientCacheKeyDao#createOrUpdate(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClientCacheKeyDao#createOrUpdate(String, String)}
   */
  @Test
  @DisplayName("Test createOrUpdate(String, String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClientCacheKeyDao.createOrUpdate(String, String)"})
  void testCreateOrUpdate_thenReturnTrue() throws DataAccessException {
    // Arrange
    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep.execute()).thenReturn(1);

    InsertOnDuplicateSetMoreStep<Record> insertOnDuplicateSetMoreStep2 =
        mock(InsertOnDuplicateSetMoreStep.class);
    when(insertOnDuplicateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep);

    InsertOnDuplicateSetStep<Record> insertOnDuplicateSetStep =
        mock(InsertOnDuplicateSetStep.class);
    when(insertOnDuplicateSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertOnDuplicateSetMoreStep2);

    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep3 =
        mock(InsertValuesStep3.class);
    when(insertValuesStep3.onDuplicateKeyUpdate()).thenReturn(insertOnDuplicateSetStep);

    InsertValuesStep3<Record, Object, Object, Object> insertValuesStep32 =
        mock(InsertValuesStep3.class);
    when(insertValuesStep32.values(
            Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(insertValuesStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = new ClientCacheKeyDao(dsl).createOrUpdate("Key", "1234");

    // Assert
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    verify(dsl).insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    assertTrue(actualCreateOrUpdateResult);
  }
}
