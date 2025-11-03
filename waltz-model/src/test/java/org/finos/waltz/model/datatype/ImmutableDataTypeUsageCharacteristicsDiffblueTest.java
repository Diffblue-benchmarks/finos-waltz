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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.datatype.ImmutableDataTypeUsageCharacteristics.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeUsageCharacteristics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageCharacteristicsDiffblueTest {
  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#builder()}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#warningMessageForEditors(String)}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#warningMessageForViewers(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableDataTypeUsageCharacteristics Builder.build()",
      "Builder Builder.warningMessageForEditors(String)", "Builder Builder.warningMessageForViewers(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualWarningMessageForEditorsResult = ImmutableDataTypeUsageCharacteristics.builder()
        .warningMessageForEditors("Warning Message For Editors");

    // Assert
    assertSame(actualWarningMessageForEditorsResult,
        actualWarningMessageForEditorsResult.warningMessageForViewers("Warning Message For Viewers"));
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   * <p>
   * Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    ImmutableDataTypeUsageCharacteristics buildResult = builderResult.build();
    assertNull(buildResult.warningMessageForEditors());
    assertNull(buildResult.warningMessageForViewers());
    assertEquals(1L, buildResult.dataTypeId());
    assertTrue(buildResult.isRemovable());
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   * <ul>
   *   <li>Then builder build warningMessageForEditors is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics); then builder build warningMessageForEditors is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom_thenBuilderBuildWarningMessageForEditorsIsNull() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn(null);
    when(instance.warningMessageForViewers()).thenReturn("Warning Message For Viewers");
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   * <ul>
   *   <li>Then builder build warningMessageForViewers is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics); then builder build warningMessageForViewers is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom_thenBuilderBuildWarningMessageForViewersIsNull() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    DataTypeUsageCharacteristics instance = mock(DataTypeUsageCharacteristics.class);
    when(instance.warningMessageForEditors()).thenReturn("Warning Message For Editors");
    when(instance.warningMessageForViewers()).thenReturn(null);
    when(instance.dataTypeId()).thenReturn(1L);
    when(instance.isRemovable()).thenReturn(true);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#isRemovable(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRemovable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemovable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRemovable(boolean)"})
  void testBuilderIsRemovable() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRemovable(true));
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   * <p>
   * Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dataTypeId());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setWarningMessageForEditors(String)}
   *   <li>{@link Json#setWarningMessageForViewers(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setWarningMessageForEditors(String)",
      "void Json.setWarningMessageForViewers(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
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
   * Test Json {@link Json#isRemovable()}.
   * <p>
   * Method under test: {@link Json#isRemovable()}
   */
  @Test
  @DisplayName("Test Json isRemovable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRemovable()"})
  void testJsonIsRemovable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRemovable());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   * <p>
   * Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDataTypeId(long)"})
  void testJsonSetDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#setIsRemovable(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsRemovable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemovable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setIsRemovable(boolean)"})
  void testJsonSetIsRemovable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRemovable(true);

    // Assert
    assertTrue(json.isRemovable);
    assertTrue(json.isRemovableIsSet);
  }

  /**
   * Test Json {@link Json#warningMessageForEditors()}.
   * <p>
   * Method under test: {@link Json#warningMessageForEditors()}
   */
  @Test
  @DisplayName("Test Json warningMessageForEditors()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.warningMessageForEditors()"})
  void testJsonWarningMessageForEditors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).warningMessageForEditors());
  }

  /**
   * Test Json {@link Json#warningMessageForViewers()}.
   * <p>
   * Method under test: {@link Json#warningMessageForViewers()}
   */
  @Test
  @DisplayName("Test Json warningMessageForViewers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.warningMessageForViewers()"})
  void testJsonWarningMessageForViewers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).warningMessageForViewers());
  }
}
