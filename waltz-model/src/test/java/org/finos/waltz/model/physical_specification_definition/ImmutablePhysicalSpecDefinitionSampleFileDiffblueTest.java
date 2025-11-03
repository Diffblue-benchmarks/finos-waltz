package org.finos.waltz.model.physical_specification_definition;

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
   * Test Builder {@link Builder#fileData(String)}.
   * <p>
   * Method under test: {@link Builder#fileData(String)}
   */
  @Test
  @DisplayName("Test Builder fileData(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fileData(String)"})
  void testBuilderFileData() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fileData("File Data"));
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
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
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFile)} with {@code PhysicalSpecDefinitionSampleFile}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionSampleFile) with 'PhysicalSpecDefinitionSampleFile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFile)"})
  void testBuilderFromWithPhysicalSpecDefinitionSampleFile() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFile)} with {@code PhysicalSpecDefinitionSampleFile}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionSampleFile) with 'PhysicalSpecDefinitionSampleFile'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFile)"})
  void testBuilderFromWithPhysicalSpecDefinitionSampleFile_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    ImmutablePhysicalSpecDefinitionSampleFile buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.specDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionSampleFile)} with {@code PhysicalSpecDefinitionSampleFile}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionSampleFile)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionSampleFile) with 'PhysicalSpecDefinitionSampleFile'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionSampleFile)"})
  void testBuilderFromWithPhysicalSpecDefinitionSampleFile_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    PhysicalSpecDefinitionSampleFile instance = mock(PhysicalSpecDefinitionSampleFile.class);
    when(instance.fileData()).thenReturn("File Data");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.specDefinitionId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).name();
    verify(instance).fileData();
    verify(instance).specDefinitionId();
    ImmutablePhysicalSpecDefinitionSampleFile buildResult = builderResult.build();
    assertEquals("File Data", buildResult.fileData());
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.specDefinitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#specDefinitionId(long)}.
   * <p>
   * Method under test: {@link Builder#specDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Builder specDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.specDefinitionId(long)"})
  void testBuilderSpecDefinitionId() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionSampleFile.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.specDefinitionId(1L));
  }

  /**
   * Test Json {@link Json#fileData()}.
   * <p>
   * Method under test: {@link Json#fileData()}
   */
  @Test
  @DisplayName("Test Json fileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.fileData()"})
  void testJsonFileData() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fileData());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setSpecDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setSpecDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#specDefinitionId()}
   */
  @Test
  @DisplayName("Test Json specDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.specDefinitionId()"})
  void testJsonSpecDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).specDefinitionId());
  }
}
