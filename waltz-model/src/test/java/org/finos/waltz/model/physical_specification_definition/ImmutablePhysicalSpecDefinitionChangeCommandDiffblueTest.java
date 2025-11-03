package org.finos.waltz.model.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionChangeCommand.Builder;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionChangeCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutablePhysicalSpecDefinitionChangeCommandDiffblueTest {
  /**
   * Test {@link ImmutablePhysicalSpecDefinitionChangeCommand#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#builder()}
   *   <li>{@link ImmutablePhysicalSpecDefinitionChangeCommand#delimiter(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutablePhysicalSpecDefinitionChangeCommand Builder.build()",
      "Builder Builder.delimiter(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualDelimiterResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder().delimiter("Delimiter");
    Optional<String> delimiter = Optional.of("foo");
    Builder actualIdResult = actualDelimiterResult.delimiter(delimiter).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#delimiter(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#delimiter(Optional)}
   */
  @Test
  @DisplayName("Test Builder delimiter(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.delimiter(Optional)"})
  void testBuilderDelimiterWithOptional() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    Optional<String> delimiter = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.delimiter(delimiter));
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionChangeCommand)} with {@code PhysicalSpecDefinitionChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionChangeCommand) with 'PhysicalSpecDefinitionChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionChangeCommand() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    when(instance.delimiter()).thenThrow(new IllegalStateException("instance"));
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).type();
    verify(instance).version();
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionChangeCommand)} with {@code PhysicalSpecDefinitionChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionChangeCommand) with 'PhysicalSpecDefinitionChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionChangeCommand2() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.delimiter()).thenReturn(emptyResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionChangeCommand)} with {@code PhysicalSpecDefinitionChangeCommand}.
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionChangeCommand) with 'PhysicalSpecDefinitionChangeCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionChangeCommand3() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PhysicalSpecDefinitionChangeCommand)} with {@code PhysicalSpecDefinitionChangeCommand}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test Builder from(PhysicalSpecDefinitionChangeCommand) with 'PhysicalSpecDefinitionChangeCommand'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PhysicalSpecDefinitionChangeCommand)"})
  void testBuilderFromWithPhysicalSpecDefinitionChangeCommand_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    PhysicalSpecDefinitionChangeCommand instance = mock(PhysicalSpecDefinitionChangeCommand.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.delimiter()).thenReturn(ofResult);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.version()).thenReturn("1.0.2");
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.type()).thenReturn(PhysicalSpecDefinitionType.DELIMITED);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).delimiter();
    verify(instance).status();
    verify(instance).type();
    verify(instance).version();
    ImmutablePhysicalSpecDefinitionChangeCommand buildResult = builderResult.build();
    assertEquals("1.0.2", buildResult.version());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertEquals(PhysicalSpecDefinitionType.DELIMITED, buildResult.type());
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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

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
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#status(ReleaseLifecycleStatus)}.
   * <p>
   * Method under test: {@link Builder#status(ReleaseLifecycleStatus)}
   */
  @Test
  @DisplayName("Test Builder status(ReleaseLifecycleStatus)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.status(ReleaseLifecycleStatus)"})
  void testBuilderStatus() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Test Builder {@link Builder#type(PhysicalSpecDefinitionType)}.
   * <p>
   * Method under test: {@link Builder#type(PhysicalSpecDefinitionType)}
   */
  @Test
  @DisplayName("Test Builder type(PhysicalSpecDefinitionType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.type(PhysicalSpecDefinitionType)"})
  void testBuilderType() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.type(PhysicalSpecDefinitionType.DELIMITED));
  }

  /**
   * Test Builder {@link Builder#version(String)}.
   * <p>
   * Method under test: {@link Builder#version(String)}
   */
  @Test
  @DisplayName("Test Builder version(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.version(String)"})
  void testBuilderVersion() {
    // Arrange
    Builder builderResult = ImmutablePhysicalSpecDefinitionChangeCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.version("1.0.2"));
  }

  /**
   * Test Json {@link Json#delimiter()}.
   * <p>
   * Method under test: {@link Json#delimiter()}
   */
  @Test
  @DisplayName("Test Json delimiter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.delimiter()"})
  void testJsonDelimiter() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).delimiter());
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
    assertNull(actualJson.version);
    assertNull(actualJson.status);
    assertNull(actualJson.type);
    assertFalse(actualJson.delimiter.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Test Json {@link Json#status()}.
   * <p>
   * Method under test: {@link Json#status()}
   */
  @Test
  @DisplayName("Test Json status()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReleaseLifecycleStatus Json.status()"})
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).status());
  }

  /**
   * Test Json {@link Json#type()}.
   * <p>
   * Method under test: {@link Json#type()}
   */
  @Test
  @DisplayName("Test Json type()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PhysicalSpecDefinitionType Json.type()"})
  void testJsonType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).type());
  }

  /**
   * Test Json {@link Json#version()}.
   * <p>
   * Method under test: {@link Json#version()}
   */
  @Test
  @DisplayName("Test Json version()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.version()"})
  void testJsonVersion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).version());
  }
}
