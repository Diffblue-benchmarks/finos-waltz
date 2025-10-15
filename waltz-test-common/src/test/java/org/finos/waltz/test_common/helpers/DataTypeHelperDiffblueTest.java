package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.schema.tables.records.DataTypeRecord;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep4;
import org.jooq.InsertValuesStep6;
import org.jooq.Table;
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
class DataTypeHelperDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private DataTypeHelper dataTypeHelper;

  /**
   * Test {@link DataTypeHelper#createDataType(Long, String, String)} with {@code id}, {@code name},
   * {@code code}.
   *
   * <p>Method under test: {@link DataTypeHelper#createDataType(Long, String, String)}
   */
  @Test
  @DisplayName("Test createDataType(Long, String, String) with 'id', 'name', 'code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeHelper.createDataType(Long, String, String)"})
  void testCreateDataTypeWithIdNameCode() throws DataAccessException {
    // Arrange
    InsertValuesStep4<DataTypeRecord, Object, Object, Object, Object> insertValuesStep4 =
        mock(InsertValuesStep4.class);
    when(insertValuesStep4.execute()).thenReturn(1);

    InsertValuesStep4<DataTypeRecord, Object, Object, Object, Object> insertValuesStep42 =
        mock(InsertValuesStep4.class);
    when(insertValuesStep42.values(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any()))
        .thenReturn(insertValuesStep4);

    InsertSetStep<DataTypeRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep42);
    when(dSLContext.insertInto(Mockito.<Table<DataTypeRecord>>any())).thenReturn(insertSetStep);

    // Act
    dataTypeHelper.createDataType(1L, "Name", "Code");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertValuesStep42)
        .values(isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertValuesStep4).execute();
  }

  /**
   * Test {@link DataTypeHelper#createUnknownDatatype()}.
   *
   * <p>Method under test: {@link DataTypeHelper#createUnknownDatatype()}
   */
  @Test
  @DisplayName("Test createUnknownDatatype()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long DataTypeHelper.createUnknownDatatype()"})
  void testCreateUnknownDatatype() throws DataAccessException {
    // Arrange
    DeleteUsingStep<DataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);

    InsertValuesStep6<DataTypeRecord, Object, Object, Object, Object, Object, Object>
        insertValuesStep6 = mock(InsertValuesStep6.class);
    when(insertValuesStep6.execute()).thenReturn(1);

    InsertValuesStep6<DataTypeRecord, Object, Object, Object, Object, Object, Object>
        insertValuesStep62 = mock(InsertValuesStep6.class);
    when(insertValuesStep62.values(
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any(),
            Mockito.<Object>any()))
        .thenReturn(insertValuesStep6);

    InsertSetStep<DataTypeRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any(),
            Mockito.<Field<Object>>any()))
        .thenReturn(insertValuesStep62);
    when(dSLContext.insertInto(Mockito.<Table<DataTypeRecord>>any())).thenReturn(insertSetStep);
    when(dSLContext.deleteFrom(Mockito.<Table<DataTypeRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    long actualCreateUnknownDatatypeResult = dataTypeHelper.createUnknownDatatype();

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetStep)
        .columns(
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class),
            isA(Field.class));
    verify(insertValuesStep62)
        .values(
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class),
            isA(Object.class));
    verify(deleteUsingStep).execute();
    verify(insertValuesStep6).execute();
    assertEquals(1L, actualCreateUnknownDatatypeResult);
  }

  /**
   * Test {@link DataTypeHelper#clearAllDataTypes()}.
   *
   * <p>Method under test: {@link DataTypeHelper#clearAllDataTypes()}
   */
  @Test
  @DisplayName("Test clearAllDataTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataTypeHelper.clearAllDataTypes()"})
  void testClearAllDataTypes() throws DataAccessException {
    // Arrange
    DeleteUsingStep<DataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    when(dSLContext.deleteFrom(Mockito.<Table<DataTypeRecord>>any())).thenReturn(deleteUsingStep);

    // Act
    dataTypeHelper.clearAllDataTypes();

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).execute();
  }
}
