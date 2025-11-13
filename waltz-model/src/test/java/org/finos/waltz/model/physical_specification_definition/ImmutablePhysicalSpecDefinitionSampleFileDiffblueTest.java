package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFile.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionSampleFile.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionSampleFileDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutablePhysicalSpecDefinitionSampleFile Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder().fileData("File Data").id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutablePhysicalSpecDefinitionSampleFile actualImmutablePhysicalSpecDefinitionSampleFile =
        actualIdResult.id(id).name("Name").specDefinitionId(1L).build();

    // Assert
    assertEquals("File Data", actualImmutablePhysicalSpecDefinitionSampleFile.fileData());
    assertEquals("Name", actualImmutablePhysicalSpecDefinitionSampleFile.name());
    assertEquals(1L, actualImmutablePhysicalSpecDefinitionSampleFile.specDefinitionId());
  }

  /**
   * Test Builder {@link Builder#fileData(String)}.
   *
   * <ul>
   *   <li>When {@code File Data}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fileData(String)}
   */
  @Test
  @DisplayName("Test Builder fileData(String); when 'File Data'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fileData(String)"})
  void testBuilderFileData_whenFileData_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act
    Builder actualFileDataResult = builderResult.fileData("File Data");

    // Assert
    assertSame(builderResult, actualFileDataResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    ImmutablePhysicalSpecDefinitionSampleFile instance =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionSampleFile actualImmutablePhysicalSpecDefinitionSampleFile =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionSampleFile);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    ImmutablePhysicalSpecDefinitionSampleFile instance =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutablePhysicalSpecDefinitionSampleFile actualImmutablePhysicalSpecDefinitionSampleFile =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionSampleFile);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFile)} with {@code
   * PhysicalSpecDefinitionSampleFile}.
   *
   * <p>Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName(
      "Test Builder from(PhysicalSpecDefinitionSampleFile) with 'PhysicalSpecDefinitionSampleFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFile)"})
  void testBuilderFromWithPhysicalSpecDefinitionSampleFile() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    ImmutablePhysicalSpecDefinitionSampleFile instance =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutablePhysicalSpecDefinitionSampleFile actualImmutablePhysicalSpecDefinitionSampleFile =
        builderResult.build();
    assertEquals(instance, actualImmutablePhysicalSpecDefinitionSampleFile);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#specDefinitionId(long)}.
   *
   * <p>Method under test: {@link Builder#specDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder specDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.specDefinitionId(long)"})
  void testBuilderSpecDefinitionId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act
    Builder actualSpecDefinitionIdResult = builderResult.specDefinitionId(1L);

    // Assert
    assertSame(builderResult, actualSpecDefinitionIdResult);
  }

  /**
   * Test {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#copyOf(PhysicalSpecDefinitionSampleFile)}.
   *
   * <ul>
   *   <li>Then return {@code File Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#copyOf(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test copyOf(PhysicalSpecDefinitionSampleFile); then return 'File Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.copyOf(PhysicalSpecDefinitionSampleFile)"
  })
  void testCopyOf_thenReturnFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile instance =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualCopyOfResult =
        ImmutablePhysicalSpecDefinitionSampleFile.copyOf(instance);

    // Assert
    assertEquals("File Data", actualCopyOfResult.fileData());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(1L, actualCopyOfResult.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile2 =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFile, immutablePhysicalSpecDefinitionSampleFile2);
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFile.hashCode(),
        immutablePhysicalSpecDefinitionSampleFile2.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}, and {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act and Assert
    assertEquals(
        immutablePhysicalSpecDefinitionSampleFile, immutablePhysicalSpecDefinitionSampleFile);
    int expectedHashCodeResult = immutablePhysicalSpecDefinitionSampleFile.hashCode();
    assertEquals(expectedHashCodeResult, immutablePhysicalSpecDefinitionSampleFile.hashCode());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("Name")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFile,
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(2L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFile,
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("File Data")
            .specDefinitionId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFile,
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutablePhysicalSpecDefinitionSampleFile,
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutablePhysicalSpecDefinitionSampleFile.equals(Object)",
    "int ImmutablePhysicalSpecDefinitionSampleFile.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build(),
        "Different type to ImmutablePhysicalSpecDefinitionSampleFile");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#fileData()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#name()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionSampleFile#specDefinitionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutablePhysicalSpecDefinitionSampleFile.fileData()",
    "String ImmutablePhysicalSpecDefinitionSampleFile.name()",
    "long ImmutablePhysicalSpecDefinitionSampleFile.specDefinitionId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    String actualFileDataResult = immutablePhysicalSpecDefinitionSampleFile.fileData();
    String actualNameResult = immutablePhysicalSpecDefinitionSampleFile.name();

    // Assert
    assertEquals("File Data", actualFileDataResult);
    assertEquals("Name", actualNameResult);
    assertEquals(1L, immutablePhysicalSpecDefinitionSampleFile.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#id()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutablePhysicalSpecDefinitionSampleFile.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#fileData()}.
   *
   * <p>Method under test: {@link Json#fileData()}
   */
  @Test
  @DisplayName("Test Json fileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.fileData()"})
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fileData());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.fileData);
    assertNull(actualJson.name);
    assertEquals(0L, actualJson.specDefinitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.specDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#setSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link Json#setSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSpecDefinitionId(long)"})
  void testJsonSetSpecDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSpecDefinitionId(1L);

    // Assert
    assertEquals(1L, json.specDefinitionId);
    assertTrue(json.specDefinitionIdIsSet);
  }

  /**
   * Test Json {@link Json#specDefinitionId()}.
   *
   * <p>Method under test: {@link Json#specDefinitionId()}
   */
  @Test
  @DisplayName("Test Json specDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.specDefinitionId()"})
  void testJsonSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#toString()}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutablePhysicalSpecDefinitionSampleFile.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "PhysicalSpecDefinitionSampleFile{id=1, name=Name, specDefinitionId=1, fileData=File Data}",
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withFileData(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withFileData(String)}
   */
  @Test
  @DisplayName("Test withFileData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withFileData(String)"
  })
  void testWithFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("42")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithFileDataResult =
        immutablePhysicalSpecDefinitionSampleFile.withFileData("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFile, actualWithFileDataResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withFileData(String)}.
   *
   * <ul>
   *   <li>Then return fileData is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withFileData(String)}
   */
  @Test
  @DisplayName("Test withFileData(String); then return fileData is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withFileData(String)"
  })
  void testWithFileData_thenReturnFileDataIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithFileDataResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .withFileData("42");

    // Assert
    assertEquals("42", actualWithFileDataResult.fileData());
    assertEquals("Name", actualWithFileDataResult.name());
    assertEquals(1L, actualWithFileDataResult.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithIdResult =
        immutablePhysicalSpecDefinitionSampleFile.withId(optional);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFile, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code File Data}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'File Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withId(Optional)"
  })
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnFileData() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithIdResult =
        immutablePhysicalSpecDefinitionSampleFile.withId(optional);

    // Assert
    assertEquals("File Data", actualWithIdResult.fileData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals(1L, actualWithIdResult.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithIdResult =
        immutablePhysicalSpecDefinitionSampleFile.withId(1L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFile, actualWithIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code File Data}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'File Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnFileData() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithIdResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("File Data", actualWithIdResult.fileData());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals(1L, actualWithIdResult.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withName(String)}.
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("42")
            .specDefinitionId(1L)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithNameResult =
        immutablePhysicalSpecDefinitionSampleFile.withName("42");

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFile, actualWithNameResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutablePhysicalSpecDefinitionSampleFile#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithNameResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("File Data", actualWithNameResult.fileData());
    assertEquals(1L, actualWithNameResult.specDefinitionId());
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withSpecDefinitionId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#withSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withSpecDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withSpecDefinitionId(long)"
  })
  void testWithSpecDefinitionId() {
    // Arrange
    ImmutablePhysicalSpecDefinitionSampleFile immutablePhysicalSpecDefinitionSampleFile =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(42L)
            .build();

    // Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithSpecDefinitionIdResult =
        immutablePhysicalSpecDefinitionSampleFile.withSpecDefinitionId(42L);

    // Assert
    assertSame(immutablePhysicalSpecDefinitionSampleFile, actualWithSpecDefinitionIdResult);
  }

  /**
   * Test {@link ImmutablePhysicalSpecDefinitionSampleFile#withSpecDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return {@code File Data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutablePhysicalSpecDefinitionSampleFile#withSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withSpecDefinitionId(long); then return 'File Data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutablePhysicalSpecDefinitionSampleFile ImmutablePhysicalSpecDefinitionSampleFile.withSpecDefinitionId(long)"
  })
  void testWithSpecDefinitionId_thenReturnFileData() {
    // Arrange and Act
    ImmutablePhysicalSpecDefinitionSampleFile actualWithSpecDefinitionIdResult =
        ImmutablePhysicalSpecDefinitionSampleFile.builder()
            .fileData("File Data")
            .id(1L)
            .name("Name")
            .specDefinitionId(1L)
            .build()
            .withSpecDefinitionId(42L);

    // Assert
    assertEquals("File Data", actualWithSpecDefinitionIdResult.fileData());
    assertEquals("Name", actualWithSpecDefinitionIdResult.name());
    assertEquals(42L, actualWithSpecDefinitionIdResult.specDefinitionId());
  }
}
