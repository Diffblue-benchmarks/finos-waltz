package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageCharacteristicsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#builder()}
   *   <li>
   * {@link ImmutableDataTypeUsageCharacteristics#warningMessageForEditors(String)}
   *   <li>
   * {@link ImmutableDataTypeUsageCharacteristics#warningMessageForViewers(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics.Builder actualWarningMessageForEditorsResult = ImmutableDataTypeUsageCharacteristics
        .builder()
        .warningMessageForEditors("Warning Message For Editors");

    // Assert
    assertSame(actualWarningMessageForEditorsResult,
        actualWarningMessageForEditorsResult.warningMessageForViewers("Warning Message For Viewers"));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Builder#dataTypeId(long)}
   */
  @Test
  void testBuilderDataTypeId() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act
    ImmutableDataTypeUsageCharacteristics.Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    ImmutableDataTypeUsageCharacteristics buildResult = builderResult.build();
    assertNull(buildResult.warningMessageForEditors());
    assertNull(buildResult.warningMessageForViewers());
    assertEquals(1L, buildResult.dataTypeId());
    assertTrue(buildResult.isRemovable());
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    ImmutableDataTypeUsageCharacteristics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).isRemovable();
    verify(instance).warningMessageForEditors();
    verify(instance).warningMessageForViewers();
    ImmutableDataTypeUsageCharacteristics buildResult = builderResult.build();
    assertEquals("Warning Message For Editors", buildResult.warningMessageForEditors());
    assertEquals("Warning Message For Viewers", buildResult.warningMessageForViewers());
    assertEquals(1L, buildResult.dataTypeId());
    assertTrue(buildResult.isRemovable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn(null);
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    ImmutableDataTypeUsageCharacteristics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).isRemovable();
    verify(instance).warningMessageForEditors();
    verify(instance).warningMessageForViewers();
    ImmutableDataTypeUsageCharacteristics buildResult = builderResult.build();
    assertEquals("Warning Message For Viewers", buildResult.warningMessageForViewers());
    assertNull(buildResult.warningMessageForEditors());
    assertEquals(1L, buildResult.dataTypeId());
    assertTrue(buildResult.isRemovable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn(null);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    ImmutableDataTypeUsageCharacteristics.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).isRemovable();
    verify(instance).warningMessageForEditors();
    verify(instance).warningMessageForViewers();
    ImmutableDataTypeUsageCharacteristics buildResult = builderResult.build();
    assertEquals("Warning Message For Editors", buildResult.warningMessageForEditors());
    assertNull(buildResult.warningMessageForViewers());
    assertEquals(1L, buildResult.dataTypeId());
    assertTrue(buildResult.isRemovable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Builder#isRemovable(boolean)}
   */
  @Test
  void testBuilderIsRemovable() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemovable(true));
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics#copyOf(DataTypeUsageCharacteristics)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    ImmutableDataTypeUsageCharacteristics actualCopyOfResult = ImmutableDataTypeUsageCharacteristics.copyOf(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).isRemovable();
    verify(instance).warningMessageForEditors();
    verify(instance).warningMessageForViewers();
    assertEquals("Warning Message For Editors", actualCopyOfResult.warningMessageForEditors());
    assertEquals("Warning Message For Viewers", actualCopyOfResult.warningMessageForViewers());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertTrue(actualCopyOfResult.isRemovable());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics#copyOf(DataTypeUsageCharacteristics)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(false);

    // Act
    ImmutableDataTypeUsageCharacteristics actualCopyOfResult = ImmutableDataTypeUsageCharacteristics.copyOf(instance);

    // Assert
    verify(instance).dataTypeId();
    verify(instance).isRemovable();
    verify(instance).warningMessageForEditors();
    verify(instance).warningMessageForViewers();
    assertEquals("Warning Message For Editors", actualCopyOfResult.warningMessageForEditors());
    assertEquals("Warning Message For Viewers", actualCopyOfResult.warningMessageForViewers());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertFalse(actualCopyOfResult.isRemovable());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#dataTypeId()}
   */
  @Test
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeUsageCharacteristics.Json()).dataTypeId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDataTypeUsageCharacteristics.Json}
   *   <li>
   * {@link ImmutableDataTypeUsageCharacteristics.Json#setWarningMessageForEditors(String)}
   *   <li>
   * {@link ImmutableDataTypeUsageCharacteristics.Json#setWarningMessageForViewers(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics.Json actualJson = new ImmutableDataTypeUsageCharacteristics.Json();
    actualJson.setWarningMessageForEditors("Warning Message For Editors");
    actualJson.setWarningMessageForViewers("Warning Message For Viewers");

    // Assert
    assertEquals("Warning Message For Editors", actualJson.warningMessageForEditors);
    assertEquals("Warning Message For Viewers", actualJson.warningMessageForViewers);
    assertEquals(0L, actualJson.dataTypeId);
    assertFalse(actualJson.dataTypeIdIsSet);
    assertFalse(actualJson.isRemovable);
    assertFalse(actualJson.isRemovableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#isRemovable()}
   */
  @Test
  void testJsonIsRemovable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeUsageCharacteristics.Json()).isRemovable());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#setDataTypeId(long)}
   */
  @Test
  void testJsonSetDataTypeId() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Json json = new ImmutableDataTypeUsageCharacteristics.Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#setIsRemovable(boolean)}
   */
  @Test
  void testJsonSetIsRemovable() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics.Json json = new ImmutableDataTypeUsageCharacteristics.Json();

    // Act
    json.setIsRemovable(true);

    // Assert
    assertTrue(json.isRemovable);
    assertTrue(json.isRemovableIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#warningMessageForEditors()}
   */
  @Test
  void testJsonWarningMessageForEditors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeUsageCharacteristics.Json()).warningMessageForEditors());
  }

  /**
   * Method under test:
   * {@link ImmutableDataTypeUsageCharacteristics.Json#warningMessageForViewers()}
   */
  @Test
  void testJsonWarningMessageForViewers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableDataTypeUsageCharacteristics.Json()).warningMessageForViewers());
  }
}
