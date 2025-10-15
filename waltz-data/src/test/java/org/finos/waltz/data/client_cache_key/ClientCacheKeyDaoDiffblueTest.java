package org.finos.waltz.data.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.client_cache_key.ClientCacheKey;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertOnDuplicateSetMoreStep;
import org.jooq.InsertOnDuplicateSetStep;
import org.jooq.InsertValuesStep3;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
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
class ClientCacheKeyDaoDiffblueTest {
  @InjectMocks private ClientCacheKeyDao clientCacheKeyDao;

  @Mock private DSLContext dSLContext;

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<ClientCacheKey> actualFindAllResult = clientCacheKeyDao.findAll();

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    assertTrue(actualFindAllResult.isEmpty());
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
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = clientCacheKeyDao.createOrUpdate("Key", "1234");

    // Assert
    verify(dSLContext)
        .insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
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
    when(dSLContext.insertInto(
            Mockito.<Table<Record>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep32);

    // Act
    boolean actualCreateOrUpdateResult = clientCacheKeyDao.createOrUpdate("Key", "1234");

    // Assert
    verify(dSLContext)
        .insertInto(isA(Table.class), isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertOnDuplicateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertOnDuplicateSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertValuesStep3).onDuplicateKeyUpdate();
    verify(insertValuesStep32).values(isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertOnDuplicateSetMoreStep).execute();
    assertTrue(actualCreateOrUpdateResult);
  }
}
