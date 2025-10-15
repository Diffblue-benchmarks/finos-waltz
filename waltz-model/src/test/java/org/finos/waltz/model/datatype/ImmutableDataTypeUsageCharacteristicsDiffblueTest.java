package org.finos.waltz.model.datatype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.datatype.ImmutableDataTypeUsageCharacteristics.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeUsageCharacteristics.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeUsageCharacteristicsDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#warningMessageForEditors(String)}
   *   <li>{@link Builder#warningMessageForViewers(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics Builder.build()",
    "Builder Builder.warningMessageForEditors(String)",
    "Builder Builder.warningMessageForViewers(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics actualImmutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Assert
    assertEquals(
        "Warning Message For Editors",
        actualImmutableDataTypeUsageCharacteristics.warningMessageForEditors());
    assertEquals(
        "Warning Message For Viewers",
        actualImmutableDataTypeUsageCharacteristics.warningMessageForViewers());
    assertEquals(1L, actualImmutableDataTypeUsageCharacteristics.dataTypeId());
    assertTrue(actualImmutableDataTypeUsageCharacteristics.isRemovable());
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   *
   * <p>Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        builderResult.build();
    assertNull(immutableDataTypeUsageCharacteristics.warningMessageForEditors());
    assertNull(immutableDataTypeUsageCharacteristics.warningMessageForViewers());
    assertEquals(1L, immutableDataTypeUsageCharacteristics.dataTypeId());
    assertTrue(immutableDataTypeUsageCharacteristics.isRemovable());
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    ImmutableDataTypeUsageCharacteristics instance =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeUsageCharacteristics actualImmutableDataTypeUsageCharacteristics =
        builderResult.build();
    assertEquals(instance, actualImmutableDataTypeUsageCharacteristics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    ImmutableDataTypeUsageCharacteristics instance =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors(null)
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeUsageCharacteristics actualImmutableDataTypeUsageCharacteristics =
        builderResult.build();
    assertEquals(instance, actualImmutableDataTypeUsageCharacteristics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DataTypeUsageCharacteristics)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeUsageCharacteristics)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeUsageCharacteristics)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();
    ImmutableDataTypeUsageCharacteristics instance =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDataTypeUsageCharacteristics actualImmutableDataTypeUsageCharacteristics =
        builderResult.build();
    assertEquals(instance, actualImmutableDataTypeUsageCharacteristics);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isRemovable(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRemovable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRemovable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRemovable(boolean)"})
  void testBuilderIsRemovable() {
    // Arrange
    Builder builderResult = ImmutableDataTypeUsageCharacteristics.builder();

    // Act
    Builder actualIsRemovableResult = builderResult.isRemovable(true);

    // Assert
    assertSame(builderResult, actualIsRemovableResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#copyOf(DataTypeUsageCharacteristics)}.
   *
   * <ul>
   *   <li>Then return {@code Warning Message For Editors}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeUsageCharacteristics#copyOf(DataTypeUsageCharacteristics)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DataTypeUsageCharacteristics); then return 'Warning Message For Editors'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.copyOf(DataTypeUsageCharacteristics)"
  })
  void testCopyOf_thenReturnWarningMessageForEditors() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics instance =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    ImmutableDataTypeUsageCharacteristics actualCopyOfResult =
        ImmutableDataTypeUsageCharacteristics.copyOf(instance);

    // Assert
    assertEquals("Warning Message For Editors", actualCopyOfResult.warningMessageForEditors());
    assertEquals("Warning Message For Viewers", actualCopyOfResult.warningMessageForViewers());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertTrue(actualCopyOfResult.isRemovable());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}, and {@link
   * ImmutableDataTypeUsageCharacteristics#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics2 =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeUsageCharacteristics, immutableDataTypeUsageCharacteristics2);
    assertEquals(
        immutableDataTypeUsageCharacteristics.hashCode(),
        immutableDataTypeUsageCharacteristics2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}, and {@link
   * ImmutableDataTypeUsageCharacteristics#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act and Assert
    assertEquals(immutableDataTypeUsageCharacteristics, immutableDataTypeUsageCharacteristics);
    int expectedHashCodeResult = immutableDataTypeUsageCharacteristics.hashCode();
    assertEquals(expectedHashCodeResult, immutableDataTypeUsageCharacteristics.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(2L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsageCharacteristics,
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("dataTypeId")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsageCharacteristics,
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("dataTypeId")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDataTypeUsageCharacteristics,
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeUsageCharacteristics.equals(Object)",
    "int ImmutableDataTypeUsageCharacteristics.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build(),
        "Different type to ImmutableDataTypeUsageCharacteristics");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#toString()}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#dataTypeId()}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#isRemovable()}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#warningMessageForEditors()}
   *   <li>{@link ImmutableDataTypeUsageCharacteristics#warningMessageForViewers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableDataTypeUsageCharacteristics.dataTypeId()",
    "boolean ImmutableDataTypeUsageCharacteristics.isRemovable()",
    "String ImmutableDataTypeUsageCharacteristics.toString()",
    "String ImmutableDataTypeUsageCharacteristics.warningMessageForEditors()",
    "String ImmutableDataTypeUsageCharacteristics.warningMessageForViewers()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    String actualToStringResult = immutableDataTypeUsageCharacteristics.toString();
    long actualDataTypeIdResult = immutableDataTypeUsageCharacteristics.dataTypeId();
    boolean actualIsRemovableResult = immutableDataTypeUsageCharacteristics.isRemovable();
    String actualWarningMessageForEditorsResult =
        immutableDataTypeUsageCharacteristics.warningMessageForEditors();

    // Assert
    assertEquals(
        "DataTypeUsageCharacteristics{dataTypeId=1, isRemovable=true, warningMessageForViewers=Warning Message"
            + " For Viewers, warningMessageForEditors=Warning Message For Editors}",
        actualToStringResult);
    assertEquals("Warning Message For Editors", actualWarningMessageForEditorsResult);
    assertEquals(
        "Warning Message For Viewers",
        immutableDataTypeUsageCharacteristics.warningMessageForViewers());
    assertEquals(1L, actualDataTypeIdResult);
    assertTrue(actualIsRemovableResult);
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setWarningMessageForEditors(String)}
   *   <li>{@link Json#setWarningMessageForViewers(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setWarningMessageForEditors(String)",
    "void Json.setWarningMessageForViewers(String)"
  })
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
   *
   * <p>Method under test: {@link Json#isRemovable()}
   */
  @Test
  @DisplayName("Test Json isRemovable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRemovable()"})
  void testJsonIsRemovable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRemovable());
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   *
   * <p>Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setIsRemovable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRemovable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#warningMessageForEditors()}
   */
  @Test
  @DisplayName("Test Json warningMessageForEditors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.warningMessageForEditors()"})
  void testJsonWarningMessageForEditors() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().warningMessageForEditors());
  }

  /**
   * Test Json {@link Json#warningMessageForViewers()}.
   *
   * <p>Method under test: {@link Json#warningMessageForViewers()}
   */
  @Test
  @DisplayName("Test Json warningMessageForViewers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.warningMessageForViewers()"})
  void testJsonWarningMessageForViewers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().warningMessageForViewers());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withDataTypeId(long)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withDataTypeId(long)"
  })
  void testWithDataTypeId() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(42L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    ImmutableDataTypeUsageCharacteristics actualWithDataTypeIdResult =
        immutableDataTypeUsageCharacteristics.withDataTypeId(42L);

    // Assert
    assertSame(immutableDataTypeUsageCharacteristics, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withDataTypeId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Warning Message For Editors}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long); then return 'Warning Message For Editors'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withDataTypeId(long)"
  })
  void testWithDataTypeId_thenReturnWarningMessageForEditors() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics actualWithDataTypeIdResult =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build()
            .withDataTypeId(42L);

    // Assert
    assertEquals(
        "Warning Message For Editors", actualWithDataTypeIdResult.warningMessageForEditors());
    assertEquals(
        "Warning Message For Viewers", actualWithDataTypeIdResult.warningMessageForViewers());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId());
    assertTrue(actualWithDataTypeIdResult.isRemovable());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withIsRemovable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#withIsRemovable(boolean)}
   */
  @Test
  @DisplayName("Test withIsRemovable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withIsRemovable(boolean)"
  })
  void testWithIsRemovable() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    ImmutableDataTypeUsageCharacteristics actualWithIsRemovableResult =
        immutableDataTypeUsageCharacteristics.withIsRemovable(true);

    // Assert
    assertSame(immutableDataTypeUsageCharacteristics, actualWithIsRemovableResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withIsRemovable(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code Warning Message For Editors}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDataTypeUsageCharacteristics#withIsRemovable(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsRemovable(boolean); when 'false'; then return 'Warning Message For Editors'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withIsRemovable(boolean)"
  })
  void testWithIsRemovable_whenFalse_thenReturnWarningMessageForEditors() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics actualWithIsRemovableResult =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build()
            .withIsRemovable(false);

    // Assert
    assertEquals(
        "Warning Message For Editors", actualWithIsRemovableResult.warningMessageForEditors());
    assertEquals(
        "Warning Message For Viewers", actualWithIsRemovableResult.warningMessageForViewers());
    assertEquals(1L, actualWithIsRemovableResult.dataTypeId());
    assertFalse(actualWithIsRemovableResult.isRemovable());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withWarningMessageForEditors(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeUsageCharacteristics#withWarningMessageForEditors(String)}
   */
  @Test
  @DisplayName("Test withWarningMessageForEditors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withWarningMessageForEditors(String)"
  })
  void testWithWarningMessageForEditors() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("42")
            .warningMessageForViewers("Warning Message For Viewers")
            .build();

    // Act
    ImmutableDataTypeUsageCharacteristics actualWithWarningMessageForEditorsResult =
        immutableDataTypeUsageCharacteristics.withWarningMessageForEditors("42");

    // Assert
    assertSame(immutableDataTypeUsageCharacteristics, actualWithWarningMessageForEditorsResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withWarningMessageForEditors(String)}.
   *
   * <ul>
   *   <li>Then return warningMessageForEditors is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeUsageCharacteristics#withWarningMessageForEditors(String)}
   */
  @Test
  @DisplayName(
      "Test withWarningMessageForEditors(String); then return warningMessageForEditors is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withWarningMessageForEditors(String)"
  })
  void testWithWarningMessageForEditors_thenReturnWarningMessageForEditorsIs42() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics actualWithWarningMessageForEditorsResult =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build()
            .withWarningMessageForEditors("42");

    // Assert
    assertEquals("42", actualWithWarningMessageForEditorsResult.warningMessageForEditors());
    assertEquals(
        "Warning Message For Viewers",
        actualWithWarningMessageForEditorsResult.warningMessageForViewers());
    assertEquals(1L, actualWithWarningMessageForEditorsResult.dataTypeId());
    assertTrue(actualWithWarningMessageForEditorsResult.isRemovable());
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withWarningMessageForViewers(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeUsageCharacteristics#withWarningMessageForViewers(String)}
   */
  @Test
  @DisplayName("Test withWarningMessageForViewers(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withWarningMessageForViewers(String)"
  })
  void testWithWarningMessageForViewers() {
    // Arrange
    ImmutableDataTypeUsageCharacteristics immutableDataTypeUsageCharacteristics =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("42")
            .build();

    // Act
    ImmutableDataTypeUsageCharacteristics actualWithWarningMessageForViewersResult =
        immutableDataTypeUsageCharacteristics.withWarningMessageForViewers("42");

    // Assert
    assertSame(immutableDataTypeUsageCharacteristics, actualWithWarningMessageForViewersResult);
  }

  /**
   * Test {@link ImmutableDataTypeUsageCharacteristics#withWarningMessageForViewers(String)}.
   *
   * <ul>
   *   <li>Then return warningMessageForViewers is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeUsageCharacteristics#withWarningMessageForViewers(String)}
   */
  @Test
  @DisplayName(
      "Test withWarningMessageForViewers(String); then return warningMessageForViewers is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeUsageCharacteristics ImmutableDataTypeUsageCharacteristics.withWarningMessageForViewers(String)"
  })
  void testWithWarningMessageForViewers_thenReturnWarningMessageForViewersIs42() {
    // Arrange and Act
    ImmutableDataTypeUsageCharacteristics actualWithWarningMessageForViewersResult =
        ImmutableDataTypeUsageCharacteristics.builder()
            .dataTypeId(1L)
            .warningMessageForEditors("Warning Message For Editors")
            .warningMessageForViewers("Warning Message For Viewers")
            .build()
            .withWarningMessageForViewers("42");

    // Assert
    assertEquals("42", actualWithWarningMessageForViewersResult.warningMessageForViewers());
    assertEquals(
        "Warning Message For Editors",
        actualWithWarningMessageForViewersResult.warningMessageForEditors());
    assertEquals(1L, actualWithWarningMessageForViewersResult.dataTypeId());
    assertTrue(actualWithWarningMessageForViewersResult.isRemovable());
  }
}
