package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.schema.tables.records.DataTypeRecord;
import org.finos.waltz.service.data_type.DataTypeService;
import org.jooq.DSLContext;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep4;
import org.jooq.InsertValuesStep6;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class DataTypeHelperDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeHelper#createDataType(Long, String, String)}
   */
  @Test
  void testCreateDataType() throws DataAccessException {
    // Arrange
    DataTypeHelper dataTypeHelper = new DataTypeHelper();
    ReflectionTestUtils.setField(dataTypeHelper, "svc", mock(DataTypeService.class));
    InsertValuesStep4<DataTypeRecord, Object, Object, Object, Object> insertValuesStep4 = mock(InsertValuesStep4.class);
    when(insertValuesStep4.execute()).thenReturn(1);
    InsertValuesStep4<DataTypeRecord, Object, Object, Object, Object> insertValuesStep42 = mock(
        InsertValuesStep4.class);
    when(insertValuesStep42.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any())).thenReturn(insertValuesStep4);
    InsertSetStep<DataTypeRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any())).thenReturn(insertValuesStep42);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.insertInto(Mockito.<Table<DataTypeRecord>>any())).thenReturn(insertSetStep);
    ReflectionTestUtils.setField(dataTypeHelper, "dsl", dslContext);

    // Act
    dataTypeHelper.createDataType(1L, "Name", "Code");

    // Assert
    verify(dslContext).insertInto(isA(Table.class));
    verify(insertSetStep).columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class));
    verify(insertValuesStep42).values(isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class));
    verify(insertValuesStep4).execute();
  }

  /**
   * Method under test: {@link DataTypeHelper#createUnknownDatatype()}
   */
  @Test
  void testCreateUnknownDatatype() throws DataAccessException {
    // Arrange
    DataTypeHelper dataTypeHelper = new DataTypeHelper();
    ReflectionTestUtils.setField(dataTypeHelper, "svc", mock(DataTypeService.class));
    DeleteUsingStep<DataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    InsertValuesStep6<DataTypeRecord, Object, Object, Object, Object, Object, Object> insertValuesStep6 = mock(
        InsertValuesStep6.class);
    when(insertValuesStep6.execute()).thenReturn(1);
    InsertValuesStep6<DataTypeRecord, Object, Object, Object, Object, Object, Object> insertValuesStep62 = mock(
        InsertValuesStep6.class);
    when(insertValuesStep62.values(Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any(),
        Mockito.<Object>any(), Mockito.<Object>any(), Mockito.<Object>any())).thenReturn(insertValuesStep6);
    InsertSetStep<DataTypeRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.columns(Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(),
        Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any(), Mockito.<Field<Object>>any()))
            .thenReturn(insertValuesStep62);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.insertInto(Mockito.<Table<DataTypeRecord>>any())).thenReturn(insertSetStep);
    when(dslContext.deleteFrom(Mockito.<Table<DataTypeRecord>>any())).thenReturn(deleteUsingStep);
    ReflectionTestUtils.setField(dataTypeHelper, "dsl", dslContext);

    // Act
    long actualCreateUnknownDatatypeResult = dataTypeHelper.createUnknownDatatype();

    // Assert
    verify(dslContext).deleteFrom(isA(Table.class));
    verify(dslContext).insertInto(isA(Table.class));
    verify(insertSetStep).columns(isA(Field.class), isA(Field.class), isA(Field.class), isA(Field.class),
        isA(Field.class), isA(Field.class));
    verify(insertValuesStep62).values(isA(Object.class), isA(Object.class), isA(Object.class), isA(Object.class),
        isA(Object.class), isA(Object.class));
    verify(deleteUsingStep).execute();
    verify(insertValuesStep6).execute();
    assertEquals(1L, actualCreateUnknownDatatypeResult);
  }

  /**
   * Method under test: {@link DataTypeHelper#clearAllDataTypes()}
   */
  @Test
  void testClearAllDataTypes() throws DataAccessException {
    // Arrange
    DataTypeHelper dataTypeHelper = new DataTypeHelper();
    ReflectionTestUtils.setField(dataTypeHelper, "svc", mock(DataTypeService.class));
    DeleteUsingStep<DataTypeRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.execute()).thenReturn(1);
    DSLContext dslContext = mock(DSLContext.class);
    when(dslContext.deleteFrom(Mockito.<Table<DataTypeRecord>>any())).thenReturn(deleteUsingStep);
    ReflectionTestUtils.setField(dataTypeHelper, "dsl", dslContext);

    // Act
    dataTypeHelper.clearAllDataTypes();

    // Assert
    verify(dslContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).execute();
  }
}
